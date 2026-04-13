package com.mytech.mangatalkreader.ui.navigation;

import androidx.navigation.NavOptionsBuilder;
import com.mytech.mangatalkreader.ui.navigation.Screen.Main;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
final class NavigationKt$navigateToSources$1 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    public static final NavigationKt$navigateToSources$1 INSTANCE = new NavigationKt$navigateToSources$1();

    NavigationKt$navigateToSources$1() {
        super(1);
    }

    public final void invoke(NavOptionsBuilder $this$navigate) {
        Intrinsics.checkNotNullParameter($this$navigate, "$this$navigate");
        $this$navigate.popUpTo(Main.INSTANCE.getRoute(), (Function1) AnonymousClass1.INSTANCE);
    }
}
