package com.product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement
public class Product {
	@XmlAttribute(name="id") private int prodId;
	@XmlElement private double price;
	@XmlElement private static int vailNum;
	private static AtomicInteger idCounter = new AtomicInteger();
	private static List<Product> allProd = new ArrayList<Product>();
	
	public Product() {
		this.prodId = idCounter.incrementAndGet();
		this.price = 0;
		vailNum++;
		allProd.add(this);
	}
	
	public Product(double value) {
		this.prodId = idCounter.incrementAndGet();
		this.price = value;
		vailNum++;
		allProd.add(this);
	}
	
	public void changePriceBy(double amount) {
		this.price += amount;
	}
	
	public static int getProductNumber() {
		return Product.vailNum;
	}
	
	public static List<Product> getAllProduct() {
		return Product.allProd;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public static Product getProduct(int id) {
		return allProd.get(id);
	}
}
