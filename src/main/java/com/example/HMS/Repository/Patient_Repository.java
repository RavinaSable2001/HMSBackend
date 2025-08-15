package com.example.HMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HMS.Entity.MedicineEntity;
import com.example.HMS.Entity.PatientEntity;


public interface Patient_Repository  extends JpaRepository<PatientEntity,Integer>{

	  List <PatientEntity> findByDoctor_DoctorId(int doctorId);
}
