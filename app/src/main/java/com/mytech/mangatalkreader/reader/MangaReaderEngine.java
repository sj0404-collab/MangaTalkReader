package com.mytech.mangatalkreader.reader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.util.LruCache;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0003NOPB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0002J\u000e\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rJ\u001a\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010/\u001a\u00020\tJ\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0014H\u0002J \u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0002J\u001a\u0010;\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020\tJ\u0018\u0010?\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020\tH@¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020=2\u0006\u0010/\u001a\u00020\tJ(\u0010B\u001a\u00020=2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020=2\u0006\u00104\u001a\u00020\u0014H\u0002J \u0010E\u001a\u00020=2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0002J\u0018\u0010G\u001a\u00020=2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0002J\u0010\u0010H\u001a\u00020\"2\u0006\u0010/\u001a\u00020\tH\u0002J\u0016\u0010I\u001a\u00020J2\u0006\u0010)\u001a\u00020\u001bH@¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\tJ\u0010\u0010M\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine;", "", "context", "Landroid/content/Context;", "config", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$ReaderConfig;", "(Landroid/content/Context;Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$ReaderConfig;)V", "activePrefetchJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/Job;", "bitmapCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getBitmapCache", "()Landroid/util/LruCache;", "bitmapCache$delegate", "Lkotlin/Lazy;", "currentIndex", "imageSizes", "", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$ImageSize;", "pageEntries", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceUri", "Landroid/net/Uri;", "calculateSample", "options", "Landroid/graphics/BitmapFactory$Options;", "reqW", "reqH", "clear", "", "combineBitmaps", "left", "right", "cropMargins", "bitmap", "decodeFromZip", "uri", "targetEntryName", "decodeSampled", "stream", "Ljava/io/InputStream;", "estimatePageSize", "index", "estimateSize", "fileSize", "", "extractPageNumber", "name", "findContentBounds", "Landroid/graphics/Rect;", "pixels", "", "w", "h", "getDualPage", "rtl", "", "getPage", "getPageAsync", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasPage", "isColumnWhite", "x", "isImage", "isRowWhite", "y", "isSpreadPair", "launchPrefetch", "open", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pageCount", "updatePrefetch", "ImageSize", "OpenResult", "ReaderConfig", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MangaArchiveService.kt */
public final class MangaReaderEngine {
    public static final int $stable = 8;
    private final ConcurrentHashMap<Integer, Job> activePrefetchJobs;
    private final Lazy bitmapCache$delegate;
    private final ReaderConfig config;
    private final Context context;
    private int currentIndex;
    private final ConcurrentHashMap<String, ImageSize> imageSizes;
    private final List<String> pageEntries;
    private final CoroutineScope scope;
    private Uri sourceUri;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$ImageSize;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MangaArchiveService.kt */
    public static final class ImageSize {
        public static final int $stable = 0;
        private final int height;
        private final int width;

        public static /* synthetic */ ImageSize copy$default(ImageSize imageSize, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = imageSize.width;
            }
            if ((i3 & 2) != 0) {
                i2 = imageSize.height;
            }
            return imageSize.copy(i, i2);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final ImageSize copy(int i, int i2) {
            return new ImageSize(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageSize)) {
                return false;
            }
            ImageSize imageSize = (ImageSize) obj;
            return this.width == imageSize.width && this.height == imageSize.height;
        }

        public int hashCode() {
            return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
        }

        public String toString() {
            int i = this.width;
            return "ImageSize(width=" + i + ", height=" + this.height + ")";
        }

        public ImageSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult;", "", "()V", "Error", "Success", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult$Error;", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult$Success;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MangaArchiveService.kt */
    public static abstract class OpenResult {
        public static final int $stable = 0;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult$Error;", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MangaArchiveService.kt */
        public static final class Error extends OpenResult {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            public final String component1() {
                return this.message;
            }

            public final Error copy(String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                return Intrinsics.areEqual(this.message, ((Error) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "Error(message=" + this.message + ")";
            }

            public Error(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                super();
                this.message = message;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult$Success;", "Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$OpenResult;", "pageCount", "", "(I)V", "getPageCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MangaArchiveService.kt */
        public static final class Success extends OpenResult {
            public static final int $stable = 0;
            private final int pageCount;

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.pageCount;
                }
                return success.copy(i);
            }

            public final int component1() {
                return this.pageCount;
            }

            public final Success copy(int i) {
                return new Success(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                return this.pageCount == ((Success) obj).pageCount;
            }

            public int hashCode() {
                return Integer.hashCode(this.pageCount);
            }

            public String toString() {
                return "Success(pageCount=" + this.pageCount + ")";
            }

            public Success(int pageCount) {
                super();
                this.pageCount = pageCount;
            }

            public final int getPageCount() {
                return this.pageCount;
            }
        }

        public /* synthetic */ OpenResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private OpenResult() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/mytech/mangatalkreader/reader/MangaReaderEngine$ReaderConfig;", "", "maxBitmapSize", "", "prefetchDistance", "prefetchBehind", "useRgb565", "", "whiteThreshold", "cacheFraction", "", "(IIIZIF)V", "getCacheFraction", "()F", "getMaxBitmapSize", "()I", "getPrefetchBehind", "getPrefetchDistance", "getUseRgb565", "()Z", "getWhiteThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MangaArchiveService.kt */
    public static final class ReaderConfig {
        public static final int $stable = 0;
        private final float cacheFraction;
        private final int maxBitmapSize;
        private final int prefetchBehind;
        private final int prefetchDistance;
        private final boolean useRgb565;
        private final int whiteThreshold;

        public ReaderConfig() {
            this(0, 0, 0, false, 0, 0.0f, 63, null);
        }

        public static /* synthetic */ ReaderConfig copy$default(ReaderConfig readerConfig, int i, int i2, int i3, boolean z, int i4, float f, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = readerConfig.maxBitmapSize;
            }
            if ((i5 & 2) != 0) {
                i2 = readerConfig.prefetchDistance;
            }
            int i6 = i2;
            if ((i5 & 4) != 0) {
                i3 = readerConfig.prefetchBehind;
            }
            int i7 = i3;
            if ((i5 & 8) != 0) {
                z = readerConfig.useRgb565;
            }
            boolean z2 = z;
            if ((i5 & 16) != 0) {
                i4 = readerConfig.whiteThreshold;
            }
            int i8 = i4;
            if ((i5 & 32) != 0) {
                f = readerConfig.cacheFraction;
            }
            return readerConfig.copy(i, i6, i7, z2, i8, f);
        }

        public final int component1() {
            return this.maxBitmapSize;
        }

        public final int component2() {
            return this.prefetchDistance;
        }

        public final int component3() {
            return this.prefetchBehind;
        }

        public final boolean component4() {
            return this.useRgb565;
        }

        public final int component5() {
            return this.whiteThreshold;
        }

        public final float component6() {
            return this.cacheFraction;
        }

        public final ReaderConfig copy(int i, int i2, int i3, boolean z, int i4, float f) {
            return new ReaderConfig(i, i2, i3, z, i4, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReaderConfig)) {
                return false;
            }
            ReaderConfig readerConfig = (ReaderConfig) obj;
            return this.maxBitmapSize == readerConfig.maxBitmapSize && this.prefetchDistance == readerConfig.prefetchDistance && this.prefetchBehind == readerConfig.prefetchBehind && this.useRgb565 == readerConfig.useRgb565 && this.whiteThreshold == readerConfig.whiteThreshold && Float.compare(this.cacheFraction, readerConfig.cacheFraction) == 0;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.maxBitmapSize) * 31) + Integer.hashCode(this.prefetchDistance)) * 31) + Integer.hashCode(this.prefetchBehind)) * 31) + Boolean.hashCode(this.useRgb565)) * 31) + Integer.hashCode(this.whiteThreshold)) * 31) + Float.hashCode(this.cacheFraction);
        }

        public String toString() {
            int i = this.maxBitmapSize;
            int i2 = this.prefetchDistance;
            int i3 = this.prefetchBehind;
            boolean z = this.useRgb565;
            int i4 = this.whiteThreshold;
            return "ReaderConfig(maxBitmapSize=" + i + ", prefetchDistance=" + i2 + ", prefetchBehind=" + i3 + ", useRgb565=" + z + ", whiteThreshold=" + i4 + ", cacheFraction=" + this.cacheFraction + ")";
        }

        public ReaderConfig(int maxBitmapSize, int prefetchDistance, int prefetchBehind, boolean useRgb565, int whiteThreshold, float cacheFraction) {
            this.maxBitmapSize = maxBitmapSize;
            this.prefetchDistance = prefetchDistance;
            this.prefetchBehind = prefetchBehind;
            this.useRgb565 = useRgb565;
            this.whiteThreshold = whiteThreshold;
            this.cacheFraction = cacheFraction;
        }

        public /* synthetic */ ReaderConfig(int i, int i2, int i3, boolean z, int i4, float f, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            int i6;
            int i7;
            if ((i5 & 1) != 0) {
                i = 2048;
            }
            if ((i5 & 2) != 0) {
                i6 = 3;
            } else {
                i6 = i2;
            }
            boolean z2 = true;
            if ((i5 & 4) != 0) {
                i7 = 1;
            } else {
                i7 = i3;
            }
            if ((i5 & 8) == 0) {
                z2 = z;
            }
            this(i, i6, i7, z2, (i5 & 16) != 0 ? 245 : i4, (i5 & 32) != 0 ? 0.125f : f);
        }

        public final int getMaxBitmapSize() {
            return this.maxBitmapSize;
        }

        public final int getPrefetchDistance() {
            return this.prefetchDistance;
        }

        public final int getPrefetchBehind() {
            return this.prefetchBehind;
        }

        public final boolean getUseRgb565() {
            return this.useRgb565;
        }

        public final int getWhiteThreshold() {
            return this.whiteThreshold;
        }

        public final float getCacheFraction() {
            return this.cacheFraction;
        }
    }

    public MangaReaderEngine(Context context, ReaderConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus((CoroutineContext) Dispatchers.getIO()));
        this.pageEntries = new ArrayList();
        this.currentIndex = -1;
        this.bitmapCache$delegate = LazyKt.lazy((Function0) new MangaReaderEngine$bitmapCache$2(this));
        this.activePrefetchJobs = new ConcurrentHashMap();
        this.imageSizes = new ConcurrentHashMap();
    }

    public /* synthetic */ MangaReaderEngine(Context context, ReaderConfig readerConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            ReaderConfig readerConfig2 = new ReaderConfig(0, 0, 0, false, 0, 0.0f, 63, null);
        }
        this(context, readerConfig);
    }

    private final LruCache<Integer, Bitmap> getBitmapCache() {
        return (LruCache) this.bitmapCache$delegate.getValue();
    }

    public final Object open(Uri uri, Continuation<? super OpenResult> $completion) {
        return BuildersKt.withContext((CoroutineContext) Dispatchers.getIO(), (Function2) new MangaReaderEngine$open$2(this, uri, null), $completion);
    }

    public final int pageCount() {
        return this.pageEntries.size();
    }

    public final boolean hasPage(int index) {
        return index >= 0 && index < this.pageEntries.size();
    }

    public final Bitmap getPage(int index) {
        boolean wasChanged = true;
        boolean z = index >= 0 && index < this.pageEntries.size();
        if (!z) {
            return null;
        }
        if (this.currentIndex == index) {
            wasChanged = false;
        }
        this.currentIndex = index;
        Bitmap it = (Bitmap) getBitmapCache().get(Integer.valueOf(index));
        if (it != null) {
            if (wasChanged) {
                updatePrefetch(index);
            }
            return it;
        }
        Uri uri = this.sourceUri;
        if (uri == null) {
            return null;
        }
        Bitmap bitmap = decodeFromZip(uri, (String) this.pageEntries.get(index));
        if (bitmap != null) {
            getBitmapCache().put(Integer.valueOf(index), bitmap);
            updatePrefetch(index);
        }
        return bitmap;
    }

    public final Object getPageAsync(int index, Continuation<? super Bitmap> $completion) {
        return BuildersKt.withContext((CoroutineContext) Dispatchers.getIO(), (Function2) new MangaReaderEngine$getPageAsync$2(this, index, null), $completion);
    }

    public static /* synthetic */ Bitmap getDualPage$default(MangaReaderEngine mangaReaderEngine, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return mangaReaderEngine.getDualPage(i, z);
    }

    public final Bitmap getDualPage(int index, boolean rtl) {
        int first = rtl ? index + 1 : index;
        Bitmap left = getPage(rtl ? index : index + 1);
        if (left == null) {
            return getPage(first);
        }
        Bitmap right = getPage(first);
        if (right != null && isSpreadPair(left, right)) {
            return combineBitmaps(left, right);
        }
        return left;
    }

    public final Bitmap cropMargins(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        if (w < 100 || h < 100) {
            return bitmap;
        }
        int[] pixels = new int[(w * h)];
        bitmap.getPixels(pixels, 0, w, 0, 0, w, h);
        Rect bounds = findContentBounds(pixels, w, h);
        if (bounds.left == 0 && bounds.top == 0 && bounds.right == w && bounds.bottom == h) {
            return bitmap;
        }
        Bitmap bitmap2;
        try {
            int contentWidth = bounds.right - bounds.left;
            int contentHeight = bounds.bottom - bounds.top;
            if (contentWidth <= 0 || contentHeight <= 0) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = Bitmap.createBitmap(bitmap, bounds.left, bounds.top, contentWidth, contentHeight);
            }
            Intrinsics.checkNotNull(bitmap2);
        } catch (Exception e) {
            bitmap2 = bitmap;
        }
        return bitmap2;
    }

    public final ImageSize estimatePageSize(int index) {
        String name = (String) CollectionsKt.getOrNull(this.pageEntries, index);
        if (name == null) {
            return null;
        }
        return (ImageSize) this.imageSizes.get(name);
    }

    public final void clear() {
        Iterable<Job> $this$forEach$iv = this.activePrefetchJobs.values();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "<get-values>(...)");
        for (Job it : $this$forEach$iv) {
            Intrinsics.checkNotNull(it);
            DefaultImpls.cancel$default(it, null, 1, null);
        }
        this.activePrefetchJobs.clear();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        getBitmapCache().evictAll();
        this.pageEntries.clear();
        this.imageSizes.clear();
        this.sourceUri = null;
        this.currentIndex = -1;
    }

    /* DevToolsApp WARNING: Missing block: B:26:?, code:
            kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* DevToolsApp WARNING: Missing block: B:33:?, code:
            kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    private final android.graphics.Bitmap decodeFromZip(android.net.Uri r10, java.lang.String r11) {
        /*
        r9 = this;
        r0 = 0;
        r1 = r9.context;	 Catch:{ Exception -> 0x005d }
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x005d }
        r1 = r1.openInputStream(r10);	 Catch:{ Exception -> 0x005d }
        if (r1 == 0) goto L_0x0062;
    L_0x000e:
        r1 = (java.io.Closeable) r1;	 Catch:{ Exception -> 0x005d }
        r2 = r1;
        r2 = (java.io.InputStream) r2;	 Catch:{ all -> 0x0056 }
        r3 = 0;
        r4 = new java.util.zip.ZipInputStream;	 Catch:{ all -> 0x0056 }
        r5 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x0056 }
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r5.<init>(r2, r6);	 Catch:{ all -> 0x0056 }
        r5 = (java.io.InputStream) r5;	 Catch:{ all -> 0x0056 }
        r4.<init>(r5);	 Catch:{ all -> 0x0056 }
        r4 = (java.io.Closeable) r4;	 Catch:{ all -> 0x0056 }
        r5 = r4;
        r5 = (java.util.zip.ZipInputStream) r5;	 Catch:{ all -> 0x004f }
        r6 = 0;
        r7 = r5.getNextEntry();	 Catch:{ all -> 0x004f }
    L_0x002c:
        if (r7 == 0) goto L_0x0046;
    L_0x002e:
        r8 = r7.getName();	 Catch:{ all -> 0x004f }
        r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r11);	 Catch:{ all -> 0x004f }
        if (r8 == 0) goto L_0x0040;
    L_0x0038:
        r8 = r5;
        r8 = (java.io.InputStream) r8;	 Catch:{ all -> 0x004f }
        r8 = r9.decodeSampled(r8);	 Catch:{ all -> 0x004f }
        goto L_0x0047;
    L_0x0040:
        r8 = r5.getNextEntry();	 Catch:{ all -> 0x004f }
        r7 = r8;
        goto L_0x002c;
    L_0x0046:
        r8 = r0;
    L_0x0047:
        kotlin.io.CloseableKt.closeFinally(r4, r0);	 Catch:{ all -> 0x0056 }
        kotlin.io.CloseableKt.closeFinally(r1, r0);	 Catch:{ Exception -> 0x005d }
        r0 = r8;
        goto L_0x0062;
    L_0x004f:
        r5 = move-exception;
        throw r5;	 Catch:{ all -> 0x0051 }
    L_0x0051:
        r6 = move-exception;
        kotlin.io.CloseableKt.closeFinally(r4, r5);	 Catch:{ all -> 0x0056 }
        throw r6;	 Catch:{ all -> 0x0056 }
    L_0x0056:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0058 }
    L_0x0058:
        r3 = move-exception;
        kotlin.io.CloseableKt.closeFinally(r1, r2);	 Catch:{ Exception -> 0x005d }
        throw r3;	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0062:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mytech.mangatalkreader.reader.MangaReaderEngine.decodeFromZip(android.net.Uri, java.lang.String):android.graphics.Bitmap");
    }

    private final Bitmap decodeSampled(InputStream stream) {
        byte[] bytes = ByteStreamsKt.readBytes(stream);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        options.inSampleSize = calculateSample(options, this.config.getMaxBitmapSize(), this.config.getMaxBitmapSize());
        options.inJustDecodeBounds = false;
        if (this.config.getUseRgb565()) {
            options.inPreferredConfig = Config.RGB_565;
        }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
    }

    private final int calculateSample(Options options, int reqW, int reqH) {
        int h = options.outHeight;
        int w = options.outWidth;
        int sample = 1;
        if (h > reqH || w > reqW) {
            int halfH = h / 2;
            int halfW = w / 2;
            while (halfH / sample >= reqH && halfW / sample >= reqW) {
                sample *= 2;
            }
        }
        return Math.max(1, sample);
    }

    private final void updatePrefetch(int currentIndex) {
        Set keySet = this.activePrefetchJobs.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        for (Integer index : CollectionsKt.toList(keySet)) {
            if (Math.abs(index.intValue() - currentIndex) > this.config.getPrefetchDistance() + this.config.getPrefetchBehind()) {
                Job job = (Job) this.activePrefetchJobs.remove(index);
                if (job != null) {
                    Intrinsics.checkNotNull(job);
                    DefaultImpls.cancel$default(job, null, 1, null);
                }
            }
        }
        int i = 1;
        int prefetchDistance = this.config.getPrefetchDistance();
        if (1 <= prefetchDistance) {
            while (true) {
                launchPrefetch(currentIndex + i);
                if (i == prefetchDistance) {
                    break;
                }
                i++;
            }
        }
        i = 1;
        prefetchDistance = this.config.getPrefetchBehind();
        if (1 <= prefetchDistance) {
            while (true) {
                launchPrefetch(currentIndex - i);
                if (i != prefetchDistance) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void launchPrefetch(int index) {
        Object obj = null;
        if (index >= 0 && index < this.pageEntries.size()) {
            obj = 1;
        }
        if (obj != null && getBitmapCache().get(Integer.valueOf(index)) == null && !this.activePrefetchJobs.containsKey(Integer.valueOf(index))) {
            Job job = BuildersKt.launch$default(this.scope, (CoroutineContext) Dispatchers.getIO(), null, (Function2) new MangaReaderEngine$launchPrefetch$job$1(this, index, null), 2, null);
            this.activePrefetchJobs.put(Integer.valueOf(index), job);
        }
    }

    private final boolean isSpreadPair(Bitmap left, Bitmap right) {
        return ((float) Math.abs(left.getHeight() - right.getHeight())) < ((float) ((left.getHeight() + right.getHeight()) / 2)) * 0.1f;
    }

    private final Bitmap combineBitmaps(Bitmap left, Bitmap right) {
        int maxHeight = Math.max(left.getHeight(), right.getHeight());
        Bitmap combined = Bitmap.createBitmap(left.getWidth() + right.getWidth(), maxHeight, this.config.getUseRgb565() ? Config.RGB_565 : Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(combined, "createBitmap(...)");
        Canvas canvas = new Canvas(combined);
        canvas.drawColor(-1);
        canvas.drawBitmap(left, 0.0f, ((float) (maxHeight - left.getHeight())) / 2.0f, null);
        canvas.drawBitmap(right, (float) left.getWidth(), ((float) (maxHeight - right.getHeight())) / 2.0f, null);
        return combined;
    }

    private final Rect findContentBounds(int[] pixels, int w, int h) {
        int top = 0;
        int bottom = h;
        int left = 0;
        int right = w;
        while (top < h && isRowWhite(pixels, w, top)) {
            top++;
        }
        if (top >= h) {
            return new Rect(0, 0, w, h);
        }
        while (bottom > top && isRowWhite(pixels, w, bottom - 1)) {
            bottom--;
        }
        while (left < w && isColumnWhite(pixels, w, h, left)) {
            left++;
        }
        while (right > left && isColumnWhite(pixels, w, h, right - 1)) {
            right--;
        }
        int paddingW = (int) (((double) w) * 1202590843);
        int paddingH = (int) (((double) h) * 0.02d);
        return new Rect(Math.max(0, left - paddingW), Math.max(0, top - paddingH), Math.min(w, right + paddingW), Math.min(h, bottom + paddingH));
    }

    private final boolean isRowWhite(int[] pixels, int w, int y) {
        int threshold = this.config.getWhiteThreshold();
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, w), 4);
        int x = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && x <= last) || (step2 < 0 && last <= x)) {
            while (true) {
                int c = pixels[(y * w) + x];
                if (Color.red(c) >= threshold && Color.green(c) >= threshold && Color.blue(c) >= threshold) {
                    if (x == last) {
                        break;
                    }
                    x += step2;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private final boolean isColumnWhite(int[] pixels, int w, int h, int x) {
        int threshold = this.config.getWhiteThreshold();
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, h), 4);
        int y = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && y <= last) || (step2 < 0 && last <= y)) {
            while (true) {
                int c = pixels[(y * w) + x];
                if (Color.red(c) >= threshold && Color.green(c) >= threshold && Color.blue(c) >= threshold) {
                    if (y == last) {
                        break;
                    }
                    y += step2;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private final boolean isImage(String name) {
        String lower = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.endsWith$default(lower, ".jpg", false, 2, null) || StringsKt.endsWith$default(lower, ".jpeg", false, 2, null) || StringsKt.endsWith$default(lower, ".png", false, 2, null) || StringsKt.endsWith$default(lower, ".webp", false, 2, null) || StringsKt.endsWith$default(lower, ".gif", false, 2, null) || StringsKt.endsWith$default(lower, ".bmp", false, 2, null)) {
            return true;
        }
        return false;
    }

    private final int extractPageNumber(String name) {
        CharSequence $this$filterTo$iv$iv = StringsKt.substringAfterLast$default(name, '/', null, 2, null);
        Appendable destination$iv$iv = new StringBuilder();
        int length = $this$filterTo$iv$iv.length();
        for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
            char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
            if (Character.isDigit(element$iv$iv)) {
                destination$iv$iv.append(element$iv$iv);
            }
        }
        String stringBuilder = ((StringBuilder) destination$iv$iv).toString();
        Intrinsics.checkNotNullExpressionValue(stringBuilder, "toString(...)");
        Integer toIntOrNull = StringsKt.toIntOrNull(stringBuilder);
        return toIntOrNull != null ? toIntOrNull.intValue() : Integer.MAX_VALUE;
    }

    private final ImageSize estimateSize(long fileSize) {
        int side = (int) ((float) Math.sqrt((double) ((float) ((int) (((long) 3) * fileSize)))));
        return new ImageSize(side, side);
    }
}
