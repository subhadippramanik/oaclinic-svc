package com.oaclinic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private static Logger LOGGER = Logger.getLogger(TestService.class);

	@Autowired
	private TestRepository testRepository;

	public List<Test> getAllTests() {
		List<Test> tests = new ArrayList<>();
		testRepository.findAll().forEach(tests::add);
		return tests;
	}

	public Test getTestByName(String testName) {
		return testRepository.findByTestName(testName);
	}

	public Test getTestById(String id) {
		return testRepository.findById(Integer.valueOf(id));
	}

	public void addTest(Test test) {
		testRepository.save(test);
	}

	public void updateTest(Test test) {
		Test testPresent = testRepository.findById(test.getId());
		if(Objects.nonNull(testPresent)) {
			testRepository.save(test);
		}	
	}
}
