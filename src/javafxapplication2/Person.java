package javafxapplication2;

public class Person {
	String ID;
	String password;
	String fullName;
	String department;
	String phoneNumber;
	String email;
	
	Person (String ID, String password, String fullName, String department, String phoneNumber, String email) {
		this.ID = ID;
		this.password = password;
		this.fullName = fullName;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getID() {
		return ID;
	}
	public String getPassword() {
		return password;
	}
	public String getFullName() {
		return fullName;
	}
	public String getDepartment() {
		return department;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
}



