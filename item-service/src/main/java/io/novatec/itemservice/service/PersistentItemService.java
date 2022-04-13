package io.novatec.itemservice.service;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersistentItemService implements ItemService {
    private final ItemRepository itemRepository;

    public PersistentItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        var items = itemRepository.findAll();
        log.info("getItems() returned {}", items);
        return items;
    }

    @Override
    public Item addItem(Item item) {
        log.info("Adding item {}", item);
        return itemRepository.save(item);
    }
}
