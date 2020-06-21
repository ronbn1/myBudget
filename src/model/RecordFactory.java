package model;

import java.util.Date;

public class RecordFactory {

	public static Record getRecord (String type, String name, double amount, Currency currency, Date date, Category category) {
		
		if (type.compareToIgnoreCase("income") == 0) {
			return new Income(name, amount, currency, date, category);
		}
		else if (type.compareToIgnoreCase("expense") == 0) {
			return new Expenses(name, amount, currency, date, category);
		}
		return null;
		
	}
	
}