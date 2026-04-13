package com.mytech.mangatalkreader.data.source;

import com.mytech.mangatalkreader.data.source.impl.MangaDexSource;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mytech/mangatalkreader/data/source/SourceRepository;", "", "()V", "sources", "", "Lcom/mytech/mangatalkreader/data/source/MangaSource;", "getSource", "name", "", "getSources", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SourceRepository.kt */
public final class SourceRepository {
    public static final int $stable = 8;
    private final List<MangaSource> sources = CollectionsKt.listOf(new MangaDexSource());

    public final List<MangaSource> getSources() {
        return this.sources;
    }

    public final MangaSource getSource(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        for (MangaSource source : this.sources) {
            if (Intrinsics.areEqual(source.getName(), name)) {
                return source;
            }
        }
        return null;
    }
}
