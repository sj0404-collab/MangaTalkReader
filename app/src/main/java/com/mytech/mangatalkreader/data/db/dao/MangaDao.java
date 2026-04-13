package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.mytech.mangatalkreader.data.db.entity.MangaEntity;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface MangaDao {

    @Query("SELECT * FROM MangaEntity ORDER BY dateAdded DESC")
    Flow<List<MangaEntity>> getAllManga();

    @Query("SELECT * FROM MangaEntity WHERE id = :id")
    Flow<MangaEntity> getMangaById(long id);

    @Query("SELECT * FROM MangaEntity WHERE title LIKE '%' || :query || '%' OR author LIKE '%' || :query || '%'")
    Flow<List<MangaEntity>> searchManga(String query);

    @Query("SELECT * FROM MangaEntity WHERE isFavorite = 1 ORDER BY dateAdded DESC")
    Flow<List<MangaEntity>> getFavoriteManga();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MangaEntity manga);

    @Update
    void update(MangaEntity manga);

    @Delete
    void delete(MangaEntity manga);

    @Query("DELETE FROM MangaEntity WHERE id = :id")
    void deleteById(long id);

    @Query("SELECT EXISTS(SELECT 1 FROM MangaEntity WHERE id = :id)")
    boolean exists(long id);
}
