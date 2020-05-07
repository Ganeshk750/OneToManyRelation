package com.ganesh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	private Integer id;
	private String fristName;
	private String lastName;
	
	@ManyToMany
	private List<Skill> skills = new ArrayList<Skill>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	//Here we are adding skills into employee
	public void addSkill(Skill skill) {
		skills.add(skill);
		skill.getEmployees().add(this);
	}
    
	
	
	

}
