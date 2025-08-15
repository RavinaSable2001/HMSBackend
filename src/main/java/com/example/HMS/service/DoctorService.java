package com.example.HMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HMS.Entity.DoctorEntity1;
import com.example.HMS.Repository.Doctor_Repository;

@Service
public class DoctorService 
{
  @Autowired
 private Doctor_Repository docrepo;
  
  public List<DoctorEntity1>getAllDr()
  {
	return docrepo.findAll();
	  
  }
  
  public DoctorEntity1 getDoctorById(int id) {
	    return docrepo.findById(id)
	                  .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
	}

  public DoctorEntity1 addDoctors(DoctorEntity1 dr)
  {
	  return docrepo.save(dr);
  }
  
  public DoctorEntity1 updateDoctors(DoctorEntity1 updatedr,int id)
  {
	
	  
	  DoctorEntity1 newdr1=docrepo.findById(id).orElseThrow(()->new RuntimeException("Doctor Not Found with " +id) );
	
	  newdr1.setName(updatedr.getName());
	  newdr1.setContactno(updatedr.getContactno());
	  newdr1.setSpecialization(updatedr.getSpecialization());
	  
	  return docrepo.save(newdr1);
  }
  
  
  public void deleteDoctors(int id)
  {
	 
	 docrepo.deleteById(id);
  }
  
  
  
}
