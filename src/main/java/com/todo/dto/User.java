package com.todo.dto;

public class User {
	private String name;
	private String username;
	private String password;
	
	

	public User() {
		
	}

	public User(String name, String username , String password) {
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", username=" + username + "]";
	}


}
