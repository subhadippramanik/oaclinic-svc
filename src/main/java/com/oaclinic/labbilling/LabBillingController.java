package com.oaclinic.labbilling;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabBillingController {
	
	@Autowired
	private LabBillingService labBillingDao;
	
	@RequestMapping(method= RequestMethod.POST, value="/labbillings")
	public void addbilldetails(@RequestBody LabBilling labBilling){
		labBillingDao.addBillDetails(labBilling);
	}
	
	@RequestMapping(value="/labbillings")
	  public List<LabBilling> showLabBillings() {	 
	   List<LabBilling> billings = labBillingDao.getAllLabBilling();
	  	 return billings;	
  }	   
 
  @RequestMapping(value="/labbilling/{patientid}")
	  public LabBilling checkUser(@PathVariable double patientid)throws ParseException {	 
	    LabBilling billing = labBillingDao.getAllLabBillingById(patientid);
	  	 return billing;	
  }
}
