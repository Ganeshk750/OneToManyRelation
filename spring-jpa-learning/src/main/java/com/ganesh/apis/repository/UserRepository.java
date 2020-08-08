package com.ganesh.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.apis.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
