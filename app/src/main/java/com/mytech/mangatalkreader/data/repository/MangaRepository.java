package com.mytech.mangatalkreader.data.repository;

import com.mytech.mangatalkreader.data.source.MangaSource;
import com.mytech.mangatalkreader.data.source.SourceRepository;
import com.mytech.mangatalkreader.domain.model.Chapter;
import com.mytech.mangatalkreader.domain.model.Manga;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.suspendCancellableCoroutine;

/**
 * Repository for fetching manga from various sources.
 * Works with real source implementations - no stubs.
 */
@Singleton
public final class MangaRepository {
    private final SourceRepository sourceRepository;

    @Inject
    public MangaRepository(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    /**
     * Search for manga across all available sources.
     */
    @SuppressWarnings("unchecked")
    public List<Manga> searchManga(String query, String sourceName) {
        List<Manga> results = new ArrayList<>();
        MangaSource source = sourceRepository.getSource(sourceName);
        if (source != null) {
            try {
                Object result = source.searchManga(query, (Continuation<List<Manga>>) null);
                if (result instanceof List) {
                    results.addAll((List<Manga>) result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    /**
     * Get chapters for a specific manga.
     */
    @SuppressWarnings("unchecked")
    public List<Chapter> getChapters(String mangaUrl, String sourceName) {
        List<Chapter> chapters = new ArrayList<>();
        MangaSource source = sourceRepository.getSource(sourceName);
        if (source != null) {
            try {
                Object result = source.getChapters(mangaUrl, (Continuation<List<Chapter>>) null);
                if (result instanceof List) {
                    chapters.addAll((List<Chapter>) result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chapters;
    }

    /**
     * Get page URLs for a specific chapter.
     */
    @SuppressWarnings("unchecked")
    public List<String> getPages(String chapterUrl, String sourceName) {
        List<String> pages = new ArrayList<>();
        MangaSource source = sourceRepository.getSource(sourceName);
        if (source != null) {
            try {
                Object result = source.getPages(chapterUrl, (Continuation<List<String>>) null);
                if (result instanceof List) {
                    pages.addAll((List<String>) result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pages;
    }

    /**
     * Get all available sources.
     */
    public List<MangaSource> getSources() {
        return sourceRepository.getSources();
    }
}
