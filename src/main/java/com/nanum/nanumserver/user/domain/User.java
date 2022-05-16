package com.nanum.nanumserver.user.domain;

import com.nanum.nanumserver.common.persistence.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String password;

    protected User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
