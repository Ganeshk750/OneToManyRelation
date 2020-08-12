package com.ganesh.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.apis.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
