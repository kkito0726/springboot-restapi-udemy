package com.ken.springDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.ken.springDemo.model.Item;
import com.ken.springDemo.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	/*
	private List<Item> allItems = new ArrayList<Item>(Arrays.asList(
			new Item("10001", "ネックレス", "ジュエリ"),
			new Item("10002", "パーカー", "ファッション"),
			new Item("10003", "フェイスクリーム", "ビューティー"),
			new Item("10004", "サプリメント", "ヘルス"),
			new Item("10005", "ブルーベリー", "フード")));
			*/

	@Cacheable("getItems")
	public List<Item> getAllItems() {
		List<Item> allItems = new ArrayList<Item>();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		itemRepository.findAll().forEach(allItems::add);
		return allItems;
	}

	@Cacheable(value = "getItem", key = "#p0")
	public Optional<Item> getItem(Long itemId) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return itemRepository.findById(itemId);
	}

	@CacheEvict(value = "getItems", allEntries = true)
	public void addItem(Item item) {
		itemRepository.save(item);
	}

	@Caching(evict = {
			@CacheEvict(value = "getItem", key = "#p0"),
			@CacheEvict(value = "getItems", allEntries = true)
	})
	public void updateItem(Long itemId, Item item) {
		Item foundItem = itemRepository.findById(itemId).get();
		if (foundItem != null) {
			itemRepository.save(item);
		}
	}

	@Caching(evict = {
			@CacheEvict(value = "getItem", key = "#p0"),
			@CacheEvict(value = "getItems", allEntries = true)
	})
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
