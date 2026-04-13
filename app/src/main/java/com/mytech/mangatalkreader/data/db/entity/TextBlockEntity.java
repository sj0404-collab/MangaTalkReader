package com.mytech.mangatalkreader.data.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b*\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001c¨\u0006<"}, d2 = {"Lcom/mytech/mangatalkreader/data/db/entity/TextBlockEntity;", "", "id", "", "chapterId", "pageNumber", "", "text", "", "type", "language", "x", "", "y", "width", "height", "fontSize", "hasAudio", "", "audioPath", "dateAdded", "(JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFFZLjava/lang/String;J)V", "getAudioPath", "()Ljava/lang/String;", "getChapterId", "()J", "getDateAdded", "getFontSize", "()F", "getHasAudio", "()Z", "getHeight", "getId", "getLanguage", "getPageNumber", "()I", "getText", "getType", "getWidth", "getX", "getY", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Entities.kt */
public final class TextBlockEntity {
    public static final int $stable = 0;
    private final String audioPath;
    private final long chapterId;
    private final long dateAdded;
    private final float fontSize;
    private final boolean hasAudio;
    private final float height;
    private final long id;
    private final String language;
    private final int pageNumber;
    private final String text;
    private final String type;
    private final float width;
    private final float x;
    private final float y;

    public static /* synthetic */ TextBlockEntity copy$default(TextBlockEntity textBlockEntity, long j, long j2, int i, String str, String str2, String str3, float f, float f2, float f3, float f4, float f5, boolean z, String str4, long j3, int i2, Object obj) {
        TextBlockEntity textBlockEntity2 = textBlockEntity;
        int i3 = i2;
        return textBlockEntity.copy((i3 & 1) != 0 ? textBlockEntity2.id : j, (i3 & 2) != 0 ? textBlockEntity2.chapterId : j2, (i3 & 4) != 0 ? textBlockEntity2.pageNumber : i, (i3 & 8) != 0 ? textBlockEntity2.text : str, (i3 & 16) != 0 ? textBlockEntity2.type : str2, (i3 & 32) != 0 ? textBlockEntity2.language : str3, (i3 & 64) != 0 ? textBlockEntity2.x : f, (i3 & 128) != 0 ? textBlockEntity2.y : f2, (i3 & 256) != 0 ? textBlockEntity2.width : f3, (i3 & 512) != 0 ? textBlockEntity2.height : f4, (i3 & 1024) != 0 ? textBlockEntity2.fontSize : f5, (i3 & 2048) != 0 ? textBlockEntity2.hasAudio : z, (i3 & 4096) != 0 ? textBlockEntity2.audioPath : str4, (i3 & 8192) != 0 ? textBlockEntity2.dateAdded : j3);
    }

    public final long component1() {
        return this.id;
    }

    public final float component10() {
        return this.height;
    }

    public final float component11() {
        return this.fontSize;
    }

    public final boolean component12() {
        return this.hasAudio;
    }

    public final String component13() {
        return this.audioPath;
    }

    public final long component14() {
        return this.dateAdded;
    }

    public final long component2() {
        return this.chapterId;
    }

    public final int component3() {
        return this.pageNumber;
    }

    public final String component4() {
        return this.text;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.language;
    }

    public final float component7() {
        return this.x;
    }

    public final float component8() {
        return this.y;
    }

    public final float component9() {
        return this.width;
    }

