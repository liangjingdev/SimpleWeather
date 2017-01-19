package activitytest.example.com.simpleweather.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asus on 2017/1/18.
 * 描述：SharedPreferences封装
 */

public class SharePreUtils {

    public static final String SHARE_NAME = "config";

    public static void putString(Context mContext, String key, String values) {
        SharedPreferences sp = mContext.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, values).commit();
    }

    public static String getString(Context mContext, String key, String values) {
        SharedPreferences sp = mContext.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, values);
    }

}
