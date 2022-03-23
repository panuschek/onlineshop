package io.novatec.itemservice.controller;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private final GreetingService greetingService;

    public HelloWorldController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        Item item = new Item("TestItem", "Description", 17.50f);
        return greetingService.getGreeting();
    }
}
