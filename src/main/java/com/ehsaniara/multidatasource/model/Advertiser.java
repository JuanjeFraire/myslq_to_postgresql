package com.ehsaniara.multidatasource.model;

import com.ehsaniara.multidatasource.utils.enums.AdvertiserType;

import javax.persistence.*;

@Entity
public class Advertiser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer phoneNumber;
    private Integer phoneNumber2;
    private String name;
    private String url;
    @Enumerated(EnumType.STRING)
    private AdvertiserType advertiserType = AdvertiserType.UNKNOWN;

    public Advertiser() {
    }

    public Advertiser(Integer phoneNumber, String name, String url) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.url = url;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdvertiserType getAdvertiserType() {
        return advertiserType;
    }

    public void setAdvertiserType(AdvertiserType advertiserType) {
        this.advertiserType = advertiserType;
    }

    public Integer getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Integer phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    @Override
    public String toString() {
        return (advertiserType == null ? "" : advertiserType.name());
    }
}
