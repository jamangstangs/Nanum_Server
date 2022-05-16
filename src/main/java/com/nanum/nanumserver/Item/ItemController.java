package com.nanum.nanumserver.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok().body(itemService.getItems());
    }

    @PostMapping("/item")
    public ResponseEntity<Void> putItem(@RequestBody ItemRequest itemRequest){
        itemService.putItem(itemRequest);
        return ResponseEntity.noContent().build();
    }
}
