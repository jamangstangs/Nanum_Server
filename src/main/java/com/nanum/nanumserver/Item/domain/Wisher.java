package com.nanum.nanumserver.Item.domain;

import com.nanum.nanumserver.common.persistence.UnmodifiableEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class Wisher extends UnmodifiableEntity {

    @Column(name = "wisher_id")
    private Long wisherID;

    public Wisher() {
    }

    public Wisher(Long wisherID) {
        this.wisherID = wisherID;
    }
}
