package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.BookService;

@Controller
public class MyController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum, Model model) {
		Ticket ticket = service.getTicket(ticketNum);
		model.addAttribute("ticket", ticket);
		return "view";
	}
	
	@GetMapping("/ticket")
	public String getTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "view";
	}

	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg", "Your ticket is booked and pnr is: "+ticket.getTicketNum());
		System.out.println(ticket);
		
		return "index";
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
}
