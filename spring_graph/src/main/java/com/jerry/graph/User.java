package com.jerry.graph;

public class User {
	private String email;
	private int id;
	private String name;
	
	public User() {
		this.id = -1;
		this.email = "NA";
		this.name = "";
	}
	
	public User(int id) {
		this.id = id;
		this.email = "NA";
		this.name = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
