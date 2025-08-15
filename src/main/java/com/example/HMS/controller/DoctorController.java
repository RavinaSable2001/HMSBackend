package com.example.HMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HMS.Entity.DoctorEntity1;
import com.example.HMS.Repository.Doctor_Repository;
import com.example.HMS.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/doctors")
public class DoctorController 
{
	@Autowired DoctorService ds;
	@Autowired Doctor_Repository docrepo;
	
	@PostMapping("/doctor/login")
	public ResponseEntity<?> loginDoctor(@RequestBody DoctorEntity1 loginRequest) {
	    DoctorEntity1 doctor = docrepo.loginDoctor(
	        loginRequest.getName(),
	        loginRequest.getPassword()
	    );

	    if (doctor != null) {
	        return ResponseEntity.ok(doctor); // returns doctor info including doctorId
	    } else {
	        return ResponseEntity.status(401).body("Invalid credentials");
	    }
	}
	
	
	@GetMapping("/getAllDoctors")
	public List<DoctorEntity1> getAllDoctor()
	{
		return ds.getAllDr();
	}
	
	@GetMapping("/getDrById/{id}")
	public DoctorEntity1 getDrById(@PathVariable int doctorId)
	{
		return ds.getDoctorById(doctorId);
	}

	@PostMapping("/saveDr")
	public DoctorEntity1 saveDr(@RequestBody DoctorEntity1 dr)
	{
	    System.out.println("Doctor received: " + dr.getName() + ", " + dr.getContactno() + ", " + dr.getSpecialization());
		return ds.addDoctors(dr);
	}
	
	
	@PutMapping("/updateDr/{doctorId}")
	public DoctorEntity1 updatedr( @RequestBody DoctorEntity1 updatedr,@PathVariable int doctorId)
	{
		return ds.updateDoctors(updatedr, doctorId);
	}
	
	@DeleteMapping("/deleteDr/{doctorId}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorId) {
	    ds.deleteDoctors(doctorId);
	    return ResponseEntity.ok().build();  // ✅ Send 200 OK back to frontend
	}
}
