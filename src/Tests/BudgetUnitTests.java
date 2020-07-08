package Tests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.junit.rules.ExpectedException;

import model.Category;
import model.Currency;
import model.Expenses;
import model.Income;
import model.Model;
import model.Record;
import model.User;
import mybudget.MyBudget;

public class BudgetUnitTests {
	static MyBudget app ;	
	static User user;	
	static Model model;
	
	
	/*
	 * create the app
	 * create user and set him to the app's user
	 * save the user's data to mybudget.txt file
	 * create model 
	 * */
	@BeforeClass
	public static void setUpMethod() {
		app = MyBudget.getMyBudget();
		user = new User("usernameTest2","firstNameTest" , "lastNameTest" , "passwordTest" );
		app.setUser(user);
		app.save();
		model = new Model();
		user.getBudget().addRecord("test1", "salary", new Date(120,05,01), 100, "Income");
		user.getBudget().addRecord("test2", "salary", new Date(120,05,01), 100.2, "Income");
		user.getBudget().addRecord("test3", "salary", new Date(120,05,01), 0, "Income");
		user.getBudget().addRecord("test4", "salary", new Date(120,05,01), 12, "Income");
		
	}
	

	/*
	 * Test records by month function
	 * add to user budget 4 transaction with different data
	 * create list of 4 transactions
	 * compare 
	*/
	
	@Test
	public void testRecordsByMonth() {
		user.getBudget().addRecord("test1", "salary", new Date(120,07,01), 100, "Income");
		user.getBudget().addRecord("test2", "salary", new Date(120,07,01), 100, "Income");
		user.getBudget().addRecord("test3", "salary", new Date(120,07,01), 100, "Expense");
		user.getBudget().addRecord("test4", "salary", new Date(120,07,01), 100, "Expense");
		List<Record> actualRecords = user.getBudget().getAllRecordsByMonth(7, 120);
		List<Record> expectedRecords = new ArrayList<>();
		expectedRecords.add(new Income("test1", 100, new Currency("NIS"), new Date(120,07,01), new Category("salary")));
		expectedRecords.add(new Income("test2", 100, new Currency("NIS"), new Date(120,07,01), new Category("salary")));
		expectedRecords.add(new Expenses("test3", 100, new Currency("NIS"), new Date(120,07,01), new Category("salary")));
		expectedRecords.add(new Expenses("test4", 100, new Currency("NIS"), new Date(120,07,01), new Category("salary")));
		
		int i = expectedRecords.size()-1;
		for(Record cur : expectedRecords) {
			assertEquals(cur.getName(), actualRecords.get(i).getName());
			assertEquals(String.valueOf(cur.getAmount()), String.valueOf(actualRecords.get(i).getAmount()));
			assertEquals(cur.getCategory().getType(), actualRecords.get(i).getCategory().getType());
			assertEquals(cur.getCurrency().getType(), actualRecords.get(i).getCurrency().getType());
			assertEquals(cur.getDate().toString(), actualRecords.get(i).getDate().toString());
			i--;
		}
	}
	
	
	
	/*
	 * test current balance function 
	 * */
	@Test
	public void testCurrentBalance() {
		assertEquals(212.2, user.getBudget().getCurrentBalance(),0);
		user.getBudget().addRecord("test5", "salary", new Date(120,05,01), 50.2, "Expense");
		assertEquals(162.0, user.getBudget().getCurrentBalance(),0);
		user.getBudget().addRecord("test6", "salary", new Date(120,05,01), 200, "Expense");
		assertEquals(-38, user.getBudget().getCurrentBalance(),0);
		
	
	}
	
	/*
	 * Test income list function
	 * create list of 4 transactions
	 * add to user budget 4 transaction with different data
	 * compare
	*/
	@Test
	public void testIncomeList() {
		List<Income> incomes = new ArrayList<>();
		incomes.add(new Income("test1", 100, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		incomes.add(new Income("test2", 100.2, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		incomes.add(new Income("test3", 0, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		incomes.add(new Income("test4", 12, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		
		int i =0;
		for(Income cur : incomes) {
			assertEquals(cur.getName(), user.getBudget().get_Income().get(i).getName());
			assertEquals(String.valueOf(cur.getAmount()), String.valueOf(user.getBudget().get_Income().get(i).getAmount()));
			assertEquals(cur.getCategory().getType(), user.getBudget().get_Income().get(i).getCategory().getType());
			assertEquals(cur.getCurrency().getType(), user.getBudget().get_Income().get(i).getCurrency().getType());
			assertEquals(cur.getDate().toString(), user.getBudget().get_Income().get(i).getDate().toString());
			i++;
		}
	
	}
	
	
	/*
	 * Test expenses list function
	 * create list of 4 transactions
	 * add to user budget 4 transaction with different data
	 * compare
	*/
	@Test
	public void testExpenseList() {
		List<Expenses> expenses = new ArrayList<>();
		expenses.add(new Expenses("test1", 100, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		expenses.add(new Expenses("test2", 100.2, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		expenses.add(new Expenses("test3", 5, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		expenses.add(new Expenses("test4", 12, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		
		user.getBudget().addRecord("test1", "salary", new Date(120,05,01), 100, "Expense");
		user.getBudget().addRecord("test2", "salary", new Date(120,05,01), 100.2, "Expense");
		user.getBudget().addRecord("test3", "salary", new Date(120,05,01), 5, "Expense");
		user.getBudget().addRecord("test4", "salary", new Date(120,05,01), 12, "Expense");
		/*
		 * 
		 * in  the previous tests we added 4 records 
		 * to the user expenses list,
		 * so now we set the count to 4,
		 *  to start with the correct item in the user list
		 *
		 */
		int i =4;
		for(Expenses cur : expenses) {
			assertEquals(cur.getName(), user.getBudget().get_expenses().get(i).getName());
			assertEquals(String.valueOf(cur.getAmount()), String.valueOf(user.getBudget().get_expenses().get(i).getAmount()));
			assertEquals(cur.getCategory().getType(), user.getBudget().get_expenses().get(i).getCategory().getType());
			assertEquals(cur.getCurrency().getType(), user.getBudget().get_expenses().get(i).getCurrency().getType());
			assertEquals(cur.getDate().toString(), user.getBudget().get_expenses().get(i).getDate().toString());
			i++;
		}
	
	}
	
	
	/*
	 * Test remove transaction function
	 * create list of 3 transactions, they exists in the user's budget
	 * remove one transaction from the budget (the one that not exist in the expected list )
	 * compare
	*/
	
	@Test
	public void testRemoveTransaction() {
		List<Income> incomes = new ArrayList<>();
		incomes.add(new Income("test1", 100, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		incomes.add(new Income("test2", 100.2, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		incomes.add(new Income("test3", 0, new Currency("NIS"), new Date(120,05,01), new Category("salary")));
		User u = app.getUser();
		
		int idToDelete = u.getBudget().get_Income().get(3).getId();
		model.removeTransByIndex(idToDelete, 5, 2020);
		int i =0;
		for(Income cur : incomes) {
			assertEquals(cur.getName(), user.getBudget().get_Income().get(i).getName());
			assertEquals(String.valueOf(cur.getAmount()), String.valueOf(user.getBudget().get_Income().get(i).getAmount()));
			assertEquals(cur.getCategory().getType(), user.getBudget().get_Income().get(i).getCategory().getType());
			assertEquals(cur.getCurrency().getType(), user.getBudget().get_Income().get(i).getCurrency().getType());
			assertEquals(cur.getDate().toString(), user.getBudget().get_Income().get(i).getDate().toString());
			i++;
		}
	}
}
