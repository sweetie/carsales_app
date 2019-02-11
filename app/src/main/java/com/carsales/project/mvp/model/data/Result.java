
package com.carsales.project.mvp.model.data;


import java.util.List;

import com.carsales.project.DisplayPrice;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("networkId")
    @Expose
    private String networkId;
    @SerializedName("displayTitle")
    @Expose
    private String displayTitle;
    @SerializedName("siloTypeFriendlyName")
    @Expose
    private String siloTypeFriendlyName;
    @SerializedName("siloTypeColour")
    @Expose
    private String siloTypeColour;
    @SerializedName("displayLocation")
    @Expose
    private String displayLocation;
    @SerializedName("displayPrice")
    @Expose
    private DisplayPrice displayPrice;
    @SerializedName("keyDetails")
    @Expose
    private List<String> keyDetails = null;
    @SerializedName("photos")
    @Expose
    private List<String> photos = null;
    @SerializedName("mainPhoto")
    @Expose
    private String mainPhoto;
    @SerializedName("webDetailsUrl")
    @Expose
    private String webDetailsUrl;

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getSiloTypeFriendlyName() {
        return siloTypeFriendlyName;
    }

    public void setSiloTypeFriendlyName(String siloTypeFriendlyName) {
        this.siloTypeFriendlyName = siloTypeFriendlyName;
    }

    public String getSiloTypeColour() {
        return siloTypeColour;
    }

    public void setSiloTypeColour(String siloTypeColour) {
        this.siloTypeColour = siloTypeColour;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public DisplayPrice getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(DisplayPrice displayPrice) {
        this.displayPrice = displayPrice;
    }

    public List<String> getKeyDetails() {
        return keyDetails;
    }

    public void setKeyDetails(List<String> keyDetails) {
        this.keyDetails = keyDetails;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getWebDetailsUrl() {
        return webDetailsUrl;
    }

    public void setWebDetailsUrl(String webDetailsUrl) {
        this.webDetailsUrl = webDetailsUrl;
    }

}
