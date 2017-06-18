package com.oaclinic.test;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
public class Test {

	@Id
	private int id;
	@NotNull
	private String testName;
	@NotNull
	private String testType;
	@NotNull
	private Double testCost;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		if (Objects.nonNull(testName)) {
			this.testName = testName;
		}
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		if (Objects.nonNull(testType)) {
			this.testType = testType;
		}
	}
	public Double getTestCost() {
		return testCost;
	}
	public void setTestCost(Double testCost) {
		if (Objects.nonNull(testCost)) {
			this.testCost = testCost;
		}
	}
	
}
