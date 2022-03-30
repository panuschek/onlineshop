package io.novatec.itemservice.service;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class PersistentItemService implements ItemService {
    private final ItemRepository itemRepository;

    public PersistentItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
}
