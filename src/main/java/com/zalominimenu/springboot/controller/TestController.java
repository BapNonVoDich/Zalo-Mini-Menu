package com.zalominimenu.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// rimmel asghar
@RestController
public class TESTController {

	@GetMapping("/TEST")
	public ResponseEntity<String> sayHello() {

		return ResponseEntity.ok("Sever is good!");
	}

}
