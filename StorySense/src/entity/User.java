package entity;

/**
 * This represents the User record that is represented in mysql
 * as a table
 * @author nickleus
 *
 */
public class User {

	//accountID | Name  | Password                         | role | Active 
	private int accountID,Role;//Active;
	private String Name,Password;
	private boolean isActive;
	
	public enum Roles{
		admin(0),learner(1),reviewer(2);
		private final int mask;

		private Roles(int mask){this.mask = mask;}
    	public int getValue(){	return mask;}
    	public boolean isAdmin(int num){return num==admin.mask;}
    	public boolean isLearner(int num){return num==learner.mask;}
    	public boolean isReviwer(int num){return num==reviewer.mask;}
	}
	
	public static boolean isLearnerAge(int age){
		return age>=6&&age<=12;
	}
	
	public int determineRole(String role){
		if(role.equalsIgnoreCase("learner"))
			return Roles.learner.mask;
		else if(role.equalsIgnoreCase("reviewer"))
			return Roles.reviewer.mask;
		else return Roles.admin.mask;
	}
	
	
	/* Name: observer | Password: observe
	 * Make User Name unique
	 * Access and Modify methods
	 */
	public void setActiveStatus(int ans){
		if(ans>=1)
			isActive=true;
	}
	public boolean isAccountActive(){return isActive;}
	
	
	public int getAccountID() {return accountID;}
	public void setAccountID(int accountID) {this.accountID = accountID;}
	public int getRole() {return Role;}
	public void setRole(int role) {Role = role;}
	public String getName() {return Name;}
	public void setName(String name) {Name = name;}
	public String getPassword() {return Password;}
	public void setPassword(String password) {Password = password;}
	public void setRole(String roleText){Role=determineRole(roleText);}
	
	
	
}
