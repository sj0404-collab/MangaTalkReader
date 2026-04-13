package com.mytech.mangatalkreader.service;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Real TTS service that works online and offline.
 * Uses Android's built-in TextToSpeech engine.
 * 
 * Works completely offline if offline voice data is installed
 * in Android Settings → Accessibility → Text-to-speech.
 * 
 * Full Russian language support included.
 */
public final class TtsService {
    private static final String TAG = "TtsService";

    /** Available TTS languages with display names. */
    public static final Map<String, Locale> SUPPORTED_LANGUAGES = new HashMap<String, Locale>() {{
        put("English", Locale.US);
        put("Русский", new Locale("ru", "RU"));
        put("Українська", new Locale("uk", "UA"));
        put("日本語", Locale.JAPAN);
        put("中文", Locale.CHINA);
        put("한국어", Locale.KOREA);
        put("Deutsch", Locale.GERMANY);
        put("Français", Locale.FRANCE);
        put("Español", new Locale("es", "ES"));
    }};

    private TextToSpeech tts;
    private boolean isInitialized = false;
    private final Context context;
    private final List<TtsStateListener> listeners = new ArrayList<>();

    private float speechRate = 1.0f;
    private float pitchRate = 1.0f;
    private Locale currentLocale = new Locale("ru", "RU"); // Default: Russian
    private String currentUtteranceId = null;

    public interface TtsStateListener {
        void onSpeakingStarted();
        void onSpeakingFinished();
        void onSpeakingError(String error);
    }

    public TtsService(Context context) {
        this.context = context.getApplicationContext();
        initializeTts();
    }

    private void initializeTts() {
        try {
            tts = new TextToSpeech(context, status -> {
                if (status == TextToSpeech.SUCCESS) {
                    setLocale(currentLocale);
                    isInitialized = true;
                    Log.d(TAG, "TTS initialized: " + currentLocale.getDisplayName());

                    tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String utteranceId) {
                            currentUtteranceId = utteranceId;
                            for (TtsStateListener listener : listeners) {
                                listener.onSpeakingStarted();
                            }
                        }

                        @Override
                        public void onDone(String utteranceId) {
                            currentUtteranceId = null;
                            for (TtsStateListener listener : listeners) {
                                listener.onSpeakingFinished();
                            }
                        }

                        @Override
                        public void onError(String utteranceId) {
                            currentUtteranceId = null;
                            for (TtsStateListener listener : listeners) {
                                listener.onSpeakingError("TTS error");
                            }
                        }
                    });
                } else {
                    Log.e(TAG, "TTS initialization failed with status: " + status);
                    isInitialized = false;
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

    public boolean isSpeaking() {
        return isInitialized && tts != null && tts.isSpeaking();
    }

    /**
     * Speak the given text.
     * Works offline if voice data for the current language is installed.
     */
    public void speak(String text) {
        if (!isAvailable()) {
            Log.w(TAG, "TTS not available");
            return;
        }
        if (text == null || text.isEmpty()) {
            return;
        }

        String utteranceId = "utterance_" + System.currentTimeMillis();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            android.os.Bundle params = new android.os.Bundle();
            params.putFloat(TextToSpeech.Engine.KEY_PARAM_SPEECH_RATE, speechRate);
            params.putFloat(TextToSpeech.Engine.KEY_PARAM_PITCH, pitchRate);
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId);
        } else {
            tts.setSpeechRate(speechRate);
            tts.setPitch(pitchRate);
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    /**
     * Stop current speech.
     */
    public void stop() {
        if (isAvailable()) {
            tts.stop();
        }
    }

    /**
     * Shutdown TTS engine. Call when done.
     */
    public void shutdown() {
        if (tts != null) {
            tts.shutdown();
            isInitialized = false;
        }
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

    /**
     * Set the TTS language.
     * @return true if language is available, false if data needs to be downloaded
     */
    public boolean setLocale(Locale locale) {
        this.currentLocale = locale;
        if (!isAvailable()) return false;

        int result = tts.setLanguage(locale);
        boolean isAvailable = (result == TextToSpeech.LANG_AVAILABLE ||
                               result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                               result == TextToSpeech.LANG_COUNTRY_VARIANT_AVAILABLE);

        if (!isAvailable) {
            Log.w(TAG, "Language data not available for " + locale.getDisplayName() +
                  ". Install offline voice data in Android Settings.");
        }

        return isAvailable;
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
     * Get list of installed voices on this device.
     */
    public Set<Voice> getInstalledVoices() {
        if (!isAvailable()) return null;
        return tts.getVoices();
    }

    /**
     * Add a state listener for TTS events.
     */
    public void addStateListener(TtsStateListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Remove a state listener.
     */
    public void removeStateListener(TtsStateListener listener) {
        listeners.remove(listener);
    }

    /**
     * Test TTS with a sample phrase in the current language.
     */
    public void testTts() {
        if (!isAvailable()) return;

        String testPhrase;
        String langCode = currentLocale.getLanguage();

        switch (langCode) {
            case "ru":
                testPhrase = "Привет! Это Manga Talk Reader. Распознавание текста и озвучка работают.";
                break;
            case "ja":
                testPhrase = "こんにちは！マンガトークリーダーです。";
                break;
            case "zh":
                testPhrase = "你好！这是漫画阅读器。";
                break;
            case "ko":
                testPhrase = "안녕하세요! 만화 리더기입니다.";
                break;
            case "uk":
                testPhrase = "Привіт! Це Manga Talk Reader.";
                break;
            case "de":
                testPhrase = "Hallo! Dies ist Manga Talk Reader.";
                break;
            case "fr":
                testPhrase = "Bonjour! Ceci est Manga Talk Reader.";
                break;
            case "es":
                testPhrase = "¡Hola! Esto es Manga Talk Reader.";
                break;
            default:
                testPhrase = "Hello! This is Manga Talk Reader.";
                break;
        }

        speak(testPhrase);
    }
}
