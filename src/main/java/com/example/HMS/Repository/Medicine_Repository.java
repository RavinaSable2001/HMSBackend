package com.example.HMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.HMS.Entity.MedicineEntity;


public interface Medicine_Repository extends JpaRepository<MedicineEntity,Integer> {
	
	@Query("SELECT m FROM MedicineEntity m WHERE m.patients.doctor.id = :doctorId")
    List<MedicineEntity> findByDoctorId(@Param("doctorId") int doctorId);

	

}
