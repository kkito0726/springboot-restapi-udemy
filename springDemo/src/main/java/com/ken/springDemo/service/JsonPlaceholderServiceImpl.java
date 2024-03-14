package com.ken.springDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ken.springDemo.model.Todo;

@Service
public class JsonPlaceholderServiceImpl implements JsonPlaceholderService {
	private RestTemplate restTemplate;

	public JsonPlaceholderServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	@Cacheable("getTodos")
	public Todo[] getTodos() {
		String url = "https://jsonplaceholder.typicode.com/todos";
		Todo[] res = restTemplate.getForObject(url, Todo[].class);
		return res;
	}

	@Override
	@Cacheable(value = "getTodo", key = "#p0")
	public Todo getTodo(Long userId) {
		String url = "https://jsonplaceholder.typicode.com/todos/" + userId;
		Todo res = restTemplate.getForObject(url, Todo.class);

		return res;
	}

	@Override
	public List<Todo> getTodosByUserId(Long userId) {
		Todo[] resTodos = getTodos();

		List<Todo> todos = new ArrayList<Todo>();
		for (Todo todo : resTodos) {
			if (todo.getUserId() == userId) {
				todos.add(todo);
			}
		}
		return todos;
	}
}
