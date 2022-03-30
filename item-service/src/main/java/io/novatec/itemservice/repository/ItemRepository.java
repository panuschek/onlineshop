package io.novatec.itemservice.repository;

import io.novatec.itemservice.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
        extends CrudRepository<Item, Integer> {
}
