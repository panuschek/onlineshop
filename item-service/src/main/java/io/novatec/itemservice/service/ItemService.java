package io.novatec.itemservice.service;

import io.novatec.itemservice.entity.Item;

public interface ItemService {
    Iterable<Item> getItems();
    Item addItem(Item item);
}
