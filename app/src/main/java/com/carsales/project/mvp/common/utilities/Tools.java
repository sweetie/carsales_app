package com.carsales.project.mvp.common.utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import com.carsales.project.R;
import com.carsales.project.mvp.common.interfaces.Listener;


public class Tools {

    public static View PROGRESSBAR;
    public static boolean IS_PROGRESSBAR_VISIBLE = false;

    public static void muestraProgressBar(Activity a) {
        PROGRESSBAR = LayoutInflater.from(a).inflate(R.layout.view_loading,
                (ViewGroup) a.findViewById(android.R.id.content), false);

        ((ViewGroup) a.findViewById(android.R.id.content)).addView(PROGRESSBAR);
        if (a.getCurrentFocus() != null)
            a.getCurrentFocus().clearFocus();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            ProgressBar bar = PROGRESSBAR.findViewById(R.id.progresBar);
            Drawable drawableProgress = DrawableCompat.wrap(bar.getIndeterminateDrawable());
            DrawableCompat.setTint(drawableProgress, ContextCompat.getColor(a, R.color.grey_300));
            bar.setIndeterminateDrawable(DrawableCompat.unwrap(drawableProgress));
        }

        IS_PROGRESSBAR_VISIBLE = true;
        a.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static void escondeProgressBar(Activity a, final Listener.LoadingCancel listener) {
        if (PROGRESSBAR != null && PROGRESSBAR.getParent() != null) {
            ((ViewGroup) PROGRESSBAR.getParent()).removeView(PROGRESSBAR);
            if (a != null)
                a.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        PROGRESSBAR = null;
        IS_PROGRESSBAR_VISIBLE = false;
    }

    public static void escondeProgressBar(Activity a) {
        if (PROGRESSBAR != null && PROGRESSBAR.getParent() != null) {
            ((ViewGroup) PROGRESSBAR.getParent()).removeView(PROGRESSBAR);
            if (a != null)
                a.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        PROGRESSBAR = null;
        IS_PROGRESSBAR_VISIBLE = false;
    }

    public static LatLng trackLatLng(Context mContext, Activity activity) {
        GPSTracker gps = new GPSTracker(mContext, activity);
        LatLng currentLocation = new LatLng(40.416775, -3.703790);
        // check if GPS enabled
        if (gps.canGetLocation()) {
            currentLocation = new LatLng(gps.getLatitude(), gps.getLongitude());
        } else {
            Toast.makeText(mContext, "GPS NOT ENABLED", Toast.LENGTH_SHORT).show();
        }
        return currentLocation;
    }

}
