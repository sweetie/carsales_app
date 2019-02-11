package com.carsales.project.mvp.common.managers;

import android.os.Handler;

import com.carsales.project.mvp.common.utilities.Logger;

import com.carsales.project.mvp.common.interfaces.Listener;


/**
 * Created by Enny Querales
 */
public class FutureTaskManager {

    /**
     * Attributes
     */
    private static final String TAG = "FutureTaskManager";
    private static Logger logger = new Logger(TAG);
    private static Handler handler;
    private static Runnable runnable;


    private FutureTaskManager() {
        if (handler == null)
            handler = new Handler();
    }

    /**
     * Executes a task after the delay specified
     *
     * @param listener Executor callback
     * @param name identify the task to be executed
     * @param time delay after which the task should be executed
     * @param shouldLoop indicates whether the task should be repeated
     */
    public static void executeAfter(final Listener.ExecutorListener listener, final String name,
                                    final long time, final boolean shouldLoop) {

        new FutureTaskManager();

        handler.postDelayed(new Runnable() {
            public void run() {
                listener.execute(name);

                runnable = this;

                if (shouldLoop) {
                    logger.log("Should be on auto-play");
                    handler.postDelayed(runnable, time * 1000);
                }
            }
        }, time * 1000);
    }

    public static void stop() {
        handler.removeCallbacks(runnable);
    }
}
