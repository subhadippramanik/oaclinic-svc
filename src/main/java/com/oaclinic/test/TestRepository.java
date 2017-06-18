package com.oaclinic.test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TestRepository  extends CrudRepository<Test, Integer>{
	
	public Test findById(int id);
	public Test findByTestName(String testName);
	public List<Test> findByTestType(String testType);
}
