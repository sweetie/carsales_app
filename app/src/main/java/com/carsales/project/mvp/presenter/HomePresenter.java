package com.carsales.project.mvp.presenter;

import android.content.Context;

import java.lang.ref.WeakReference;

import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.generic.GenericPresenter;
import com.carsales.project.mvp.common.interfaces.Listener;
import com.carsales.project.mvp.common.utilities.AppPreferences;
import com.carsales.project.mvp.model.GlobalModel;

public class HomePresenter
        extends GenericPresenter<MVP.RequiredPresenterMethods, MVP.ProvidedModelMethods, GlobalModel>
        implements MVP.ProvidedPresenterMethodsFragment, MVP.RequiredPresenterMethods {

    /**
     * Attributes
     */
    private WeakReference<MVP.RequiredFragmentMethods> view;
    private Context context;
    private Listener.OnNetworkResponseListener listener = null;
    private AppPreferences appPreferences;

    /**
     * Hook method called when a new instance of this presenter is created.
     *
     * @param view A reference to the View layer.
     */
    @Override
    public void onCreate(MVP.RequiredFragmentMethods view) {
        // Initialized the defined WeakReference
        this.view = new WeakReference<>(view);

        // Invoke the special onCreate() method in GenericPresenter to instantiate the model
        super.onCreate(GlobalModel.class, this);

        // Initialize context
        context = this.view.get().getActivityContext();
        appPreferences = new AppPreferences(context);
    }

    public void getCategories() {
/*        Call<ResponseBody> call = Client.getRestAPIService().getCategories(Constants.APP_ID, Constants.LANGUAGE, "Bearer " + appPreferences.getUser().getContent().getToken());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (listener != null)
                        try {
                            listener.processResponse(Client.getSuccessAPIService(response.body().string(), ResultCategory.class));
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
        });*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public MVP.ProvidedModelMethods getModel() {
        return new GlobalModel(context);
    }

    @Override
    public <T> void handleClick(int viewId, Listener.OnNetworkResponseListener listener, T clazz) {
        this.listener = listener;
    }

    @Override
    public <T> void cancel() {

    }
}
