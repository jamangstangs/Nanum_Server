package com.nanum.nanumserver.Item;

import lombok.Getter;

@Getter
public class ItemRequest {
    private String name;
    private String url;

    public ItemRequest(String name,String url){
        this.name = name;
        this.url = url;
    }
}
