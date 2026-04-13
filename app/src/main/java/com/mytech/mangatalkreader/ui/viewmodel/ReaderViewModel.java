package com.mytech.mangatalkreader.ui.viewmodel;

import android.graphics.Bitmap;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope;
import com.mytech.mangatalkreader.data.db.dao.ChapterDao;
import com.mytech.mangatalkreader.data.db.entity.ChapterEntity;
import com.mytech.mangatalkreader.reader.MangaReaderEngine;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.stateIn;
import kotlinx.coroutines.launch;

@HiltViewModel
public final class ReaderViewModel extends ViewModel {
    private final ChapterDao chapterDao;
    private final SavedStateHandle savedStateHandle;
    private final MangaReaderEngine readerEngine;
    public final Flow<ChapterEntity> chapter;
    private final MutableStateFlow<Bitmap> currentPage = new MutableStateFlow<>(null);

    @Inject
    public ReaderViewModel(ChapterDao chapterDao, SavedStateHandle savedStateHandle, MangaReaderEngine readerEngine) {
        this.chapterDao = chapterDao;
        this.savedStateHandle = savedStateHandle;
        this.readerEngine = readerEngine;
        long chapterId = savedStateHandle.get("chapterId");
        this.chapter = chapterDao.getChapterById(chapterId).stateIn(viewModelScope, SharingStarted.Lazily, null);
    }

    public void loadPage(int pageIndex) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            Bitmap bitmap = readerEngine.getPage(pageIndex);
            if (bitmap != null) {
                currentPage.setValue(bitmap);
            }
            return null;
        });
    }

    public Flow<Bitmap> getCurrentPage() {
        return currentPage;
    }

    public void saveProgress(long chapterId, int page) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            chapterDao.updateProgress(chapterId, page, false);
            return null;
        });
    }
}
