package com.ehsaniara.multidatasource.utils;

public class HousingListPageInfo {

    private Integer pageNumber;
    private Integer totalHousings;
    private Integer housingsProcessedInPage;
    private Integer pendingHousingsToProcess;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalHousings() {
        return totalHousings;
    }

    public void setTotalHousings(Integer totalHousings) {
        this.totalHousings = totalHousings;
    }

    public Integer getHousingsProcessedInPage() {
        return housingsProcessedInPage;
    }

    public void setHousingsProcessedInPage(Integer housingsProcessedInPage) {
        this.housingsProcessedInPage = housingsProcessedInPage;
    }

    public Integer getPendingHousingsToProcess() {
        return pendingHousingsToProcess;
    }

    public void setPendingHousingsToProcess(Integer pendingHousingsToProcess) {
        this.pendingHousingsToProcess = pendingHousingsToProcess;
    }
}
