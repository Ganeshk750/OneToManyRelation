package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
