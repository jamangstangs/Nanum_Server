package com.nanum.nanumserver.Item.domain;

import com.nanum.nanumserver.common.persistence.UnmodifiableEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Wish extends UnmodifiableEntity {

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    public Wish() {
    }

    public Wish(Long userId, Item item) {
        this.userId = userId;
        this.item = item;
    }
}
