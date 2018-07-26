package com.customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
public class Customer {
	@XmlAttribute(name="id") private int userId;
	@XmlElement private String name;
	@XmlElement private double count;
	
	public Customer() {
		this.userId = -1;
		this.name = "";
		this.count = 0;
	}
	
	public Customer(int id, String name, double count) {
		this.userId = id;
		this.name = name;
		this.count = count;
	}
	
	public int getId() {
		return this.userId;
	}
	
	public void setId(int id) {
		this.userId = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void updateName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Customer " + userId + ": " + name + "\nAccount: " + count; 
	}
}
