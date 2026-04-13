package com.mytech.mangatalkreader.ui.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope;
import com.mytech.mangatalkreader.data.db.dao.ChapterDao;
import com.mytech.mangatalkreader.data.db.dao.MangaDao;
import com.mytech.mangatalkreader.data.db.entity.ChapterEntity;
import com.mytech.mangatalkreader.data.db.entity.MangaEntity;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.stateIn;

@HiltViewModel
public final class MangaDetailsViewModel extends ViewModel {
    private final MangaDao mangaDao;
    private final ChapterDao chapterDao;
    private final SavedStateHandle savedStateHandle;
    public final Flow<MangaEntity> manga;
    public final Flow<java.util.List<ChapterEntity>> chapters;

    @Inject
    public MangaDetailsViewModel(MangaDao mangaDao, ChapterDao chapterDao, SavedStateHandle savedStateHandle) {
        this.mangaDao = mangaDao;
        this.chapterDao = chapterDao;
        this.savedStateHandle = savedStateHandle;
        long mangaId = savedStateHandle.get("mangaId");
        this.manga = mangaDao.getMangaById(mangaId).stateIn(viewModelScope, SharingStarted.Lazily, null);
        this.chapters = chapterDao.getChaptersByMangaId(mangaId).stateIn(viewModelScope, SharingStarted.Lazily, java.util.Collections.emptyList());
    }

    public void updateManga(MangaEntity manga) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            mangaDao.update(manga);
            return null;
        });
    }
}
