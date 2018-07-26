package com.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CustomerServer {
	private static Map<Integer ,Customer> allCustomers = new ConcurrentHashMap<Integer, Customer>();
	private static AtomicInteger idCount = new AtomicInteger();
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Customer updateCustomerName(Customer newInfo) {
		int id = newInfo.getId();
		if(!allCustomers.containsKey(id)) {
			throw new InvalidUserIdException();
		} else {
			Customer cos = allCustomers.get(id);
			cos.updateName(newInfo.getName());
			return cos;
		}
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Customer createCustomer(Customer newCus) {
		int id = idCount.incrementAndGet();
		newCus.setId(id);
		allCustomers.put(id, newCus);
		return newCus;
	}
	
	@GET
	@Path("/allcustomer")
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getAllCustomers() {
		List<Customer> allCus = new ArrayList<Customer>(allCustomers.values());
		return allCus;
	}
}
