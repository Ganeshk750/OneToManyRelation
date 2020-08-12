package com.ganesh.apis.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ganesh.apis.model.Post;

public interface PostService {
	
	Page<Post> getAllPosts(Pageable pageable);
	Post createPost(Post post);
	Post updatePost(Long postId, Post postRequest);
	ResponseEntity<?> deletePost(Long postId);
}
