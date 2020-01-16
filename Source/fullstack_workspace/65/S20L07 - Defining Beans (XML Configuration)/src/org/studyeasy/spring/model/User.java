package org.studyeasy.spring.model;

public class User {
	
	private int userID;
	private String name;
	public User(int userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
	}

	private String email;
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
