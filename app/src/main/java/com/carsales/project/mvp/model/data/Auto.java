
package com.carsales.project.mvp.model.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Auto {

    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    @SerializedName("searchContext")
    @Expose
    private SearchContext searchContext;
    @SerializedName("capability")
    @Expose
    private Capability capability;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public SearchContext getSearchContext() {
        return searchContext;
    }

    public void setSearchContext(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }

}
