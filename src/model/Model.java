package model;

import java.util.Observable;

import mybudget.MyBudget;

public class Model extends Observable {
	
	public void createNewUser(String userName,  String firstName,  String lastName ,  String password) {
		
		MyBudget m = MyBudget.getMyBudget();
		User user = new User(userName, firstName, lastName, password);
		m.setUser(user);
	}

}
