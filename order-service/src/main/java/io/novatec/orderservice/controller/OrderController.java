package io.novatec.orderservice.controller;

import io.novatec.orderservice.entity.NewOrder;
import io.novatec.orderservice.entity.OutOrder;
import io.novatec.orderservice.service.ItemService;
import io.novatec.orderservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
  private final UserService userService;
  private final ItemService itemService;

  public OrderController(UserService userService, ItemService itemService) {
    this.userService = userService;
    this.itemService = itemService;
  }

  @PostMapping("/order")
  public OutOrder order(@RequestBody NewOrder newOrder) {
    log.info("Received POST request to /order with requestBody {}", newOrder);
    var outOrder = new OutOrder();
    var user = userService.getUserById(newOrder.getUserId());
    outOrder.setUser(user);

    for(var itemId : newOrder.getItems()) {
      var item = itemService.getItemById(itemId.getItemId());
      item.setAmount(itemId.getAmount());
      outOrder.getItems().add(item);
    }

    return outOrder;
  }
}
