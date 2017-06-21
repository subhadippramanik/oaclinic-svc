package com.oaclinic.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oaclinic.patient.Patient;
import com.oaclinic.patient.PatientRepository;

@Service
public class BillService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	public void addBill(Bill bill) { 
		
		Patient patient = new Patient(bill.getPatientName(), bill.getPatientAddress());
		patientRepository.save(patient);
		billRepository.save(bill);
	}

}
