package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Budget budget;

	public Budget getBudget() {
		return budget;
	}



	public User(String userName, String firstName, String lastName, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.budget = new Budget();
	}

	
	public String getUserName() {
		return userName;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	} 

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
