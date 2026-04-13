package com.mytech.mangatalkreader.ui.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedContentScope;", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke", "(Landroidx/compose/animation/AnimatedContentScope;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
final class ComposableSingletons$NavigationKt$lambda-2$1 extends Lambda implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    public static final ComposableSingletons$NavigationKt$lambda-2$1 INSTANCE = new ComposableSingletons$NavigationKt$lambda-2$1();

    ComposableSingletons$NavigationKt$lambda-2$1() {
        super(4);
    }

    public final void invoke(AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "C117@4538L26:Navigation.kt#rqrdms");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1798095855, $changed, -1, "com.mytech.mangatalkreader.ui.navigation.ComposableSingletons$NavigationKt.lambda-2.<anonymous> (Navigation.kt:117)");
        }
        NavigationKt.SimpleContainer("История", $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
