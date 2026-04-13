package com.mytech.mangatalkreader.ui.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
final class NavigationKt$AppNavigation$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ String $startDestination;

    NavigationKt$AppNavigation$2(NavHostController navHostController, String str, int i, int i2) {
        this.$navController = navHostController;
        this.$startDestination = str;
        this.$$changed = i;
        this.$$default = i2;
        super(2);
    }

    public final void invoke(Composer composer, int i) {
        NavigationKt.AppNavigation(this.$navController, this.$startDestination, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
