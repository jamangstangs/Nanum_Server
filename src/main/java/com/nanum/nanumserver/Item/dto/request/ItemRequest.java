package com.nanum.nanumserver.Item.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ItemRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String url;
    @NotBlank
    private String description;
    @NotBlank
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
