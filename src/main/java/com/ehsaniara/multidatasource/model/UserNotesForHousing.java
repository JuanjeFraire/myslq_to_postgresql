package com.ehsaniara.multidatasource.model;

import javax.persistence.*;

@Entity
public class UserNotesForHousing extends AuditablePoor<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean visited = false;
    @JoinColumn(name = "housing_id", nullable = false)
    @ManyToOne
    private Housing housing;
    @Lob
    @Column( length = 3000 )
    private String note;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
