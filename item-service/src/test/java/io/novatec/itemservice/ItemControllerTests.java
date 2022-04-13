package io.novatec.itemservice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.novatec.itemservice.controller.ItemController;
import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ItemController.class)
public class ItemControllerTests {

  @MockBean
  ItemService itemService;

  @Autowired
  MockMvc mvc;

  @Test
  void getItems_returnsHttp200AndReturnsItems() throws Exception {
    // Arrange
    var expected1 = new Item(1, "Test 1", "Test", 9.13f);
    var expected2 = new Item(2, "Test 2", "Test", 9.13f);
    given(itemService.getItems()).willReturn(List.of(expected1, expected2));

    // Act
    String responseString = mvc.perform(get("/items").contentType("application/json"))
                               // Assert
                               .andExpect(status().isOk())
                               .andExpect(content().contentTypeCompatibleWith("application/json"))
                               .andReturn()
                               .getResponse()
                               .getContentAsString();

    assertTrue(responseString.contains("\"itemId\":1"));
    assertTrue(responseString.contains("\"itemId\":2"));
  }
}
