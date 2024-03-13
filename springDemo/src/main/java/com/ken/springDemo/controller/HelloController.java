package com.ken.springDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(value = "/")
	public String hello() {
		return "Hello World!! add devtools !!!";
	}

	@GetMapping(value = "/spring")
	public String spring() {
		return "Spring";
	}

	@GetMapping(value = "/spring/boot")
	public String boot() {
		return "Boot";
	}
}
