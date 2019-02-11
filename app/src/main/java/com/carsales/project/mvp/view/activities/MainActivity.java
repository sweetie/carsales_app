package com.carsales.project.mvp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carsales.project.R;
import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.generic.GenericActivity;
import com.carsales.project.mvp.common.interfaces.Listener;
import com.carsales.project.mvp.common.utilities.Tools;
import com.carsales.project.mvp.model.data.Auto;
import com.carsales.project.mvp.presenter.MainActivityPresenter;
import com.carsales.project.mvp.view.adapter.AutoAdapter;


/**
 * Created by Enny Querales
 */
public class MainActivity
        extends GenericActivity<MVP.RequiredActivityMethods, MVP.ProvidedPresenterMethodsActivity, MainActivityPresenter>
        implements MVP.RequiredActivityMethods, View.OnClickListener, Listener.ExecutorListener, Listener.OnNetworkResponseListener {

    /**
     * Attributes
     */
    private static boolean activityStarted;
    private AutoAdapter adapter;
    private RecyclerView recyclerView;
    private Listener.OnNetworkResponseListener listener;

    /**
     * Vector drawable support
     */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /**
     * This hook method is called when the Activity is instantiated.
     *
     * @param savedInstanceState saved previous state, it may be null
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (activityStarted && getIntent() != null && (getIntent().getFlags() & Intent.FLAG_ACTIVITY_REORDER_TO_FRONT) != 0) {
            finish();
            return;
        }

        activityStarted = true;

        setContentView(R.layout.activity_main);

        // Instantiate the presenter
        super.onCreate(MainActivityPresenter.class, this);

        listener = this;
        // Initialize all view components defined in the activity's layout
        Tools.muestraProgressBar(this);
        getPresenter().handleClick(-1, listener, null);
        initializeViews();
    }

    /**
     * Initialize the Views and GUI widgets.
     */
    public void initializeViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
    }

    /**
     * Called when the user clicks a button to perform some action
     *
     * @param view Indicates the view component pressed by the user
     */
    @Override
    public void onClick(View view) {
        // no-op
    }

    @Override
    public void execute(String name) {
    }

    public void onResume() {
        super.onResume();
    }

    @Override
    public <T> void processResponse(T response) {
        Tools.escondeProgressBar(this);
        if (response instanceof Auto) {
            Auto result = (Auto) response;
            //if (!result.getResult().isEmpty()) {
                adapter = new AutoAdapter(this, result.getResult());
                recyclerView.setAdapter(adapter);
          //  }
        }
    }

    @Override
    public <T> void processFailure(T response) {
        Tools.escondeProgressBar(this);
    }
}
