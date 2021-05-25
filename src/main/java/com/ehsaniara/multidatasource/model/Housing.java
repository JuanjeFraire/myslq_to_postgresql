package com.ehsaniara.multidatasource.model;

import com.ehsaniara.multidatasource.utils.enums.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"site", "code"})
})
public class Housing extends Auditable<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Housing.class);

    private String title;
    private Boolean enabled = true;
    @Column(unique = true)
    private String url;
    private Integer m2Constructed;
    private Integer m2Usable;
    private Integer floor;
    private Integer rooms;
    private Integer bathrooms;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced garage;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced lift;
    private String address;
    @Enumerated(EnumType.STRING)
    private Site site;
    @Column(name = "code", length = 30)
    private String code;
    private Integer currentCost;
    @Lob
    @Column(length = 3000)
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private Advertiser advertiser;
    @OneToMany(mappedBy = "housing", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Photo> photosList = new ArrayList<>();
    @OneToMany(mappedBy = "housing", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cost> costList = new ArrayList<>();
    @OneToMany(mappedBy = "housing", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feature> featureList = new ArrayList<>();
    private String lastUpdateWebRaw;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateWeb;
    private String locationRaw;
    private Integer photosAmount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTimeFoundInList;
    private Float latitude;
    private Float longitude;
    @Enumerated(EnumType.STRING)
    private LocationType locationType;
    private Boolean locationConfirmed = false;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced terrace;
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private YesNoEnhanced rooftop;
    @Enumerated(EnumType.STRING)
    private HousingFurnished furnished = HousingFurnished.UNKNOWN;
    @Enumerated(EnumType.STRING)
    private HousingOrientation orientation = HousingOrientation.UNKNOWN;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced courtyard;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced toReform;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced storageRoom;
    private Integer antiquity;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced intermediaryPayment;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced premises;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced reliableLocation;
    @OneToOne(mappedBy = "housing", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private UserNotesForHousing userNotesForHousing;
    private boolean completelyReviewed = false;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced bankable100;

    @Enumerated(EnumType.STRING)
    private YesNoEnhanced visitable;

    public Housing() {
    }

    public Housing(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Housing(String title, String url, Site site, String code, String description, Integer costValue) {
        this.title = title;
        this.url = url;
        this.site = site;
        this.code = code;
        this.description = description;
        this.costList.add(new Cost(costValue, this));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getM2Constructed() {
        return m2Constructed;
    }

    public void setM2Constructed(Integer m2Constructed) {
        this.m2Constructed = m2Constructed;
    }

    public Integer getM2Usable() {
        return m2Usable;
    }

    public void setM2Usable(Integer m2Usable) {
        this.m2Usable = m2Usable;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

    public String getLastUpdateWebRaw() {
        return lastUpdateWebRaw;
    }

    public void setLastUpdateWebRaw(String lastUpdateWebRaw) {
        this.lastUpdateWebRaw = lastUpdateWebRaw;
    }

    public Date getLastUpdateWeb() {
        return lastUpdateWeb;
    }

    public void setLastUpdateWeb(Date lastUpdateWeb) {
        this.lastUpdateWeb = lastUpdateWeb;
    }

    public String getLocationRaw() {
        return locationRaw;
    }

    public void setLocationRaw(String locationRaw) {
        this.locationRaw = locationRaw;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getPhotosAmount() {
        return photosAmount;
    }

    public void setPhotosAmount(Integer photosAmount) {
        this.photosAmount = photosAmount;
    }

    public void addCost(Integer costValue) {
        List<Cost> costList = new ArrayList<>();
        costList.addAll(this.costList);
        costList.add(new Cost(costValue, this));
        this.costList = costList;
    }

    public Date getLastTimeFoundInList() {
        return lastTimeFoundInList;
    }

    public void setLastTimeFoundInList(Date lastTimeFoundInList) {
        this.lastTimeFoundInList = lastTimeFoundInList;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocationConfirmed() {
        return locationConfirmed;
    }

    public void setLocationConfirmed(Boolean locationConfirmed) {
        this.locationConfirmed = locationConfirmed;
    }

    public HousingFurnished getFurnished() {
        return furnished;
    }

    public void setFurnished(HousingFurnished furnished) {
        this.furnished = furnished;
    }

    public HousingOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(HousingOrientation orientation) {
        this.orientation = orientation;
    }

    public boolean isCompletelyReviewed() {
        return completelyReviewed;
    }

    public void setCompletelyReviewed(boolean completelyReviewed) {
        this.completelyReviewed = completelyReviewed;
    }

    public Integer getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(Integer antiquity) {
        this.antiquity = antiquity;
    }

    public UserNotesForHousing getUserNotesForHousing() {
        return userNotesForHousing;
    }

    public void setUserNotesForHousing(UserNotesForHousing userNotesForHousing) {
        this.userNotesForHousing = userNotesForHousing;
    }

    public Boolean getCompletelyReviewed() {
        return completelyReviewed;
    }

    public void setCompletelyReviewed(Boolean completelyReviewed) {
        this.completelyReviewed = completelyReviewed;
    }

    public Integer getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(Integer currentCost) {
        this.currentCost = currentCost;
    }

    public YesNoEnhanced getVisitable() {
        return visitable;
    }

    public void setVisitable(YesNoEnhanced visitable) {
        this.visitable = visitable;
    }

    public List<Photo> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<Photo> photosList) {
        this.photosList = photosList;
    }

    public YesNoEnhanced getGarage() {
        return garage;
    }

    public void setGarage(YesNoEnhanced garage) {
        this.garage = garage;
    }

    public YesNoEnhanced getLift() {
        return lift;
    }

    public void setLift(YesNoEnhanced lift) {
        this.lift = lift;
    }

    public YesNoEnhanced getTerrace() {
        return terrace;
    }

    public void setTerrace(YesNoEnhanced terrace) {
        this.terrace = terrace;
    }

    public YesNoEnhanced getRooftop() {
        return rooftop;
    }

    public void setRooftop(YesNoEnhanced rooftop) {
        this.rooftop = rooftop;
    }

    public YesNoEnhanced getCourtyard() {
        return courtyard;
    }

    public void setCourtyard(YesNoEnhanced courtyard) {
        this.courtyard = courtyard;
    }

    public YesNoEnhanced getToReform() {
        return toReform;
    }

    public void setToReform(YesNoEnhanced toReform) {
        this.toReform = toReform;
    }

    public YesNoEnhanced getStorageRoom() {
        return storageRoom;
    }

    public void setStorageRoom(YesNoEnhanced storageRoom) {
        this.storageRoom = storageRoom;
    }

    public YesNoEnhanced getIntermediaryPayment() {
        return intermediaryPayment;
    }

    public void setIntermediaryPayment(YesNoEnhanced intermediaryPayment) {
        this.intermediaryPayment = intermediaryPayment;
    }

    public YesNoEnhanced getPremises() {
        return premises;
    }

    public void setPremises(YesNoEnhanced premises) {
        this.premises = premises;
    }

    public YesNoEnhanced getReliableLocation() {
        return reliableLocation;
    }

    public void setReliableLocation(YesNoEnhanced reliableLocation) {
        this.reliableLocation = reliableLocation;
    }

    public YesNoEnhanced getBankable100() {
        return bankable100;
    }

    public void setBankable100(YesNoEnhanced bankable100) {
        this.bankable100 = bankable100;
    }

    //
//    public long getAlreadyDownloadedPhotos(){
//        return photosList.stream().filter(photo -> photo.getPhotoPath() == null).collect(Collectors.counting());
//    }
//
//    public void addPhoto(Integer photoIndex, String housingPhotoUrl){
//        List<Photo> photoList = new ArrayList<>();
//        photoList.addAll(this.photosList);
//        photoList.add(new Photo(photoIndex, housingPhotoUrl, this));
//        this.photosList = photoList;
//    }
//
//    public void addPhoto(Photo photo){
//        List<Photo> photoList = new ArrayList<>();
//        photoList.addAll(this.photosList);
//        photoList.add(photo);
//        this.photosList = photoList;
//    }


    @Override
    public String toString() {
        String string = "Error printing housing " + this.site + " / " + this.code;
        try {
            string = this.site + " / " + (this.enabled ? "enabled" : "DISABLED") + " / " + this.code + " / " + this.getCurrentCost() + " / " + this.title + " / " + ((this.advertiser == null || this.advertiser.getAdvertiserType() == null) ? "ADVERTISER TYPE NOT FOUND" : this.advertiser.getAdvertiserType().name());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return string;
    }
}
