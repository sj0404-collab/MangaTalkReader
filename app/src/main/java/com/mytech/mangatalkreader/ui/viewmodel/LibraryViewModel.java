package com.mytech.mangatalkreader.ui.viewmodel;

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
import kotlinx.coroutines.launch;

@HiltViewModel
public final class LibraryViewModel extends ViewModel {
    private final MangaDao mangaDao;
    public final Flow<java.util.List<MangaEntity>> mangaList;

    @Inject
    public LibraryViewModel(MangaDao mangaDao) {
        this.mangaDao = mangaDao;
        this.mangaList = mangaDao.getAllManga().stateIn(viewModelScope, SharingStarted.Lazily, java.util.Collections.emptyList());
    }

    public void addToLibrary(MangaEntity manga) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            mangaDao.insert(manga);
            return null;
        });
    }

    public void removeFromLibrary(long mangaId) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            mangaDao.deleteById(mangaId);
            return null;
        });
    }
}
