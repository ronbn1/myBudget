package model;

import java.util.Date;

public class RecurringExpenses extends Record{
	
	private String source;
	private Date renewDate;
	public RecurringExpenses(String name, double amount, Currency currency, Date date, Category category) {
		super(name, amount, currency, date, category);
		this.source = source;
		this.renewDate = renewDate;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getRenewDate() {
		return renewDate;
	}
	public void setRenewDate(Date renewDate) {
		this.renewDate = renewDate;
	}
	

}
