package com.example.HMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HMS.Entity.PatientEntity;
import com.example.HMS.Repository.Patient_Repository;

@Service
public class PatientService {
	
	@Autowired
	private Patient_Repository patientrepo;
	
	
	public List<PatientEntity> getPatientsByDoctorId(int doctorId) {
	    return patientrepo.findByDoctor_DoctorId(doctorId);
	}
	public List<PatientEntity>getAllPatients()
	{
		return  patientrepo.findAll();
	}
	
	public PatientEntity getPatientById(int id)
	{
		return patientrepo.findById(id).orElseThrow(()->new RuntimeException("Patient Not found By Given "+id));
		
		
	}
	
	
	
	public PatientEntity savePatient(PatientEntity p)
	{
		return  patientrepo.save(p);
	}
	
	
	public PatientEntity updatePatient(PatientEntity updatep,int id)
	{
		
		
		PatientEntity newpatient=patientrepo.findById(id).orElseThrow(()->new RuntimeException("Patient Not Found By Given "+id));
	
		newpatient.setName(updatep.getName());
		newpatient.setDisease(updatep.getDisease());
		newpatient.setContactNo(updatep.getContactNo());
		newpatient.setDoctor(updatep.getDoctor());
	    newpatient.setMedicine(updatep.getMedicine());
		
		return patientrepo.save(newpatient);
		
		
	}
	
	public void deletePatients(int id)
	{
		patientrepo.deleteById(id);
	}

	
	
}
