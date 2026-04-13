package com.mytech.mangatalkreader.ui.navigation;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000f\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u000f\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AI", "AdditionalSettings", "Browser", "Chat", "Downloads", "History", "Library", "Main", "MangaDetails", "ModelManager", "More", "Reader", "Search", "Settings", "Sources", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$AI;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$AdditionalSettings;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Browser;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Chat;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Downloads;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$History;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Library;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Main;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$MangaDetails;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$ModelManager;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$More;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Reader;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Search;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Settings;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen$Sources;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
public abstract class Screen {
    public static final int $stable = 0;
    private final String route;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$AI;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class AI extends Screen {
        public static final int $stable = 0;
        public static final AI INSTANCE = new AI();

        private AI() {
            super("ai", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$AdditionalSettings;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class AdditionalSettings extends Screen {
        public static final int $stable = 0;
        public static final AdditionalSettings INSTANCE = new AdditionalSettings();

        private AdditionalSettings() {
            super("additional_settings", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Browser;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "createRoute", "", "url", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Browser extends Screen {
        public static final int $stable = 0;
        public static final Browser INSTANCE = new Browser();

        private Browser() {
            super("browser/{encodedUrl}", null);
        }

        public final String createRoute(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return "browser/" + URLEncoder.encode(url, StandardCharsets.UTF_8.name());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Chat;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Chat extends Screen {
        public static final int $stable = 0;
        public static final Chat INSTANCE = new Chat();

        private Chat() {
            super("chat", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Downloads;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Downloads extends Screen {
        public static final int $stable = 0;
        public static final Downloads INSTANCE = new Downloads();

        private Downloads() {
            super("downloads", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$History;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class History extends Screen {
        public static final int $stable = 0;
        public static final History INSTANCE = new History();

        private History() {
            super("history", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Library;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Library extends Screen {
        public static final int $stable = 0;
        public static final Library INSTANCE = new Library();

        private Library() {
            super("library", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Main;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Main extends Screen {
        public static final int $stable = 0;
        public static final Main INSTANCE = new Main();

        private Main() {
            super("main", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$MangaDetails;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "createRoute", "", "mangaId", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class MangaDetails extends Screen {
        public static final int $stable = 0;
        public static final MangaDetails INSTANCE = new MangaDetails();

        private MangaDetails() {
            super("manga_details/{mangaId}", null);
        }

        public final String createRoute(long mangaId) {
            return "manga_details/" + mangaId;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$ModelManager;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class ModelManager extends Screen {
        public static final int $stable = 0;
        public static final ModelManager INSTANCE = new ModelManager();

        private ModelManager() {
            super("model_manager", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$More;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class More extends Screen {
        public static final int $stable = 0;
        public static final More INSTANCE = new More();

        private More() {
            super("more", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Reader;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "createRoute", "", "chapterId", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Reader extends Screen {
        public static final int $stable = 0;
        public static final Reader INSTANCE = new Reader();

        private Reader() {
            super("reader/{chapterId}", null);
        }

        public final String createRoute(long chapterId) {
            return "reader/" + chapterId;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Search;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Search extends Screen {
        public static final int $stable = 0;
        public static final Search INSTANCE = new Search();

        private Search() {
            super("search", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Settings;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Settings extends Screen {
        public static final int $stable = 0;
        public static final Settings INSTANCE = new Settings();

        private Settings() {
            super("settings", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mytech/mangatalkreader/ui/navigation/Screen$Sources;", "Lcom/mytech/mangatalkreader/ui/navigation/Screen;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Navigation.kt */
    public static final class Sources extends Screen {
        public static final int $stable = 0;
        public static final Sources INSTANCE = new Sources();

        private Sources() {
            super("sources", null);
        }
    }

    public /* synthetic */ Screen(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private Screen(String route) {
        this.route = route;
    }

    public final String getRoute() {
        return this.route;
    }
}
