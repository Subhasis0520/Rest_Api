package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@PostMapping("/save")
	public ResponseEntity<String> save(){
		String msg = "Data saved sucessfully...!";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Good evening";
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		String msg = "Welcome to Bangalore";
		return new ResponseEntity<String>(msg, HttpStatusCode.valueOf(210));
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		String msg = "Hello everyone....";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
