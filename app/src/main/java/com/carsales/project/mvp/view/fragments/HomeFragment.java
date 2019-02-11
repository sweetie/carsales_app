package com.carsales.project.mvp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.carsales.project.R;
import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.generic.GenericFragment;
import com.carsales.project.mvp.common.interfaces.Listener;
import com.carsales.project.mvp.common.utilities.Tools;
import com.carsales.project.mvp.presenter.HomePresenter;
import com.carsales.project.mvp.view.activities.MainActivity;


public class HomeFragment
        extends GenericFragment<MVP.RequiredFragmentMethods, MVP.ProvidedPresenterMethodsFragment, HomePresenter>
        implements MVP.RequiredFragmentMethods, View.OnClickListener, Listener.OnNetworkResponseListener {

    private FrameLayout containerLayout;
    private Listener.OnNetworkResponseListener listener;
    private MainActivity mActivity;

    /**
     * Hook method called to set up the fragment's user interface. It returns a View object,
     * that is given to the hosting activity to install it into its view hierarchy.
     *
     * @param container          view parent of the fragment in the activity, therefore its container
     * @param savedInstanceState object that contains saved state information.
     * @return View object returned by the inflation process
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        containerLayout = (FrameLayout) inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize retained fragment state
        isRetainedFragment = false;
        mActivity = (MainActivity) getActivity();

        // Instantiate the presenter
        super.onCreate(HomePresenter.class, this);

        listener = this;
        // Initialize the view components defined in the fragment's layout
        initializeViews();

        Tools.muestraProgressBar(mActivity);
        getPresenter().handleClick(-1, listener, null);
        return containerLayout;
    }

    public void initializeViews() {
    }

    @Override
    public <T> void processResponse(T response) {
        Tools.escondeProgressBar(getActivity());
    }

    @Override
    public <T> void processFailure(T response) {
        Tools.escondeProgressBar(mActivity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }

    @Override
    public <T> void updateView(T data) {

    }
}
