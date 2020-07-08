package model;

import java.io.Serializable;
import java.util.*;

import mybudget.MyBudget;

public class Budget  implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Expenses> expensesList;
	private List<Income> incomeList;
	private double currentBalance;

	public Budget() {
		expensesList = new ArrayList<Expenses>();
		incomeList = new ArrayList<Income>();
		currentBalance = 0;
	}

	/*
	  add new expense record to user's budget
	 */
	public void add_Expense(Record e) {
		expensesList.add((Expenses) e);
		currentBalance += e.getAmount();
	}


	/*
	  add new income record to user's budget
	 
	 */
	public void add_Income(Record e) {
		

		incomeList.add((Income) e);

		currentBalance += e.getAmount();

	}



	public List<Income> get_Income() {

		return incomeList;
	}

	public List<Expenses> get_expenses() {

		return expensesList;
	}
	
	
	/*
	  return all income records by specific month
	 
	 */
	public List<Record> get_Income_Inperiod(int month, int year) {// month-1
		ArrayList<Record> allRecords = new ArrayList<Record>();
		for (Income cur : incomeList) {

			if (cur.getDate().getMonth() == month && cur.getDate().getYear() == year)
				allRecords.add(cur);
		}



		return allRecords;
	}
	

	/*
	  return all expense records by specific month
	 
	 */
	public List<Record> get_Expenses_Inperiod(int month, int year) {

		ArrayList<Record> allRecords = new ArrayList<Record>();
		for (Expenses cur : expensesList) {
			if (cur.getDate().getMonth() == month && cur.getDate().getYear() == year)
				allRecords.add(cur);
		}



		return allRecords;
	}

	public double getCurrentBalance() {

		return currentBalance;
	}
	
	

	/*
	  return all records by specific month
	  
	  call to auxiliary functions 
	 
	 */
	
	public List<Record> getAllRecordsByMonth(int month, int year) {

		ArrayList<Record> allRecords = new ArrayList<Record>();
		ArrayList<Record> incomesByMonth = (ArrayList<Record>) get_Income_Inperiod(month, year);
		ArrayList<Record> expensesByMonth = (ArrayList<Record>) get_Expenses_Inperiod(month, year);

		for (Record cur : incomesByMonth) {
			allRecords.add(cur);
		}
		for (Record cur : expensesByMonth) {
			allRecords.add(cur);
		}

		Collections.sort(allRecords, Comparator.comparing(Record::getDate));
		Collections.reverse(allRecords);
		return allRecords;

	}
	

	/*
	 * 
	 * 
	 * add new record via Factory design pattern (RecodFactory)
	 */
	public void addRecord(String name, String c, Date date, double amount, String type) {
		Currency currency = new Currency("NIS");
		Category category = new Category(c);

		// renew date
		Record r = RecordFactory.getRecord(type, name, amount, currency, date, category);
		
		if(r instanceof Income)
			add_Income(r);
		else if (r instanceof Expenses)
			add_Expense(r);
			
		
		
	}
	
	

	/*
	  remove specific record by index, month, year
	 
	 */
	public void removeRecord(int index, int month, int year) {

		ArrayList<Record> allRecords = new ArrayList<Record>();
		
		allRecords =(ArrayList<Record>) getAllRecordsByMonth(month, year-1900);
		
		Record toRemove = null;
		for(Record r : allRecords) {
			if(r.getId() == index) toRemove=r;
		}
		
		if(toRemove instanceof Income ) {
			currentBalance-=toRemove.getAmount();
			incomeList.remove(toRemove);
		}
		else {
			currentBalance-=toRemove.getAmount();
			expensesList.remove(toRemove);
		}
		
		MyBudget m = MyBudget.getMyBudget();
		try {
			m.update();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
