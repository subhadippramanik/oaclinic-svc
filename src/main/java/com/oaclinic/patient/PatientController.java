package com.oaclinic.patient;

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
public class PatientController {

	private static Logger LOGGER = Logger.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> readAllPatient() {
		return patientService.readAllPatient();
	}

	@RequestMapping(value = "/patient/name/{patientName}", method = RequestMethod.GET)
	public List<Patient> getByPatientName(@PathVariable String patientName) {
		return patientService.getByPatientName(patientName);
	}

	@RequestMapping(value = "/patient/id/{id}", method = RequestMethod.GET)
	public Patient getById(@PathVariable String id) {
		return patientService.getById(id);
	}

	@RequestMapping(value = "/patient/address/{address}", method = RequestMethod.GET)
	public List<Patient> getByAddress(@PathVariable String address) {
		return patientService.getByAddress(address);
	}

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public HttpStatus createPatient(@RequestBody Patient patient) {
		patientService.createPatient(patient);
		return HttpStatus.CREATED;
	}

	@RequestMapping(value = "/patient/id/{id}", method = RequestMethod.POST)
	public HttpStatus updatePatientById(@PathVariable int id, @RequestBody Patient patient) {
		patient.setId(id);
		try {
			patientService.updatePatient(patient);
			return HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return HttpStatus.NOT_ACCEPTABLE;
	}
}
