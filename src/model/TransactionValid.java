package model;

import java.util.ArrayList;
import java.util.List;
/*
 
   validate all the entered data in transaction window
   
   * amount
   * date
   * name
   
 * */ 
public class TransactionValid {
	
	public boolean isDouble(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public boolean isInt(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public boolean isDateValid(String date) {
		if(date.length() != 8) return false; 
	
		String d = date.substring(0, 2);
		String m = date.substring(3, 5);
		String y =date.substring(6);
		
		if(date.charAt(2) != '/' || date.charAt(5) != '/' ) {
			return false;
		}
		
		if(!isInt(d) || !isInt(m) || !isInt(y)) return false;
		
		int day = Integer.parseInt(d);
		int month = Integer.parseInt(m);
		int year = Integer.parseInt(y);
		
		if(day>31 || day<1  || month>12 ||month <1 || year<19 || year >25) return false;
		
		return true;
	}
	
	public boolean isValidIndex(String index,List<Record> allRecords) {
		if(!isInt(index)) {
			return false;
		}
		
		System.out.println(allRecords.size());
		if(allRecords.size()<Integer.parseInt(index) || Integer.parseInt(index) <1) return false;
		return true;
		
	}
}
