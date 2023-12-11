package com.org.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class BookApp {

	private Integer pnr;
	private String name;
	private Double price;
	private Payment payment;
}
