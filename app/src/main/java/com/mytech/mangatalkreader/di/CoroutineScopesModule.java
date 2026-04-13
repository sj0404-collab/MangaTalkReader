package com.mytech.mangatalkreader.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJob;

@Module
@InstallIn(SingletonComponent.class)
public final class CoroutineScopesModule {

    @Provides
    @Singleton
    public CoroutineScope provideApplicationScope() {
        return new CoroutineScope(SupervisorJob(null, 1, null).plus(Dispatchers.getIO()));
    }
}
