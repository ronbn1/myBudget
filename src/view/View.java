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
	public void init(Controller controller) {
		this.controller = controller;
		mainFrame = new JFrame();
		mainFrame.setTitle("MyBudget");
		mainFrame.setSize(600, 600);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreen("register",null);
		// dashboardView = new Dashboard(mainFrame, controller);
	}

	public void signInFail() {

	}

	public AddTransaction viewAddTransaction(Controller c) {
		return AddTransaction.getAddTransaction(c);

	}

	public void setScreen(String screen, User user ) {
		switch (screen) {
		case "register":
			registerView = new Register(mainFrame, controller);
			if (signinView != null) {

				signinView.removeScreen();
			}
			break;
		case "sign in":
			signinView = new Signin(mainFrame, controller);
			if (registerView != null) {

				registerView.removeScreen();
			}
			break;
		case "dashboard":
			dashboardView =  Dashboard.getDashboard(mainFrame, controller,user);
			if (registerView != null)
				registerView.removeScreen();
			if (signinView != null)
				signinView.removeScreen();
			break;

		}

	}

	public void signInSuccess() {
		signinView.removeScreen();
	}

	public void displayDashboard(User user) {

		setScreen("dashboard",user);
		

	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
}
