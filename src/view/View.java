package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import controller.Controller;
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
		setScreen("register");
		//dashboardView = new Dashboard(mainFrame, controller);
	}

	public void signInFail() {

	}
	
public AddTransaction viewAddTransaction() {
	 return AddTransaction.getAddTransaction();
	 

}

	public void setScreen(String screen) {
		switch (screen) {
		case "register":
			registerView = new Register(mainFrame, controller);
			signinView.removeScreen();
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
		}
	}

	public void signInSuccess() {
		signinView.removeScreen();
	}
}
