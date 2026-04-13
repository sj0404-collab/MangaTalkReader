package com.mytech.mangatalkreader;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Surface;
import androidx.compose.ui.Modifier;
import androidx.navigation.compose.rememberNavController;
import com.mytech.mangatalkreader.ui.navigation.NavigationKt;
import com.mytech.mangatalkreader.ui.theme.MangaTalkReaderTheme;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class MainActivity extends ComponentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent(() -> {
            MangaTalkReaderTheme();
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.INSTANCE.getColorScheme().getBackground()) {
                androidx.navigation.NavHostController navController = rememberNavController();
                NavigationKt.AppNavigation(navController, "", null, 0, 0);
            }
        });
    }
}
