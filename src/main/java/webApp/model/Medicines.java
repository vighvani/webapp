package webApp.model;

import javax.persistence.Entity;

@Entity
public class Medicines {

	private int medID;
	private String medName;
	private String description;
	private int patientID;

	public Medicines(int medID, String medName, String description, int patientID) {
		this.medID = medID;
		this.medName = medName;
		this.description = description;
		this.patientID = patientID;
	}

	public int getMedID() {
		return medID;
	}

	public void setMedID(int medID) {
		this.medID = medID;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
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
