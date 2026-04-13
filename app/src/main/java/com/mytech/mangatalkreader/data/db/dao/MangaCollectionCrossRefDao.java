package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.mytech.mangatalkreader.data.db.entity.MangaCollectionCrossRef;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface MangaCollectionCrossRefDao {

    @Query("SELECT * FROM MangaCollectionCrossRef WHERE collectionId = :collectionId")
    Flow<List<MangaCollectionCrossRef>> getMangaInCollection(long collectionId);

    @Query("SELECT * FROM MangaCollectionCrossRef WHERE mangaId = :mangaId")
    Flow<List<MangaCollectionCrossRef>> getCollectionsForManga(long mangaId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MangaCollectionCrossRef crossRef);

    @Delete
    void delete(MangaCollectionCrossRef crossRef);

    @Query("DELETE FROM MangaCollectionCrossRef WHERE mangaId = :mangaId AND collectionId = :collectionId")
    void remove(long mangaId, long collectionId);
}
