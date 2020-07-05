package com.hackathon.sailors.preffs;

import android.content.ContentResolver;
import android.content.SharedPreferences;


public class Data {


    public static final String PREFS_SID_KEY = "sidToken";



    private final ContentResolver contentResolver;
    private final String LOG_TAG = "DATA";

    public Data(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    //user tokens
    public static void setSidToken(SharedPreferences prefs, String sidToken) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREFS_SID_KEY, sidToken);
        editor.apply();
    }

    public static String getSidToken(SharedPreferences prefs) {
        return prefs.getString(PREFS_SID_KEY, "");
    }

    public static void deleteAuthToken(SharedPreferences prefs) {
         prefs.edit().clear().apply();
    }

}

