package com.mytech.mangatalkreader.ui.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt;
import com.mytech.mangatalkreader.ui.navigation.Screen.Browser;
import com.mytech.mangatalkreader.ui.navigation.Screen.Downloads;
import com.mytech.mangatalkreader.ui.navigation.Screen.Main;
import com.mytech.mangatalkreader.ui.navigation.Screen.MangaDetails;
import com.mytech.mangatalkreader.ui.navigation.Screen.Reader;
import com.mytech.mangatalkreader.ui.navigation.Screen.Sources;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000f\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0013"}, d2 = {"AppNavigation", "", "navController", "Landroidx/navigation/NavHostController;", "startDestination", "", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SimpleContainer", "title", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "navigateToBrowser", "url", "navigateToDownloads", "navigateToMangaDetails", "mangaId", "", "navigateToReader", "chapterId", "navigateToSources", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Navigation.kt */
public final class NavigationKt {
    public static final void AppNavigation(NavHostController navController, String startDestination, Composer $composer, int $changed, int i) {
        int $dirty;
        String startDestination2;
        NavHostController navHostController = navController;
        int i2 = i;
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Composer $composer2 = $composer.startRestartGroup(-1606412029);
        ComposerKt.sourceInformation($composer2, "C(AppNavigation)53@2098L2923:Navigation.kt#rqrdms");
        int $dirty2 = $changed;
        if ((i2 & 2) != 0) {
            $dirty = $dirty2 & -113;
            startDestination2 = Main.INSTANCE.getRoute();
        } else {
            startDestination2 = startDestination;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1606412029, $dirty, -1, "com.mytech.mangatalkreader.ui.navigation.AppNavigation (Navigation.kt:52)");
        }
        String str = startDestination2;
        String startDestination3 = startDestination2;
        int i3 = ($dirty & 112) | 8;
        Composer $composer3 = $composer2;
        NavHostKt.NavHost(navController, str, null, null, null, null, null, null, null, null, (Function1) new NavigationKt$AppNavigation$1(navHostController), $composer2, i3, 0, 1020);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope((Function2) new NavigationKt$AppNavigation$2(navHostController, startDestination3, $changed, i));
            return;
        }
        int i4 = $changed;
        String str2 = startDestination3;
    }

    /* DevToolsApp WARNING: Missing block: B:25:0x00f5, code:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r5.rememberedValue(), java.lang.Integer.valueOf(r29)) == false) goto L_0x00fa;
     */
    public static final void SimpleContainer(java.lang.String r48, androidx.compose.runtime.Composer r49, int r50) {
        /*
        r0 = r48;
        r15 = r50;
        r1 = "title";
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1);
        r1 = -649490942; // 0xffffffffd9498e02 float:-3.5457881E15 double:NaN;
        r2 = r49;
        r13 = r2.startRestartGroup(r1);
        r2 = "C(SimpleContainer)131@5078L269:Navigation.kt#rqrdms";
        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2);
        r2 = r50;
        r3 = r15 & 14;
        r4 = 2;
        if (r3 != 0) goto L_0x0028;
    L_0x001e:
        r3 = r13.changed(r0);
        if (r3 == 0) goto L_0x0026;
    L_0x0024:
        r3 = 4;
        goto L_0x0027;
    L_0x0026:
        r3 = r4;
    L_0x0027:
        r2 = r2 | r3;
    L_0x0028:
        r14 = r2;
        r2 = r14 & 11;
        if (r2 != r4) goto L_0x003d;
    L_0x002d:
        r2 = r13.getSkipping();
        if (r2 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x003d;
    L_0x0034:
        r13.skipToGroupEnd();
        r45 = r13;
        r46 = r14;
        goto L_0x01b4;
    L_0x003d:
        r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress();
        if (r2 == 0) goto L_0x0049;
    L_0x0043:
        r2 = -1;
        r3 = "com.mytech.mangatalkreader.ui.navigation.SimpleContainer (Navigation.kt:130)";
        androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r2, r3);
    L_0x0049:
        r1 = androidx.compose.ui.Modifier.Companion;
        r1 = (androidx.compose.ui.Modifier) r1;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r1 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r4, r2, r3);
        r2 = androidx.compose.ui.Alignment.Companion;
        r2 = r2.getCenter();
        r12 = r1;
        r1 = 54;
        r25 = r1;
        r11 = r2;
        r26 = 0;
        r1 = 733328855; // 0x2bb5b5d7 float:1.2911294E-12 double:3.623125944E-315;
        r2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2);
        r9 = 0;
        r10 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r11, r9);
        r1 = r25 << 3;
        r1 = r1 & 112;
        r27 = r1;
        r28 = 0;
        r1 = -1323940314; // 0xffffffffb1164626 float:-2.1867748E-9 double:NaN;
        r2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2);
        r1 = 0;
        r29 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r1);
        r8 = r13.getCurrentCompositionLocalMap();
        r7 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r13, r12);
        r1 = androidx.compose.ui.node.ComposeUiNode.Companion;
        r1 = r1.getConstructor();
        r2 = r27 << 6;
        r2 = r2 & 896;
        r2 = r2 | 6;
        r6 = r1;
        r30 = r2;
        r31 = 0;
        r1 = -692256719; // 0xffffffffd6bd0031 float:-1.0390426E14 double:NaN;
        r2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2);
        r1 = r13.getApplier();
        r1 = r1 instanceof androidx.compose.runtime.Applier;
        if (r1 != 0) goto L_0x00b0;
    L_0x00ad:
        androidx.compose.runtime.ComposablesKt.invalidApplier();
    L_0x00b0:
        r13.startReusableNode();
        r1 = r13.getInserting();
        if (r1 == 0) goto L_0x00bd;
    L_0x00b9:
        r13.createNode(r6);
        goto L_0x00c0;
    L_0x00bd:
        r13.useNode();
    L_0x00c0:
        r1 = androidx.compose.runtime.Updater.constructor-impl(r13);
        r2 = 0;
        r3 = androidx.compose.ui.node.ComposeUiNode.Companion;
        r3 = r3.getSetMeasurePolicy();
        androidx.compose.runtime.Updater.set-impl(r1, r10, r3);
        r3 = androidx.compose.ui.node.ComposeUiNode.Companion;
        r3 = r3.getSetResolvedCompositionLocals();
        androidx.compose.runtime.Updater.set-impl(r1, r8, r3);
        r3 = androidx.compose.ui.node.ComposeUiNode.Companion;
        r3 = r3.getSetCompositeKeyHash();
        r4 = 0;
        r5 = r1;
        r16 = 0;
        r17 = r5.getInserting();
        if (r17 != 0) goto L_0x00f8;
    L_0x00e7:
        r0 = r5.rememberedValue();
        r49 = r2;
        r2 = java.lang.Integer.valueOf(r29);
        r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2);
        if (r0 != 0) goto L_0x0108;
    L_0x00f7:
        goto L_0x00fa;
    L_0x00f8:
        r49 = r2;
    L_0x00fa:
        r0 = java.lang.Integer.valueOf(r29);
        r5.updateRememberedValue(r0);
        r0 = java.lang.Integer.valueOf(r29);
        r1.apply(r0, r3);
        r0 = androidx.compose.ui.node.ComposeUiNode.Companion;
        r0 = r0.getSetModifier();
        androidx.compose.runtime.Updater.set-impl(r1, r7, r0);
        r0 = r30 >> 6;
        r32 = r0 & 14;
        r0 = r13;
        r33 = 0;
        r1 = -2146769399; // 0xffffffff800ae609 float:-1.000876E-39 double:NaN;
        r2 = "C73@3429L9:Box.kt#2w3rfo";
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r1, r2);
        r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE;
        r2 = r25 >> 6;
        r2 = r2 & 112;
        r34 = r2 | 6;
        r35 = r1;
        r35 = (androidx.compose.foundation.layout.BoxScope) r35;
        r4 = r0;
        r21 = r4;
        r36 = 0;
        r1 = -2030936796; // 0xffffffff86f25d24 float:-9.116714E-35 double:NaN;
        r2 = "C137@5306L10,135@5213L128:Navigation.kt#rqrdms";
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r2);
        r1 = androidx.compose.material3.MaterialTheme.INSTANCE;
        r2 = androidx.compose.material3.MaterialTheme.$stable;
        r1 = r1.getTypography(r4, r2);
        r20 = r1.getHeadlineMedium();
        r22 = r14 & 14;
        r1 = 0;
        r2 = 0;
        r16 = 0;
        r37 = r4;
        r4 = r16;
        r16 = 0;
        r38 = r6;
        r6 = r16;
        r39 = r7;
        r7 = r16;
        r40 = r8;
        r8 = r16;
        r16 = 0;
        r41 = r9;
        r42 = r10;
        r9 = r16;
        r16 = 0;
        r43 = r11;
        r11 = r16;
        r44 = r12;
        r12 = r16;
        r16 = 0;
        r45 = r13;
        r46 = r14;
        r13 = r16;
        r16 = 0;
        r15 = r16;
        r17 = 0;
        r18 = 0;
        r19 = 0;
        r23 = 0;
        r24 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        r47 = r0;
        r0 = r48;
        androidx.compose.material3.TextKt.Text--4IGK_g(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r37);
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r47);
        r45.endNode();
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r45);
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r45);
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r45);
        r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress();
        if (r0 == 0) goto L_0x01b4;
    L_0x01b1:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
    L_0x01b4:
        r0 = r45.endRestartGroup();
        if (r0 == 0) goto L_0x01c9;
    L_0x01ba:
        r1 = new com.mytech.mangatalkreader.ui.navigation.NavigationKt$SimpleContainer$2;
        r2 = r48;
        r3 = r50;
        r1.<init>(r2, r3);
        r1 = (kotlin.jvm.functions.Function2) r1;
        r0.updateScope(r1);
        goto L_0x01cd;
    L_0x01c9:
        r2 = r48;
        r3 = r50;
    L_0x01cd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mytech.mangatalkreader.ui.navigation.NavigationKt.SimpleContainer(java.lang.String, androidx.compose.runtime.Composer, int):void");
    }

    public static final void navigateToReader(NavHostController $this$navigateToReader, long chapterId) {
        Intrinsics.checkNotNullParameter($this$navigateToReader, "<this>");
        NavController.navigate$default((NavController) $this$navigateToReader, Reader.INSTANCE.createRoute(chapterId), null, null, 6, null);
    }

    public static final void navigateToMangaDetails(NavHostController $this$navigateToMangaDetails, long mangaId) {
        Intrinsics.checkNotNullParameter($this$navigateToMangaDetails, "<this>");
        NavController.navigate$default((NavController) $this$navigateToMangaDetails, MangaDetails.INSTANCE.createRoute(mangaId), null, null, 6, null);
    }

    public static final void navigateToBrowser(NavHostController $this$navigateToBrowser, String url) {
        Intrinsics.checkNotNullParameter($this$navigateToBrowser, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        NavController.navigate$default((NavController) $this$navigateToBrowser, Browser.INSTANCE.createRoute(url), null, null, 6, null);
    }

    public static final void navigateToSources(NavHostController $this$navigateToSources) {
        Intrinsics.checkNotNullParameter($this$navigateToSources, "<this>");
        $this$navigateToSources.navigate(Sources.INSTANCE.getRoute(), (Function1) NavigationKt$navigateToSources$1.INSTANCE);
    }

    public static final void navigateToDownloads(NavHostController $this$navigateToDownloads) {
        Intrinsics.checkNotNullParameter($this$navigateToDownloads, "<this>");
        NavController.navigate$default((NavController) $this$navigateToDownloads, Downloads.INSTANCE.getRoute(), null, null, 6, null);
    }
}
