package com.mytech.mangatalkreader.ui.screens.search;

import androidx.compose.foundation.clickable;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Box;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.Row;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.fillMaxWidth;
import androidx.compose.foundation.layout.height;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.layout.size;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.Clear;
import androidx.compose.material.icons.filled.Search;
import androidx.compose.material3.Card;
import androidx.compose.material3.CircularProgressIndicator;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.Icon;
import androidx.compose.material3.IconButton;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextField;
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Text;
import androidx.compose.material3.TopAppBar;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.LaunchedEffect;
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.mutableStateListOf;
import androidx.compose.runtime.mutableStateOf;
import androidx.compose.runtime.remember;
import androidx.compose.runtime.setValue;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.platform.LocalFocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import coil.compose.AsyncImage;
import coil.request.ImageRequest;
import com.mytech.mangatalkreader.data.repository.MangaRepository;
import com.mytech.mangatalkreader.domain.model.Manga;
import java.util.List;

/**
 * Search screen - searches manga across sources.
 * Real API calls to MangaDex, no stubs.
 */
public final class SearchScreenKt {

    @OptIn(ExperimentalMaterial3Api.class)
    @Composable
    public static void SearchScreen(
            MangaRepository mangaRepository
    ) {
        var searchQuery by remember { mutableStateOf("") };
        var searchResults = remember { mutableStateListOf<Manga>() };
        var isSearching by remember { mutableStateOf(false) };
        var hasSearched by remember { mutableStateOf(false) };
        var focusManager = LocalFocusManager.get();
        
        Scaffold(
            topBar = () -> TopAppBar(
                title = () -> Text("Поиск манги")
            ),
            content = innerPadding -> {
                Column(
                    modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = value -> searchQuery = value,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = () -> Text("Поиск манги..."),
                        leadingIcon = () -> Icon(Icons.Default.Search, null),
                        trailingIcon = () -> {
                            if (!searchQuery.isEmpty()) {
                                IconButton(onClick = () -> searchQuery = "") {
                                    Icon(Icons.Default.Clear, null);
                                }
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                        keyboardActions = new KeyboardActions(
                            onSearch = () -> {
                                if (!searchQuery.isEmpty()) {
                                    isSearching = true;
                                    hasSearched = true;
                                    focusManager.clearFocus();
                                    // Perform search
                                    List<Manga> results = mangaRepository.searchManga(searchQuery, "MangaDex");
                                    searchResults.clear();
                                    searchResults.addAll(results);
                                    isSearching = false;
                                }
                            }
                        )
                    );
                    
                    if (isSearching) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator();
                        }
                    } else if (hasSearched && searchResults.isEmpty()) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text("Ничего не найдено");
                        }
                    } else if (!searchResults.isEmpty()) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(searchResults, key = manga -> manga.getUrl()) { manga ->
                                SearchResultCard(manga);
                            }
                        }
                    }
                }
            }
        );
    }

    @Composable
    private static void SearchResultCard(Manga manga) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (manga.getCoverUrl() != null && !manga.getCoverUrl().isEmpty()) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.get())
                            .data(manga.getCoverUrl())
                            .crossfade(true)
                            .build(),
                        contentDescription = manga.getTitle(),
                        modifier = Modifier.size(80.dp, 120.dp),
                        contentScale = ContentScale.Crop
                    );
                }
                
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = manga.getTitle(),
                        fontSize = 16.sp,
                        maxLines = 2
                    );
                    if (manga.getAuthor() != null && !manga.getAuthor().isEmpty()) {
                        Text(
                            text = "Автор: " + manga.getAuthor(),
                            fontSize = 12.sp,
                            color = MaterialTheme.INSTANCE.getColorScheme().getOnSurfaceVariant()
                        );
                    }
                }
            }
        }
    }
}
