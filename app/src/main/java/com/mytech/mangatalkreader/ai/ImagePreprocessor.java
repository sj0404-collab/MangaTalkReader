package com.mytech.mangatalkreader.ai;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\f¨\u0006\u0014"}, d2 = {"Lcom/mytech/mangatalkreader/ai/ImagePreprocessor;", "", "()V", "applyAdaptiveThreshold", "", "pixels", "", "applyContrast", "contrast", "", "applyFastBlur", "w", "", "h", "radius", "applyGrayscale", "enhanceForManga", "Landroid/graphics/Bitmap;", "src", "blurRadius", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImagePreprocessor.kt */
public final class ImagePreprocessor {
    public static final int $stable = 0;
    public static final ImagePreprocessor INSTANCE = new ImagePreprocessor();

    private ImagePreprocessor() {
    }

    public static /* synthetic */ Bitmap enhanceForManga$default(ImagePreprocessor imagePreprocessor, Bitmap bitmap, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.6f;
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return imagePreprocessor.enhanceForManga(bitmap, f, i);
    }

    public final Bitmap enhanceForManga(Bitmap src, float contrast, int blurRadius) {
        Intrinsics.checkNotNullParameter(src, "src");
        int width = src.getWidth();
        int height = src.getHeight();
        int[] pixels = new int[(width * height)];
        src.getPixels(pixels, 0, width, 0, 0, width, height);
        applyGrayscale(pixels);
        if ((contrast == 1.0f ? 1 : null) == null) {
            applyContrast(pixels, contrast);
        }
        if (blurRadius > 0) {
            applyFastBlur(pixels, width, height, blurRadius);
        }
        applyAdaptiveThreshold(pixels);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Bitmap result = createBitmap;
        createBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return result;
    }

    private final void applyGrayscale(int[] pixels) {
        int length = pixels.length;
        for (int i = 0; i < length; i++) {
            int p = pixels[i];
            int gray = (int) (((((float) Color.red(p)) * 0.299f) + (((float) Color.green(p)) * 0.587f)) + (((float) Color.blue(p)) * 0.114f));
            pixels[i] = Color.rgb(gray, gray, gray);
        }
    }

    private final void applyContrast(int[] pixels, float contrast) {
        int length = pixels.length;
        for (int i = 0; i < length; i++) {
            int newGray = RangesKt.coerceIn((int) ((((float) (Color.red(pixels[i]) - 128)) * contrast) + ((float) 128)), 0, 255);
            pixels[i] = Color.rgb(newGray, newGray, newGray);
        }
    }

    private final void applyFastBlur(int[] pixels, int w, int h, int radius) {
        if (w >= (radius * 2) + 1 && h >= (radius * 2) + 1) {
            int x;
            int sum;
            int y;
            int prevIdx;
            int avg;
            int[] temp = new int[pixels.length];
            for (x = 0; x < w; x++) {
                sum = 0;
                y = 0;
                if (0 <= radius) {
                    while (true) {
                        sum += Color.red(pixels[(y * w) + x]);
                        if (y == radius) {
                            break;
                        }
                        y++;
                    }
                }
                for (y = 0; y < h; y++) {
                    prevIdx = (Math.max(0, (y - radius) - 1) * w) + x;
                    sum += Color.red(pixels[(Math.min(h - 1, y + radius) * w) + x]);
                    if (y > radius) {
                        sum -= Color.red(pixels[prevIdx]);
                    }
                    avg = sum / ((radius * 2) + 1);
                    temp[(y * w) + x] = Color.rgb(avg, avg, avg);
                }
            }
            for (x = 0; x < h; x++) {
                sum = 0;
                y = 0;
                if (0 <= radius) {
                    while (true) {
                        sum += Color.red(temp[(x * w) + y]);
                        if (y == radius) {
                            break;
                        }
                        y++;
                    }
                }
                for (y = 0; y < w; y++) {
                    prevIdx = (x * w) + Math.max(0, (y - radius) - 1);
                    sum += Color.red(temp[(x * w) + Math.min(w - 1, y + radius)]);
                    if (y > radius) {
                        sum -= Color.red(temp[prevIdx]);
                    }
                    avg = sum / ((radius * 2) + 1);
                    pixels[(x * w) + y] = Color.rgb(avg, avg, avg);
                }
            }
        }
    }

    private final void applyAdaptiveThreshold(int[] pixels) {
        int p;
        long sum = 0;
        for (int p2 : pixels) {
            sum += (long) Color.red(p2);
        }
        int length = ((int) (sum / ((long) pixels.length))) - 20;
        int length2 = pixels.length;
        for (p2 = 0; p2 < length2; p2++) {
            int binary = Color.red(pixels[p2]) > length ? 255 : 0;
            pixels[p2] = Color.rgb(binary, binary, binary);
        }
    }
}
