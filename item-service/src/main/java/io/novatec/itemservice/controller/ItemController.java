package io.novatec.itemservice.controller;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/items")
    public Iterable<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping(value = "/items")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
}
