
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
 * Delete transaction window
 * */
public class DeleteTransaction extends JFrame {
	JPanel recordPanel;
	JPanel mainPanel;
	private Controller c;
	public static DeleteTransaction t = null;
	private JTextField textField;
	public String name;
	public String type;
	public String category;
	public Date date;
	public Double amount;

	private DeleteTransaction(Controller c) {
		this.c = c;
		setAlwaysOnTop(true);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		setSize(425, 200);
		JLabel lblAddNewRecord = new JLabel("Delete record");
		lblAddNewRecord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblAddNewRecord);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(120, 11, 161, 24);
		panel_1.add(panel_2);

		JLabel lblName = new JLabel("Record number");

		textField = new JTextField(8);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addComponent(lblName)
						.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE).addComponent(textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(8)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))));
		panel_2.setLayout(gl_panel_2);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (c.deleteTransactionValid(textField.getText())) {

					int indexToRemove = Integer.parseInt(textField.getText());
					c.removeTransByIndex(indexToRemove);
					textField.setText("");
					setVisible(false);
					try {
						c.update();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton.setBounds(163, 58, 89, 23);
		panel_1.add(btnNewButton);

	}

	public static DeleteTransaction getDeleteTransaction(Controller c) {
		if (t == null) {
			t = new DeleteTransaction(c);
		}
		return t;
	}
}
