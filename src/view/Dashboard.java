package view;

import java.awt.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.Controller;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends View{
	private JPanel mainPanel; 
	private Controller controller;
	private JTable table;
	
	public Dashboard(JFrame mainFrame,Controller controller) {
		this.controller = controller;
		mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.window);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setSize(500,350);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainPanel.setSize(screenSize.width, screenSize.height);
		//JPanel recordPanel ;
//		recordPanel = new JPanel();
//		recordPanel.setLocation(700, 300);
//		recordPanel.setSize(400,200);
//		recordPanel.setBackground(Color.red);
//		
//		mainPanel.add(recordPanel);
//		recordPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 64, 76));
		panel.setBounds(0, 0, 1920, 45);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBalance = new JLabel("Add Transaction");
		lblBalance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTransaction t = viewAddTransaction();
				t.setLocation(700,300);
				t.setSize(400,320);
				t.setVisible(true);
			}
		});
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setForeground(new Color(53, 173, 202));
		lblBalance.setBounds(1352, 14, 122, 17);
		panel.add(lblBalance);
		
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setForeground(new Color(53, 173, 202));
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHello.setBounds(405, 8, 36, 23);
		panel.add(lblHello);
		
		JLabel lblRon = new JLabel("Ron");
		lblRon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRon.setForeground(new Color(53, 173, 202));
		lblRon.setBounds(442, 12, 46, 14);
		panel.add(lblRon);
		
		JLabel lblMybudget = new JLabel("MyBudget");
		lblMybudget.setForeground(new Color(53, 173, 202));
		lblMybudget.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblMybudget.setBounds(856, 6, 127, 28);
		panel.add(lblMybudget);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBackground(new Color(255, 255, 255));
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		
		DefaultTableModel model = new DefaultTableModel(); 
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Date d = new Date();
		table.setModel(model);
		model.addColumn("Name"); 
		model.addColumn("Category"); 
		model.addColumn("Date"); 
		model.addColumn("Amount"); 
		model.addRow(new Object[]{"Name", "Category","Date","Amount"});
		model.addRow(new Object[]{"task 1", "Category 1",d.toString(),30.45});

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.setBounds(400, 158, 1069, 154);
		
		
		mainPanel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(3, 36, 44));
		panel_1.setBounds(0, 43, 1920, 93);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("13,021.42");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(34, 139, 34));
		lblNewLabel_1.setBounds(1335, 27, 124, 40);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblMay = new JLabel("MAY, 2020");
		lblMay.setForeground(new Color(255, 255, 255));
		lblMay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMay.setBounds(449, 27, 180, 40);
		panel_1.add(lblMay);
		
		JLabel label = new JLabel("<");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(409, 27, 40, 40);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(">");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(589, 27, 40, 40);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(399, 134, 1070, 927);
		mainPanel.add(panel_2);
		
				


	}
}
