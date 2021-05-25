package com.ehsaniara.multidatasource.model;

import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String photoUrl;
    private String housingPhotoUrl;
    @Column(unique = true)
    private String photoPath;
    @Column(nullable = false)
    private Integer photoIndex;
    @JoinColumn(name = "housing_id", nullable = false)
    @ManyToOne
    private Housing housing;

    public Photo() {
    }
    public Photo(Integer photoIndex, String housingPhotoUrl) {
        this.photoIndex = photoIndex;
        this.housingPhotoUrl = housingPhotoUrl;
    }

    public Photo(Integer photoIndex, String housingPhotoUrl, Housing housing) {
        this.photoIndex = photoIndex;
        this.housingPhotoUrl = housingPhotoUrl;
        this.housing = housing;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public String getHousingPhotoUrl() {
        return housingPhotoUrl;
    }

    public void setHousingPhotoUrl(String housingPhotoUrl) {
        this.housingPhotoUrl = housingPhotoUrl;
    }

    public Integer getPhotoIndex() {
        return photoIndex;
    }

    public void setPhotoIndex(Integer photoIndex) {
        this.photoIndex = photoIndex;
    }
}