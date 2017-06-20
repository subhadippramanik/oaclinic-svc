package com.oaclinic.doctor;

import org.springframework.data.repository.CrudRepository;

public interface DcotorRepository extends CrudRepository<Doctor, Integer> {

	public Doctor findById(int id);
}
