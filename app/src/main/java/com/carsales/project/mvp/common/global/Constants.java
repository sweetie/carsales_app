package com.carsales.project.mvp.common.global;

import android.Manifest;
import android.support.v4.util.Pair;

/**
 * Created by Enny Querales
 */
public class Constants {

    /**
     * Permission constants
     */

    public static final String API_KEY = "c9ad162701204a39a7a64e59c87e3df1";
    public static final String COUNTRY = "us";
    public static final int READ_EXTERNAL_STORAGE = 10;
    public static final int WRITE_EXTERNAL_STORAGE = 20;
    /*    public static final int CAMERA = 30;
        public static final int RECORD_AUDIO = 40;
        public static final int FINE_LOCATION = 50;
        public static final int COURSE_LOCATION = 60;
        public static final int READ_CONTACTS = 70;
        public static final int WRITE_CONTACTS = 80;
        public static final int READ_PHONE_STATE = 90;
        public static final int CALL_PHONE = 100;*/
    public static final int ALL = 200;

    public static final Pair<String, Integer> READ_PERMISSION =
            new Pair<>(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE);

    public static final Pair<String, Integer> WRITE_PERMISSION =
            new Pair<>(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE);

/*    public static final Pair<String, Integer> CAMERA_PERMISSION =
            new Pair<>(Manifest.permission.CAMERA, CAMERA);*/
}
