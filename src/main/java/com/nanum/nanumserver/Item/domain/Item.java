package com.nanum.nanumserver.Item.domain;

import com.nanum.nanumserver.common.persistence.BaseEntity;
import com.nanum.nanumserver.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item extends BaseEntity {

    private String name;
    private String url;
    private Long providerId;
    private String description;
    @Embedded
    @OptimisticLock(excluded = true)
    private final Wishers wishers = new Wishers();
    @Version
    private Long version;

    public Item() {
    }

    public Item(String name, String url, Long providerId, String description) {
        this.name = name;
        this.url = url;
        this.providerId = providerId;
        this.description = description;
    }

    public void wish(Long userId) {
        this.wishers.add(new Wisher(providerId));
    }
    
    public int getWishCount() {
        return wishers.size();
    }



}
