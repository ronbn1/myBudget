package model;

import java.io.Serializable;
import java.util.*;

public class RecurringIncome extends Record implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date renewDate;
	public RecurringIncome(String name, double amount, Currency currency, Date date, Category category) {
		super(name, amount, currency, date, category);
		
		this.renewDate = renewDate;
	}
	
	
	public Date getRenewDate() {
		return renewDate;
	}
	public void setRenewDate(Date renewDate) {
		this.renewDate = renewDate;
	}
	

}
