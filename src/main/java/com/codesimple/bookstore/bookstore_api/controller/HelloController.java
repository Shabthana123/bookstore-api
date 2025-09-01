package com.codesimple.bookstore.bookstore_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@RequestMapping("/hello")
	public String getHello() {
		
		return "Hello World!!";
	}

}
