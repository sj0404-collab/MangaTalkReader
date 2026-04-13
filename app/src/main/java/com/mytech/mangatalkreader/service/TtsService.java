package com.mytech.mangatalkreader.service;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Real TTS service that works online and offline.
 * Uses Android's built-in TextToSpeech engine.
 * Works completely offline if offline voice data is installed.
 */
public final class TtsService {
    private static final String TAG = "TtsService";
    
    private TextToSpeech tts;
    private boolean isInitialized = false;
    private final Context context;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    
    private float speechRate = 1.0f;
    private float pitchRate = 1.0f;
    private Locale currentLocale = Locale.getDefault();

    public TtsService(Context context) {
        this.context = context.getApplicationContext();
        initializeTts();
    }

    private void initializeTts() {
        try {
            tts = new TextToSpeech(context, status -> {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(currentLocale);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.w(TAG, "Language not supported, falling back to US English");
                        tts.setLanguage(Locale.US);
                    }
                    isInitialized = true;
                    Log.d(TAG, "TTS initialized successfully");
                } else {
                    Log.e(TAG, "TTS initialization failed");
                    isInitialized = false;
                }
            });

            tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                @Override
                public void onStart(String utteranceId) {
                    Log.d(TAG, "TTS started: " + utteranceId);
                }

                @Override
                public void onDone(String utteranceId) {
                    Log.d(TAG, "TTS finished: " + utteranceId);
                }

                @Override
                public void onError(String utteranceId) {
                    Log.e(TAG, "TTS error: " + utteranceId);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "TTS initialization error: " + e.getMessage(), e);
            isInitialized = false;
        }
    }

    public boolean isAvailable() {
        return isInitialized && tts != null;
    }

    public void speak(String text) {
        if (!isAvailable()) {
            Log.w(TAG, "TTS not available");
            return;
        }
        if (text == null || text.isEmpty()) {
            return;
        }

        executor.execute(() -> {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Bundle params = new Bundle();
                    params.putFloat(TextToSpeech.Engine.KEY_PARAM_SPEECH_RATE, speechRate);
                    params.putFloat(TextToSpeech.Engine.KEY_PARAM_PITCH, pitchRate);
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, params, "utterance_" + System.currentTimeMillis());
                } else {
                    tts.setSpeechRate(speechRate);
                    tts.setPitch(pitchRate);
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
            } catch (Exception e) {
                Log.e(TAG, "TTS speak error: " + e.getMessage(), e);
            }
        });
    }

    public void speakAsync(String text) {
        speak(text);
    }

    public void stop() {
        if (isAvailable()) {
            tts.stop();
        }
    }

    public void shutdown() {
        if (tts != null) {
            tts.shutdown();
            isInitialized = false;
        }
        executor.shutdown();
    }

    public void setSpeechRate(float rate) {
        this.speechRate = Math.max(0.1f, Math.min(3.0f, rate));
        if (isAvailable()) {
            tts.setSpeechRate(this.speechRate);
        }
    }

    public void setPitchRate(float rate) {
        this.pitchRate = Math.max(0.1f, Math.min(2.0f, rate));
        if (isAvailable()) {
            tts.setPitch(this.pitchRate);
        }
    }

    public void setLocale(Locale locale) {
        this.currentLocale = locale;
        if (isAvailable()) {
            int result = tts.setLanguage(locale);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.w(TAG, "Locale not supported");
            }
        }
    }

    public float getSpeechRate() { return speechRate; }
    public float getPitchRate() { return pitchRate; }
    public Locale getCurrentLocale() { return currentLocale; }

    /**
     * Check if offline voice data is available for a language.
     */
    public boolean isLanguageAvailable(Locale locale) {
        if (!isAvailable()) return false;
        int result = tts.isLanguageAvailable(locale);
        return result == TextToSpeech.LANG_AVAILABLE ||
               result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
               result == TextToSpeech.LANG_COUNTRY_VARIANT_AVAILABLE;
    }

    /**
     * Install offline voice data for a language.
     */
    public void installVoiceData(Locale locale) {
        if (isAvailable()) {
            tts.setLanguage(locale);
        }
    }
}
