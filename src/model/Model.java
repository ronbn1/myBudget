package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import mybudget.MyBudget;

public class Model  {
	
	

	/*
	  create new user with relevant data
	 
	 */
	public void createNewUser(String userName,  String firstName,  String lastName ,  String password) {
		
		MyBudget m = MyBudget.getMyBudget();
		User user = new User(userName, firstName, lastName, password);
		m.setUser(user);
	}


	/*
	  return the current user if is exist
	 
	 */
	public User isExistUser() {
		MyBudget m = MyBudget.getMyBudget();
		User user = m.getUser();
		if(user == null) return null;
		return user;
		
	}
	
	

	/*
	  add record via budget function
	 
	 */
	public void addNewRecordToUser(String name,String category,Date date,double amount,String type) {
		User user = MyBudget.getMyBudget().getUser();
		Budget budget = user.getBudget();
		budget.addRecord(name, category, date, amount, type);
		
		

	}
	


	/*
	  remove record via budget function
	 
	 */
	public void removeTransByIndex(int index,int month,int year) {
		
		User user = MyBudget.getMyBudget().getUser();
		Budget budget = user.getBudget();
		
		budget.removeRecord(index,month,year);
		
	}
	

	/*
	  log out the current user
	 
	 */
	public void clearUser() {
		MyBudget m = MyBudget.getMyBudget();
		m.setUser(null); 
	}
	

	/*
	  check if the user name and the password is of existing user 
	 
	 */
	public boolean isUserNameExist(String username) {
	

		ArrayList<User> users = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("mybudget.txt"));
			users = (ArrayList<User>) ois.readObject();

			for (User u : users) {
				if (u.getUserName().compareTo(username) == 0 ) {
					return true;
				}
			}

		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		return false;
	}
}
