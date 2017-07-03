package com.oaclinic.billingNTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bill {

	@Id
	@Column(name = "PatientId")
	private long patientId;

	@Column(name = "PaMobile")
	private String paMobile;

	@Column(name = "BillNo")
	private String billNo;

	@Column(name = "BillDate")
	private String billDate;

	@Column(name = "Name")
	private String name;

	@Column(name = "AgeYrs")
	private String ageYrs;

	@Column(name = "AgeMonth")
	private String ageMonth;

	@Column(name = "AgeDays")
	private String ageDays;

	@Column(name = "Sex")
	private String sex;

	@Column(name = "Address1")
	private String address1;

	@Column(name = "DoctorsId")
	private double doctorsId;

	@Column(name = "DoctorsNM")
	private String doctorsNM;
	
	

	@Column(name = "TestCost")
	private double testCost;

	@Column(name = "TessAmnt")
	private double tessAmnt;

	@Column(name = "Advance")
	private double advance;

	@Column(name = "AgentId")
	private double agentId;

	@Column(name = "AgentNM")
	private String agentNM;
	
	
	private Set<TestDetails> testDetails;
	
	@OneToMany(targetEntity = TestDetails.class, mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<TestDetails> getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(Set<TestDetails> testDetails) {
		this.testDetails = testDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPatientid() {
		return patientId;
	}

	public void setPatientid(long patientid) {
		this.patientId = patientid;
	}

	public String getPaMobile() {
		return paMobile;
	}

	public void setPaMobile(String paMobile) {
		this.paMobile = paMobile;
	}

	public String getBillNo() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime current = LocalDateTime.now();
		return dtf.format(current);
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgeYrs() {
		return ageYrs;
	}

	public void setAgeYrs(String ageYrs) {
		this.ageYrs = ageYrs;
	}

	public String getAgeMonth() {
		return ageMonth;
	}

	public void setAgeMonth(String ageMonth) {
		this.ageMonth = ageMonth;
	}

	public String getAgeDays() {
		return ageDays;
	}

	public void setAgeDays(String ageDays) {
		this.ageDays = ageDays;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public double getDoctorsId() {
		return doctorsId;
	}

	public void setDoctorsId(double doctorsId) {
		this.doctorsId = doctorsId;
	}

	public String getDoctorsNM() {
		return doctorsNM;
	}

	public void setDoctorsNM(String doctorsNM) {
		this.doctorsNM = doctorsNM;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	public double getTessAmnt() {
		return tessAmnt;
	}

	public void setTessAmnt(double tessAmnt) {
		this.tessAmnt = tessAmnt;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public double getAgentId() {
		return agentId;
	}

	public void setAgentId(double agentId) {
		this.agentId = agentId;
	}

	public String getAgentNM() {
		return agentNM;
	}

	public void setAgentNM(String agentNM) {
		this.agentNM = agentNM;
	}

}

