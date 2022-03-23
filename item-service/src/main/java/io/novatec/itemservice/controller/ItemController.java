package io.novatec.itemservice.controller;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }
}
