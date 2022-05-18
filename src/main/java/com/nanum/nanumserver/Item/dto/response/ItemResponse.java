package com.nanum.nanumserver.Item.dto.response;


import com.nanum.nanumserver.Item.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private Long id;
    private String name;
    private String url;
    private String description;
    private Long providerId;
    private int wishCount;

    public static ItemResponse of(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getUrl(),
                item.getDescription(),
                item.getProviderId(),
                item.getWishCount()
        );
    }
}
