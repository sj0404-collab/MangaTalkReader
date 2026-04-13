package com.mytech.mangatalkreader.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b"}, d2 = {"Lcom/mytech/mangatalkreader/domain/model/Chapter;", "", "url", "", "name", "scanlator", "read", "", "dateUpload", "pagesCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Chapter {
    private final String url;
    private final String name;
    private final String scanlator;
    private final String read;
    private final long dateUpload;
    private final int pagesCount;

    public Chapter(String url, String name, String scanlator, String read, long dateUpload, int pagesCount) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        this.url = url;
        this.name = name;
        this.scanlator = scanlator;
        this.read = read;
        this.dateUpload = dateUpload;
        this.pagesCount = pagesCount;
    }

    public Chapter(String url, String name, String scanlator) {
        this(url, name, scanlator, "", 0, 0);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScanlator() {
        return this.scanlator;
    }

    public final String getRead() {
        return this.read;
    }

    public final long getDateUpload() {
        return this.dateUpload;
    }

    public final int getPagesCount() {
        return this.pagesCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Chapter)) return false;
        Chapter chapter = (Chapter) obj;
        return Intrinsics.areEqual(this.url, chapter.url) &&
               Intrinsics.areEqual(this.name, chapter.name) &&
               Intrinsics.areEqual(this.scanlator, chapter.scanlator);
    }

    @Override
    public int hashCode() {
        int result = this.url.hashCode();
        result = (result * 31) + this.name.hashCode();
        result = (result * 31) + (this.scanlator != null ? this.scanlator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chapter(url='" + url + "', name='" + name + "', scanlator='" + scanlator + "')";
    }
}
