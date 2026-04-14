package com.mytech.mangatalkreader.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytech.mangatalkreader.data.db.dao.ChapterDao
import com.mytech.mangatalkreader.data.db.entity.ChapterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReaderViewModel @Inject constructor(
    private val chapterDao: ChapterDao
) : ViewModel() {

    private val _pageUrls = MutableStateFlow<List<String>>(emptyList())
    val pageUrls: StateFlow<List<String>> = _pageUrls.asStateFlow()

    private val _chapter = MutableStateFlow<ChapterEntity?>(null)
    val chapter: StateFlow<ChapterEntity?> = _chapter.asStateFlow()

    private val _currentPage = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage.asStateFlow()

    fun loadChapter(chapterId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            chapterDao.getChapterById(chapterId).collect { chapter ->
                _chapter.value = chapter
            }
        }
    }

    fun setPageUrls(urls: List<String>) {
        _pageUrls.value = urls
    }

    fun saveProgress(pageIndex: Int) {
        _currentPage.value = pageIndex
        viewModelScope.launch(Dispatchers.IO) {
            val ch = _chapter.value
            if (ch != null) {
                chapterDao.updateProgress(ch.id, pageIndex)
            }
        }
    }

    @dagger.hilt.android.lifecycle.HiltViewModel
    class Factory @Inject constructor(
        private val chapterDao: ChapterDao
    ) : androidx.lifecycle.ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ReaderViewModel(chapterDao) as T
        }

        fun create(chapterId: Long): ReaderViewModel {
            val vm = ReaderViewModel(chapterDao)
            vm.loadChapter(chapterId)
            return vm
        }
    }
}
