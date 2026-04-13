package com.mytech.mangatalkreader.data.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jb\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006)"}, d2 = {"Lcom/mytech/mangatalkreader/data/db/entity/SourceEntity;", "", "id", "", "name", "", "url", "iconUrl", "isActive", "", "dateAdded", "lastChecked", "updateCheckInterval", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;J)V", "getDateAdded", "()J", "getIconUrl", "()Ljava/lang/String;", "getId", "()Z", "getLastChecked", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "getUpdateCheckInterval", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;J)Lcom/mytech/mangatalkreader/data/db/entity/SourceEntity;", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Entities.kt */
public final class SourceEntity {
    public static final int $stable = 0;
    private final long dateAdded;
    private final String iconUrl;
    private final long id;
    private final boolean isActive;
    private final Long lastChecked;
    private final String name;
    private final long updateCheckInterval;
    private final String url;

    public static /* synthetic */ SourceEntity copy$default(SourceEntity sourceEntity, long j, String str, String str2, String str3, boolean z, long j2, Long l, long j3, int i, Object obj) {
        SourceEntity sourceEntity2 = sourceEntity;
        int i2 = i;
        return sourceEntity.copy((i2 & 1) != 0 ? sourceEntity2.id : j, (i2 & 2) != 0 ? sourceEntity2.name : str, (i2 & 4) != 0 ? sourceEntity2.url : str2, (i2 & 8) != 0 ? sourceEntity2.iconUrl : str3, (i2 & 16) != 0 ? sourceEntity2.isActive : z, (i2 & 32) != 0 ? sourceEntity2.dateAdded : j2, (i2 & 64) != 0 ? sourceEntity2.lastChecked : l, (i2 & 128) != 0 ? sourceEntity2.updateCheckInterval : j3);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final boolean component5() {
        return this.isActive;
    }

    public final long component6() {
        return this.dateAdded;
    }

    public final Long component7() {
        return this.lastChecked;
    }

    public final long component8() {
        return this.updateCheckInterval;
    }

    public final SourceEntity copy(long j, String str, String str2, String str3, boolean z, long j2, Long l, long j3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new SourceEntity(j, str, str2, str3, z, j2, l, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceEntity)) {
            return false;
        }
        SourceEntity sourceEntity = (SourceEntity) obj;
        return this.id == sourceEntity.id && Intrinsics.areEqual(this.name, sourceEntity.name) && Intrinsics.areEqual(this.url, sourceEntity.url) && Intrinsics.areEqual(this.iconUrl, sourceEntity.iconUrl) && this.isActive == sourceEntity.isActive && this.dateAdded == sourceEntity.dateAdded && Intrinsics.areEqual(this.lastChecked, sourceEntity.lastChecked) && this.updateCheckInterval == sourceEntity.updateCheckInterval;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + (this.iconUrl == null ? 0 : this.iconUrl.hashCode())) * 31) + Boolean.hashCode(this.isActive)) * 31) + Long.hashCode(this.dateAdded)) * 31;
        if (this.lastChecked != null) {
            i = this.lastChecked.hashCode();
        }
        return ((hashCode + i) * 31) + Long.hashCode(this.updateCheckInterval);
    }

    public String toString() {
        long j = this.id;
        String str = this.name;
        String str2 = this.url;
        String str3 = this.iconUrl;
        boolean z = this.isActive;
        long j2 = this.dateAdded;
        Long l = this.lastChecked;
        return "SourceEntity(id=" + j + ", name=" + str + ", url=" + str2 + ", iconUrl=" + str3 + ", isActive=" + z + ", dateAdded=" + j2 + ", lastChecked=" + l + ", updateCheckInterval=" + this.updateCheckInterval + ")";
    }

    public SourceEntity(long id, String name, String url, String iconUrl, boolean isActive, long dateAdded, Long lastChecked, long updateCheckInterval) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.name = name;
        this.url = url;
        this.iconUrl = iconUrl;
        this.isActive = isActive;
        this.dateAdded = dateAdded;
        this.lastChecked = lastChecked;
        this.updateCheckInterval = updateCheckInterval;
    }

    public /* synthetic */ SourceEntity(long j, String str, String str2, String str3, boolean z, long j2, Long l, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j4;
        String str4;
        long currentTimeMillis;
        Long l2;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j4 = 0;
        } else {
            j4 = j;
        }
        if ((i2 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        boolean z2 = (i2 & 16) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j2;
        }
        if ((i2 & 64) != 0) {
            l2 = null;
        } else {
            l2 = l;
        }
        this(j4, str, str2, str4, z2, currentTimeMillis, l2, (i2 & 128) != 0 ? 86400000 : j3);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }

    public final Long getLastChecked() {
        return this.lastChecked;
    }

    public final long getUpdateCheckInterval() {
        return this.updateCheckInterval;
    }
}
