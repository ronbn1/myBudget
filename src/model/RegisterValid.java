package model;

public class RegisterValid {
	
	/*
	 check if all the fields are empty (valid)
	 * */
	public String inputValid(String username,String fName, String lName,String password) {
		if(username.compareTo("")==0 ) {
			return "User name can't be empty";
		}
		else if(fName.compareTo("")==0 ) {
			return "First name can't be empty";
		}
		else if(lName.compareTo("")==0 ) {
			return "Last name can't be empty";
		}
		else if(password.compareTo("")==0 ) {
			return "Password can't be empty";
		}
		return "";	
	}
	
}
