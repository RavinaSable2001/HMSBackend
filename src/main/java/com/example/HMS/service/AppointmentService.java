package com.example.HMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HMS.Entity.AppointmentsEntity;
import com.example.HMS.Repository.Appointment_Repository;
import com.example.HMS.Repository.Doctor_Repository;
import com.example.HMS.Repository.Patient_Repository;

@Service
public class AppointmentService {

	
	@Autowired
	private Appointment_Repository appoinrepo;

	// ✅ Add these two missing repositories
	@Autowired
	private Doctor_Repository doctorRepo;
	
	@Autowired
	private Patient_Repository patientRepo;

	public List<AppointmentsEntity> getAppointmentsByDoctor(int doctorId) {
        return appoinrepo.findByDoctor_DoctorId(doctorId);
    }

	public List<AppointmentsEntity> getAllAppointements() {
		return appoinrepo.findAll();
	}

	public AppointmentsEntity saveAppoin(AppointmentsEntity appoin) {
	    int doctorId = appoin.getDoctor().getDoctorId();
	    int patientId = appoin.getPatient().getPatientId();

	    appoin.setDoctor(doctorRepo.findById(doctorId)
	        .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId)));

	    appoin.setPatient(patientRepo.findById(patientId)
	        .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId)));

	    return appoinrepo.save(appoin);
	}


	public AppointmentsEntity getById(Long id) {
		return appoinrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Appointmenets not found with this " + id));
	}

	public void deleteApoointments(Long id) {
		appoinrepo.deleteById(id);
	}

	public AppointmentsEntity updateAppointments(AppointmentsEntity updateappoin, Long id) {

	    AppointmentsEntity newappoin = appoinrepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Appointments not found with this id " + id));

	    newappoin.setAppointmentDate(updateappoin.getAppointmentDate());
	    newappoin.setStatus(updateappoin.getStatus());

	    int doctorId = updateappoin.getDoctor().getDoctorId();
	    int patientId = updateappoin.getPatient().getPatientId();

	    newappoin.setDoctor(doctorRepo.findById(doctorId)
	        .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId)));

	    newappoin.setPatient(patientRepo.findById(patientId)
	        .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId)));

	    return appoinrepo.save(newappoin);
	}



}
