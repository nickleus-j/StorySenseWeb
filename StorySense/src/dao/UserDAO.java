package dao;

import java.util.List;

import entity.User;
import entity.Profile;
public abstract class UserDAO {

	public abstract void addUser(User U);
	public abstract void addUser(User U,Profile P);
	public abstract void changeActivation(User U,int active);
	public abstract void updateUser(User U);
	public abstract User getUser(String Name,String Password);
	public abstract User findUserWithName(String name);
	public abstract List<User> getUsers();
	public abstract List<User> getUsersWithRole(int role);
	public abstract List<User> getTopLearners();
	public abstract boolean authenticateUser(String Name,String Password);
	
}
