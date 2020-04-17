package com.sogou.speech.util;

import android.util.Log;

public class LogUtil {
    private static final String DEFAULT_TAG = "sogou_speech";
    private static boolean isDebug = false;

    public static void setDebug(boolean isDebug) {
        LogUtil.isDebug = isDebug;
    }


    public static boolean isDebug() {
        return isDebug;
    }


    public static void log(String content) {
        log(DEFAULT_TAG, content);
    }


    public static void log(String tag, String content) {
        if (StringUtil.stringsNotEmpty(tag, content)) {
            if (isDebug) {
                Log.d(tag, content);
            }
        }


    }


    public static void logw(String content) {
        logw(DEFAULT_TAG, content);

    }


    public static void logw(String tag, String content) {
        if (StringUtil.stringsNotEmpty(tag, content)) {
            if (isDebug) {
                Log.w(tag, content);
            }
        }


    }

    public static void loge(String content) {
        loge(DEFAULT_TAG, content);
    }


    public static void loge(String tag, String content) {
        if (StringUtil.stringsNotEmpty(tag, content)) {
            if (isDebug) {
                Log.e(tag, content);
            }
        }
    }


}
