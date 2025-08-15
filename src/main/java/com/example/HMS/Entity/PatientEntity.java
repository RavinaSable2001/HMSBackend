package com.example.HMS.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIgnoreProperties("appoin")
@Entity
@Table(name = "patients_records")
public class PatientEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")            // map DB column patient_id to this field
    @JsonProperty("patientId")              // JSON key sent/received as patientId
    private int patientId;
	private String name;
	private String disease;
	private String contactNo;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity1 doctor;

	@OneToMany(mappedBy = "patients", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<MedicineEntity> medicine;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<AppointmentsEntity> appoin;

	public int getPatientId() {
		return  patientId;
	}

	public void setPatientId(int patient_id) {
		this. patientId= patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public DoctorEntity1 getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity1 doctor) {
		this.doctor = doctor;
	}

	public PatientEntity() {
		super();

	}

	public List<MedicineEntity> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<MedicineEntity> medicine) {
		this.medicine = medicine;
	}

	public List<AppointmentsEntity> getAppoin() {
		return appoin;
	}

	public void setAppoin(List<AppointmentsEntity> appoin) {
		this.appoin = appoin;
	}

	public PatientEntity(int id, String name, String disease, String contactNo, DoctorEntity1 doctor) {
		super();
		this. patientId = id;
		this.name = name;
		this.disease = disease;
		this.contactNo = contactNo;
		this.doctor = doctor;
	}

}
