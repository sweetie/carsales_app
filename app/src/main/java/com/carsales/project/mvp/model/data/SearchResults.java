
package com.carsales.project.mvp.model.data;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResults {

    @SerializedName("results")
    @Expose
    private List<Result_> results = null;

    public List<Result_> getResults() {
        return results;
    }

    public void setResults(List<Result_> results) {
        this.results = results;
    }

}
