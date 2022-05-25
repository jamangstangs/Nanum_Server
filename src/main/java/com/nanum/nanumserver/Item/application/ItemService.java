package com.nanum.nanumserver.Item.application;

import com.nanum.nanumserver.Item.domain.Item;
import com.nanum.nanumserver.Item.domain.Wish;
import com.nanum.nanumserver.Item.domain.repository.ItemRepository;
import com.nanum.nanumserver.Item.dto.request.ItemRequest;
import com.nanum.nanumserver.Item.dto.request.WishRequest;
import com.nanum.nanumserver.exception.item.NoSuchItemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Long putItem(ItemRequest itemRequest) {
        Item item = itemRepository.save(new Item(itemRequest.getName(), itemRequest.getUrl(), itemRequest.getProviderId(), itemRequest.getDescription()));
        return item.getId();
    }

    @Transactional
    public void wish(WishRequest wishRequest, Long userId) {
        Long itemId = wishRequest.getItemId();
        Item item = fineItemByItemId(itemId);

        item.wish(userId);
    }

    @Transactional(readOnly = true)
    public List<Wish> getWishedItem(Long id) {
        Item item = fineItemByItemId(id);
        return item.getWishes();
    }

    private Item fineItemByItemId(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(NoSuchItemException::new);
    }
}
