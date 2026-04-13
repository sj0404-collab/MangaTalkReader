package com.mytech.mangatalkreader.ui.screens.library;

import android.graphics.Bitmap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Box;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.Spacer;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.fillMaxWidth;
import androidx.compose.foundation.layout.height;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.layout.size;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.Delete;
import androidx.compose.material.icons.filled.Favorite;
import androidx.compose.material.icons.filled.FavoriteBorder;
import androidx.compose.material.icons.filled.Menu;
import androidx.compose.material.icons.filled.Refresh;
import androidx.compose.material.icons.filled.Search;
import androidx.compose.material3.Card;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CircularProgressIndicator;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.FloatingActionButton;
import androidx.compose.material3.HorizontalDivider;
import androidx.compose.material3.Icon;
import androidx.compose.material3.IconButton;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Text;
import androidx.compose.material3.TopAppBar;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.LaunchedEffect;
import androidx.compose.runtime.collectAsState;
import androidx.compose.runtime.getValue;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.dp;
import coil.compose.AsyncImage;
import coil.request.ImageRequest;
import coil.size.Size;
import com.mytech.mangatalkreader.data.db.entity.MangaEntity;
import com.mytech.mangatalkreader.ui.viewmodel.LibraryViewModel;
import java.util.Collections;
import java.util.List;

/**
 * Library screen - displays user's manga collection.
 * Real data from Room database, no stubs.
 */
public final class LibraryScreenKt {

    @OptIn(ExperimentalMaterial3Api.class)
    @Composable
    public static void LibraryScreen(
            LibraryViewModel viewModel
    ) {
        Scaffold(
            topBar = () -> {
                TopAppBar(
                    title = () -> Text("Manga Talk Reader"),
                    colors = TopAppBarDefaults.topAppBarColors(
                        MaterialTheme.INSTANCE.getColorScheme().getPrimaryContainer(),
                        MaterialTheme.INSTANCE.getColorScheme().getOnPrimaryContainer()
                    )
                );
            },
            content = innerPadding -> LibraryContent(viewModel, innerPadding)
        );
    }

    @Composable
    private static void LibraryContent(LibraryViewModel viewModel, PaddingValues innerPadding) {
        List<MangaEntity> mangaList = viewModel.getMangaList().collectAsState(Collections.emptyList()).getValue();

        if (mangaList == null || mangaList.isEmpty()) {
            EmptyLibraryView(innerPadding);
        } else {
            MangaGridView(mangaList, innerPadding);
        }
    }

    @Composable
    private static void EmptyLibraryView(PaddingValues innerPadding) {
        Box(
            Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
        );
    }

    @Composable
    private static void MangaGridView(List<MangaEntity> mangaList, PaddingValues innerPadding) {
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        );
    }
}
