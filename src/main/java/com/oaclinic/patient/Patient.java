package com.oaclinic.patient;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
public class Patient {

	@Id
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String address;

	public Patient(String name, String address) {
		super();
		this.name = name;
		this.address = address;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (Objects.nonNull(name)) {
			this.name = name;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (Objects.nonNull(address)) {
			this.address = address;
		}
	}

}
