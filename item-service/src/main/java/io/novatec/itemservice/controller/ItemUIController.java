package io.novatec.itemservice.controller;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ItemUIController {
  private final ItemService itemService;

  public ItemUIController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/web/items")
  public String items(Model model) {
    var items = itemService.getItems();
    model.addAttribute("item", new Item());
    model.addAttribute("items",items);
    return "index";
  }

  @PostMapping("/web/items")
  public String saveItem(@ModelAttribute Item item) {
    log.info("Received POST from Thymeleaf with item {}", item);
    itemService.addItem(item);
    return "redirect:/web/items";
  }
}
