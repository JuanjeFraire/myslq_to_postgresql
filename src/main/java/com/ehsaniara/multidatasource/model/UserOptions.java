package com.ehsaniara.multidatasource.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserOptions extends AuditablePoor<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;
    private Integer budget;
    @ElementCollection
    private List<Integer> excludedHousingIdList;
    @ElementCollection
    private List<Integer> favoriteList;

    private Integer maxCost;
    private Integer m2ConstructedMin;
    private Integer m2ConstructedMax;
    private Boolean m2ConstructedUnknown;
    private Integer floorMaxWithoutLift;
    private Integer floorMin;
    private Boolean floorUnknown;
    private Boolean liftUnknown;
    private Integer roomsMin;
    private Boolean roomsUnknown;
    private Float mapCenterLatitude;
    private Float mapCenterLongitude;
    private Float mapLeftUpperCornerLatitude;
    private Float mapLeftUpperCornerLongitude;
    private Float mapRightLowerCornerLatitude;
    private Float mapRightLowerCornerLongitude;
    private Integer mapCenterZoom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Integer> getExcludedHousingIdList() {
        return excludedHousingIdList;
    }

    public void setExcludedHousingIdList(List<Integer> excludedHousingIdList) {
        this.excludedHousingIdList = excludedHousingIdList;
    }

    public List<Integer> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Integer> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public Integer getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Integer maxCost) {
        this.maxCost = maxCost;
    }

    public Integer getM2ConstructedMin() {
        return m2ConstructedMin;
    }

    public void setM2ConstructedMin(Integer m2ConstructedMin) {
        this.m2ConstructedMin = m2ConstructedMin;
    }

    public Integer getM2ConstructedMax() {
        return m2ConstructedMax;
    }

    public void setM2ConstructedMax(Integer m2ConstructedMax) {
        this.m2ConstructedMax = m2ConstructedMax;
    }

    public Boolean getM2ConstructedUnknown() {
        return m2ConstructedUnknown;
    }

    public void setM2ConstructedUnknown(Boolean m2ConstructedUnknown) {
        this.m2ConstructedUnknown = m2ConstructedUnknown;
    }

    public Boolean getLiftUnknown() {
        return liftUnknown;
    }

    public void setLiftUnknown(Boolean liftUnknown) {
        this.liftUnknown = liftUnknown;
    }

    public Integer getFloorMaxWithoutLift() {
        return floorMaxWithoutLift;
    }

    public void setFloorMaxWithoutLift(Integer floorMaxWithoutLift) {
        this.floorMaxWithoutLift = floorMaxWithoutLift;
    }

    public Integer getFloorMin() {
        return floorMin;
    }

    public void setFloorMin(Integer floorMin) {
        this.floorMin = floorMin;
    }

    public Boolean getFloorUnknown() {
        return floorUnknown;
    }

    public void setFloorUnknown(Boolean floorUnknown) {
        this.floorUnknown = floorUnknown;
    }

    public Integer getRoomsMin() {
        return roomsMin;
    }

    public void setRoomsMin(Integer roomsMin) {
        this.roomsMin = roomsMin;
    }

    public Boolean getRoomsUnknown() {
        return roomsUnknown;
    }

    public void setRoomsUnknown(Boolean roomsUnknown) {
        this.roomsUnknown = roomsUnknown;
    }

    public Float getMapCenterLatitude() {
        return mapCenterLatitude;
    }

    public void setMapCenterLatitude(Float mapCenterLatitude) {
        this.mapCenterLatitude = mapCenterLatitude;
    }

    public Float getMapCenterLongitude() {
        return mapCenterLongitude;
    }

    public void setMapCenterLongitude(Float mapCenterLongitude) {
        this.mapCenterLongitude = mapCenterLongitude;
    }

    public Integer getMapCenterZoom() {
        return mapCenterZoom;
    }

    public void setMapCenterZoom(Integer mapCenterZoom) {
        this.mapCenterZoom = mapCenterZoom;
    }

    public Float getMapLeftUpperCornerLatitude() {
        return mapLeftUpperCornerLatitude;
    }

    public void setMapLeftUpperCornerLatitude(Float mapLeftUpperCornerLatitude) {
        this.mapLeftUpperCornerLatitude = mapLeftUpperCornerLatitude;
    }

    public Float getMapLeftUpperCornerLongitude() {
        return mapLeftUpperCornerLongitude;
    }

    public void setMapLeftUpperCornerLongitude(Float mapLeftUpperCornerLongitude) {
        this.mapLeftUpperCornerLongitude = mapLeftUpperCornerLongitude;
    }

    public Float getMapRightLowerCornerLatitude() {
        return mapRightLowerCornerLatitude;
    }

    public void setMapRightLowerCornerLatitude(Float mapRightLowerCornerLatitude) {
        this.mapRightLowerCornerLatitude = mapRightLowerCornerLatitude;
    }

    public Float getMapRightLowerCornerLongitude() {
        return mapRightLowerCornerLongitude;
    }

    public void setMapRightLowerCornerLongitude(Float mapRightLowerCornerLongitude) {
        this.mapRightLowerCornerLongitude = mapRightLowerCornerLongitude;
    }
}
