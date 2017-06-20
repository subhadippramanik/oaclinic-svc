package com.oaclinic.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	private DcotorRepository doctorRepository;

	public List<Doctor> showAll() {
		List<Doctor> doctors = new ArrayList<>();
		doctorRepository.findAll().forEach(doctors::add);
		return doctors;
	}

	public Doctor getdoctorById(String id) {
		return doctorRepository.findById(Integer.valueOf(id));
	}

	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);

	}

	public void updateDoctor(Doctor doctor) {
		Doctor doctorPresent = doctorRepository.findById(doctor.getId());
		if(Objects.nonNull(doctorPresent)) {
			doctorRepository.save(doctor);
		} else {
			throw new RuntimeException("No such doctor found!");
		}
		
	}

}
