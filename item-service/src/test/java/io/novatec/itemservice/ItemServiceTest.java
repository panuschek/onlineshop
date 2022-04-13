package io.novatec.itemservice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.BDDMockito.given;

import io.novatec.itemservice.entity.Item;
import io.novatec.itemservice.repository.ItemRepository;
import io.novatec.itemservice.service.ItemService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ItemServiceTest {
	@Autowired
	ItemService itemService;

	@MockBean
	ItemRepository itemRepository;

	@Test
	void getItems_returnsCorrectItem() {
		given(itemRepository.findAll()).willReturn(List.of(new Item(1, "Test", "Test", 13.5f)));
		var items = itemService.getItems();

		assertThat(items, containsInAnyOrder(new Item(1, "Test", "Test", 13.5f)));
	}
}
