package com.mytech.mangatalkreader;

import android.app.Application;
import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public final class MangaApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
