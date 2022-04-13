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
class ItemServiceTests {
	@MockBean
	ItemRepository itemRepository;

	@Autowired
	ItemService itemService;

	@Test
	void getItems_returnsCorrectItem() {
		// Arrange
		var expected1 = new Item(1, "Test 1", "Test", 9.13f);
		var expected2 = new Item(2, "Test 2", "Test", 9.13f);
		given(itemRepository.findAll()).willReturn(List.of(expected1, expected2));

		// Act
		var actual = itemService.getItems();

		// Assert
		assertThat(actual, containsInAnyOrder(expected1, expected2));
	}
}
