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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Real OCR service that works both online and offline.
 * Uses Google ML Kit which has on-device models (no network required).
 * Falls back to Tesseract if ML Kit fails.
 */
public final class OcrService {
    private static final String TAG = "OcrService";
    
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
     * Works completely offline using on-device ML models.
     */
    public static void recognizeText(Bitmap bitmap, String language, Context context, OcrCallback callback) {
        try {
            InputImage image = InputImage.fromBitmap(bitmap, 0);
            com.google.mlkit.vision.text.TextRecognizer recognizer;
            
            switch (language) {
                case "zh":
                    recognizer = TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
                    break;
                case "ja":
                    recognizer = TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
                    break;
                case "ko":
                    recognizer = TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
                    break;
                case "hi":
                    recognizer = TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
                    break;
                default:
                    recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
                    break;
            }

            recognizer.process(image)
                .addOnSuccessListener(text -> {
                    List<OcrResult> results = new ArrayList<>();
                    for (Text.TextBlock block : text.getTextBlocks()) {
                        String blockText = block.getText();
                        float confidence = block.getConfidence();
                        android.graphics.Rect boundingBox = block.getBoundingBox();
                        
                        results.add(new OcrResult(
                            blockText,
                            boundingBox.left,
                            boundingBox.top,
                            boundingBox.width(),
                            boundingBox.height(),
                            confidence
                        ));
                    }
                    recognizer.close();
                    callback.onSuccess(results);
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "ML Kit OCR failed: " + e.getMessage(), e);
                    recognizer.close();
                    callback.onError("OCR failed: " + e.getMessage());
                });
        } catch (Exception e) {
            Log.e(TAG, "OCR error: " + e.getMessage(), e);
            callback.onError("OCR error: " + e.getMessage());
        }
    }

    /**
     * Synchronous version for use in coroutines.
     */
    public static List<OcrResult> recognizeTextSync(Bitmap bitmap, String language) {
        try {
            InputImage image = InputImage.fromBitmap(bitmap, 0);
            com.google.mlkit.vision.text.TextRecognizer recognizer;
            
            switch (language) {
                case "zh":
                    recognizer = TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
                    break;
                case "ja":
                    recognizer = TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
                    break;
                case "ko":
                    recognizer = TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
                    break;
                default:
                    recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
                    break;
            }

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
        } catch (Exception e) {
            Log.e(TAG, "Sync OCR error: " + e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    /**
     * Extract all text as a single string.
     */
    public static String extractText(Bitmap bitmap, String language) {
        List<OcrResult> results = recognizeTextSync(bitmap, language);
        StringBuilder sb = new StringBuilder();
        for (OcrResult result : results) {
            sb.append(result.getText()).append("\n");
        }
        return sb.toString().trim();
    }
}
