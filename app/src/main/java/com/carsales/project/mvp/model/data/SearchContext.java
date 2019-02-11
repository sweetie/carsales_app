
package com.carsales.project.mvp.model.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchContext {

    @SerializedName("pageNum")
    @Expose
    private Integer pageNum;
    @SerializedName("numOfItem")
    @Expose
    private Integer numOfItem;
    @SerializedName("recordOffset")
    @Expose
    private Integer recordOffset;
    @SerializedName("maxItemsPerPage")
    @Expose
    private Integer maxItemsPerPage;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("sortKey")
    @Expose
    private String sortKey;
    @SerializedName("canonicalQuery")
    @Expose
    private String canonicalQuery;
    @SerializedName("suggestedSavedSearchName")
    @Expose
    private String suggestedSavedSearchName;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("adSections")
    @Expose
    private List<Object> adSections = null;
    @SerializedName("predicate")
    @Expose
    private String predicate;
    @SerializedName("seoData")
    @Expose
    private SeoData seoData;
    @SerializedName("tracking")
    @Expose
    private Tracking tracking;
    @SerializedName("disclaimers")
    @Expose
    private List<String> disclaimers = null;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(Integer numOfItem) {
        this.numOfItem = numOfItem;
    }

    public Integer getRecordOffset() {
        return recordOffset;
    }

    public void setRecordOffset(Integer recordOffset) {
        this.recordOffset = recordOffset;
    }

    public Integer getMaxItemsPerPage() {
        return maxItemsPerPage;
    }

    public void setMaxItemsPerPage(Integer maxItemsPerPage) {
        this.maxItemsPerPage = maxItemsPerPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getCanonicalQuery() {
        return canonicalQuery;
    }

    public void setCanonicalQuery(String canonicalQuery) {
        this.canonicalQuery = canonicalQuery;
    }

    public String getSuggestedSavedSearchName() {
        return suggestedSavedSearchName;
    }

    public void setSuggestedSavedSearchName(String suggestedSavedSearchName) {
        this.suggestedSavedSearchName = suggestedSavedSearchName;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Object> getAdSections() {
        return adSections;
    }

    public void setAdSections(List<Object> adSections) {
        this.adSections = adSections;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public SeoData getSeoData() {
        return seoData;
    }

    public void setSeoData(SeoData seoData) {
        this.seoData = seoData;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    public List<String> getDisclaimers() {
        return disclaimers;
    }

    public void setDisclaimers(List<String> disclaimers) {
        this.disclaimers = disclaimers;
    }

}
