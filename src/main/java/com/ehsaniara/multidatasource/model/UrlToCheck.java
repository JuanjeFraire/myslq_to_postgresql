package com.ehsaniara.multidatasource.model;

import com.ehsaniara.multidatasource.utils.enums.Site;

import javax.persistence.*;

@Entity
public class UrlToCheck extends Auditable<String> {

    @Lob
    @Column(length = 3000, nullable = false)
    private String url;
    private Integer totalHousings;
    private String alias;
    @Enumerated(EnumType.STRING)
    private Site site;

    public UrlToCheck() {
    }

    public UrlToCheck(String url, Site site) {
        this.url = url;
        this.site = site;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTotalHousings() {
        return totalHousings;
    }

    public void setTotalHousings(Integer totalHousings) {
        this.totalHousings = totalHousings;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getPagesForTotalHousings(Integer housingsPerPage) {
        return Math.toIntExact((long) Math.ceil(Double.valueOf(this.totalHousings) / housingsPerPage));
    }

    public Integer getPagesForTotalHousingsWhenFirstPageIsDifferent(Integer housingsOnFirstPage, Integer housingsOnNonFirstPage) {
        Integer totalPages = 0;
        if (this.totalHousings <= housingsOnFirstPage) {
            totalPages = 1;
        } else {
            totalPages = Math.toIntExact((long) Math.ceil(Double.valueOf(this.totalHousings - housingsOnFirstPage) / housingsOnNonFirstPage)) + 1;
        }
        return totalPages;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
