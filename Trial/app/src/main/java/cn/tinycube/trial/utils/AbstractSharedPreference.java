package cn.tinycube.trial.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author: GuSiheng
 * @time: 15/5/22
 * @email: gusiheng@qccr.com
 * @desc: SP父类
 */
public abstract class AbstractSharedPreference {

    private Context context;

    protected abstract String getPreferenceName();

    protected int getMode() {
        return Context.MODE_PRIVATE;
    }

    public AbstractSharedPreference(Context context) {
        this.context = context;
    }

    public void putString(String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value).apply();
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        return settings.getString(key, defaultValue);
    }

    public void putObject() {

    }

    public void putInt(String key, int value) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value).apply();
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }

    public int getInt(String key, int defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        return settings.getInt(key, defaultValue);
    }

    public void putLong(String key, long value) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value).apply();
    }

    public long getLong(String key) {
        return getLong(key, -1);
    }

    public long getLong(String key, long defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        return settings.getLong(key, defaultValue);
    }

    public void putFloat(String key, float value) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value).apply();
    }

    public float getFloat(String key) {
        return getFloat(key, -1);
    }

    public float getFloat(String key, float defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        return settings.getFloat(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        return settings.getBoolean(key, defaultValue);
    }

    public void clear() {
        SharedPreferences settings = context.getSharedPreferences(getPreferenceName(), getMode());
        SharedPreferences.Editor editor = settings.edit();
        editor.clear().apply();
    }
}
