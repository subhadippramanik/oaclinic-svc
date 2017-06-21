package com.oaclinic.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> readAllPatient() {
		List<Patient> patients = new ArrayList<>();
		patientRepository.findAll().forEach(patients::add);
		return patients;
	}

	public void createPatient(Patient patient) {
		patientRepository.save(patient);
	}

	public void updatePatient(Patient patient) {
		Patient patientPresent = patientRepository.findById(patient.getId());
		if (Objects.nonNull(patientPresent)) {
			patientRepository.save(patient);
		} else {
			throw new RuntimeException("no such that patient found");
		}
	}

	public List<Patient> getByPatientName(String patientName) {
		return patientRepository.findByName(patientName);
	}

	public Patient getById(String id) {
		return patientRepository.findById(Integer.valueOf(id));
	}

	public List<Patient> getByAddress(String address) {
		return patientRepository.findByAddress(address);
	}

}
