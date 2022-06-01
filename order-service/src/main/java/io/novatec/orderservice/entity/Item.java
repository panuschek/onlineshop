package io.novatec.orderservice.entity;

import lombok.Data;

@Data
public class Item {
  private Integer itemId;
  private String name;
  private String description;
  private float price;
  private Integer amount;
}
