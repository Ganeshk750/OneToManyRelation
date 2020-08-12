package com.ganesh.apis.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ganesh.apis.exception.ResourceNotFoundException;
import com.ganesh.apis.model.Post;
import com.ganesh.apis.repository.PostRepository;
import com.ganesh.apis.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Page<Post> getAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Long postId, Post postRequest) {
		return postRepository.findById(postId).map(post -> {
		 post.setTitle(postRequest.getTitle());	
		 post.setDescription(postRequest.getContent());
		 post.setContent(postRequest.getContent());
		 return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

	@Override
	public ResponseEntity<?> deletePost(Long postId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

}
