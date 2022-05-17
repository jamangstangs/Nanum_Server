package com.nanum.nanumserver.Item;

import com.nanum.nanumserver.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private Long providerId;
    @ElementCollection
    private List<Long> wishers = new ArrayList<>();

    public Item(String name, String url, String description, Long providerId) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.providerId = providerId;
    }
}
