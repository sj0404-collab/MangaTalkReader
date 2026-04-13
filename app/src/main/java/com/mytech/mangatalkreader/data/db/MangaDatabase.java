package com.mytech.mangatalkreader.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.mytech.mangatalkreader.data.db.dao.ChapterDao;
import com.mytech.mangatalkreader.data.db.dao.CollectionDao;
import com.mytech.mangatalkreader.data.db.dao.MangaCollectionCrossRefDao;
import com.mytech.mangatalkreader.data.db.dao.MangaDao;
import com.mytech.mangatalkreader.data.db.dao.SourceDao;
import com.mytech.mangatalkreader.data.db.dao.TextBlockDao;
import com.mytech.mangatalkreader.data.db.entity.ChapterEntity;
import com.mytech.mangatalkreader.data.db.entity.CollectionEntity;
import com.mytech.mangatalkreader.data.db.entity.MangaCollectionCrossRef;
import com.mytech.mangatalkreader.data.db.entity.MangaEntity;
import com.mytech.mangatalkreader.data.db.entity.SourceEntity;
import com.mytech.mangatalkreader.data.db.entity.TextBlockEntity;

@Database(
        entities = {
                MangaEntity.class,
                ChapterEntity.class,
                SourceEntity.class,
                CollectionEntity.class,
                TextBlockEntity.class,
                MangaCollectionCrossRef.class
        },
        version = 1,
        exportSchema = false
)
public abstract class MangaDatabase extends RoomDatabase {
    public abstract MangaDao mangaDao();
    public abstract ChapterDao chapterDao();
    public abstract SourceDao sourceDao();
    public abstract CollectionDao collectionDao();
    public abstract TextBlockDao textBlockDao();
    public abstract MangaCollectionCrossRefDao crossRefDao();
}
