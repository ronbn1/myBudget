package model;

import java.io.Serializable;

public class Category implements Serializable{

	String type;
	public Category(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
