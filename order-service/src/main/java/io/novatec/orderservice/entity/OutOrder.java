package io.novatec.orderservice.entity;

import java.util.List;
import lombok.Data;

@Data
public class OutOrder {
  private User user;
  private List<Item> items;
}
