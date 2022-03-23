package io.novatec.itemservice.service;

import io.novatec.itemservice.entity.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryItemService implements ItemService {
    private final List<Item> items;

    public InMemoryItemService() {
        this.items = new ArrayList<>();

        items.add(new Item("Testitem 1", "Dies ist ein Testitem.", 13.50f));
        items.add(new Item("Testitem 2", "Dies ist ein Testitem.", 13.50f));
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public Item addItem(Item item) {
        items.add(item);
        return item;
    }
}
