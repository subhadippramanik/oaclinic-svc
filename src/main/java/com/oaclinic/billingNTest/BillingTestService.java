package com.oaclinic.billingNTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingTestService {

	@Autowired
	private BillingsRepository billingsRepository;

	@Autowired
	private TestDetailsRepository testDetailsRepository;

	public void addbilltest(BillingNTest billntest) {

		Bill bill = billntest.getBill();
		billingsRepository.save(bill);

		List<TestDetails> testDetails = billntest.getTestDetails();
		for (TestDetails tds : testDetails) {
			tds.setBill(bill);
			testDetailsRepository.save(tds);
		}
	}

}
