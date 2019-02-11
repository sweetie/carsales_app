package com.carsales.project.mvp.model;

import android.content.Context;

import com.carsales.project.mvp.MVP;
import com.carsales.project.mvp.common.generic.GenericModel;


/**
  * Created by Enny Querales
 */
public class GlobalModel
        extends GenericModel
        implements MVP.ProvidedModelMethods {


    public GlobalModel() {
        // no-op
    }

    public GlobalModel(Context context) {
        super(context);
    }
}
