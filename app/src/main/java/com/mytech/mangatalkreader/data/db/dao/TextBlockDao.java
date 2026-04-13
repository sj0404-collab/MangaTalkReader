package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.mytech.mangatalkreader.data.db.entity.TextBlockEntity;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface TextBlockDao {

    @Query("SELECT * FROM TextBlockEntity WHERE chapterId = :chapterId AND pageNumber = :pageNumber")
    Flow<List<TextBlockEntity>> getTextBlocks(long chapterId, int pageNumber);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(TextBlockEntity textBlock);

    @Query("DELETE FROM TextBlockEntity WHERE chapterId = :chapterId")
    void deleteByChapterId(long chapterId);
}
