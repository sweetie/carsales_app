package com.carsales.project.mvp.common.interfaces;

/**
 * Created by Enny Querales
 */

public interface Listener {

    interface OnNetworkResponseListener {
        <T> void processResponse(T response);

        <T> void processFailure(T response);
    }

    interface ExecutorListener {
        void execute(String name);
    }

    interface OnSelectedListener {
        <T> void onSelected(T model);
    }

    interface PermissionListener {
        void startComponent();

        void showDialog();
    }

    interface LoadingCancel {
        void onCancel();
    }
}
