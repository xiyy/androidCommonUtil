package com.sogou.speech.util;

import android.text.TextUtils;

public class StringUtil {
    public static boolean stringsNotEmpty(String... strings) {
        if (strings != null) {
            int length = strings.length;
            if (length > 0) {
                for (String each : strings) {
                    if (TextUtils.isEmpty(each)) {
                        return false;
                    }
                }
                return true;
            }

        }
        return false;

    }
}
