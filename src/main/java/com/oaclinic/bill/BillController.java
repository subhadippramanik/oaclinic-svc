package com.oaclinic.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(value="/billing", method=RequestMethod.POST)
	public HttpStatus addBill(@RequestBody Bill bill){
		billService.addBill(bill);
		return HttpStatus.CREATED;
	}
}
