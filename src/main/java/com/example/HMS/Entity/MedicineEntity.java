package com.example.HMS.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MedicineRecords")
public class MedicineEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dosage;
	private LocalDate expiryDate; // e.g., 2025-12-31
	private String manufacturer; // e.g., "Cipla"
	private String type;

	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patients;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PatientEntity getPatients() {
		return patients;
	}

	public void setPatients(PatientEntity patients) {
		this.patients = patients;
	}



	public MedicineEntity(int id, String name, String dosage, LocalDate expiryDate, String manufacturer, String type,
			PatientEntity patients) {
		super();
		this.id = id;
		this.name = name;
		this.dosage = dosage;
		this.expiryDate = expiryDate;
		this.manufacturer = manufacturer;
		this.type = type;
		this.patients = patients;
		
	}

	public MedicineEntity() {
		super();
	
	}

	
}
