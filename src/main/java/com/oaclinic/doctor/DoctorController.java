package com.oaclinic.doctor;

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
public class DoctorController {

	private static Logger LOGGER = Logger.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public List<Doctor> showAll() {
		return doctorService.showAll();
	}

	@RequestMapping(value = "/doctors/id/{id}", method = RequestMethod.GET)
	public Doctor showById(@PathVariable String id) {
		return doctorService.getdoctorById(id);
	}

	@RequestMapping(value = "/doctor", method = RequestMethod.POST)
	public HttpStatus addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return HttpStatus.CREATED;
	}

	@RequestMapping(value = "/doctor/id/{id}", method = RequestMethod.POST)
	public HttpStatus updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		doctor.setId(id);
		try {
			doctorService.updateDoctor(doctor);
			return HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return HttpStatus.NOT_ACCEPTABLE;
	}
}
