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

public class UserUnitTests {
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
		user = new User("usernameTest","firstNameTest" , "lastNameTest" , "passwordTest" );
		app.setUser(user);
		app.save();
		model = new Model();
		user.getBudget().addRecord("test1", "salary", new Date(120,05,01), 100, "Income");
		user.getBudget().addRecord("test2", "salary", new Date(120,05,01), 100.2, "Income");
		user.getBudget().addRecord("test3", "salary", new Date(120,05,01), 0, "Income");
		user.getBudget().addRecord("test4", "salary", new Date(120,05,01), 12, "Income");
		
	}
	
	
	/*
	 * test all user's properties
	 */
	@Test
	public void testUserDetails() {
		assertEquals(user.getUserName(), "usernameTest");
		assertEquals(user.getFirstName(), "firstNameTest");
		assertEquals(user.getLastName(), "lastNameTest");
		assertEquals(user.getPassword(), "passwordTest");
	}
	


	/*
	 * test model.isUserNameExist function
	 */
	@Test
	public void testIsUserNameExist() {
		assertEquals(model.isUserNameExist("usernameTest"),true );
	}
	

	
	/*
	 * test load function
	 */
	@Test
	public void testLoadUser() {
	
		assertEquals(false, app.load("usernameTest5","passwordTest")); //expected to be false
		assertEquals(true, app.load("usernameTest","passwordTest"));
	}
	



}
