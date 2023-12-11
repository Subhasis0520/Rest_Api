package com.org.service;

import com.org.binding.Passenger;
import com.org.binding.Ticket;

public interface BookService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNum);
}
