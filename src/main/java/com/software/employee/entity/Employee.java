package com.software.employee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "employee")
@Entity
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name = "salary")
	private float salary;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="employee_project",joinColumns = @JoinColumn(name="emp_id"), inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> projects;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonManagedReference(value="emp_pan")
	private Pancard pancard;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonManagedReference(value="emp_account")
	private List<BankAccount> bankAccounts;
	
	public Employee() {
		super();
	}

	public Employee(int emp_id, String emp_name, String designation, String gender, float salary,
			List<Project> projects, Pancard pancard, List<BankAccount> bankAccounts) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;
		this.projects = projects;
		this.pancard = pancard;
		this.bankAccounts = bankAccounts;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Pancard getPancard() {
		return pancard;
	}

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", designation=" + designation + ", gender="
				+ gender + ", salary=" + salary + ", projects=" + projects + ", pancard=" + pancard + ", bankAccounts="
				+ bankAccounts + "]";
	}

	

}
