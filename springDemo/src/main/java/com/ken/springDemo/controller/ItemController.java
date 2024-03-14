package com.ken.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ken.springDemo.model.Item;
import com.ken.springDemo.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;

	@GetMapping(value = "/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping(value = "/items/{itemId}")
	public Item getItem(@PathVariable("itemId") Long itemId) {
		return itemService.getItem(itemId);
	}

	@PostMapping("/items")
	public void postMethodName(@RequestBody Item item) {
		itemService.addItem(item);
	}

	@PutMapping("items/{itemId}")
	public void updateItem(@PathVariable Long itemId, @RequestBody Item item) {
		itemService.updateItem(itemId, item);
	}

	@DeleteMapping("items/{itemId}")
	public void deleteItem(@PathVariable Long itemId) {
		itemService.deleteItem(itemId);
	}

}
