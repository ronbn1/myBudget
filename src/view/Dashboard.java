package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.synth.SynthStyle;

import controller.Controller;
import model.*;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/*
  Main window -- user Dashboard
 
 */
public class Dashboard extends View {
	private JPanel mainPanel;
	private Controller controller;
	private JTable table;
	private User user = null;
	private JLabel lblUsername;
	private JLabel lblCurrentBudget;
	public static Dashboard dashboard = null;
	private DefaultTableModel m;
	private int currentMonth;
	private int currentYear;
	private JLabel lblMonth;
	private JLabel lblYear;
	private ArrayList<String> months = new ArrayList<String>(
			Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));

	private Dashboard(JFrame mainFrame, Controller controller, User user) {
		this.controller = controller;
		mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.window);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setSize(500, 350);
		this.user = user;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainPanel.setSize(screenSize.width, screenSize.height);
		// JPanel recordPanel ;
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
				AddTransaction t = viewAddTransaction(controller);
				t.setLocation(700, 300);
				t.setSize(400, 320);
				t.setVisible(true);
			}
		});
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setForeground(new Color(127, 255, 212));
		lblBalance.setBounds(1352, 14, 122, 17);
		panel.add(lblBalance);

		JLabel lblHello = new JLabel("Hello,");
		lblHello.setForeground(new Color(53, 173, 202));
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHello.setBounds(405, 8, 36, 23);
		panel.add(lblHello);

		 lblUsername = new JLabel(user.getFirstName());
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(new Color(53, 173, 202));
		lblUsername.setBounds(442, 12, 79, 14);
		panel.add(lblUsername);

		JLabel lblMybudget = new JLabel("MyBudget");
		lblMybudget.setForeground(new Color(53, 173, 202));
		lblMybudget.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblMybudget.setBounds(856, 6, 127, 28);
		panel.add(lblMybudget);

		JLabel lblDeleteTransaction = new JLabel("Delete Transaction");
		lblDeleteTransaction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DeleteTransaction d = viewDeleteTransaction(controller);
				d.setLocation(700, 300);
				d.setSize(400, 320);
				d.setVisible(true);

			}
		});
		lblDeleteTransaction.setForeground(new Color(255, 192, 203));
		lblDeleteTransaction.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeleteTransaction.setBounds(1169, 14, 168, 17);
		panel.add(lblDeleteTransaction);
		
		JLabel logOut = new JLabel("LOGOUT");
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.logOut();
			}
		});
		logOut.setIcon(new ImageIcon("C:\\Users\\rbena\\Desktop\\MyBudget\\icons8-exit-16.png"));
		logOut.setBounds(480, 5, 96, 30);
		logOut.setForeground(new Color(255, 192, 203));
		panel.add(logOut);

//		DefaultTableModel model = new DefaultTableModel(); 
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        Date d = new Date();
//		model.addColumn("Name"); 
//		model.addColumn("Category"); 
//		model.addColumn("Date"); 
//		model.addColumn("Amount"); 
//		model.addRow(new Object[]{"Name", "Category","Date","Amount"});
//		model.addRow(new Object[]{"task 1", "Category 1",d.toString(),30.45});

//		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
//		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//		table.setBounds(400, 158, 1069, 154);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(3, 36, 44));
		panel_1.setBounds(0, 43, 1920, 93);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		Budget budget = user.getBudget();
		String currentBudget = String.valueOf(budget.getCurrentBalance());
		lblCurrentBudget = new JLabel(currentBudget);
		lblCurrentBudget.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCurrentBudget.setForeground(new Color(34, 139, 34));
		lblCurrentBudget.setBounds(1335, 27, 124, 40);
		panel_1.add(lblCurrentBudget);
		int month = new Date().getMonth();

		currentMonth = month - 1;
		currentYear = new Date().getYear() + 1900;

		lblMonth = new JLabel("MAY");
		lblMonth.setForeground(new Color(255, 255, 255));
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMonth.setBounds(449, 27, 66, 40);
		panel_1.add(lblMonth);

		JLabel label = new JLabel("<");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentYear = currentMonth == 0 ? currentYear - 1 : currentYear;
				currentMonth = currentMonth == 0 ? 12 : currentMonth;
				currentMonth = (currentMonth - 1);
				controller.updateDashboard();
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(409, 27, 40, 40);
		panel_1.add(label);

		JLabel label_1 = new JLabel(">");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				currentYear = currentMonth == 11 ? currentYear + 1 : currentYear;
				currentMonth = (currentMonth + 1) % 12;

				controller.updateDashboard();
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(589, 27, 40, 40);
		panel_1.add(label_1);

		lblYear = new JLabel(String.valueOf(currentYear));
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblYear.setBounds(525, 27, 66, 40);
		panel_1.add(lblYear);

		JLabel label_3 = new JLabel(",");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(503, 27, 24, 40);
		panel_1.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(399, 134, 1070, 927);
		mainPanel.add(panel_2);

