package com.mytech.mangatalkreader.reader;

import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.mytech.mangatalkreader.reader.MangaReaderEngine$launchPrefetch$job$1", f = "MangaArchiveService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MangaArchiveService.kt */
final class MangaReaderEngine$launchPrefetch$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MangaReaderEngine this$0;

    MangaReaderEngine$launchPrefetch$job$1(MangaReaderEngine mangaReaderEngine, int i, Continuation<? super MangaReaderEngine$launchPrefetch$job$1> continuation) {
        this.this$0 = mangaReaderEngine;
        this.$index = i;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MangaReaderEngine$launchPrefetch$job$1 mangaReaderEngine$launchPrefetch$job$1 = new MangaReaderEngine$launchPrefetch$job$1(this.this$0, this.$index, continuation);
        mangaReaderEngine$launchPrefetch$job$1.L$0 = obj;
        return (Continuation) mangaReaderEngine$launchPrefetch$job$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MangaReaderEngine$launchPrefetch$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$launch = this.L$0;
                try {
                    Uri uri = this.this$0.sourceUri;
                    if (uri == null) {
                        Unit unit = Unit.INSTANCE;
                        this.this$0.activePrefetchJobs.remove(Boxing.boxInt(this.$index));
                        return unit;
                    }
                    Bitmap bitmap = this.this$0.decodeFromZip(uri, (String) this.this$0.pageEntries.get(this.$index));
                    if (bitmap != null && CoroutineScopeKt.isActive($this$launch)) {
                        this.this$0.getBitmapCache().put(Boxing.boxInt(this.$index), bitmap);
                    }
                    this.this$0.activePrefetchJobs.remove(Boxing.boxInt(this.$index));
                    return Unit.INSTANCE;
                } catch (Exception e) {
                } catch (Throwable th) {
                    this.this$0.activePrefetchJobs.remove(Boxing.boxInt(this.$index));
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
