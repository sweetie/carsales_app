package com.carsales.project.mvp.presenter;

import android.content.Context;

import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.generic.GenericPresenter;
import com.carsales.project.mvp.common.interfaces.Listener;
import com.carsales.project.mvp.common.utilities.AppPreferences;
import com.carsales.project.mvp.model.GlobalModel;
import com.carsales.project.mvp.model.data.Auto;
import com.carsales.project.mvp.model.data.Result;
import com.carsales.project.mvp.model.netwotk.Client;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Enny Querales
 */
public class MainActivityPresenter
        extends GenericPresenter<MVP.RequiredPresenterMethods, MVP.ProvidedModelMethods, GlobalModel>
        implements MVP.ProvidedPresenterMethodsActivity, MVP.RequiredPresenterMethods {

    /**
     * Attributes
     */
    private WeakReference<MVP.RequiredActivityMethods> view;
    private Listener.OnNetworkResponseListener listener = null;
    private Context context;

    /**
     * Hook method called when a new instance of this presenter is created.
     *
     * @param view A reference to the View layer.
     */
    @Override
    public void onCreate(MVP.RequiredActivityMethods view) {
        // Initialized the defined WeakReference
        this.view = new WeakReference<>(view);

        // Invoke the special onCreate() method in GenericPresenter to instantiate the model
        super.onCreate(GlobalModel.class, this);

        context = this.view.get().getActivityContext();
    }

    public void getAutos() {
        Call<ResponseBody> call = Client.getRestAPIService().getAutos();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (listener != null)
                        try {
                            listener.processResponse(Client.getSuccessAPIService(response.body().string(), Auto.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                } else {
                    listener.processFailure(Client.getErrorAPIService(response.errorBody().byteStream()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                try {
                    listener.processFailure("Something went wrong! \n" + throwable.getCause().toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * Called when the user clicks a button to perform some action
     *
     * @param viewId Indicates the id of the button pressed by the user
     */
    @Override
    public void handleClick(int viewId) {
        // no-op
    }

    @SuppressWarnings("unchecked")
    @Override
    public MVP.ProvidedModelMethods getModel() {
        return new GlobalModel(context);
    }

    @Override
    public <T> void handleClick(int viewId, Listener.OnNetworkResponseListener listener, T clazz) {
        this.listener = listener;
        getAutos();
    }
}
