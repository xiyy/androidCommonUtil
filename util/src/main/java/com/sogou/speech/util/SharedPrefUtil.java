package com.sogou.speech.util;

import android.content.Context;

public class SharedPrefUtil {
    private static final String SP_FILE_NAME = "sougou_speech_sp";

    public static boolean putString(Context context, String key, String value) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).edit().putString(key, value).commit();
        }
        return false;


    }

    public static void putStringAsynchronous(Context context, String key, String value) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
        }


    }


    public static String getString(Context context, String key) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).getString(key, "");
        }
        return null;


    }

    public static boolean putInt(Context context, String key, int value) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).edit().putInt(key, value).commit();
        }
        return false;

    }

    public static void putIntAsynchronous(Context context, String key, int value) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).edit().putInt(key, value).apply();
        }

    }

    public static int getInt(Context context, String key) {
        if (context != null && StringUtil.stringsNotEmpty(key)) {
            return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE).getInt(key, -1);
        }
        return -1;

    }
}
