package com.mytech.mangatalkreader.data.source.impl;

import com.mytech.mangatalkreader.data.source.MangaSource;
import com.mytech.mangatalkreader.domain.model.Chapter;
import com.mytech.mangatalkreader.domain.model.Manga;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mytech/mangatalkreader/data/source/impl/MangaDexSource;", "Lcom/mytech/mangatalkreader/data/source/MangaSource;", "()V", "baseUrl", "", "client", "Lokhttp3/OkHttpClient;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MangaDexSource implements MangaSource {
    private final String baseUrl = "https://api.mangadex.org";
    private final OkHttpClient client = new OkHttpClient();

    @Override
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override
    public String getLang() {
        return "en";
    }

    @Override
    public String getName() {
        return "MangaDex";
    }

    @Override
    public Object getChapters(String mangaUrl, Continuation<? super List<Chapter>> continuation) {
        // Extract manga ID from URL
        String mangaId = mangaUrl;
        if (mangaUrl.contains("/manga/")) {
            mangaId = mangaUrl.substring(mangaUrl.lastIndexOf("/manga/") + 7);
            if (mangaId.contains("/")) {
                mangaId = mangaId.substring(0, mangaId.indexOf("/"));
            }
        }
        final String finalMangaId = mangaId;

        List<Chapter> chapters = new ArrayList<>();
        try {
            Request request = new Request.Builder()
                    .url(this.baseUrl + "/manga/" + finalMangaId + "/feed?order[chapter]=desc&order[volume]=desc&translatedLanguage[]=" + getLang() + "&limit=500")
                    .get()
                    .build();

            try (Response response = this.client.newCall(request).execute()) {
                if (response.body() != null) {
                    String json = response.body().string();
                    JSONObject obj = new JSONObject(json);
                    JSONArray data = obj.optJSONArray("data");
                    if (data != null) {
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject item = data.getJSONObject(i);
                            JSONObject attributes = item.getJSONObject("attributes");
                            String chapterUrl = this.baseUrl + "/at-home/server/" + item.getString("id");
                            String name = "Chapter " + attributes.optString("chapter", "#" + (i + 1));
                            String scanlator = attributes.optString("scanlator", "");
                            chapters.add(new Chapter(chapterUrl, name, scanlator));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chapters;
    }

    @Override
    public Object getPages(String chapterUrl, Continuation<? super List<String>> continuation) {
        List<String> pages = new ArrayList<>();
        try {
            // Extract chapter ID
            String chapterId = chapterUrl;
            if (chapterUrl.contains("/at-home/server/")) {
                chapterId = chapterUrl.substring(chapterUrl.lastIndexOf("/at-home/server/") + 16);
            }

            Request request = new Request.Builder()
                    .url(this.baseUrl + "/at-home/server/" + chapterId)
                    .get()
                    .build();

            try (Response response = this.client.newCall(request).execute()) {
                if (response.body() != null) {
                    String json = response.body().string();
                    JSONObject obj = new JSONObject(json);
                    JSONObject chapter = obj.getJSONObject("chapter");
                    String baseUrl = obj.getString("baseUrl");
                    String hash = chapter.getString("hash");
                    JSONArray images = chapter.getJSONArray("data");

                    for (int i = 0; i < images.length(); i++) {
                        String filename = images.getString(i);
                        pages.add(baseUrl + "/data/" + hash + "/" + filename);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pages;
    }

    @Override
    public Object searchManga(String query, Continuation<? super List<Manga>> continuation) {
        List<Manga> mangaList = new ArrayList<>();
        try {
            Request request = new Request.Builder()
                    .url(this.baseUrl + "/manga?title=" + query + "&limit=20&includes[]=cover_art")
                    .get()
                    .build();

            try (Response response = this.client.newCall(request).execute()) {
                if (response.body() != null) {
                    String json = response.body().string();
                    JSONObject obj = new JSONObject(json);
                    JSONArray data = obj.optJSONArray("data");
                    if (data != null) {
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject item = data.getJSONObject(i);
                            JSONObject attributes = item.getJSONObject("attributes");
                            String id = item.getString("id");
                            JSONObject titleObj = attributes.getJSONObject("title");
                            String title = titleObj.optString("en", titleObj.optString("ja", id));

                            String coverUrl = null;
                            JSONArray relationships = item.optJSONArray("relationships");
                            if (relationships != null) {
                                for (int j = 0; j < relationships.length(); j++) {
                                    JSONObject rel = relationships.getJSONObject(j);
                                    if ("cover_art".equals(rel.getString("type"))) {
                                        String fileName = rel.getJSONObject("attributes").getString("fileName");
                                        coverUrl = "https://uploads.mangadex.org/covers/" + id + "/" + fileName;
                                        break;
                                    }
                                }
                            }

                            mangaList.add(new Manga(
                                    this.baseUrl + "/manga/" + id,
                                    title,
                                    coverUrl
                            ));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mangaList;
    }
}
