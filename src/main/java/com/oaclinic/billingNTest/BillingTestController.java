package com.oaclinic.billingNTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingTestController {
	
	@Autowired
	private BillingTestService billingTestService;

	@RequestMapping(value = "/addBilling", method= RequestMethod.POST)
	public HttpStatus addbilltest(@RequestBody BillingNTest billntest){
		billingTestService.addbilltest(billntest);
		return HttpStatus.OK;
	}
}
