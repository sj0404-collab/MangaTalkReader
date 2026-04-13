package com.mytech.mangatalkreader.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.mytech.mangatalkreader.data.db.entity.CollectionEntity;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface CollectionDao {

    @Query("SELECT * FROM CollectionEntity ORDER BY dateAdded DESC")
    Flow<List<CollectionEntity>> getAllCollections();

    @Query("SELECT * FROM CollectionEntity WHERE id = :id")
    Flow<CollectionEntity> getCollectionById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(CollectionEntity collection);

    @Update
    void update(CollectionEntity collection);

    @Delete
    void delete(CollectionEntity collection);
}
