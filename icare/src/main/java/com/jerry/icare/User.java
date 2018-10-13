package com.jerry.icare;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="weCare")
public class User {
	@Id
	private String id;
	private String email;
	private String name;
	private String employer;
	private String password;
	
	public User() {
		
	}
	
	public User(String email, String name, String employer, String password) {
		this.email = email;
		this.name = name;
		this.employer = employer;
		this.password = password;
	}

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
