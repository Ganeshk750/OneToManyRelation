package com.ganesh.apis.controller;

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

import com.ganesh.apis.model.Comment;
import com.ganesh.apis.service.CommentService;

@RestController
public class CommentController {
	
	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/posts/{postId}/comments")
	public Page<Comment> getAllCommentByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable) {
		return commentService.getAllCommentsByPostId(postId, pageable);
	}

	@PostMapping("/posts/{postId}/comments")
	public Comment addComment(@PathVariable(value = "postId") Long postId, @RequestBody Comment comment) {
		return commentService.createComment(postId, comment);
	}

	@PutMapping("/posts/{postId}/comments/{commentId}")
	public Comment editComment(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "commentId") Long commentId, @RequestBody Comment commentRequest) {

		return commentService.updateComment(postId, commentId, commentRequest);
	}

	@DeleteMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "commentId") Long commentId) {
		return commentService.deleteComment(postId, commentId);
	}

}
