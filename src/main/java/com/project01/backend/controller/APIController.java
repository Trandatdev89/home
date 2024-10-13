package com.project01.backend.controller;


import com.project01.backend.controller.dto.Item;
import com.project01.backend.entity.ItemEntity;
import com.project01.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class APIController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    @CrossOrigin
    public Item addItem(@RequestBody Item item) {
        ItemEntity itemEntity = ItemEntity.builder()
                .title(item.getTitle())
                .build();
        itemRepository.save(itemEntity);
        return item;
    }

    @GetMapping
    @CrossOrigin
    public List<Item> getAllItem() {
       List<ItemEntity> itemEntities = itemRepository.findAll();
       List<Item> items = new ArrayList<>();
       for (ItemEntity itemEntity : itemEntities) {
           Item item=Item.builder().id(itemEntity.getId()).title(itemEntity.getTitle()).build();
           items.add(item);
       }
       return items;
    }
}
