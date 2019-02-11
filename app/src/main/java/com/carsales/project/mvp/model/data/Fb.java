
package com.carsales.project.mvp.model.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fb {

    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
