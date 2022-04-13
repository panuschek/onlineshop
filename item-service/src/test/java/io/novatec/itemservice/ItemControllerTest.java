package io.novatec.itemservice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.novatec.itemservice.controller.ItemController;
import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.service.ItemService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  ItemService itemService;

  @Test
  void getItems_returnsItems() throws Exception {
    Item expected = new Item(1, "Test", "Test", 13.5f);
    given(itemService.getItems()).willReturn(List.of(expected));

    String responseString = mvc.perform(get("/items")
                                            .contentType(MediaType.APPLICATION_JSON))
                               .andExpect(status().isOk())
                               .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                               .andReturn()
                               .getResponse()
                               .getContentAsString();

    assertTrue(responseString.contains("\"itemId\":1"));
  }
}
