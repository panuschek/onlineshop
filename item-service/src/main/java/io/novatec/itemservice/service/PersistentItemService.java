package io.novatec.itemservice.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.repository.ItemRepository;
import java.time.Duration;
import org.springframework.stereotype.Service;

@Service
public class PersistentItemService implements ItemService {
    private final ItemRepository itemRepository;
    private final Counter apiCallsCounter;
    private final Timer getItemsTimer;

    public PersistentItemService(MeterRegistry meterRegistry, ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        apiCallsCounter = Counter.builder("api.calls")
            .description("The amount of calls against the REST api")
            .register(meterRegistry);

        getItemsTimer = Timer.builder("responseTime.getItems")
            .description("Time-based metrics for the /times endpoint")
            .register(meterRegistry);
    }

    @Override
    public Iterable<Item> getItems() {
        apiCallsCounter.increment();
        getItemsTimer.record(Duration.ofMillis(100));
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
}
