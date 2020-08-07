package com.ganesh.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.apis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
