package com.ehsaniara.multidatasource.model;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User extends Auditable<String> {

    @Column(unique = true, nullable = false)
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_options_id")
    private UserOptions userOptions;

    public User() {
    }


    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserOptions getUserOptions() {
        return userOptions;
    }

    public void setUserOptions(UserOptions userOptions) {
        this.userOptions = userOptions;
    }
}
