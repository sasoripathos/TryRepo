package com.product;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ProductService {
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public static Product addProduce(@QueryParam("price") double price) {
		Product newProd = new Product(price);
		return newProd;
	}
	
	@GET
	@Path("/allprod")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Product> getAllProduct() {
		return Product.getAllProduct();
	}
	
	@GET
	@Path("/prodnum")
	@Produces(MediaType.TEXT_PLAIN)
	public static Integer getProductNumber() {
		return Product.getProductNumber();
	}
	
	@GET
	@Path("/prod/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Product getProduct(@PathParam("id") int id) {
		return Product.getProduct(id-1);
	}
}
