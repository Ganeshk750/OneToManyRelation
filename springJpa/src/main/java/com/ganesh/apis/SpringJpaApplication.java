package com.ganesh.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ganesh.apis.model.Address;
import com.ganesh.apis.model.Car;
import com.ganesh.apis.model.Ownner;
import com.ganesh.apis.model.User;
import com.ganesh.apis.repository.AddressRepository;
import com.ganesh.apis.repository.CarRepository;
import com.ganesh.apis.repository.OwnnerRepository;
import com.ganesh.apis.repository.UserRepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	
	private CarRepository carRepository;
	private OwnnerRepository ownnerRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
    @Autowired
	public SpringJpaApplication(CarRepository carRepository, OwnnerRepository ownnerRepository) {
		super();
		this.carRepository = carRepository;
		this.ownnerRepository = ownnerRepository;
	}
    

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Car car = new Car();
		car.setCarName("Honda");
		carRepository.save(car);
		
		Car car1 = new Car();
		car1.setCarName("Mahindra");
		carRepository.save(car1);
		
		
		
		Ownner ow = new Ownner();
		ow.setName("Ganesh");
		ow.setCar(car1);
		ownnerRepository.save(ow);
		

		Ownner ow1 = new Ownner();
		ow1.setName("Aditya");
		ow1.setCar(car);
		ownnerRepository.save(ow1);
		
		
		Address ad = new Address("Bangalore");
		addressRepository.save(ad);
		
		User us = new User();
		us.setName("Ganesh");
		us.setAddress(ad);
		userRepository.save(us);
		
	}

	
}
