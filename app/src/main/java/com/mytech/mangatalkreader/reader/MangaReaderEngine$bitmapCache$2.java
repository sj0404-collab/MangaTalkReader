package com.mytech.mangatalkreader.reader;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/mytech/mangatalkreader/reader/MangaReaderEngine$bitmapCache$2$1", "invoke", "()Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$bitmapCache$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MangaArchiveService.kt */
final class MangaReaderEngine$bitmapCache$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ MangaReaderEngine this$0;

    MangaReaderEngine$bitmapCache$2(MangaReaderEngine mangaReaderEngine) {
        this.this$0 = mangaReaderEngine;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new LruCache<Integer, Bitmap>((int) (((float) (Runtime.getRuntime().maxMemory() / ((long) 1024))) * this.this$0.config.getCacheFraction())) {
            protected int sizeOf(int key, Bitmap value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.getByteCount() / 1024;
            }

            protected void entryRemoved(boolean evicted, int key, Bitmap oldValue, Bitmap newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                if (evicted && newValue == null) {
                    oldValue.recycle();
                }
            }
        };
    }
}
