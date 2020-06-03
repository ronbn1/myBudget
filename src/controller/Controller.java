package controller;

import java.util.Date;

import javax.swing.JPanel;

import model.*;

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

	public void goToScreen(String screen, User user) {

		view.setScreen(screen, user);

	}

	public void setLoginParam(String name, String password) {
		// validate username and password via model
		// if validate redirect to deshboard
		// else print error via view

		view.signInSuccess(); // pass User object

	}

	public void addNewUser(String userName, String firstName, String lastName, String password) {
		model.createNewUser(userName, firstName, lastName, password);
		User user = model.isExistUser();
		goToScreen("dashboard", user);
	}

	public void addNewRecord(String name, String category, Date date, double amount, String type) {

		model.addNewRecordToUser(name, category, date, amount, type);
	}

	public User getUser() {
		return model.isExistUser();
	}

	public void updateDashboard() {
		Dashboard d = Dashboard.getDashboard(view.getMainFrame(), this, model.isExistUser());
		d.updateView(model.isExistUser().getBudget());
	}

}
