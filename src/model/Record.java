package model;

import java.util.*;

public abstract class  Record {

	private String name;
	private double amount;
	private Currency currency;
	private Date date;
	private Category category;
	
	public Record(String name, double amount, Currency currency, Date date, Category category) {
		super();
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.date = date;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
