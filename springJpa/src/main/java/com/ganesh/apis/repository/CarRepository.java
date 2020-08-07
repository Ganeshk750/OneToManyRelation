package com.ganesh.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.apis.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
