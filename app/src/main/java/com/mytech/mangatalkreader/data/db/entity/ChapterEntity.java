package com.mytech.mangatalkreader.data.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\fHÖ\u0001J\t\u00107\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001e¨\u00068"}, d2 = {"Lcom/mytech/mangatalkreader/data/db/entity/ChapterEntity;", "", "id", "", "mangaId", "name", "", "number", "", "url", "path", "currentPage", "", "isRead", "", "dateAdded", "source", "pagesCount", "dateUpload", "title", "(JJLjava/lang/String;FLjava/lang/String;Ljava/lang/String;IZJLjava/lang/String;IJLjava/lang/String;)V", "getCurrentPage", "()I", "getDateAdded", "()J", "getDateUpload", "getId", "()Z", "getMangaId", "getName", "()Ljava/lang/String;", "getNumber", "()F", "getPagesCount", "getPath", "getSource", "getTitle", "getUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Entities.kt */
public final class ChapterEntity {
    public static final int $stable = 0;
    private final int currentPage;
    private final long dateAdded;
    private final long dateUpload;
    private final long id;
    private final boolean isRead;
    private final long mangaId;
    private final String name;
    private final float number;
    private final int pagesCount;
    private final String path;
    private final String source;
    private final String title;
    private final String url;

    public static /* synthetic */ ChapterEntity copy$default(ChapterEntity chapterEntity, long j, long j2, String str, float f, String str2, String str3, int i, boolean z, long j3, String str4, int i2, long j4, String str5, int i3, Object obj) {
        ChapterEntity chapterEntity2 = chapterEntity;
        int i4 = i3;
        return chapterEntity.copy((i4 & 1) != 0 ? chapterEntity2.id : j, (i4 & 2) != 0 ? chapterEntity2.mangaId : j2, (i4 & 4) != 0 ? chapterEntity2.name : str, (i4 & 8) != 0 ? chapterEntity2.number : f, (i4 & 16) != 0 ? chapterEntity2.url : str2, (i4 & 32) != 0 ? chapterEntity2.path : str3, (i4 & 64) != 0 ? chapterEntity2.currentPage : i, (i4 & 128) != 0 ? chapterEntity2.isRead : z, (i4 & 256) != 0 ? chapterEntity2.dateAdded : j3, (i4 & 512) != 0 ? chapterEntity2.source : str4, (i4 & 1024) != 0 ? chapterEntity2.pagesCount : i2, (i4 & 2048) != 0 ? chapterEntity2.dateUpload : j4, (i4 & 4096) != 0 ? chapterEntity2.title : str5);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.source;
    }

    public final int component11() {
        return this.pagesCount;
    }

    public final long component12() {
        return this.dateUpload;
    }

    public final String component13() {
        return this.title;
    }

    public final long component2() {
        return this.mangaId;
    }

    public final String component3() {
        return this.name;
    }

    public final float component4() {
        return this.number;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.path;
    }

    public final int component7() {
        return this.currentPage;
    }

    public final boolean component8() {
        return this.isRead;
    }

    public final long component9() {
        return this.dateAdded;
    }

