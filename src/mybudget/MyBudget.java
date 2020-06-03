package mybudget;

import controller.Controller;
import model.Model;
import model.User;
import view.View;

public class MyBudget {

	public static MyBudget myBudget = null;
	private Model m;
	private View v;
	private Controller c;
	private User user;
	
	private MyBudget() {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(v,m);

	}

	public static MyBudget getMyBudget() {
		if (myBudget == null)
			myBudget = new MyBudget();
		return myBudget;
	}

	public User getUser() {
		return user;
	}
	
	public  void setUser(User user) {
		this.user = user;
	}
	
	
}
