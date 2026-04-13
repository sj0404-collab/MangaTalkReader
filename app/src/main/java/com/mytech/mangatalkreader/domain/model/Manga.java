package com.mytech.mangatalkreader.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n"}, d2 = {"Lcom/mytech/mangatalkreader/domain/model/Manga;", "", "url", "", "title", "coverUrl", "author", "description", "isFavorite", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Manga {
    private final String url;
    private final String title;
    private final String coverUrl;
    private final String author;
    private final String description;
    private final boolean isFavorite;

    public Manga(String url, String title, String coverUrl, String author, String description, boolean isFavorite) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        this.url = url;
        this.title = title;
        this.coverUrl = coverUrl;
        this.author = author;
        this.description = description;
        this.isFavorite = isFavorite;
    }

    public Manga(String url, String title, String coverUrl) {
        this(url, title, coverUrl, null, null, false);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manga)) return false;
        Manga manga = (Manga) obj;
        return Intrinsics.areEqual(this.url, manga.url) &&
               Intrinsics.areEqual(this.title, manga.title);
    }

    @Override
    public int hashCode() {
        int result = this.url.hashCode();
        result = (result * 31) + this.title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Manga(url='" + url + "', title='" + title + "', coverUrl='" + coverUrl + "')";
    }
}