//		table_1 = new JTable();
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, "", null, null, null},
//			},
//			new String[] {
//				"Name", "Category", "New column", "New column", "New column"
//			}
//		));

		JTable table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setShowVerticalLines(false);
		m = new DefaultTableModel(new Object[][] {}, new String[] { "Trans No", "Name", "Category", "Date", "Amount" });

		table.setModel(m);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Verdana", Font.PLAIN, 12);
		table.setFont(font);
		table.setRowHeight(30);
		table.setBackground(new Color(240, 240, 240));
		table.setForeground(Color.black);
		JTableHeader tableHeader = table.getTableHeader();
		// tableHeader.setBackground(Color.black);
		tableHeader.setForeground(new Color(33, 64, 76));
		Font headerFont = new Font("Verdana", Font.PLAIN, 24);
		tableHeader.setFont(headerFont);
		panel_2.setLayout(null);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 5, 1070, 909);
		panel_2.add(scrollPane);
//		

	}

	public void updateView(Budget b) {
		if (b.getCurrentBalance() >= 0) {

			lblCurrentBudget.setText(String.valueOf(b.getCurrentBalance()));
			lblCurrentBudget.setForeground(new Color(34, 139, 34));
		} else {
			lblCurrentBudget.setText(String.valueOf(b.getCurrentBalance()));
			lblCurrentBudget.setForeground(Color.red);

		}

//		ArrayList<Record> income = new ArrayList<Record>();
//		ArrayList<Record> expenses = new ArrayList<Record>();
//		income = (ArrayList<Record>) b.get_Income_Inperiod(month);
//		expenses= (ArrayList<Record>) b.get_Income_Inperiod(month);
		 lblUsername.setText(user.getFirstName());
		 
		lblMonth.setText(months.get((currentMonth) % 12));
		lblYear.setText(String.valueOf(currentYear));

		ArrayList<Record> allRecords = (ArrayList<Record>) b.getAllRecordsByMonth(currentMonth, currentYear - 1900);
		int size = m.getRowCount();

		for (int i = 0; i < size; i++) {
			m.removeRow(0);
		}

		for (Record cur : allRecords) {
			String date = String.valueOf(cur.getDate().getDate()) + "/" + String.valueOf(cur.getDate().getMonth()+1) + "/"
					+ String.valueOf(cur.getDate().getYear() + 1900);
			if (cur instanceof Income || cur instanceof RecurringIncome) {

				m.addRow(new Object[] { allRecords.indexOf(cur) + 1, cur.getName(), cur.getCategory().getType(), date,
						cur.getAmount() });

			} else {
				m.addRow(new Object[] {allRecords.indexOf(cur) + 1, cur.getName(), cur.getCategory().getType(), date, -cur.getAmount() });

			}
		}

		

	}

	public void changeMonth(String act) {
		if (act == "next") {
			currentMonth = currentMonth + 1 % 12;
			lblMonth.setText(months.get(currentMonth - 1));

		}

	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}
	public void removeScreen() {
		mainPanel.setVisible(false);
	}
	public void showScreen() {
		mainPanel.setVisible(true);
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public static Dashboard getDashboard(JFrame mainFrame, Controller controller, User user) {
		if (dashboard == null) {
			dashboard = new Dashboard(mainFrame, controller, user);
		}
		return dashboard;
	}
}
