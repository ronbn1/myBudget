package model;

import java.io.Serializable;

public class Currency implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;

	public Currency(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
