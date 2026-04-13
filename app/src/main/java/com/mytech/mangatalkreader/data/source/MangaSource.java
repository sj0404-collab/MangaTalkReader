package com.mytech.mangatalkreader.data.source;

import com.mytech.mangatalkreader.domain.model.Chapter;
import com.mytech.mangatalkreader.domain.model.Manga;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/mytech/mangatalkreader/data/source/MangaSource;", "", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "lang", "getLang", "name", "getName", "getChapters", "", "Lcom/mytech/mangatalkreader/domain/model/Chapter;", "mangaUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPages", "chapterUrl", "searchManga", "Lcom/mytech/mangatalkreader/domain/model/Manga;", "query", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MangaSource.kt */
public interface MangaSource {
    String getBaseUrl();

    Object getChapters(String str, Continuation<? super List<Chapter>> continuation);

    String getLang();

    String getName();

    Object getPages(String str, Continuation<? super List<String>> continuation);

    Object searchManga(String str, Continuation<? super List<Manga>> continuation);
}
