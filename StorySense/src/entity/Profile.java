package entity;

import java.sql.Date;

public class Profile {

	//User | Point | picUrl | Birthday   | Firstname | Surname
	private int Account;
	private Date birthDay;
	private String FirstName,Surname,imageURL,dateString;
	
	//Change level into point
	
	public int getAccount() {
		return Account;
	}
	public void setAccount(int account) {
		Account = account;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDateString() {
		return dateString;
	}
	/**
	 * Set the birthday based on the year, month and day provided
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setBdayString(int year,int month,int day) {
		//this.dateString = dateString;3909-04-17
		dateString=year+"-"+month+"-"+day;
		birthDay=new Date(year-1900,month,day);
	}
	
	
	
	
}
