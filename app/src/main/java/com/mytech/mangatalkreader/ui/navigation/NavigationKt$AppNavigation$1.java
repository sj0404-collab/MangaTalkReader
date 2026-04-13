package com.mytech.mangatalkreader.ui.navigation;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.mytech.mangatalkreader.ui.navigation.Screen.AI;
import com.mytech.mangatalkreader.ui.navigation.Screen.AdditionalSettings;
import com.mytech.mangatalkreader.ui.navigation.Screen.Browser;
import com.mytech.mangatalkreader.ui.navigation.Screen.Chat;
import com.mytech.mangatalkreader.ui.navigation.Screen.Downloads;
import com.mytech.mangatalkreader.ui.navigation.Screen.History;
import com.mytech.mangatalkreader.ui.navigation.Screen.Library;
import com.mytech.mangatalkreader.ui.navigation.Screen.Main;
import com.mytech.mangatalkreader.ui.navigation.Screen.MangaDetails;
import com.mytech.mangatalkreader.ui.navigation.Screen.ModelManager;
import com.mytech.mangatalkreader.ui.navigation.Screen.More;
import com.mytech.mangatalkreader.ui.navigation.Screen.Reader;
import com.mytech.mangatalkreader.ui.navigation.Screen.Search;
import com.mytech.mangatalkreader.ui.navigation.Screen.Settings;
import com.mytech.mangatalkreader.ui.navigation.Screen.Sources;
import com.mytech.mangatalkreader.ui.screen.AIScreenKt;
import com.mytech.mangatalkreader.ui.screen.AdditionalSettingsScreenKt;
import com.mytech.mangatalkreader.ui.screen.DownloadsScreenKt;
import com.mytech.mangatalkreader.ui.screen.LibraryScreenKt;
import com.mytech.mangatalkreader.ui.screen.MainScreenKt;
import com.mytech.mangatalkreader.ui.screen.MangaDetailsScreenKt;
import com.mytech.mangatalkreader.ui.screen.MoreScreenKt;
import com.mytech.mangatalkreader.ui.screen.ReaderScreenKt;
import com.mytech.mangatalkreader.ui.screen.SourcesScreenKt;
import com.mytech.mangatalkreader.ui.viewmodel.AdditionalSettingsViewModel;
import com.mytech.mangatalkreader.ui.viewmodel.DownloadsViewModel;
import com.mytech.mangatalkreader.ui.viewmodel.MoreViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavGraphBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
final class NavigationKt$AppNavigation$1 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ NavHostController $navController;

    NavigationKt$AppNavigation$1(NavHostController navHostController) {
        this.$navController = navHostController;
        super(1);
    }

    public final void invoke(NavGraphBuilder $this$NavHost) {
        Intrinsics.checkNotNullParameter($this$NavHost, "$this$NavHost");
        String route = Main.INSTANCE.getRoute();
        final NavHostController navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(1242808422, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C56@2229L41:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1242808422, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:56)");
                }
                MainScreenKt.MainScreen((NavController) navHostController, $composer, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 254, null);
        route = Library.INSTANCE.getRoute();
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(1694043421, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C60@2337L44:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1694043421, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:60)");
                }
                LibraryScreenKt.LibraryScreen((NavController) navHostController, null, $composer, 8, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 254, null);
        route = Sources.INSTANCE.getRoute();
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(-129143842, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C64@2448L44:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-129143842, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:64)");
                }
                SourcesScreenKt.SourcesScreen((NavController) navHostController, null, $composer, 8, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 254, null);
        route = Reader.INSTANCE.getRoute();
        List listOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument("chapterId", (Function1) AnonymousClass4.INSTANCE));
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, listOf, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1952331105, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry backStackEntry, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
                ComposerKt.sourceInformation($composer, "C74@2874L66:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1952331105, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:72)");
                }
                Bundle arguments = backStackEntry.getArguments();
                ReaderScreenKt.ReaderScreen((NavController) navHostController, arguments != null ? arguments.getLong("chapterId") : 0, null, $composer, 8, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 252, null);
        route = MangaDetails.INSTANCE.getRoute();
        listOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument("mangaId", (Function1) AnonymousClass6.INSTANCE));
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, listOf, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(519448928, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry backStackEntry, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
                ComposerKt.sourceInformation($composer, "C82@3221L68:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(519448928, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:81)");
                }
                Bundle arguments = backStackEntry.getArguments();
                MangaDetailsScreenKt.MangaDetailsScreen((NavController) navHostController, arguments != null ? arguments.getLong("mangaId") : 0, null, $composer, 8, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 252, null);
        route = Browser.INSTANCE.getRoute();
        listOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument("encodedUrl", (Function1) AnonymousClass8.INSTANCE));
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, listOf, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1303738335, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            /* DevToolsApp WARNING: Missing block: B:13:0x0099, code:
            if (r1 == null) goto L_0x009b;
     */
            public final void invoke(androidx.compose.animation.AnimatedContentScope r20, androidx.navigation.NavBackStackEntry r21, androidx.compose.runtime.Composer r22, int r23) {
                /*
                r19 = this;
                r8 = r22;
                r0 = "$this$composable";
                r9 = r20;
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0);
                r0 = "backStackEntry";
                r10 = r21;
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0);
                r0 = "C89@3527L15,92@3730L183:Navigation.kt#rqrdms";
                androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0);
                r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress();
                if (r0 == 0) goto L_0x0027;
            L_0x001b:
                r0 = -1303738335; // 0xffffffffb24a8821 float:-1.17889E-8 double:NaN;
                r1 = -1;
                r2 = "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:89)";
                r11 = r23;
                androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r1, r2);
                goto L_0x0029;
            L_0x0027:
                r11 = r23;
            L_0x0029:
                r12 = 0;
                r13 = 0;
                r0 = 1890788296; // 0x70b323c8 float:4.435286E29 double:9.341735406E-315;
                r8.startReplaceableGroup(r0);
                r0 = "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars";
                androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0);
                r0 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE;
                r1 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.$stable;
                r0 = r0.getCurrent(r8, r1);
                if (r0 == 0) goto L_0x00c5;
            L_0x0040:
                r14 = r0;
                r15 = 0;
                r0 = r12 & 14;
                r16 = androidx.hilt.navigation.compose.HiltViewModelKt.createHiltViewModelFactory(r14, r8, r0);
                r0 = r12 & 14;
                r1 = r12 & 112;
                r0 = r0 | r1;
                r17 = r0;
                r18 = 0;
                r0 = 1729797275; // 0x671a9c9b float:7.301333E23 double:8.54633408E-315;
                r8.startReplaceableGroup(r0);
                r0 = "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67";
                androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0);
                r0 = r14 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory;
                if (r0 == 0) goto L_0x0069;
            L_0x0060:
                r0 = r14;
                r0 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r0;
                r0 = r0.getDefaultViewModelCreationExtras();
                r4 = r0;
                goto L_0x006e;
            L_0x0069:
                r0 = androidx.lifecycle.viewmodel.CreationExtras.Empty.INSTANCE;
                r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0;
                r4 = r0;
                r0 = com.mytech.mangatalkreader.ui.viewmodel.BrowserViewModel.class;
                r1 = r17 << 3;
                r1 = r1 & 896;
                r2 = 36936; // 0x9048 float:5.1758E-41 double:1.8249E-319;
                r6 = r1 | r2;
                r7 = 0;
                r1 = r14;
                r2 = r15;
                r3 = r16;
                r5 = r22;
                r0 = androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(r0, r1, r2, r3, r4, r5, r6, r7);
                r22.endReplaceableGroup();
                r22.endReplaceableGroup();
                r0 = (com.mytech.mangatalkreader.ui.viewmodel.BrowserViewModel) r0;
                r1 = r21.getArguments();
                if (r1 == 0) goto L_0x009b;
            L_0x0093:
                r2 = "encodedUrl";
                r1 = r1.getString(r2);
                if (r1 != 0) goto L_0x009d;
            L_0x009b:
                r1 = "";
            L_0x009d:
                r2 = java.nio.charset.StandardCharsets.UTF_8;
                r2 = r2.name();
                r2 = java.net.URLDecoder.decode(r1, r2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
                r3 = new com.mytech.mangatalkreader.ui.navigation.NavigationKt$AppNavigation$1$9$1;
                r4 = r19;
                r5 = r1;
                r3.<init>(r5);
                r3 = (kotlin.jvm.functions.Function0) r3;
                r5 = com.mytech.mangatalkreader.ui.viewmodel.BrowserViewModel.$stable;
                com.mytech.mangatalkreader.ui.screen.WebBrowserScreenKt.WebBrowserScreen(r0, r2, r3, r8, r5);
                r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress();
                if (r3 == 0) goto L_0x00c4;
            L_0x00c1:
                androidx.compose.runtime.ComposerKt.traceEventEnd();
            L_0x00c4:
                return;
            L_0x00c5:
                r4 = r19;
                r0 = 0;
                r0 = new java.lang.IllegalStateException;
                r1 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
                r1 = r1.toString();
                r0.<init>(r1);
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mytech.mangatalkreader.ui.navigation.NavigationKt.AppNavigation.1.9.invoke(androidx.compose.animation.AnimatedContentScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
            }
        }), 252, null);
        route = Downloads.INSTANCE.getRoute();
        navHostController = this.$navController;
        NavGraphBuilder navGraphBuilder = $this$NavHost;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(1168041698, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Composer composer = $composer;
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation(composer, "C100@4020L15,101@4048L64:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1168041698, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:100)");
                } else {
                    int i = $changed;
                }
                composer.startReplaceableGroup(1890788296);
                ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    CreationExtras extras$iv$iv;
                    ViewModelStoreOwner viewModelStoreOwner$iv = current;
                    Factory factory$iv = HiltViewModelKt.createHiltViewModelFactory(viewModelStoreOwner$iv, composer, 0 & 14);
                    int $changed$iv$iv = (0 & 14) | (0 & 112);
                    composer.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                        extras$iv$iv = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                    } else {
                        extras$iv$iv = (CreationExtras) Empty.INSTANCE;
                    }
                    DownloadsViewModel downloadsVm = ViewModelKt.viewModel(DownloadsViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv$iv, $composer, (($changed$iv$iv << 3) & 896) | 36936, 0);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    DownloadsScreenKt.DownloadsScreen((NavController) navHostController, downloadsVm, composer, (DownloadsViewModel.$stable << 3) | 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }), 254, null);
        NavGraphBuilderKt.composable$default(navGraphBuilder, Settings.INSTANCE.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$NavigationKt.INSTANCE.m0getLambda-1$app_debug(), 254, null);
        route = AI.INSTANCE.getRoute();
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(1816634468, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C109@4270L39:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1816634468, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:109)");
                }
                AIScreenKt.AIScreen((NavController) navHostController, null, $composer, 8, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 254, null);
        route = More.INSTANCE.getRoute();
        navHostController = this.$navController;
        navGraphBuilder = $this$NavHost;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(-6552795, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Composer composer = $composer;
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation(composer, "C113@4401L15,114@4429L54:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-6552795, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:113)");
                } else {
                    int i = $changed;
                }
                composer.startReplaceableGroup(1890788296);
                ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    CreationExtras extras$iv$iv;
                    ViewModelStoreOwner viewModelStoreOwner$iv = current;
                    Factory factory$iv = HiltViewModelKt.createHiltViewModelFactory(viewModelStoreOwner$iv, composer, 0 & 14);
                    int $changed$iv$iv = (0 & 14) | (0 & 112);
                    composer.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                        extras$iv$iv = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                    } else {
                        extras$iv$iv = (CreationExtras) Empty.INSTANCE;
                    }
                    MoreViewModel moreVm = ViewModelKt.viewModel(MoreViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv$iv, $composer, (($changed$iv$iv << 3) & 896) | 36936, 0);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    MoreScreenKt.MoreScreen((NavController) navHostController, moreVm, composer, (MoreViewModel.$stable << 3) | 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }), 254, null);
        NavGraphBuilderKt.composable$default(navGraphBuilder, History.INSTANCE.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$NavigationKt.INSTANCE.m1getLambda-2$app_debug(), 254, null);
        NavGraphBuilderKt.composable$default(navGraphBuilder, Search.INSTANCE.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$NavigationKt.INSTANCE.m2getLambda-3$app_debug(), 254, null);
        NavGraphBuilderKt.composable$default(navGraphBuilder, Chat.INSTANCE.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$NavigationKt.INSTANCE.m3getLambda-4$app_debug(), 254, null);
        NavGraphBuilderKt.composable$default(navGraphBuilder, ModelManager.INSTANCE.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$NavigationKt.INSTANCE.m4getLambda-5$app_debug(), 254, null);
        route = AdditionalSettings.INSTANCE.getRoute();
        navHostController = this.$navController;
        NavGraphBuilderKt.composable$default($this$NavHost, route, null, null, null, null, null, null, null, (Function4) ComposableLambdaKt.composableLambdaInstance(-500910315, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
                Composer composer = $composer;
                Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation(composer, "C123@4893L15,124@4921L84:Navigation.kt#rqrdms");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-500910315, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation.<anonymous>.<anonymous> (Navigation.kt:123)");
                } else {
                    int i = $changed;
                }
                composer.startReplaceableGroup(1890788296);
                ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    CreationExtras extras$iv$iv;
                    ViewModelStoreOwner viewModelStoreOwner$iv = current;
                    Factory factory$iv = HiltViewModelKt.createHiltViewModelFactory(viewModelStoreOwner$iv, composer, 0 & 14);
                    int $changed$iv$iv = (0 & 14) | (0 & 112);
                    composer.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                        extras$iv$iv = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                    } else {
                        extras$iv$iv = (CreationExtras) Empty.INSTANCE;
                    }
                    AdditionalSettingsViewModel settingsVm = ViewModelKt.viewModel(AdditionalSettingsViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv$iv, $composer, (($changed$iv$iv << 3) & 896) | 36936, 0);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    settingsVm = settingsVm;
                    final NavHostController navHostController = navHostController;
                    AdditionalSettingsScreenKt.AdditionalSettingsScreen(settingsVm, (Function0) new Function0<Unit>() {
                        public final void invoke() {
                            navHostController.popBackStack();
                        }
                    }, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }), 254, null);
    }
}
