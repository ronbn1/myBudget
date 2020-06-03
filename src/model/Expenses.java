package model;

import java.util.Date;

public class Expenses extends Record {
	private String source;

	
	public Expenses(String source, String name, double amount, Currency currency, Date date, Category category) {
		super(name, amount, currency, date, category);
		// TODO Auto-generated constructor stub
		this.source = source;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}
}
