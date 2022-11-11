package com.eray.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/test")
public class FoodliteRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world!";
	}
	
}
