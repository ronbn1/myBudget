package mybudget;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import model.Model;
import model.User;
import view.View;

public class MyBudget {

	public static MyBudget myBudget = null;
	private Model m;
	private View v;
	private Controller c;
	private User user = null;

	private MyBudget() {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(v, m);

	}

	/*
	 create myBudget - singleton
	 */
	public static MyBudget getMyBudget() {
		if (myBudget == null)
			myBudget = new MyBudget();
		return myBudget;
	}

	public Controller getController() {return c;}
	public Model getModel() {return m;}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	/*
	 save user data to mybudget.txt
	 */
	public void save() {

		File tempFile = new File("mybudget.txt");
		boolean exists = tempFile.exists();
		ObjectOutputStream oos = null;
		if (exists) {
			ArrayList<User> users = null;
			ObjectInputStream ois = null;

			try {
				ois = new ObjectInputStream(new FileInputStream("mybudget.txt"));
				users = (ArrayList<User>) ois.readObject();

				users.add(user);
				oos = new ObjectOutputStream(new FileOutputStream("mybudget.txt"));
				oos.writeObject(users);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ois != null)
					try {
						ois.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
			}

		} else {

			ArrayList<User> users = new ArrayList<User>();
			users.add(user);
			try {
				oos = new ObjectOutputStream(new FileOutputStream("mybudget.txt"));
				oos.writeObject(users);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}
	
	/*
	  load specific user by username an password from mybudget.txt
	 
	 */
	public boolean load(String userName, String password) {

		ArrayList<User> users = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("mybudget.txt"));
			users = (ArrayList<User>) ois.readObject();

			for (User u : users) {
				if (u.getUserName().compareTo(userName) == 0 && u.getPassword().compareTo(password) == 0) {
					this.user = u;
					return true;
				}
			}

		} catch (Exception e) {
			//e.printStackTrace();
			
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		return false;
	}


	/*
	  load all users from mybudget.txt
	 this function return arrayList of all users
	 called by update function
	 */
	public ArrayList<User> load() {

		ArrayList<User> users = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("mybudget.txt"));
			users = (ArrayList<User>) ois.readObject();

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		return null;
	}
	

	/*
	  update data in mybudget.txt 
	 
	 1. load all users data
	 2. updated specific user
	 */

	public void update() throws ClassNotFoundException {
		ArrayList<User> users = load();

		for (User u : users) {
			if (u.getUserName().compareTo(user.getUserName()) == 0) {
				u.setBudget(user.getBudget());
			}
		}

		// ----------
		File tempFile = new File("mybudget.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(tempFile);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectOutputStream oos = null;

		ObjectInputStream ois = null;

		try {

			oos = new ObjectOutputStream(new FileOutputStream("mybudget.txt"));
			oos.writeObject(users);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}

	}

	// -------
	
	
	

}
