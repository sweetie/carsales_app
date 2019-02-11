
package com.carsales.project.mvp.model.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capability {

    @SerializedName("canSaveSearch")
    @Expose
    private Boolean canSaveSearch;
    @SerializedName("canShareSearch")
    @Expose
    private Boolean canShareSearch;
    @SerializedName("haveDistanceFromPostcode")
    @Expose
    private Boolean haveDistanceFromPostcode;

    public Boolean getCanSaveSearch() {
        return canSaveSearch;
    }

    public void setCanSaveSearch(Boolean canSaveSearch) {
        this.canSaveSearch = canSaveSearch;
    }

    public Boolean getCanShareSearch() {
        return canShareSearch;
    }

    public void setCanShareSearch(Boolean canShareSearch) {
        this.canShareSearch = canShareSearch;
    }

    public Boolean getHaveDistanceFromPostcode() {
        return haveDistanceFromPostcode;
    }

    public void setHaveDistanceFromPostcode(Boolean haveDistanceFromPostcode) {
        this.haveDistanceFromPostcode = haveDistanceFromPostcode;
    }

}
