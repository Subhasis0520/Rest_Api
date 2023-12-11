package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping(value ="/ticket",
	             consumes = "application/json",
	             produces = "application/json"
	)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		Ticket ticket = service.bookTicket(passenger);
		System.out.println(ticket);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/ticket/{ticketNum}", produces = "application/json")
	public Ticket getTicket(@PathVariable("ticketNum") Integer ticketNum) {
		Ticket ticket = service.getTicket(ticketNum);
		return ticket;
	}
}
