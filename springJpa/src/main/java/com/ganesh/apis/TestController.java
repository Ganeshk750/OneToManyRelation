package com.ganesh.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.apis.model.Address;
import com.ganesh.apis.model.Car;
import com.ganesh.apis.model.Ownner;
import com.ganesh.apis.model.User;
import com.ganesh.apis.repository.AddressRepository;
import com.ganesh.apis.repository.CarRepository;
import com.ganesh.apis.repository.OwnnerRepository;
import com.ganesh.apis.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class TestController {
    
	private UserRepository userRepo;
	private AddressRepository addRepo;
	private CarRepository carRepo;
	private OwnnerRepository ownnRepo;
	
	@Autowired
	  public TestController(UserRepository userRepo, AddressRepository addRepo, CarRepository carRepo,
				OwnnerRepository ownnRepo) {
			super();
			this.userRepo = userRepo;
			this.addRepo = addRepo;
			this.carRepo = carRepo;
			this.ownnRepo = ownnRepo;
		}


    @GetMapping("/")
	public List<User> getAllUser() {
	 return userRepo.findAll();
	}
    

	@GetMapping("/car")
   	public List<Car> getAllCar() {
   	 return carRepo.findAll();
   	}
	
	@GetMapping("/ownner")
   	public List<Ownner> getAllOwnner() {
   	 return ownnRepo.findAll();
   	}
    
    @PostMapping("/create")
   	public User addingUser(@RequestBody User user) {
   	 return userRepo.save(user);
   	}
    
    @PostMapping("/add")
   	public Address addingAddress(@RequestBody Address address) {
   	 return addRepo.save(address);
   	}
}
