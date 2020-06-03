package model;

import java.util.*;

public class Budget {
	private List<Category> categoryList;// string -> category
	private List<RecurringIncome> recurringIncomeList;
	private List<RecurringExpenses> recurringExpensesList;
	private List<Expenses> expensesList;
	private List<Income> incomeList;
	private double currentBalance;

	public Budget() {
		recurringIncomeList = new ArrayList<RecurringIncome>();
		recurringExpensesList = new ArrayList<RecurringExpenses>();
		expensesList = new ArrayList<Expenses>();
		incomeList = new ArrayList<Income>();
		categoryList = new ArrayList<Category>();
		Category c1 = new Category("c1");
		Category c2 = new Category("c2");
		Category c3 = new Category("c3");
		Category c4 = new Category("c4");
		categoryList.add(c1);
		categoryList.add(c2);
		categoryList.add(c3);
		categoryList.add(c4);

		currentBalance = 0;
	}

	public void add_Expense(String name, double amount, Currency currency, Date date, Category category) {
		Expenses e = new Expenses(name, amount, currency, date, category);
		expensesList.add(e);
		currentBalance -= e.getAmount();
	}

	public void add_RecurringExpense(String name, double amount, Currency currency, Date date, Category category,
			Date renewDate) {
		RecurringExpenses e = new RecurringExpenses(name, amount, currency, renewDate, category);
		recurringExpensesList.add(e);
	}

	public void add_Income(String name, double amount, Currency currency, Date date, Category category) {
		Income e = new Income(name, amount, currency, date, category);
		incomeList.add(e);
		currentBalance += e.getAmount();
	}

	public void add_RecurringIncome(String name, double amount, Currency currency, Date date, Category category,
			Date renewDate) {
		RecurringIncome e = new RecurringIncome(name, amount, currency, renewDate, category);
		recurringIncomeList.add(e);

	}

	public List<Income> get_Income() {

		return incomeList;
	}

	public List<Expenses> get_expenses() {

		return expensesList;
	}

	public List<Record> get_Income_Inperiod(int month) {// month-1
		ArrayList<Record> allRecords = new ArrayList<Record>();
		for (Income cur : incomeList) {
			if (cur.getDate().getMonth() - 1 == month)
				allRecords.add(cur);
		}

		for (RecurringIncome cur : recurringIncomeList) {
			allRecords.add(cur);
		}

		return allRecords;
	}

	public List<Record> get_Expenses_Inperiod(int month) {

		ArrayList<Record> allRecords = new ArrayList<Record>();
		for (Expenses cur : expensesList) {
			if (cur.getDate().getMonth() - 1 == month)
				allRecords.add(cur);
		}

		for (RecurringExpenses cur : recurringExpensesList) {

			allRecords.add(cur);
		}

		return allRecords;
	}

	public double getCurrentBalance() {

		return currentBalance;
	}

	public List<Record> getAllRecordsByMonth(int month){
		ArrayList<Record> allRecords = new ArrayList<Record>();
		ArrayList<Record> incomesByMonth =(ArrayList<Record>) get_Income_Inperiod(month);
		ArrayList<Record> expensesByMonth = (ArrayList<Record>)get_Expenses_Inperiod(month);
		
		for(Record cur : incomesByMonth) {
			allRecords.add(cur);
		}
		for(Record cur : expensesByMonth) {
			allRecords.add(cur);
		}
		
		Collections.sort(allRecords, Comparator.comparing(Record::getDate));	
		//System.out.println(allRecords.get(0));
		return allRecords;
		
		
		
		
	}
	
	public void addRecord(String name, String c, Date date, double amount, String type) {
		Currency currency = new Currency("NIS");
		Category category = new Category(c);

		// renew date

		if (type == "Income")
			add_Income(name, amount, currency, date, category);
		else if (type == "Expense")
			add_Expense(name, amount, currency, date, category);
		else if (type == "Recurring Income")
			add_RecurringIncome(name, amount, currency, date, category, date);
		else if (type == "Recurring Expense")
			add_RecurringExpense(name, amount, currency, date, category, date);
	}
}
