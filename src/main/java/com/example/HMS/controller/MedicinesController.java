package com.example.HMS.controller;
import com.example.HMS.Entity.MedicineEntity; 
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

import com.example.HMS.Entity.MedicineEntity;
import com.example.HMS.service.MedicineService;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin(origins = "http://localhost:4200") 
public class MedicinesController {
	
	
	@Autowired 
	private MedicineService ms;
	
	 @GetMapping("/doctor/{doctorId}")
	    public List<MedicineEntity> getMedicinesByDoctor(@PathVariable int doctorId) {
	        return ms.getMedicinesByDoctor(doctorId);
	    }
	
	@GetMapping("/getAll")
	public List<MedicineEntity> getAllMedicine()
	{
		return ms.getAllMedicine();
	}
	
	@GetMapping("/getById/{id}")
	public MedicineEntity getById(@PathVariable int id)
	{
		return ms.getById(id);
	}
	
	
	@PostMapping("/save/{patientId}")
	public MedicineEntity saveMedicineWithPatient( @RequestBody MedicineEntity m, @PathVariable int patientId) {
	    return ms.saveMedicine(m, patientId);
	}

	
	@PutMapping("/updateMedicine/{id}")
	public MedicineEntity updateMedicine(@RequestBody MedicineEntity m,@PathVariable int id)
	{
		return ms.updateMedicine(m, id);
	  
		
	}
	
	@DeleteMapping("/deleteMed/{id}")
	public String deleteMedi(@PathVariable int id)
	{
		ms.deletemedicine(id);
		return "Medicine with id"+id+"was deleted successfully......";
		
	}
	

}
