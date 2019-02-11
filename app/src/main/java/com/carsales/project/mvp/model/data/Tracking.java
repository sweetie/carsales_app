
package com.carsales.project.mvp.model.data;

import com.carsales.project.mvp.model.data.Fb;
import com.carsales.project.mvp.model.data.Ga;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracking {

    @SerializedName("ga")
    @Expose
    private Ga ga;
    @SerializedName("fb")
    @Expose
    private Fb fb;

    public Ga getGa() {
        return ga;
    }

    public void setGa(Ga ga) {
        this.ga = ga;
    }

    public Fb getFb() {
        return fb;
    }

    public void setFb(Fb fb) {
        this.fb = fb;
    }

}
