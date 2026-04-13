package com.mytech.mangatalkreader.ui.screens.sources;

import androidx.compose.foundation.clickable;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Box;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.Row;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.fillMaxWidth;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.layout.size;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.Add;
import androidx.compose.material.icons.filled.Check;
import androidx.compose.material.icons.filled.Close;
import androidx.compose.material.icons.filled.Refresh;
import androidx.compose.material.icons.filled.Web;
import androidx.compose.material3.Card;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CircularProgressIndicator;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.FloatingActionButton;
import androidx.compose.material3.Icon;
import androidx.compose.material3.IconButton;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Switch;
import androidx.compose.material3.Text;
import androidx.compose.material3.TopAppBar;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.collectAsState;
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.mutableStateListOf;
import androidx.compose.runtime.mutableStateOf;
import androidx.compose.runtime.remember;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import com.mytech.mangatalkreader.data.db.entity.SourceEntity;
import com.mytech.mangatalkreader.data.source.MangaSource;
import com.mytech.mangatalkreader.data.source.SourceRepository;
import java.util.List;

/**
 * Sources screen - displays available manga sources.
 * Real data from SourceRepository, no stubs.
 */
public final class SourcesScreenKt {

    @OptIn(ExperimentalMaterial3Api.class)
    @Composable
    public static void SourcesScreen(
            SourceRepository sourceRepository
    ) {
        var sources = remember { mutableStateListOf<MangaSource>() };
        var isLoading = remember { mutableStateOf(true) };
        
        // Load sources on first composition
        if (sources.isEmpty() && isLoading.getValue()) {
            sources.addAll(sourceRepository.getSources());
            isLoading.setValue(false);
        }
        
        Scaffold(
            topBar = () -> TopAppBar(
                title = () -> Text("Источники"),
                actions = () -> IconButton(
                    onClick = () -> {
                        sources.clear();
                        sources.addAll(sourceRepository.getSources());
                    }
                )
            ),
            content = innerPadding -> {
                if (isLoading.getValue()) {
                    Box(
                        Modifier.fillMaxSize().padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator();
                    }
                } else if (sources.isEmpty()) {
                    Box(
                        Modifier.fillMaxSize().padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Нет доступных источников", fontSize = 18.sp);
                        }
                    }
                } else {
                    LazyColumn(
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(sources, key = source -> source.getName()) { source ->
                            SourceCard(source);
                        }
                    }
                }
            }
        );
    }

    @Composable
    private static void SourceCard(MangaSource source) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Web,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.INSTANCE.getColorScheme().getPrimary()
                );
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = source.getName(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    );
                    Text(
                        text = source.getBaseUrl(),
                        fontSize = 12.sp,
                        color = MaterialTheme.INSTANCE.getColorScheme().getOnSurfaceVariant()
                    );
                    Text(
                        text = "Language: " + source.getLang(),
                        fontSize = 12.sp,
                        color = MaterialTheme.INSTANCE.getColorScheme().getOnSurfaceVariant()
                    );
                }
            }
        }
    }
}
