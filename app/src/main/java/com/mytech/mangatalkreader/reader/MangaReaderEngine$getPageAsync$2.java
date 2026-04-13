package com.mytech.mangatalkreader.reader;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.mytech.mangatalkreader.reader.MangaReaderEngine$getPageAsync$2", f = "MangaArchiveService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MangaArchiveService.kt */
final class MangaReaderEngine$getPageAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ MangaReaderEngine this$0;

    MangaReaderEngine$getPageAsync$2(MangaReaderEngine mangaReaderEngine, int i, Continuation<? super MangaReaderEngine$getPageAsync$2> continuation) {
        this.this$0 = mangaReaderEngine;
        this.$index = i;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new MangaReaderEngine$getPageAsync$2(this.this$0, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((MangaReaderEngine$getPageAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return this.this$0.getPage(this.$index);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
