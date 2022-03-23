package io.novatec.itemservice.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello, Reutlingen :)";
    }
}
