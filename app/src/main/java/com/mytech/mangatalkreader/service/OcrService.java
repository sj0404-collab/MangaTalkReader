package com.mytech.mangatalkreader.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions;
import com.google.mlkit.vision.text.japanese.JapaneseTextRecognizerOptions;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Real OCR service that works both online and offline.
 * 
 * - Latin/English: ML Kit (on-device, offline)
 * - Russian/Cyrillic: Tesseract4Android (on-device, offline)
 * - Japanese, Chinese, Korean, Devanagari: ML Kit (on-device, offline)
 */
public final class OcrService {
    private static final String TAG = "OcrService";

    /** Available OCR languages with display names. */
    public static final Map<String, String> SUPPORTED_LANGUAGES = new HashMap<String, String>() {{
        put("en", "English");
        put("ru", "Русский (Tesseract)");
        put("ja", "日本語");
        put("zh", "中文");
        put("ko", "한국어");
        put("hi", "हिन्दी");
    }};

    public interface OcrCallback {
        void onSuccess(List<OcrResult> results);
        void onError(String error);
    }

    public static class OcrResult {
        private final String text;
        private final float x, y, width, height;
        private final float confidence;

        public OcrResult(String text, float x, float y, float width, float height, float confidence) {
            this.text = text;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.confidence = confidence;
        }

        public String getText() { return text; }
        public float getX() { return x; }
        public float getY() { return y; }
        public float getWidth() { return width; }
        public float getHeight() { return height; }
        public float getConfidence() { return confidence; }
    }

    /**
     * Recognize text from bitmap image.
     * For Russian: uses Tesseract4Android (offline).
     * For other languages: uses Google ML Kit (offline).
     */
    public static void recognizeText(Bitmap bitmap, String language, Context context, OcrCallback callback) {
        try {
            if ("ru".equals(language)) {
                // Use Tesseract for Russian/Cyrillic
                recognizeWithTesseract(bitmap, context, callback);
            } else {
                // Use ML Kit for everything else
                recognizeWithMlKit(bitmap, language, callback);
            }
        } catch (Exception e) {
            Log.e(TAG, "OCR error: " + e.getMessage(), e);
            callback.onError("OCR error: " + e.getMessage());
        }
    }

    /**
     * Synchronous version for use in coroutines.
     */
    public static List<OcrResult> recognizeTextSync(Bitmap bitmap, String language, Context context) {
        try {
            if ("ru".equals(language)) {
                return recognizeWithTesseractSync(bitmap, context);
            } else {
                return recognizeWithMlKitSync(bitmap, language);
            }
        } catch (Exception e) {
            Log.e(TAG, "Sync OCR error (" + language + "): " + e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    /**
     * Extract all text as a single string.
     */
    public static String extractText(Bitmap bitmap, String language, Context context) {
        List<OcrResult> results = recognizeTextSync(bitmap, language, context);
        StringBuilder sb = new StringBuilder();
        for (OcrResult result : results) {
            if (sb.length() > 0) sb.append("\n");
            sb.append(result.getText());
        }
        return sb.toString().trim();
    }

    // ====== ML Kit (Latin, Japanese, Chinese, Korean, Devanagari) ======

    private static void recognizeWithMlKit(Bitmap bitmap, String language, OcrCallback callback) {
        try {
            InputImage image = InputImage.fromBitmap(bitmap, 0);
            com.google.mlkit.vision.text.TextRecognizer recognizer = createMlKitRecognizer(language);

            recognizer.process(image)
                .addOnSuccessListener(text -> {
                    List<OcrResult> results = new ArrayList<>();
                    for (Text.TextBlock block : text.getTextBlocks()) {
                        android.graphics.Rect bbox = block.getBoundingBox();
                        results.add(new OcrResult(
                            block.getText(),
                            bbox.left, bbox.top,
                            bbox.width(), bbox.height(),
                            block.getConfidence()
                        ));
                    }
                    recognizer.close();
                    callback.onSuccess(results);
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "ML Kit OCR failed (" + language + "): " + e.getMessage(), e);
                    recognizer.close();
                    callback.onError("OCR failed: " + e.getMessage());
                });
        } catch (Exception e) {
            Log.e(TAG, "ML Kit error: " + e.getMessage(), e);
            callback.onError("ML Kit error: " + e.getMessage());
        }
    }

    private static List<OcrResult> recognizeWithMlKitSync(Bitmap bitmap, String language) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);
        com.google.mlkit.vision.text.TextRecognizer recognizer = createMlKitRecognizer(language);

        Text text = recognizer.process(image).getResult();
        List<OcrResult> results = new ArrayList<>();
        for (Text.TextBlock block : text.getTextBlocks()) {
            android.graphics.Rect bbox = block.getBoundingBox();
            results.add(new OcrResult(
                block.getText(),
                bbox.left, bbox.top,
                bbox.width(), bbox.height(),
                block.getConfidence()
            ));
        }
        recognizer.close();
        return results;
    }

    private static com.google.mlkit.vision.text.TextRecognizer createMlKitRecognizer(String language) {
        switch (language != null ? language : "en") {
            case "zh":
                return TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
            case "ja":
                return TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
            case "ko":
                return TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
            case "hi":
                return TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
            case "en":
            default:
                return TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        }
    }

    // ====== Tesseract (Russian/Cyrillic) ======

    private static void recognizeWithTesseract(Bitmap bitmap, Context context, OcrCallback callback) {
        try {
            cz.adaptech.tesseract4android.TessOCR tessOCR = new cz.adaptech.tesseract4android.TessOCR(
                context,
                "rus",
                cz.adaptech.tesseract4android.TessBaseAPI.OEM_LSTM_ONLY
            );

            String result = tessOCR.getOCR(bitmap);
            List<OcrResult> results = new ArrayList<>();
            if (result != null && !result.isEmpty()) {
                results.add(new OcrResult(result.trim(), 0, 0, bitmap.getWidth(), bitmap.getHeight(), 1.0f));
            }
            callback.onSuccess(results);
        } catch (Exception e) {
            Log.e(TAG, "Tesseract OCR error: " + e.getMessage(), e);
            callback.onError("Tesseract error: " + e.getMessage());
        }
    }

    private static List<OcrResult> recognizeWithTesseractSync(Bitmap bitmap, Context context) {
        try {
            cz.adaptech.tesseract4android.TessOCR tessOCR = new cz.adaptech.tesseract4android.TessOCR(
                context,
                "rus",
                cz.adaptech.tesseract4android.TessBaseAPI.OEM_LSTM_ONLY
            );

            String result = tessOCR.getOCR(bitmap);
            List<OcrResult> results = new ArrayList<>();
            if (result != null && !result.isEmpty()) {
                results.add(new OcrResult(result.trim(), 0, 0, bitmap.getWidth(), bitmap.getHeight(), 1.0f));
            }
            return results;
        } catch (Exception e) {
            Log.e(TAG, "Tesseract sync error: " + e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}
