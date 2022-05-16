package com.nanum.nanumserver.user.domain;

import java.io.Serializable;

public class SimpleUser implements Serializable {
    private final Long id;

    public SimpleUser(User user) {
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

}
