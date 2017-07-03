package com.oaclinic.billingNTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestDetails {

	@Id
	private long patientTestDetailsId;
	private double testDetailsId;
	private String testNM;
	private String specNo;
	private String specDt;
	private double testRate;
	private String testType;
	private String testGrpName;

	private Bill bill;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPatientTestDetailsId() {
		return patientTestDetailsId;
	}

	public void setPatientTestDetailsId(long patientTestDetailsId) {
		this.patientTestDetailsId = patientTestDetailsId;
	}

	public double getTestDetailsId() {
		return testDetailsId;
	}

	public void setTestDetailsId(double testDetailsId) {
		this.testDetailsId = testDetailsId;
	}

	public String getTestNM() {
		return testNM;
	}

	public void setTestNM(String testNM) {
		this.testNM = testNM;
	}

	public String getSpecNo() {
		return specNo;
	}

	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}

	public String getSpecDt() {
		return specDt;
	}

	public void setSpecDt(String specDt) {
		this.specDt = specDt;
	}

	public double getTestRate() {
		return testRate;
	}

	public void setTestRate(double testRate) {
		this.testRate = testRate;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestGrpName() {
		return testGrpName;
	}

	public void setTestGrpName(String testGrpName) {
		this.testGrpName = testGrpName;
	}
}
