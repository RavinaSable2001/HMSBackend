package com.example.HMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HMS.Entity.AppointmentsEntity;
import com.example.HMS.Entity.DoctorEntity1;

@Repository
public interface Appointment_Repository extends JpaRepository<AppointmentsEntity,Long>
{
	  List<AppointmentsEntity> findByDoctor_DoctorId(int doctorId);
	
	
	
}
