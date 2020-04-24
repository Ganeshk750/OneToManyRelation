package com.ganesh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Student extends AbstractPersistable<Long> {
	
  private String studentId;
  private String name;
  private String branch;
  private String email;
  
  @OneToMany(targetEntity=Address.class, mappedBy="student", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  private Set<Address> addresses;
  
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Set<Address> getAddresses() {
	return addresses;
}
public void setAddresses(Set<Address> addresses) {
	this.addresses = addresses;
}
  
  

  
  
  
}
