package model;

import java.io.Serializable;
import java.util.Date;

public class Expenses extends Record implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Expenses(String name, double amount, Currency currency, Date date, Category category) {
		
		super(name, amount*-1, currency, date, category);
		// TODO Auto-generated constructor stub
		
	}


	
}
