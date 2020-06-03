package controller;

import javax.swing.JPanel;

import model.Model;
import view.AddTransaction;
import view.View;

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
	
	public void goToScreen(String screen) {
		
		view.setScreen(screen);
		
	}

	public void setLoginParam(String name, String password) {
		// validate username and password via model
		//if validate redirect to deshboard
		// else print error via view
		
		view.signInSuccess(); //pass User object
		

	}
	
	
	public void addNewUser(String userName, String firstName, String lastName , String password) {
		model.createNewUser(userName,  firstName,  lastName ,  password);
	}

//	public AddTransaction openAddTransactionWindow(JPanel mainPanel) {
//		return view.viewAddTransaction(mainPanel);
//	}
}