    public final ChapterEntity copy(long j, long j2, String str, float f, String str2, String str3, int i, boolean z, long j3, String str4, int i2, long j4, String str5) {
        long j5 = j2;
        String str6 = str;
        float f2 = f;
        String str7 = str2;
        String str8 = str3;
        int i3 = i;
        boolean z2 = z;
        long j6 = j3;
        String str9 = str4;
        int i4 = i2;
        long j7 = j4;
        String str10 = str5;
        long j8 = j;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str3, "path");
        Intrinsics.checkNotNullParameter(str4, "source");
        Intrinsics.checkNotNullParameter(str5, "title");
        return new ChapterEntity(j8, j5, str6, f2, str7, str8, i3, z2, j6, str9, i4, j7, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChapterEntity)) {
            return false;
        }
        ChapterEntity chapterEntity = (ChapterEntity) obj;
        return this.id == chapterEntity.id && this.mangaId == chapterEntity.mangaId && Intrinsics.areEqual(this.name, chapterEntity.name) && Float.compare(this.number, chapterEntity.number) == 0 && Intrinsics.areEqual(this.url, chapterEntity.url) && Intrinsics.areEqual(this.path, chapterEntity.path) && this.currentPage == chapterEntity.currentPage && this.isRead == chapterEntity.isRead && this.dateAdded == chapterEntity.dateAdded && Intrinsics.areEqual(this.source, chapterEntity.source) && this.pagesCount == chapterEntity.pagesCount && this.dateUpload == chapterEntity.dateUpload && Intrinsics.areEqual(this.title, chapterEntity.title);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.mangaId)) * 31) + this.name.hashCode()) * 31) + Float.hashCode(this.number)) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + this.path.hashCode()) * 31) + Integer.hashCode(this.currentPage)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Long.hashCode(this.dateAdded)) * 31) + this.source.hashCode()) * 31) + Integer.hashCode(this.pagesCount)) * 31) + Long.hashCode(this.dateUpload)) * 31) + this.title.hashCode();
    }

    public String toString() {
        long j = this.id;
        long j2 = this.mangaId;
        String str = this.name;
        float f = this.number;
        String str2 = this.url;
        String str3 = this.path;
        int i = this.currentPage;
        boolean z = this.isRead;
        long j3 = this.dateAdded;
        String str4 = this.source;
        int i2 = this.pagesCount;
        long j4 = this.dateUpload;
        return "ChapterEntity(id=" + j + ", mangaId=" + j2 + ", name=" + str + ", number=" + f + ", url=" + str2 + ", path=" + str3 + ", currentPage=" + i + ", isRead=" + z + ", dateAdded=" + j3 + ", source=" + str4 + ", pagesCount=" + i2 + ", dateUpload=" + j4 + ", title=" + this.title + ")";
    }

    public ChapterEntity(long id, long mangaId, String name, float number, String url, String path, int currentPage, boolean isRead, long dateAdded, String source, int pagesCount, long dateUpload, String title) {
        String str = name;
        String str2 = path;
        String str3 = source;
        String str4 = title;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "source");
        Intrinsics.checkNotNullParameter(str4, "title");
        this.id = id;
        this.mangaId = mangaId;
        this.name = str;
        this.number = number;
        this.url = url;
        this.path = str2;
        this.currentPage = currentPage;
        this.isRead = isRead;
        this.dateAdded = dateAdded;
        this.source = str3;
        this.pagesCount = pagesCount;
        this.dateUpload = dateUpload;
        this.title = str4;
    }

    public /* synthetic */ ChapterEntity(long j, long j2, String str, float f, String str2, String str3, int i, boolean z, long j3, String str4, int i2, long j4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        long j5;
        String str6;
        int i4;
        boolean z2;
        long currentTimeMillis;
        String str7;
        int i5;
        long j6;
        String str8;
        int i6 = i3;
        if ((i6 & 1) != 0) {
            j5 = 0;
        } else {
            j5 = j;
        }
        String str9 = (i6 & 16) != 0 ? null : str2;
        String str10 = "";
        if ((i6 & 32) != 0) {
            str6 = str10;
        } else {
            str6 = str3;
        }
        if ((i6 & 64) != 0) {
            i4 = 0;
        } else {
            i4 = i;
        }
        if ((i6 & 128) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i6 & 256) != 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j3;
        }
        if ((i6 & 512) != 0) {
            str7 = "LOCAL";
        } else {
            str7 = str4;
        }
        if ((i6 & 1024) != 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if ((i6 & 2048) != 0) {
            j6 = 0;
        } else {
            j6 = j4;
        }
        if ((i6 & 4096) != 0) {
            str8 = str10;
        } else {
            str8 = str5;
        }
        this(j5, j2, str, f, str9, str6, i4, z2, currentTimeMillis, str7, i5, j6, str8);
    }

    public final long getId() {
        return this.id;
    }

    public final long getMangaId() {
        return this.mangaId;
    }

    public final String getName() {
        return this.name;
    }

    public final float getNumber() {
        return this.number;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getPagesCount() {
        return this.pagesCount;
    }

    public final long getDateUpload() {
        return this.dateUpload;
    }

    public final String getTitle() {
        return this.title;
    }
}
