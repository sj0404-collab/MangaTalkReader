package com.mytech.mangatalkreader.ui.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
final class NavigationKt$SimpleContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $title;

    NavigationKt$SimpleContainer$2(String str, int i) {
        this.$title = str;
        this.$$changed = i;
        super(2);
    }

    public final void invoke(Composer composer, int i) {
        NavigationKt.SimpleContainer(this.$title, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
