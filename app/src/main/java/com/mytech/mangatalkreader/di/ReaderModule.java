package com.mytech.mangatalkreader.di;

import android.content.Context;
import com.mytech.mangatalkreader.reader.MangaReaderEngine;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@Module
@InstallIn(ActivityComponent.class)
public final class ReaderModule {

    @Provides
    public MangaReaderEngine provideMangaReaderEngine(@ActivityContext Context context) {
        return new MangaReaderEngine(context, new MangaReaderEngine.ReaderConfig());
    }
}
