package com.ken.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ken.springDemo.model.Todo;
import com.ken.springDemo.service.JsonPlaceholderService;

@RestController
public class JsonPlaceHolderController {
	@Autowired
	private JsonPlaceholderService jsonPlaceholderService;

	@GetMapping("/getTodos")
	public Todo[] getTodos() {
		return jsonPlaceholderService.getTodos();
	}

	@GetMapping("/getTodos/{userId}")
	public Todo getJson(@PathVariable Long userId) {
		return jsonPlaceholderService.getTodo(userId);
	}

	@GetMapping("/getTodosByUserId/{userId}")
	public List<Todo> getTodosByUserId(@PathVariable Long userId) {

		return jsonPlaceholderService.getTodosByUserId(userId);
	}
}
