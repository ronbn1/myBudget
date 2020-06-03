package model;

import java.util.*;

public class Budget {
	private List<Category> categoryList;// string -> category
	private List<RecurringIncome> RecurringIncomeList;
	private List<RecurringExpenses> RecurringExpensesList;
	private List<Expenses> ExpensesList;
	private List<Income> IncomeList;

	public void add_Expense(String name, double amount, Currency currency, Date date, Category category,
			String target) {

	}

	public void add_RecurringExpense(String name, double amount, Currency currency, Date date, Category category,
			String target, Date renewDate) {

	}

	public void add_Income(String name, double amount, Currency currency, Date date, Category category, String target) {

	}

	public void add_RecurringIncome(String name, double amount, Currency currency, Date date, Category category,
			String target, Date renewDate) {

	}

	public List<Income> Get_Income_Inperiod(Date start, Date end) {

		return IncomeList;
	}

	public List<Expenses> Get_Expenses_Inperiod(Date start, Date end) {
		return ExpensesList;
	}
}
