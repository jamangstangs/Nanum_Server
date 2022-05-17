package com.nanum.nanumserver.Item.dto.request;

import lombok.Getter;

@Getter
public class ItemRequest {
    private String name;
    private String url;
    private String description;
    private Long providerId;

    public ItemRequest() {
    }

    public ItemRequest(String name, String url, String description, Long providerId) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.providerId = providerId;
    }


}
