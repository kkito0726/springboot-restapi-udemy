package com.ken.springDemo.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ken.springDemo.model.Item;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	void test() throws Exception {
		int itemId = 1;
		String responseJsonString = mvc
				.perform(get("/items/{itemId}", itemId)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.characterEncoding("UTF-8"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		ObjectMapper objectMapper = new ObjectMapper();
		Item responItem = objectMapper.readValue(responseJsonString, Item.class);

		assertThat(responItem.getItemId()).isEqualTo(1L);
		assertThat(responItem.getItemName()).isEqualTo("ネックレス");
		assertThat(responItem.getItemCategory()).isEqualTo("ジュエリ");
	}

}
