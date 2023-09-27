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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "project")
@Entity
public class Project implements Serializable{
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	
	@ManyToMany(mappedBy = "projects")
	@JsonBackReference
	private List<Employee> team;
	
	
	
	public Project() {
		super();
	}

	public Project(int projectId, String projectName, String description, String status, List<Employee> team) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.status = status;
		this.team=team;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public List<Employee> getTeam() {
		return team;
	}

	public void setTeam(List<Employee> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", status=" + status + ", team=" + team + "]";
	}

	
	
	

	
}
