package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;


/*
 * Register window 
 * */

public class Register {
	private JPanel mainPanel; 
	private Controller controller;

	public Register(JFrame mainFrame, Controller controller) {
		
		this.controller = controller;
		mainPanel = new JPanel();
		mainPanel.setForeground(Color.WHITE);
		mainPanel.setBackground(SystemColor.window);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setSize(500,350);
		 JLabel loginText;
		JPanel registerPanel = new JPanel();
		registerPanel.setSize(500, 304);
		registerPanel.setBackground(SystemColor.window);
		registerPanel.setBorder(new LineBorder(Color.black));
		registerPanel.setPreferredSize(new Dimension(500, 200));
		registerPanel.setLocation(new Point(700, 350));
		
		JLabel label = new JLabel("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		loginText = new JLabel("Register");
		panel_1.add(loginText);
		loginText.setBorder(new EmptyBorder(0, 0, 5, 0));
		
		loginText.setFont(new Font("serif", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		JPanel namePasswordSection = new JPanel();
		
		
		namePasswordSection.setBackground(SystemColor.window);
		namePasswordSection.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 3));
		JPanel nameSection = new JPanel(new GridBagLayout());
		nameSection.setBackground(SystemColor.window);
		namePasswordSection.add(nameSection);
		JLabel nameText = new JLabel("Username: ");
		nameText.setBackground(SystemColor.window);
		JTextField nameField = new JTextField(8);
		nameSection.add(nameText);
		nameSection.add(nameField);
		
		JPanel firstNameSection = new JPanel(new GridBagLayout());
		firstNameSection.setBackground(SystemColor.window);
		namePasswordSection.add(firstNameSection);
		JLabel firstNameText = new JLabel("First name: ");
		firstNameText.setBackground(SystemColor.window);
		JTextField firstNameField = new JTextField(8);
		firstNameSection.add(firstNameText);
		firstNameSection.add(firstNameField);
		
		JPanel lastNameSection = new JPanel(new GridBagLayout());
		lastNameSection .setBackground(SystemColor.window);
		namePasswordSection.add(lastNameSection );
		JLabel lastNameText = new JLabel("Last name: ");
		lastNameText.setBackground(SystemColor.window);
		JTextField lastNameField = new JTextField(8);
		lastNameSection.add(lastNameText);
		lastNameSection.add(lastNameField );
		
		JPanel passwordSection = new JPanel(new GridBagLayout());
		passwordSection.setBackground(SystemColor.window);
		namePasswordSection.add(passwordSection);
		JLabel passwordText = new JLabel("Password: ");
		passwordText.setBackground(SystemColor.window);
		JPasswordField passwordField = new JPasswordField(8);
		passwordSection.add(passwordText);
		passwordSection.add(passwordField);
		
		JLabel label_3 = new JLabel("");
		
		
		mainPanel.add(registerPanel);
		
		JLabel label_4 = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		JButton loginBtn = new JButton("Sign up");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				boolean isSeccess = controller.registerValid(nameField.getText(), firstNameField.getText(), lastNameField.getText(), passwordField.getText());
				if(isSeccess) {
					//send the data to the controller
					controller.addNewUser(nameField.getText(),firstNameField.getText(),lastNameField.getText(),passwordField.getText());
					//controller.goToScreen("dashboard");
					try {
						controller.save();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		panel.add(loginBtn);
		GroupLayout gl_registerPanel = new GroupLayout(registerPanel);
		gl_registerPanel.setHorizontalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(namePasswordSection, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
		);
		gl_registerPanel.setVerticalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_registerPanel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(namePasswordSection, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_registerPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_registerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
		);
		
		JLabel lblNewLabel = new JLabel("Already have an account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(lblNewLabel);
		
		JLabel lblSignIn = new JLabel("Sign in");
		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.goToScreen("sign in",null);
			}
		});
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSignIn.setForeground(Color.BLUE);
		panel.add(lblSignIn);
		registerPanel.setLayout(gl_registerPanel);
	}
	public void removeScreen() {
		mainPanel.setVisible(false);
		
	}
}
