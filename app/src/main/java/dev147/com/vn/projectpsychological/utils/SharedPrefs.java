package dev147.com.vn.projectpsychological.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefs {
    private static SharedPrefs instance;
    private SharedPreferences preferences;

    private SharedPrefs(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new SharedPrefs(context);
        }
    }

    public static SharedPrefs getInstance() {
        if (null == instance) {
            throw new IllegalStateException("SharedPrefs has not initialized");
        }
        return instance;
    }

    public SharedPrefs putBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
        return instance;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }
}
