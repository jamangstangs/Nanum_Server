package com.nanum.nanumserver.Item;

import com.nanum.nanumserver.Item.domain.repository.ItemRepository;
import com.nanum.nanumserver.Item.dto.request.ItemRequest;
import com.nanum.nanumserver.Item.dto.request.LikeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Long putItem(ItemRequest itemRequest){
        Item item = itemRepository.save(new Item(itemRequest.getName(), itemRequest.getUrl(), itemRequest.getDescription(), itemRequest.getProviderId()));
        return item.getId();
    }

    public Long likeItem(LikeRequest likeRequest) {
        Long itemId = likeRequest.getItemId();
        Optional<Item> item = itemRepository.findById(itemId);
//        item.wishers
        return 0L;
    }

}
