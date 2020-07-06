package controller;

import java.util.Date;

import javax.swing.JPanel;

import model.*;
import mybudget.MyBudget;
import view.*;

public class Controller {
	private View view;
	private Model model;

	public Controller(View v, Model m) {
		this.view = v;
		this.model = m;
		init();
	}
	
	
	private void init() {
		view.init(this);
	}
	
	
	/*
	 * get the screen type and the user object and change to correct screen via View's setScreen function
	 * */
	public void goToScreen(String screen, User user) {

		view.setScreen(screen, user);

	}
	/*
	 * move to view with dashboard screen
	 * */
	public void setLoginParam() {

		view.signInSuccess(); // pass User object

	}
	
	
	/*
	 * add new user via model and change to SignIn screen
	 * */
	public void addNewUser(String userName, String firstName, String lastName, String password) {
		model.createNewUser(userName, firstName, lastName, password);
		User user = model.isExistUser();
		goToScreen("sign in", null);
	}

	
	/*
	 * add new record to the current user via  model
	 * */
	public void addNewRecord(String name, String category, Date date, double amount, String type) {

		model.addNewRecordToUser(name, category, date, amount, type);
	}

	/*
	 * get the current user object
	 * */
	public User getUser() {
		return model.isExistUser();
	}

	
	/*
	 * update the dashboard view with the relevant data via model and view
	 * */
	public void updateDashboard() {
		if (model.isExistUser() == null)
			return;
		Dashboard d = Dashboard.getDashboard(view.getMainFrame(), this, model.isExistUser());
		d.setUser(model.isExistUser());
		d.updateView(model.isExistUser().getBudget());
	}

	
	/*
	 * remove the chosen record by the user
	 * */
	public void removeTransByIndex(int index) {
		Dashboard d = Dashboard.getDashboard(view.getMainFrame(), this, model.isExistUser());
		int month = d.getCurrentMonth();
		int year = d.getCurrentYear();
		model.removeTransByIndex(index, month, year);
		d.updateView(model.isExistUser().getBudget());

	}
	
	/*
	 * save all the data of the user
	 * */

	public void save() throws ClassNotFoundException {
		MyBudget b = MyBudget.getMyBudget();

		b.save();

	}
	
	/*
	 * call to save  function via MyBudget
	 * */

	public boolean load(String userName, String password) throws ClassNotFoundException {

		MyBudget b = MyBudget.getMyBudget();

		boolean isSeccess = b.load(userName, password);
		return isSeccess;
	}

	
	/*
	 * call to update  function via MyBudget
	 * */

	public void update() throws ClassNotFoundException {

		MyBudget b = MyBudget.getMyBudget();

		b.update();
	}

	/*
	 * logout the current user via model and change the view screen to signin screen
	 * */
	public void logOut() {
		model.clearUser();
		view.setScreen("sign in", null);
	}

	/*
	 * pop up the relevant error message via view
	 * */
	public void showMessage(String msg) {
		view.showMessage(msg);

	}

	
	/*
	 * * check if the user is already exist and if the input data is valid via model functions
	 * * if the user already exist popup relevant message
	 * */
	public boolean registerValid(String username, String fName, String lName, String password) {
		RegisterValid rv = new RegisterValid();
		String msg = rv.inputValid(username, fName, lName, password);

		if (msg.compareTo("") != 0) {
			Message m = new Message(msg);
			return false;
		} else if (model.isUserNameExist(username)) {
			// isUser already exist
			Message m = new Message("User name already exist");
			return false;
		}
		return true;
	}
	
	
	/*
	 * * check if the user entered valid transaction data  via model functions
	 * * if the data is not valid, pop up via view function the relevant error message
	 * */
	public boolean addTransactionValid(String amount, String name, String date) {
	
		TransactionValid tv = new TransactionValid();
		if(!tv.isDouble(amount)) {
			Message m = new Message("Amount must be a number");
			return false;
		}
		
		if(name.compareTo("")==0) {
			Message m = new Message("Name can't be empty");
			return false;
		}
		
		if(!tv.isDateValid(date)) {
			Message m = new Message("The Date you entered is not valid");
			return false;
		}
		
		return true;
		
	}
	
	
	/*
	 * delete the chosen transaction via model 
	 * */
	public boolean deleteTransactionValid(String index) {
		TransactionValid tv = new TransactionValid();
		Dashboard d = Dashboard.getDashboard(view.getMainFrame(), this, model.isExistUser());
		System.out.println(d.getCurrentMonth() + " " + d.getCurrentYear());
		if(!tv.isValidIndex(index,model.isExistUser().getBudget().getAllRecordsByMonth(d.getCurrentMonth(), d.getCurrentYear()-1900))) {
			Message m = new Message("There is no record with this index");
			return false;
		}
		
		
		return true;
	}

}
