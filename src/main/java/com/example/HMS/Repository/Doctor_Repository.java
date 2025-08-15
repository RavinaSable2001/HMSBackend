package com.example.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.HMS.Entity.DoctorEntity1;
import com.example.HMS.Entity.MedicineEntity;


public interface Doctor_Repository  extends JpaRepository<DoctorEntity1,Integer>{
	
	 
	@Query("SELECT d FROM DoctorEntity1 d WHERE TRIM(LOWER(d.name)) = LOWER(TRIM(:name)) AND d.password = :password")
	DoctorEntity1 loginDoctor(@Param("name") String name, @Param("password") String password);

}
