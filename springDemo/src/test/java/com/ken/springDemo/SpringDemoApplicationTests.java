package com.ken.springDemo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ken.springDemo.controller.ItemController;
import com.ken.springDemo.repository.ItemRepository;
import com.ken.springDemo.service.ItemService;

@SpringBootTest
class SpringDemoApplicationTests {

	@Autowired
	private ItemController itemController;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void contextLoads() {
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
		assertThat(itemRepository).isNotNull();
	}

}
