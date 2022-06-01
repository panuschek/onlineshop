package io.novatec.orderservice.entity;

import java.util.List;
import lombok.Data;

@Data
public class NewOrder {
  private Integer userId;
  private List<NewItem> items;
}
