package com.mytech.mangatalkreader.data.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/mytech/mangatalkreader/data/db/entity/CollectionEntity;", "", "id", "", "name", "", "description", "iconColor", "", "dateAdded", "(JLjava/lang/String;Ljava/lang/String;IJ)V", "getDateAdded", "()J", "getDescription", "()Ljava/lang/String;", "getIconColor", "()I", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Entities.kt */
public final class CollectionEntity {
    public static final int $stable = 0;
    private final long dateAdded;
    private final String description;
    private final int iconColor;
    private final long id;
    private final String name;

    public static /* synthetic */ CollectionEntity copy$default(CollectionEntity collectionEntity, long j, String str, String str2, int i, long j2, int i2, Object obj) {
        CollectionEntity collectionEntity2 = collectionEntity;
        return collectionEntity.copy((i2 & 1) != 0 ? collectionEntity2.id : j, (i2 & 2) != 0 ? collectionEntity2.name : str, (i2 & 4) != 0 ? collectionEntity2.description : str2, (i2 & 8) != 0 ? collectionEntity2.iconColor : i, (i2 & 16) != 0 ? collectionEntity2.dateAdded : j2);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.iconColor;
    }

    public final long component5() {
        return this.dateAdded;
    }

    public final CollectionEntity copy(long j, String str, String str2, int i, long j2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "name");
        return new CollectionEntity(j, str, str2, i, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionEntity)) {
            return false;
        }
        CollectionEntity collectionEntity = (CollectionEntity) obj;
        return this.id == collectionEntity.id && Intrinsics.areEqual(this.name, collectionEntity.name) && Intrinsics.areEqual(this.description, collectionEntity.description) && this.iconColor == collectionEntity.iconColor && this.dateAdded == collectionEntity.dateAdded;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + Integer.hashCode(this.iconColor)) * 31) + Long.hashCode(this.dateAdded);
    }

    public String toString() {
        long j = this.id;
        String str = this.name;
        String str2 = this.description;
        int i = this.iconColor;
        return "CollectionEntity(id=" + j + ", name=" + str + ", description=" + str2 + ", iconColor=" + i + ", dateAdded=" + this.dateAdded + ")";
    }

    public CollectionEntity(long id, String name, String description, int iconColor, long dateAdded) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconColor = iconColor;
        this.dateAdded = dateAdded;
    }

    public /* synthetic */ CollectionEntity(long j, String str, String str2, int i, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j3;
        long currentTimeMillis;
        if ((i2 & 1) != 0) {
            j3 = 0;
        } else {
            j3 = j;
        }
        String str3 = (i2 & 4) != 0 ? null : str2;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j2;
        }
        this(j3, str, str3, i3, currentTimeMillis);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }
}
