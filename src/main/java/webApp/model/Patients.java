package webApp.model;

public class Patients {

	private int patientID;
	private String lastName;
	private String firstName;
	private String address;
	private int age;

	public Patients(int patientID , String lastName, String firstName, String address, int age) {
		this.patientID = patientID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.age = age;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
