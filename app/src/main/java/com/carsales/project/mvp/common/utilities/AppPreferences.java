package com.carsales.project.mvp.common.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class AppPreferences {

    private SharedPreferences mSharedPrefs;
    private SharedPreferences.Editor mPrefsEditor;
    private Context mContext;

    public AppPreferences(Context context) {
        mContext = context;
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
        mPrefsEditor = mSharedPrefs.edit();
    }

    public void removePreferences() {
        mPrefsEditor.remove("resultUser");
        mPrefsEditor.commit();
    }

    public void removeUser() {
        mPrefsEditor.remove("resultUser");
        mPrefsEditor.commit();
    }
}
