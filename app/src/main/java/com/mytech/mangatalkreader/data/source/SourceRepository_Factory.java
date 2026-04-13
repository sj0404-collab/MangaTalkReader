package com.mytech.mangatalkreader.data.source;

import dagger.internal.Factory;

public final class SourceRepository_Factory implements Factory<SourceRepository> {

    private static final class InstanceHolder {
        private static final SourceRepository_Factory INSTANCE = new SourceRepository_Factory();

        private InstanceHolder() {
        }
    }

    public SourceRepository get() {
        return newInstance();
    }

    public static SourceRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SourceRepository newInstance() {
        return new SourceRepository();
    }
}
