package com.mytech.mangatalkreader.reader;

import android.net.Uri;
import com.mytech.mangatalkreader.reader.MangaReaderEngine.OpenResult;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.mytech.mangatalkreader.reader.MangaReaderEngine$open$2", f = "MangaArchiveService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MangaArchiveService.kt */
final class MangaReaderEngine$open$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenResult>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ MangaReaderEngine this$0;

    MangaReaderEngine$open$2(MangaReaderEngine mangaReaderEngine, Uri uri, Continuation<? super MangaReaderEngine$open$2> continuation) {
        this.this$0 = mangaReaderEngine;
        this.$uri = uri;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new MangaReaderEngine$open$2(this.this$0, this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OpenResult> continuation) {
        return ((MangaReaderEngine$open$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        this.this$0.sourceUri = this.$uri;
        this.this$0.pageEntries.clear();
        this.this$0.getBitmapCache().evictAll();
        this.this$0.imageSizes.clear();
        this.this$0.currentIndex = -1;

        try {
            InputStream inputStream = this.this$0.context.getContentResolver().openInputStream(this.$uri);
            if (inputStream != null) {
                ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputStream, 65536));
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (!entry.isDirectory()) {
                        String name = entry.getName();
                        if (this.this$0.isImage(name)) {
                            this.this$0.pageEntries.add(name);
                            long size = entry.getSize();
                            if (size > 0) {
                                this.this$0.imageSizes.put(name, this.this$0.estimateSize(size));
                            }
                        }
                    }
                }
                zis.close();
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return new OpenResult.Error(message);
        }

        this.this$0.pageEntries.sort((Comparator<String>) new MangaReaderEngine$open$2$invokeSuspend$$inlined$compareBy$1(this.this$0));
        return new OpenResult.Success(this.this$0.pageEntries.size());
    }
}
