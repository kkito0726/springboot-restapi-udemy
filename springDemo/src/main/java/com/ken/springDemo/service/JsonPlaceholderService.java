package com.ken.springDemo.service;

import java.util.List;

import com.ken.springDemo.model.Todo;

public interface JsonPlaceholderService {
	Todo[] getTodos();

	Todo getTodo(Long userId);

	List<Todo> getTodosByUserId(Long userId);
}
