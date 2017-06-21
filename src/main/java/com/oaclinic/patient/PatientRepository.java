package com.oaclinic.patient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	public Patient findById(int id);

	public List<Patient> findByName(String name);

	public List<Patient> findByAddress(String address);
}
