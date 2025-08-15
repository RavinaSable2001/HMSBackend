package com.example.HMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HMS.Entity.PatientEntity;
import com.example.HMS.service.PatientService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/patients")
public class PatientsController {

	@Autowired
	private PatientService ps;

	 @GetMapping("/doctor/{doctorId}")
	    public List<PatientEntity> getPatientsByDoctor(@PathVariable int doctorId) {

	        return ps.getPatientsByDoctorId(doctorId);
	    }
	@GetMapping("/getAllPatients")
	public List<PatientEntity> getAllPatients() {
		return ps.getAllPatients();
	}

	@GetMapping("/getById/{patientId}")
	public PatientEntity getById(@PathVariable int patientId)
	{
		return ps.getPatientById( patientId);
	}

	@PostMapping("/savePatients")
	public PatientEntity savePatients(@RequestBody PatientEntity p)
	{
		return ps.savePatient(p);
	}
	
	@PutMapping("/updatePatients/{patientId}")
	public PatientEntity updatePatients(@RequestBody PatientEntity p,@PathVariable int patientId)
	{
		return ps.updatePatient(p, patientId);
	}
	
	
	@DeleteMapping("/deletePatient/{patientId}")
	public String deletepatients(@PathVariable int patientId )
	{
		ps.deletePatients(patientId);
		 return "Patient with ID " + patientId + " deleted successfully!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
