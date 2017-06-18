package com.oaclinic.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static Logger LOGGER = Logger.getLogger(TestController.class);

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	public List<Test> getAllTests(@RequestHeader("session-id") String sessionId) {
		return testService.getAllTests();
	}
	
	@RequestMapping(value = "/test/name/{testName}", method = RequestMethod.GET)
	public Test getTestByName(@PathVariable String testName, @RequestHeader("session-id") String sessionId) {
		return testService.getTestByName(testName);
	}
	
	@RequestMapping(value = "/test/id/{id}", method = RequestMethod.GET)
	public Test getTestById(@PathVariable String id, @RequestHeader("session-id") String sessionId) {
		return testService.getTestById(id);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public HttpStatus addTest(@RequestBody Test test, @RequestHeader("session-id") String sessionId) {
		testService.addTest(test);
		return HttpStatus.CREATED;
	}
}
