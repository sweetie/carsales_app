package com.carsales.project.mvp.common.generic;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;

import com.carsales.project.R;
import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.global.Enums;
import com.carsales.project.mvp.common.interfaces.PresenterMethods;
import com.carsales.project.mvp.common.managers.RetainedFragmentManager;
import com.carsales.project.mvp.common.utilities.Logger;

/**
 * This class provides a framework for mediating access to an object residing in the Presenter
 * layer in the Model-View-Presenter (MVP) pattern. It automatically handles runtime configuration
 * changes in conjunction with an instance of the Presenter (P), which must implement the
 * PresenterMethods interface.
 * It extends LifecycleLoggingFragment so all lifecycle hook method calls are automatically logged.
 * <p>
 * The three types used by a GenericActivity are the following:
 * <p>
 * RequiredViewMethods (RVM): the class or interface that defines the methods available to the
 * Presenter object from the View layer.
 * <p>
 * ProvidedPresenterMethods (PPM: the class or interface that defines the methods available to the
 * View layer from the Presenter object.
 * <p>
 * Presenter (P): the class used by the GenericActivity framework to instantiate a Presenter object.
 * <p>
 * Modified by
 *
 * @author Enny Querales
 */
public abstract class GenericFragment<RVM, PPM, P extends PresenterMethods<RVM>>
        extends LifecycleLoggingFragment
        implements MVP.RequiredFragmentMethods {

    /**
     * Attributes
     */
    private final String TAG = getClass().getSimpleName();
    private String presenterTAG;
    private Logger logger = new Logger(TAG);
    protected Activity activityContext;
    private P presenter;
    private RetainedFragmentManager retainedFragmentManager;
    protected boolean isRetainedFragment;
    protected View dialogView = null;
    protected DialogFragment dialog = null;


    /**
     * Hook method called when a fragment is attached to its hosting activity.
     *
     * @param context Activity context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity)
            activityContext = (Activity) context;

        retainedFragmentManager = new RetainedFragmentManager(activityContext.getFragmentManager(), TAG);
    }

    /**
     * Initialize or reinitialize the Presenter layer.
     * Handle configuration-related events, including the initial creation of an Activity and any
     * subsequent runtime configuration changes.
     * This must be called after the onCreate(Bundle saveInstanceState) method.
     *
     * @param presenter Class used to create a Presenter object.
     * @param view      Reference to the RequiredViewMethods object.
     */
    public void onCreate(Class<P> presenter, RVM view) {
        if (isRetainedFragment) {
            presenterTAG = presenter.getSimpleName();
            //noinspection TryWithIdenticalCatches
            try {
                if (retainedFragmentManager.firstTimeIn())
                    initialize(presenter, view);
                else
                    reinitialize(presenter, view);
            } catch (InstantiationException e) {
                logger.log("onCreate() - " + e);
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                logger.log("onCreate() - " + e);
                throw new RuntimeException(e);
            }
        } else {
            try {
                initializeNotRetained(presenter, view);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Return the ProvidedPresenterMethods instance for use by application logic in the View layer.
     */
    @SuppressWarnings("unchecked")
    public PPM getPresenter() {
        return (PPM) this.presenter;
    }

    /**
     * Initialize the GenericFragment fields.
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void initialize(Class<P> presenter, RVM view)
            throws InstantiationException, IllegalAccessException {

        // Create the Presenter object.
        try {
            this.presenter = presenter.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        // Put instances into the RetainedFragmentManager under a simple name.
        retainedFragmentManager.put(presenterTAG, this.presenter);

        // Calls onCreate hook method on the Presenter layer.
        this.presenter.onCreate(view);
    }

    /**
     * Initialize the GenericFragment fields without retained functionality
     *
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private void initializeNotRetained(Class<P> presenter, RVM view)
            throws InstantiationException, IllegalAccessException {

        // Create the Presenter object.
        try {
            this.presenter = presenter.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        // Calls onCreate hook method on the Presenter layer.
        this.presenter.onCreate(view);
    }

    /**
     * Reinitialize the GenericActivity fields after a runtime configuration change.
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void reinitialize(Class<P> presenter, RVM view)
            throws InstantiationException, IllegalAccessException {

        // Restoring states from the RetainedFragmentManager under a simple name.
        this.presenter = retainedFragmentManager.get(presenterTAG);

        // Checks Presenter state
        if (this.presenter == null)
            initialize(presenter, view);
        else
            this.presenter.onConfigurationChange(view);
    }

    /**
     * Return boolean value that specifies the retained functionality state.
     * Whether active or inactive.
     */
    public boolean isRetainedFragment() {
        return isRetainedFragment;
    }

    /**
     * Return Activity's context
     */
    public Context getActivityContext() {
        return activityContext;
    }

    /**
     * Return parent Activity
     */
    public <T extends GenericActivity> T getParentActivity(Class<T> classType) {
        return classType.cast(getActivity());
    }

    /**
     * Sets a custom dialog view to be displayed on request of the fragment
     */
    public void setDialog(View view) {
        dialogView = view;
    }

    /**
     * Sets a custom dialog fragment to be displayed on request of the fragment
     */
    public void setDialog(DialogFragment dialog) {
        this.dialog = dialog;
    }

    /**
     * Displays dialog with type {@param type}
     *
     * @param type chosen type
     */
    public void displayDialog(Enums.DialogType type) {
        switch (type) {
            case TIME_DETERMINED:
                break;
            case TIME_UNDETERMINED:
                LinearLayout progressBar = (LinearLayout) dialogView;
                progressBar.setVisibility(View.VISIBLE);
                break;
            case MESSAGE:
                break;
        }
    }

    /**
     * Dismiss dialog with type {@param type}
     *
     * @param type chosen type
     */
    public void dismissDialog(Enums.DialogType type) {
        switch (type) {
            case TIME_DETERMINED:
                break;
            case TIME_UNDETERMINED:
                LinearLayout progressBar = (LinearLayout) dialogView;
                progressBar.setVisibility(View.GONE);
                break;
            case MESSAGE:
                break;
        }
    }

    public void showTitleAndMessageDialog(Context context, String title, String message) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        final AlertDialog dialog = alert.setPositiveButton("OK", null).setCancelable(false).setTitle(title).setMessage(message).create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        dialog.show();
    }

    public void showTitleAndMessageDialog(final View view, Context context, String title, String message, final View.OnClickListener okListener) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);

        final AlertDialog dialog = alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (okListener != null)
                    okListener.onClick(view);
            }

        }).setCancelable(false).setTitle(title).setMessage(message).create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        if (!((Activity) context).isFinishing()) {
            dialog.show();
        }
    }

    public void showTitleAndMessageDialogOptions(final View view, Context context, String
            title, String message, String opt1, String opt2,
                                                 final View.OnClickListener opt1Listener, final View.OnClickListener opt2Listener) {
        final android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(context);
        final android.support.v7.app.AlertDialog dialog = alert
                .setPositiveButton(opt1, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (opt1Listener != null)
                            opt1Listener.onClick(view);
                    }

                }).setNegativeButton(opt2, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (opt2Listener != null)
                            opt2Listener.onClick(view);
                    }

                }).setCancelable(false).setTitle(title).setMessage(message).create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        dialog.show();
    }
}
