
package com.carsales.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisplayPrice {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("preInfo")
    @Expose
    private String preInfo;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPreInfo() {
        return preInfo;
    }

    public void setPreInfo(String preInfo) {
        this.preInfo = preInfo;
    }

}
