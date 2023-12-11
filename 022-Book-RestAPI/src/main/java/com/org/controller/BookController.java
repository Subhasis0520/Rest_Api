package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.BookApp;
import com.org.binding.Payment;


@RestController
public class BookController {

	
	@PostMapping(value = "/book",
			     consumes = {"application/xml","application/json"}
	)
	public ResponseEntity<String> saveBook(@RequestBody BookApp book){
		// logic to save
		System.out.println(book);
	return new ResponseEntity<String>("Book confirm..!", HttpStatus.CREATED);	
	}
	
	
	@GetMapping(
			value ="/book",
			produces = {"application/xml","application/json"}
	)
	public BookApp getBook() {
		Payment p = new Payment();
		p.setAcc(13420);
		p.setCard("Credit Card");
		
		BookApp book = new BookApp();			
		book.setPnr(1001);
		book.setName("Subhasis");
		book.setPrice(1965.67);
		book.setPayment(p);
		
		return book;
	}
}
