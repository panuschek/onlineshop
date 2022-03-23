package io.novatec.itemservice.service;

import io.novatec.itemservice.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();
    Item addItem(Item item);
}
