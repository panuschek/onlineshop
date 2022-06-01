package io.novatec.orderservice.service;

import io.novatec.orderservice.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ItemService", url = "http://localhost:8070")
public interface ItemService {
  @RequestMapping(method = RequestMethod.GET, value = "/items/{itemId}")
  Item getItemById(@PathVariable Integer itemId);
}
