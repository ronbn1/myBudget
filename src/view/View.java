package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import controller.Controller;
import model.User;

import javax.swing.border.EmptyBorder;
import view.Signin;




public class View {

	private JFrame mainFrame;
	private Controller controller;
	private Signin signinView = null;
	private Register registerView = null;
	private Dashboard dashboardView = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	
	/*
	 *  Init the main frame
	 * */
	public void init(Controller controller) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.controller = controller;
		mainFrame = new JFrame();
		mainFrame.setTitle("MyBudget");
		mainFrame.setSize(screenSize.width,screenSize.height);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreen("register",null);
		// dashboardView = new Dashboard(mainFrame, controller);
	}


	public AddTransaction viewAddTransaction(Controller c) {
		return AddTransaction.getAddTransaction(c);

	}
	
	
	public DeleteTransaction viewDeleteTransaction(Controller c) {
		return DeleteTransaction.getDeleteTransaction(c);

	}
	
	/*
	 * set the right screen 
	 * */
	public void setScreen(String screen, User user ) {
		switch (screen) {
		case "register":
			registerView = new Register(mainFrame, controller);
			if (signinView != null) signinView.removeScreen();
			if(dashboardView !=null) dashboardView.removeScreen();
			break;
			
		case "sign in":
			signinView = new Signin(mainFrame, controller);
			if (registerView != null) registerView.removeScreen();
			if(dashboardView !=null) dashboardView.removeScreen();
			break;
			
		case "dashboard":
			dashboardView =  Dashboard.getDashboard(mainFrame, controller,user);
			if (registerView != null)	registerView.removeScreen();
			if (signinView != null)	signinView.removeScreen();
			dashboardView.showScreen();
			break;

		}

	}
	

	/*
	  switch to dashboard screen if the signin done successfully
	 
	 */
	public void signInSuccess() {
		signinView.removeScreen();
		setScreen("dashboard",controller.getUser());
	}

	public void displayDashboard(User user) {

		setScreen("dashboard",user);
		

	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
	
	public void showMessage(String msg) {
		Message m = new Message(msg); 
		
	}

}
