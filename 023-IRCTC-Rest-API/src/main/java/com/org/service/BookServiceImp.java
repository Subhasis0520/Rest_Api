package com.org.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.org.binding.Passenger;
import com.org.binding.Ticket;

@Service
public class BookServiceImp implements BookService{

	private Map<Integer, Ticket> map = new HashMap<>();
	private Integer ticketNum = 1001;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketNum(ticketNum);
		t.setStatus("Confirmed..");
		t.setTicketPrice(1965.0);
		
		map.put(t.getTicketNum(), t);
		
		ticketNum++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {

		if(map.containsKey(ticketNum))
		{
			return map.get(ticketNum);
		}
		return null;
	}

}
