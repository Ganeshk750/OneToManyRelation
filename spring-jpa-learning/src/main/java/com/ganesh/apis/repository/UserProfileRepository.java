package com.ganesh.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.apis.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
