package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ganesh.model.Address;

import repository.AddressRepository;

public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	private StudentService studentRepo;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, StudentService studentRepo ) {
		this.addressRepository = addressRepository;
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Address> addressList() {
		
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
	
		return addressRepository.getOne(id);
	}

	@Override
	public Address addAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "Address Deleted Successfully!!";
	}

}
