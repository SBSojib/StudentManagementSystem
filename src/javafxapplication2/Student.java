package javafxapplication2;

public class Student extends Person {
	String fatherName;
	String motherName;
	String year;
	String semester;
	String address;
	String result;
	
	Student (String ID, String password, String fullName, String fatherName,
					String motherName, String year, String semester, String department,
							String phoneNumber, String email, String address, String result) {
		
		super (ID, password, fullName, department, phoneNumber, email);

		this.fatherName = fatherName;
		this.motherName = motherName;
		this.year = year;
		this.semester = semester;
		this.address = address;
		this.result = result;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public String getYear() {
		return year;
	}
	public String getSemester() {
		return semester;
	}
	public String getAddress() {
		return address;
	}
	public String getResult() {
		return result;
	}
}	





