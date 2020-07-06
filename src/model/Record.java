package model;

import java.io.Serializable;
import java.util.*;

public abstract class  Record  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double amount;
	private Currency currency;
	private Date date;
	private Category category;
	private static int count = 0;
	private int id;
	public Record(String name, double amount, Currency currency, Date date, Category category) {
		super();
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.date = date;
		this.category = category;
		id = count++;
	}

	public static int lastIndex() {
		return count-1;
	}
	public int getId() {
		return id;
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

	public String getCategoryType() {
		return category.getType();
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
