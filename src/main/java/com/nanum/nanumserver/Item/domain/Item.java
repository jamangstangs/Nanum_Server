package com.nanum.nanumserver.Item.domain;

import com.nanum.nanumserver.common.persistence.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Item extends BaseEntity {

    private String name;
    private String url;
    private Long providerId;
    private String description;
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Wish> wishes = new ArrayList<>();

    public Item() {
    }

    public Item(String name, String url, Long providerId, String description) {
        this.name = name;
        this.url = url;
        this.providerId = providerId;
        this.description = description;
    }

    public void wish(Long userId) {
        this.wishes.add(new Wish(userId, this));
    }

    public int getWishCount() {
        return wishes.size();
    }
}
