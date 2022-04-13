package io.novatec.itemservice.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ItemController {
    private final ItemService itemService;
    private final Counter apiCallCounter;
    private final Timer getItemsTimer;

    public ItemController(MeterRegistry meterRegistry, ItemService itemService) {
        this.itemService = itemService;

        apiCallCounter = Counter.builder("api.calls")
            .description("The amount of calls against our api")
            .register(meterRegistry);

        getItemsTimer = Timer.builder("timings.items")
            .description("Time-based metrics for getItems()")
            .register(meterRegistry);
    }

    @GetMapping(value = "/items")
    public Iterable<Item> getItems() {
        apiCallCounter.increment();
        log.info("Received GET request to /items");

        var startTime = System.currentTimeMillis();
        var items = itemService.getItems();
        var endTime = System.currentTimeMillis();

        var executionTime = endTime - startTime;

        getItemsTimer.record(Duration.ofMillis(executionTime));
        return items;
    }

    @PostMapping(value = "/items")
    public Item addItem(@RequestBody Item item) {
        apiCallCounter.increment();
        log.info("Received POST request to /items");
        return itemService.addItem(item);
    }
}
