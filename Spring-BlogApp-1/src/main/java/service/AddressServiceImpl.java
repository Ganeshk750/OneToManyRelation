package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.model.Address;

import repository.AddressRepository;

@Service
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
		address.setStudent(studentRepo.findOne(address.getStudentId()));
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "{'message':'Address Deleted Successfully!!'}";
	}

}
