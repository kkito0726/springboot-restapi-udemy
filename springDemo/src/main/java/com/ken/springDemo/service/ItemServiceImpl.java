package com.ken.springDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.ken.springDemo.exception.ItemNotFoundException;
import com.ken.springDemo.model.Item;
import com.ken.springDemo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Override
	@Cacheable("getItems")
	public List<Item> getAllItems() {
		List<Item> allItems = new ArrayList<Item>();

		itemRepository.findAll().forEach(allItems::add);
		return allItems;
	}

	@Override
	@Cacheable(value = "getItem", key = "#p0")
	public Item getItem(Long itemId) {
		return itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
	}

	@Override
	@CacheEvict(value = "getItems", allEntries = true)
	public Item addItem(Item item) {
		itemRepository.save(item);
		return item;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "getItem", key = "#p0"),
			@CacheEvict(value = "getItems", allEntries = true)
	})
	public Item updateItem(Long itemId, Item item) {
		Item foundItem = itemRepository.findById(itemId).get();
		if (foundItem != null) {
			itemRepository.save(item);
		}
		return item;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "getItem", key = "#p0"),
			@CacheEvict(value = "getItems", allEntries = true)
	})
	public Item deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
		return getItem(itemId);
	}

}
