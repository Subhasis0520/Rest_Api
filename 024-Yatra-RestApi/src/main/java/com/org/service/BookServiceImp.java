package com.org.service;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.binding.Passenger;
import com.org.binding.Ticket;

@Service
public class BookServiceImp implements BookService{

	   // we have to deploy this into aws cloud to communicate or
	   // another local host in eclipse
	private final String Book_Ticket_Url = "http://localhost:8090/ticket";
	private final String Get_Ticket_Url = "http://localhost:8090/ticket/{ticketNum}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		
			WebClient webClient = WebClient.create();
			Ticket ticket = webClient.post()
			                         .uri(Book_Ticket_Url)
			                         .bodyValue(passenger)
			                         .retrieve()
			                         .bodyToMono(Ticket.class)
			                         .block();
			
		return ticket;
		
		/*
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(Book_Ticket_Url,passenger,Ticket.class);
		Ticket ticket = responseEntity.getBody();
		
		return ticket;
		*/
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		
		WebClient wc = WebClient.create();
		Ticket ticket = wc.get()
		                  .uri(Get_Ticket_Url, ticketNum)
		                  .retrieve()
		                  .bodyToMono(Ticket.class)
		                  .block();
		
		return ticket;
		
		/*
		          //It is out-dated
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(Get_Ticket_Url, Ticket.class,ticketNum);
		Ticket body = responseEntity.getBody();
		
		return body;
		*/
	}


}
