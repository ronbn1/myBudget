package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

/*
 * error message window
 * */


public class Message extends JFrame {
	
	public Message(String msg) {
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(msg);
		lblNewLabel.setBounds(148, 22, 215, 45);
		getContentPane().add(lblNewLabel);
		setSize(520,128);
		setLocation(700,450);
		setTitle("ERROR");
		setVisible(true);
		
	}

}
