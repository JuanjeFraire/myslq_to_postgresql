package com.ehsaniara.multidatasource.model;

import javax.persistence.*;

@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value;
    @JoinColumn(name = "housing_id", nullable = false)
    @ManyToOne
    private Housing housing;

    public Feature(){

    }
    public Feature(String value, Housing housing){
        this.value = value;
        this.housing = housing;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Housing getHousing() {
        return housing;
    }
    public void setHousing(Housing housing) {
        this.housing = housing;
    }
}