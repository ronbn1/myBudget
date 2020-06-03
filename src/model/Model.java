package model;

import java.util.Date;
import java.util.Observable;

import mybudget.MyBudget;

public class Model extends Observable {
	
	public void createNewUser(String userName,  String firstName,  String lastName ,  String password) {
		
		MyBudget m = MyBudget.getMyBudget();
		User user = new User(userName, firstName, lastName, password);
		m.setUser(user);
	}

	public User isExistUser() {
		MyBudget m = MyBudget.getMyBudget();
		User user = m.getUser();
		if(user == null) return null;
		return user;
		
	}
	
	public void addNewRecordToUser(String name,String category,Date date,double amount,String type) {
		User user = MyBudget.getMyBudget().getUser();
		Budget budget = user.getBudget();
		budget.addRecord(name, category, date, amount, type);
		
		

	}
}
