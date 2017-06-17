package com.oaclinic.labbilling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabBillingService {
	
	@Autowired
	private LabBillingRepository labBillingRepository;
	
	public List<LabBilling> getAllLabBilling() {
		List<LabBilling> labBillings= new ArrayList<>();
		labBillingRepository.findAll().forEach(labBillings :: add);
		System.out.println("passsss22");
		return labBillings;
	}

	public LabBilling getAllLabBillingById(double patientid) {
		return labBillingRepository.findOne(patientid);
	}

	public void addBillDetails(LabBilling labBilling) {
		System.out.println("passsss");
		labBillingRepository.save(labBilling);
	}
	
}
