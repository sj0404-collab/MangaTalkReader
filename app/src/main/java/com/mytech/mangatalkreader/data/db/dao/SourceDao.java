package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.mytech.mangatalkreader.data.db.entity.SourceEntity;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface SourceDao {

    @Query("SELECT * FROM SourceEntity ORDER BY name ASC")
    Flow<List<SourceEntity>> getAllSources();

    @Query("SELECT * FROM SourceEntity WHERE id = :id")
    Flow<SourceEntity> getSourceById(long id);

    @Query("SELECT * FROM SourceEntity WHERE isActive = 1 ORDER BY name ASC")
    Flow<List<SourceEntity>> getActiveSources();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(SourceEntity source);

    @Update
    void update(SourceEntity source);

    @Delete
    void delete(SourceEntity source);

    @Query("UPDATE SourceEntity SET isActive = :active WHERE id = :id")
    void setActive(long id, boolean active);
}
