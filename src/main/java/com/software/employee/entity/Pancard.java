package com.software.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pancard implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pancard_id")
	private int pancardId;
	
	@Column(name="holder_name")
	private String holderName;
	
	@OneToOne
	@JoinColumn(name="emp_id")
	@JsonBackReference(value="emp_pan")
	private Employee employee;
	
	public Pancard() {
		super();
	}

	public Pancard(int pancardId, String holderName) {
		super();
		this.pancardId = pancardId;
		this.holderName = holderName;
	}

	public int getPancardId() {
		return pancardId;
	}
	
	public void setPancardId(int pancardId) {
		this.pancardId = pancardId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	@Override
	public String toString() {
		return "Pancard [pancardId=" + pancardId + ", holderName=" + holderName + "]";
	}
	
	
	
	

}
