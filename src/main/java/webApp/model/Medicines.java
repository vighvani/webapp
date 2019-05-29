package webApp.model;

public class Medicines {

	private int medicineID;
	private String medicineName;
	private String description;
	private int patientID;

	public Medicines(int medicineID, String medicineName, String description, int patientID) {
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.description = description;
		this.patientID = patientID;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

}
