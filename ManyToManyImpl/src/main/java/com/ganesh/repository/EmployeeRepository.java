package com.ganesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.ganesh.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
