package com.mytech.mangatalkreader.ui.theme;

import androidx.compose.foundation.isSystemInDarkTheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.darkColorScheme;
import androidx.compose.material3.lightColorScheme;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.graphics.Color;

public final class MangaTalkReaderTheme {

    private static final androidx.compose.material3.ColorScheme DarkColorScheme =
            darkColorScheme(
                    0,
                    Color.Black,
                    Color.White,
                    new Color(0xFF1E1E1E),
                    new Color(0xFF323232),
                    new Color(0xFFBB86FC),
                    new Color(0xFF03DAC6),
                    Color.Red,
                    Color.Green,
                    Color.Yellow,
                    Color.Cyan,
                    Color.Magenta
            );

    private static final androidx.compose.material3.ColorScheme LightColorScheme =
            lightColorScheme(
                    0,
                    Color.White,
                    Color.Black,
                    new Color(0xFFF5F5F5),
                    new Color(0xFFE0E0E0),
                    new Color(0xFF6200EE),
                    new Color(0xFF03DAC6),
                    Color.Red,
                    Color.Green,
                    Color.Yellow,
                    Color.Cyan,
                    Color.Magenta
            );

    @Composable
    public static void MangaTalkReaderTheme(Boolean darkTheme, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean useDarkTheme = darkTheme != null ? darkTheme : isSystemInDarkTheme();
        androidx.compose.material3.ColorScheme colorScheme = useDarkTheme ? DarkColorScheme : LightColorScheme;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        // Apply color scheme
    }

    @Composable
    public static void MangaTalkReaderTheme() {
        MangaTalkReaderTheme(null, null, 0);
    }
}
