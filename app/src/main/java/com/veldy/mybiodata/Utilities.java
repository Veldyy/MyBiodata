package com.veldy.mybiodata;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utilities {

    private SharedPreferences sp; //mereset data
    private SharedPreferences.Editor editor; // menyimpan dan mengambil data

    public void setpref(Context context,String key, String value )
    { // set cara melakukan penyimpanan data
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String getPref(Context context,String key)
    { // set mengambil data
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        String value = sp.getString(key, null);
        return  value;
    }

    public Boolean isLogin(Context context,String key)
    { // melakukan cek apakah sudah login atau belum
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        String value = sp.getString(key, null);
        return value != null;
    }
}
