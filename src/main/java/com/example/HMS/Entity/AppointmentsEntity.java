package com.example.HMS.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Appointments")
public class AppointmentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	private String status;


	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity1 doctor;

	public AppointmentsEntity(Long id, LocalDate appointmentDate, String status, PatientEntity patient,
			DoctorEntity1 doctor) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
	}

	public AppointmentsEntity() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DoctorEntity1 getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity1 doctor) {
		this.doctor = doctor;
	}

}
