package com.nanum.nanumserver.Item.domain;

import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Wishers {
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Wisher> wishers = new ArrayList<>();

    public void add(Wisher wisher) {
        this.wishers.add(wisher);
    }

    public int size() {
        return wishers.size();
    }

}
