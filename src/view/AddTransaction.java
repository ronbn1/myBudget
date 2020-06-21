package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.Controller;
import model.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;


/*
 * add transaction window
 * 
 * */
public class AddTransaction extends JFrame{
	JPanel recordPanel;
	JPanel mainPanel;
	public static AddTransaction t =null;
	private JTextField textField;
	private JComboBox textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public String name;
	public String type;
	public String category;
	public Date date;
	public Double amount;
	
	private AddTransaction(Controller c) {
		setAlwaysOnTop(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblAddNewRecord = new JLabel("Add new record");
		lblAddNewRecord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblAddNewRecord);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(120, 11, 161, 24);
		panel_1.add(panel_2);
		
		JLabel lblName = new JLabel("Name:");
		
		textField = new JTextField(8);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(120, 46, 161, 24);
		panel_1.add(panel_3);
		
		JLabel lblCategory = new JLabel("Category:");
		
		 textField_1 = new JComboBox();
		 textField_1.setBackground(Color.WHITE);
		textField_1.setModel(new DefaultComboBoxModel(new String[] {"Salary", "Shopping", "Food & Dining", "Education", "Others"}));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblCategory)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(120, 81, 161, 24);
		panel_1.add(panel_4);
		
		JLabel lblDate = new JLabel("Date:");
		
		textField_2 = new JTextField(8);
		textField_2.setText("DD/MM/YY");
		textField_2.setToolTipText("");
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addComponent(lblDate)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate)))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(120, 121, 161, 24);
		panel_1.add(panel_5);
		
		JLabel lblAmount = new JLabel("Amount:");
		
		textField_3 = new JTextField(8);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addComponent(lblAmount)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount)))
		);
		panel_5.setLayout(gl_panel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Income", "Expense"}));
		comboBox.setBounds(145, 166, 109, 20);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 type = comboBox.getSelectedItem().toString();
				 name = textField.getText();
				 category = textField_1.getSelectedItem().toString();
				String d= textField_2.getText();
				if(c.addTransactionValid(textField_3.getText(), name, d)) {
					
					amount= Double.parseDouble(textField_3.getText().toString());
					
					int day,month,year;
					day = Integer.parseInt(String.valueOf(d.charAt(0))) * 10 + Integer.parseInt(String.valueOf(d.charAt(1)));
					month = Integer.parseInt(String.valueOf(d.charAt(3))) * 10 + Integer.parseInt(String.valueOf(d.charAt(4))) ;
					year = Integer.parseInt(String.valueOf(d.charAt(6))) * 10 + Integer.parseInt(String.valueOf(d.charAt(7))) + 100;
					
					date = new Date(year,month-1,day);
					
					
					c.addNewRecord(name,category,date,amount,type);
					c.updateDashboard();
					setVisible(false);
					//clear form
					textField.setText("");
					textField_1.setSelectedIndex(0);
					textField_2.setText("dd/mm/yy");
					textField_3.setText("");
					
					try {
						c.update();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(155, 203, 89, 23);
		panel_1.add(btnNewButton);
		
		
	


	}
	
	public static AddTransaction getAddTransaction(Controller c) {
		if(t == null) {
			t = new AddTransaction(c);
		}
		return t;
	}
}