    public final TextBlockEntity copy(long j, long j2, int i, String str, String str2, String str3, float f, float f2, float f3, float f4, float f5, boolean z, String str4, long j3) {
        long j4 = j2;
        int i2 = i;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        float f6 = f;
        float f7 = f2;
        float f8 = f3;
        float f9 = f4;
        float f10 = f5;
        boolean z2 = z;
        String str8 = str4;
        long j5 = j3;
        long j6 = j;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "language");
        return new TextBlockEntity(j6, j4, i2, str5, str6, str7, f6, f7, f8, f9, f10, z2, str8, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextBlockEntity)) {
            return false;
        }
        TextBlockEntity textBlockEntity = (TextBlockEntity) obj;
        return this.id == textBlockEntity.id && this.chapterId == textBlockEntity.chapterId && this.pageNumber == textBlockEntity.pageNumber && Intrinsics.areEqual(this.text, textBlockEntity.text) && Intrinsics.areEqual(this.type, textBlockEntity.type) && Intrinsics.areEqual(this.language, textBlockEntity.language) && Float.compare(this.x, textBlockEntity.x) == 0 && Float.compare(this.y, textBlockEntity.y) == 0 && Float.compare(this.width, textBlockEntity.width) == 0 && Float.compare(this.height, textBlockEntity.height) == 0 && Float.compare(this.fontSize, textBlockEntity.fontSize) == 0 && this.hasAudio == textBlockEntity.hasAudio && Intrinsics.areEqual(this.audioPath, textBlockEntity.audioPath) && this.dateAdded == textBlockEntity.dateAdded;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.chapterId)) * 31) + Integer.hashCode(this.pageNumber)) * 31) + this.text.hashCode()) * 31) + this.type.hashCode()) * 31) + this.language.hashCode()) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height)) * 31) + Float.hashCode(this.fontSize)) * 31) + Boolean.hashCode(this.hasAudio)) * 31) + (this.audioPath == null ? 0 : this.audioPath.hashCode())) * 31) + Long.hashCode(this.dateAdded);
    }

    public String toString() {
        long j = this.id;
        long j2 = this.chapterId;
        int i = this.pageNumber;
        String str = this.text;
        String str2 = this.type;
        String str3 = this.language;
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        float f5 = this.fontSize;
        boolean z = this.hasAudio;
        String str4 = this.audioPath;
        return "TextBlockEntity(id=" + j + ", chapterId=" + j2 + ", pageNumber=" + i + ", text=" + str + ", type=" + str2 + ", language=" + str3 + ", x=" + f + ", y=" + f2 + ", width=" + f3 + ", height=" + f4 + ", fontSize=" + f5 + ", hasAudio=" + z + ", audioPath=" + str4 + ", dateAdded=" + this.dateAdded + ")";
    }

    public TextBlockEntity(long id, long chapterId, int pageNumber, String text, String type, String language, float x, float y, float width, float height, float fontSize, boolean hasAudio, String audioPath, long dateAdded) {
        String str = text;
        String str2 = type;
        String str3 = language;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "language");
        this.id = id;
        this.chapterId = chapterId;
        this.pageNumber = pageNumber;
        this.text = str;
        this.type = str2;
        this.language = str3;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
        this.hasAudio = hasAudio;
        this.audioPath = audioPath;
        this.dateAdded = dateAdded;
    }

    public /* synthetic */ TextBlockEntity(long j, long j2, int i, String str, String str2, String str3, float f, float f2, float f3, float f4, float f5, boolean z, String str4, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j4;
        String str5;
        String str6;
        long currentTimeMillis;
        int i3 = i2;
        if ((i3 & 1) != 0) {
            j4 = 0;
        } else {
            j4 = j;
        }
        if ((i3 & 16) != 0) {
            str5 = "dialog";
        } else {
            str5 = str2;
        }
        if ((i3 & 32) != 0) {
            str6 = "ru";
        } else {
            str6 = str3;
        }
        float f6 = (i3 & 1024) != 0 ? 16.0f : f5;
        boolean z2 = (i3 & 2048) != 0 ? false : z;
        String str7 = (i3 & 4096) != 0 ? null : str4;
        if ((i3 & 8192) != 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j3;
        }
        this(j4, j2, i, str, str5, str6, f, f2, f3, f4, f6, z2, str7, currentTimeMillis);
    }

    public final long getId() {
        return this.id;
    }

    public final long getChapterId() {
        return this.chapterId;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final boolean getHasAudio() {
        return this.hasAudio;
    }

    public final String getAudioPath() {
        return this.audioPath;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }
}
