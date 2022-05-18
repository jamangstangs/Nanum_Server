package com.nanum.nanumserver.Item.dto.request;

import lombok.Getter;

@Getter
public class WishRequest {
    private Long itemId;
    private Long wisherId;

    public WishRequest() {
    }

    public WishRequest(Long itemId, Long wisherId) {
        this.itemId = itemId;
        this.wisherId = wisherId;
    }
}
