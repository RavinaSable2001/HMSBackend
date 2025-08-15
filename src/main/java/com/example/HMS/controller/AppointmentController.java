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

import com.example.HMS.Entity.AppointmentsEntity;
import com.example.HMS.service.AppointmentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/appoint")
public class AppointmentController {
	
	@Autowired
	private AppointmentService as;
	
	@GetMapping("/doctor/{doctorId}")
	public List<AppointmentsEntity> getAppointmentsByDoctor(@PathVariable int doctorId) {
	    return as.getAppointmentsByDoctor(doctorId);
	}
	
	@GetMapping("/getAll")
	public List<AppointmentsEntity>getAllAppoin()
	{
		return as.getAllAppointements();
	}
	
	@GetMapping("/getById/{id}")
	public AppointmentsEntity getById(@PathVariable Long id)
	{
		return as.getById(id);
	}
	
	
	@PostMapping("/saveAppoin")
	public AppointmentsEntity saveAppoin(@RequestBody AppointmentsEntity a) {
	    System.out.println("== Saving Appointment ==");
	    System.out.println("Doctor ID: " + (a.getDoctor() != null ? a.getDoctor().getDoctorId() : "null"));
	    System.out.println("Patient ID: " + (a.getPatient() != null ? a.getPatient().getPatientId() : "null"));
	    return as.saveAppoin(a);
	}
	@PutMapping("/updateAppoin/{id}")
	public AppointmentsEntity updateAppoin(@RequestBody AppointmentsEntity a,@PathVariable Long id)
	{
		return as.updateAppointments(a, id);
	}
	
	@DeleteMapping("/deleteAppoin/{id}")
	public String deleteAppoin(@PathVariable Long id)
	{
		 as.deleteApoointments(id);
		 return "Appointments with id"+id+"was deleted";
	}
	
	
	
	

}
