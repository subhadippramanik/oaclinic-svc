package com.oaclinic.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static Logger LOGGER = Logger.getLogger(TestController.class);

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	public List<Test> getAllTests() {		
		return testService.getAllTests();
	}
	
	@RequestMapping(value = "/test/name/{testName}", method = RequestMethod.GET)
	public Test getTestByName(@PathVariable String testName) {
		return testService.getTestByName(testName);
	}
	
	@RequestMapping(value = "/test/id/{id}", method = RequestMethod.GET)
	public Test getTestById(@PathVariable String id) {
		return testService.getTestById(id);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public HttpStatus addTest(@RequestBody Test test) {
		testService.addTest(test);
		return HttpStatus.CREATED;
	}
	
	@RequestMapping(value = "/test/id/{id}", method = RequestMethod.POST)
	public HttpStatus updateTest(@PathVariable int id, @RequestBody Test test) {
		test.setId(id);
		try {
			testService.updateTest(test);
			return HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return HttpStatus.NOT_ACCEPTABLE;
	}
	
}
