package com.nanum.nanumserver.Item.dto.request;

import lombok.Getter;

@Getter
public class LikeRequest {
    private Long itemId;
    private Long wisherId;

    public LikeRequest() {
    }

    public LikeRequest(Long itemId, Long wisherId) {
        this.itemId = itemId;
        this.wisherId = wisherId;
    }
}
