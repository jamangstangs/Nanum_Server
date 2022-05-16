package com.nanum.nanumserver.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public void putItem(ItemRequest itemRequest){
        Item item = itemRepository.save(new Item(itemRequest.getName(),itemRequest.getUrl()));
        return;
    }
}
