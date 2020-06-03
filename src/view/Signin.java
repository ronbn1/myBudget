package view;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.Controller;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Signin {
	private JPanel mainPanel; 
	private Controller controller;

	public Signin(JFrame mainFrame, Controller controller) {
		this.controller = controller;
		mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.window);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		 JLabel loginText;
		JPanel signinPanel = new JPanel();
		signinPanel.setSize(500, 221);
		signinPanel.setBackground(SystemColor.window);
		signinPanel.setBorder(new LineBorder(Color.black));
		signinPanel.setPreferredSize(new Dimension(500, 200));
		signinPanel.setLocation(new Point(0, 0));
		
		JLabel label = new JLabel("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		loginText = new JLabel("Log In");
		panel_1.add(loginText);
		loginText.setBorder(new EmptyBorder(0, 0, 5, 0));
		
		loginText.setFont(new Font("serif", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		JPanel namePasswordSection = new JPanel(new GridBagLayout());
		
		
		namePasswordSection.setBackground(SystemColor.window);
		JPanel nameSection = new JPanel(new GridBagLayout());
		nameSection.setBackground(SystemColor.window);
		GridBagConstraints gbc_nameSection = new GridBagConstraints();
		gbc_nameSection.insets = new Insets(0, 0, 5, 0);
		gbc_nameSection.gridx = 1;
		gbc_nameSection.gridy = 0;
		namePasswordSection.add(nameSection, gbc_nameSection);
		JLabel nameText = new JLabel("Username: ");
		nameText.setBackground(SystemColor.window);
		JTextField nameField = new JTextField(8);
		
	
		nameSection.add(nameText);
		nameSection.add(nameField);
		JPanel passwordSection = new JPanel(new GridBagLayout());
		passwordSection.setBackground(SystemColor.window);
		GridBagConstraints gbc_passwordSection = new GridBagConstraints();
		gbc_passwordSection.gridx = 1;
		gbc_passwordSection.gridy = 1;
		namePasswordSection.add(passwordSection, gbc_passwordSection);
		JLabel passwordText = new JLabel("Password: ");
		passwordText.setBackground(SystemColor.window);
		JTextField passwordField = new JTextField(8);
		passwordSection.add(passwordText);
		passwordSection.add(passwordField);
		
		JLabel label_3 = new JLabel("");
		
		
		mainPanel.add(signinPanel);
		
		JLabel label_4 = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		JButton loginBtn = new JButton("Sign in");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//send the data to the controller
				controller.setLoginParam(nameField.getText(),passwordField.getText());
			}
		});
		GroupLayout gl_signinPanel = new GroupLayout(signinPanel);
		gl_signinPanel.setHorizontalGroup(
			gl_signinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signinPanel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_signinPanel.createSequentialGroup()
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addComponent(namePasswordSection, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_signinPanel.createSequentialGroup()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
		);
		gl_signinPanel.setVerticalGroup(
			gl_signinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signinPanel.createSequentialGroup()
					.addGroup(gl_signinPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_signinPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(namePasswordSection, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_signinPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		
		JLabel lblNewLabel = new JLabel("Don't have an account? ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblRegisterNow = new JLabel("Register now!");
		lblRegisterNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.goToScreen("register",null);
			}
		});
		lblRegisterNow.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRegisterNow.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(loginBtn))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(6)
							.addComponent(lblRegisterNow)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(loginBtn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblRegisterNow))
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		signinPanel.setLayout(gl_signinPanel);
	}
	public void removeScreen() {
		mainPanel.setVisible(false);
		
	}
}
