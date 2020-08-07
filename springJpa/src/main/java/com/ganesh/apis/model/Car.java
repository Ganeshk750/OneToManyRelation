package com.ganesh.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String carName;
	
	@OneToOne(mappedBy="car")
	private Ownner ownner;
	
	public Car() {}

	public Car(String carName) {
		super();
		this.carName = carName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Ownner getOwnner() {
		return ownner;
	}

	public void setOwnner(Ownner ownner) {
		this.ownner = ownner;
	}

	
	
	

}
