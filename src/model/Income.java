package model;

import java.io.Serializable;
import java.util.Date;

public class Income extends Record implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Income(String name, double amount, Currency currency, Date date, Category category) {
		super(name, amount, currency, date, category);
		// TODO Auto-generated constructor stub

	}


}
