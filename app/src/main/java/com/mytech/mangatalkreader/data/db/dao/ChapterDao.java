package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.mytech.mangatalkreader.data.db.entity.ChapterEntity;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface ChapterDao {

    @Query("SELECT * FROM ChapterEntity WHERE mangaId = :mangaId ORDER BY number DESC")
    Flow<List<ChapterEntity>> getChaptersByMangaId(long mangaId);

    @Query("SELECT * FROM ChapterEntity WHERE id = :id")
    Flow<ChapterEntity> getChapterById(long id);

    @Query("SELECT * FROM ChapterEntity WHERE mangaId = :mangaId AND isRead = 0 ORDER BY number ASC LIMIT 1")
    Flow<ChapterEntity> getNextUnreadChapter(long mangaId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ChapterEntity chapter);

    @Update
    void update(ChapterEntity chapter);

    @Delete
    void delete(ChapterEntity chapter);

    @Query("UPDATE ChapterEntity SET currentPage = :page, isRead = :isRead WHERE id = :id")
    void updateProgress(long id, int page, boolean isRead);

    @Query("DELETE FROM ChapterEntity WHERE mangaId = :mangaId")
    void deleteByMangaId(long mangaId);
}
