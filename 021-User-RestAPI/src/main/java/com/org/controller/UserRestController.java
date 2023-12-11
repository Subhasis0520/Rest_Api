package com.org.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.User;

import jakarta.websocket.server.PathParam;

@RestController
public class UserRestController {

	private Map<Integer, User> map = new HashMap<>();
	
	@PostMapping("/user")
	public ResponseEntity<String> save(@RequestBody User user){
		System.out.println(user);
		map.put(user.getId(), user);
		return new ResponseEntity<>("User data saved", HttpStatus.CREATED);
	}
	 
	          // Path Parameter
	@GetMapping("/user/{id}/data")
	public User getUser(@PathVariable("id") Integer userId) {
		User user = map.get(userId);
		return user;
	}
	
	
	          // Query Parameter
//	@GetMapping("/user")
//	public User getUser(@RequestParam("userId") Integer userId) {
//		User user = map.get(userId);
//		return user;
//	}
}
