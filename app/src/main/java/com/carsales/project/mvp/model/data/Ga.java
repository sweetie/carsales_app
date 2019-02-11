
package com.carsales.project.mvp.model.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ga {

    @SerializedName("memberTrackingId")
    @Expose
    private String memberTrackingId;
    @SerializedName("eventKey")
    @Expose
    private String eventKey;
    @SerializedName("eventType")
    @Expose
    private String eventType;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("searchResults")
    @Expose
    private SearchResults searchResults;

    public String getMemberTrackingId() {
        return memberTrackingId;
    }

    public void setMemberTrackingId(String memberTrackingId) {
        this.memberTrackingId = memberTrackingId;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

}
