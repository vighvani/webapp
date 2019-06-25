package webApp.model;

public class Medicines {

	private int medID;
	private String medName;
	private String description;
	private int patientID;

	public Medicines(int medicineID, String medicineName, String description, int patientID) {
		this.medID = medicineID;
		this.medName = medicineName;
		this.description = description;
		this.patientID = patientID;
	}

	public int getMedicineID() {
		return medID;
	}

	public void setMedicineID(int medicineID) {
		this.medID = medicineID;
	}

	public String getMedicineName() {
		return medName;
	}

	public void setMedicineName(String medicineName) {
		this.medName = medicineName;
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
