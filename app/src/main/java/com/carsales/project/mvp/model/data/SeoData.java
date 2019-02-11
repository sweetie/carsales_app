
package com.carsales.project.mvp.model.data;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeoData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("h1")
    @Expose
    private String h1;
    @SerializedName("query")
    @Expose
    private String query;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
