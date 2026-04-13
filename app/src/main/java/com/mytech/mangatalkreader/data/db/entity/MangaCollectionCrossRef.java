package com.mytech.mangatalkreader.data.db.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/mytech/mangatalkreader/data/db/entity/MangaCollectionCrossRef;", "", "mangaId", "", "collectionId", "(JJ)V", "getCollectionId", "()J", "getMangaId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Entities.kt */
public final class MangaCollectionCrossRef {
    public static final int $stable = 0;
    private final long collectionId;
    private final long mangaId;

    public static /* synthetic */ MangaCollectionCrossRef copy$default(MangaCollectionCrossRef mangaCollectionCrossRef, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mangaCollectionCrossRef.mangaId;
        }
        if ((i & 2) != 0) {
            j2 = mangaCollectionCrossRef.collectionId;
        }
        return mangaCollectionCrossRef.copy(j, j2);
    }

    public final long component1() {
        return this.mangaId;
    }

    public final long component2() {
        return this.collectionId;
    }

    public final MangaCollectionCrossRef copy(long j, long j2) {
        return new MangaCollectionCrossRef(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MangaCollectionCrossRef)) {
            return false;
        }
        MangaCollectionCrossRef mangaCollectionCrossRef = (MangaCollectionCrossRef) obj;
        return this.mangaId == mangaCollectionCrossRef.mangaId && this.collectionId == mangaCollectionCrossRef.collectionId;
    }

    public int hashCode() {
        return (Long.hashCode(this.mangaId) * 31) + Long.hashCode(this.collectionId);
    }

    public String toString() {
        long j = this.mangaId;
        return "MangaCollectionCrossRef(mangaId=" + j + ", collectionId=" + this.collectionId + ")";
    }

    public MangaCollectionCrossRef(long mangaId, long collectionId) {
        this.mangaId = mangaId;
        this.collectionId = collectionId;
    }

    public final long getMangaId() {
        return this.mangaId;
    }

    public final long getCollectionId() {
        return this.collectionId;
    }
}
