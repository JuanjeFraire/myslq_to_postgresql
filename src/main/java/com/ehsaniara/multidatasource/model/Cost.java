package com.ehsaniara.multidatasource.model;

import javax.persistence.*;

@Entity
public class Cost extends AuditablePoor<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer value;
    @JoinColumn(name = "housing_id", nullable = false)
    @ManyToOne
    private Housing housing;

    public Cost(Integer value, Housing housing) {
        this.value = value;
        this.housing = housing;
    }

    public Cost() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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
