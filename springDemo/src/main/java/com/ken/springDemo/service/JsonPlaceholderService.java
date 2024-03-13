package com.ken.springDemo.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ken.springDemo.model.Todo;



@Service
public class JsonPlaceholderService {
	private RestTemplate restTemplate;

	public JsonPlaceholderService(RestTemplateBuilder restTemplateBuilder) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.restTemplate = restTemplateBuilder.build();
	}

	@Cacheable("getTodos")
	public Todo[] getTodos() {
		String url = "https://jsonplaceholder.typicode.com/todos";
		Todo[] res = restTemplate.getForObject(url, Todo[].class);
		return res;
	}

	@Cacheable(value = "getTodo", key = "#p0")
	public Todo getTodo(Long userId) {
		String url = "https://jsonplaceholder.typicode.com/todos/" + userId;
		Todo res = restTemplate.getForObject(url, Todo.class);

		return res;
	}
}
