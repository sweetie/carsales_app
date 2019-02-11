package com.carsales.project.mvp;

import android.app.Application;

/**
 * Created by Enny Querales.
 */
public class App extends Application {

    public static final String TAG = App.class.getSimpleName();
    private static App mInstance;
    //private static List<ActivityScience> actividades = new ArrayList<>();
    public static synchronized App getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
