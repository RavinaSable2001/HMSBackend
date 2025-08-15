package com.example.HMS.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIgnoreProperties("appoin")
@Entity
@Table(name = "doctors_records")
public class DoctorEntity1 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
 

   
    @Column(name = "doctor_id")
    private int doctorId;
    private String name;
    private String contactno;
    private String specialization;
    private String password;
    @Column(name = "role")
    private String role = "DOCTOR";  
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	private List<PatientEntity> patients;
	
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
    private List<AppointmentsEntity> appoin;
	
	 public String getRole() { return role; }
	    public void setRole(String role) { this.role = role; }
	
	
	public DoctorEntity1()
	{
		
	}
	
	public DoctorEntity1(int id,String name,String contactno,String specialization)
	{
		this.doctorId=id;
		this.name=name;
		this.contactno=contactno;
		this.specialization=specialization;
	}

	 public int getDoctorId() {
	        return doctorId;
	    }

	    public void setDoctorId(int doctorId) {
	        this.doctorId = doctorId;
	    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	
}
