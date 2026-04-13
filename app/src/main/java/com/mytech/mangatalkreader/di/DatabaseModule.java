package com.mytech.mangatalkreader.di;

import android.content.Context;
import com.mytech.mangatalkreader.data.db.MangaDatabase;
import com.mytech.mangatalkreader.data.db.dao.ChapterDao;
import com.mytech.mangatalkreader.data.db.dao.CollectionDao;
import com.mytech.mangatalkreader.data.db.dao.MangaCollectionCrossRefDao;
import com.mytech.mangatalkreader.data.db.dao.MangaDao;
import com.mytech.mangatalkreader.data.db.dao.SourceDao;
import com.mytech.mangatalkreader.data.db.dao.TextBlockDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public final class DatabaseModule {

    @Provides
    @Singleton
    public MangaDatabase provideDatabase(@ApplicationContext Context context) {
        return androidx.room.Room.databaseBuilder(
                context,
                MangaDatabase.class,
                "manga_talk_reader.db"
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public MangaDao provideMangaDao(MangaDatabase database) {
        return database.mangaDao();
    }

    @Provides
    @Singleton
    public ChapterDao provideChapterDao(MangaDatabase database) {
        return database.chapterDao();
    }

    @Provides
    @Singleton
    public SourceDao provideSourceDao(MangaDatabase database) {
        return database.sourceDao();
    }

    @Provides
    @Singleton
    public CollectionDao provideCollectionDao(MangaDatabase database) {
        return database.collectionDao();
    }

    @Provides
    @Singleton
    public TextBlockDao provideTextBlockDao(MangaDatabase database) {
        return database.textBlockDao();
    }

    @Provides
    @Singleton
    public MangaCollectionCrossRefDao provideCrossRefDao(MangaDatabase database) {
        return database.crossRefDao();
    }
}
