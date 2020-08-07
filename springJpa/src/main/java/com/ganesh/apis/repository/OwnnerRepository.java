package com.ganesh.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.apis.model.Ownner;

@Repository
public interface OwnnerRepository extends JpaRepository<Ownner, Long> {

}
