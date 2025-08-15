package com.example.HMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HMS.Entity.MedicineEntity;
import com.example.HMS.Repository.Medicine_Repository;
import com.example.HMS.Repository.Patient_Repository;

@Service
public class MedicineService {

	@Autowired
	private Medicine_Repository medrepo;

	@Autowired
	private Patient_Repository patientRepo; 
	
    public List<MedicineEntity> getMedicinesByDoctor(int doctorId) {
       return medrepo.findByDoctorId(doctorId);
    }

	public List<MedicineEntity> getAllMedicine() {
		return medrepo.findAll();
	}

	public MedicineEntity getById(int id) {
		return medrepo.findById(id).orElseThrow(() -> new RuntimeException("ID not fount with id" + id));
	}
	public MedicineEntity saveMedicine(MedicineEntity m, int patientId) {
	    // Fetch the patient by ID
	    var patient = patientRepo.findById(patientId)
	            .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));
	    
	    // Set the patient to the medicine
	    m.setPatients(patient); // ✅ Ensure you have setPatients() in entity
	    return medrepo.save(m);
	}

	public MedicineEntity updateMedicine(MedicineEntity medupdate, int id) {
		MedicineEntity newmed = medrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Medicine not found with this id:" + id));

		newmed.setName(medupdate.getName());
		newmed.setDosage(medupdate.getDosage());
		newmed.setExpiryDate(medupdate.getExpiryDate());
		newmed.setManufacturer(medupdate.getManufacturer());
		newmed.setType(medupdate.getType());
		newmed.setPatients(medupdate.getPatients());
		return medrepo.save(newmed);

	}

	public void deletemedicine(int id) {
		medrepo.deleteById(id);
	}
}
