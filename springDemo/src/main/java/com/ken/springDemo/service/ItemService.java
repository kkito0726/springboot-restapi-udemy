package com.ken.springDemo.service;

import java.util.List;

import com.ken.springDemo.model.Item;

public interface ItemService {
	List<Item> getAllItems();

	Item getItem(Long itemId);

	Item addItem(Item item);

	Item updateItem(Long itemId, Item item);

	Item deleteItem(Long itemId);
}
