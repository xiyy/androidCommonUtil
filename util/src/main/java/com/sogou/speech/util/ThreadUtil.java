package com.sogou.speech.util;

import android.os.Looper;

public class ThreadUtil {
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }
}
