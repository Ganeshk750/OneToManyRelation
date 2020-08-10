package com.ganesh.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.apis.model.Post;
import com.ganesh.apis.service.PostService;

@RestController
public class PostController {
	
	private PostService postServie;

	@Autowired
	public PostController(PostService postServie) {
		this.postServie = postServie;
	}
	
	@GetMapping("/posts")
	public Page<Post> allPost(Pageable pageable){
	     return postServie.getAllPosts(pageable);
	}
	
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		return postServie.createPost(post);
	}

	@PutMapping("/posts/{postId}")
	public Post modifyPost(@PathVariable Long postId, @RequestBody Post postRequest) {
		return postServie.updatePost(postId, postRequest);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePosts(@PathVariable Long postId) {
		return postServie.deletePost(postId);
	}

}
