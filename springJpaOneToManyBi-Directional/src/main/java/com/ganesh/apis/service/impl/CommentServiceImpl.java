package com.ganesh.apis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ganesh.apis.exception.ResourceNotFoundException;
import com.ganesh.apis.model.Comment;
import com.ganesh.apis.repository.CommentRepository;
import com.ganesh.apis.repository.PostRepository;
import com.ganesh.apis.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	private PostRepository postRepository;
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	@Override
	public Page<Comment> getAllCommentsByPostId(Long postId, Pageable pageable) {
		
		return commentRepository.findByPostId(postId, pageable);
	}

	@Override
	public Comment createComment(Long postId, Comment comment) {
		
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

	@Override
	public Comment updateComment(Long postId, Long commentId, Comment commentRequest) {
		if(!postRepository.existsById(postId)) {
			throw new ResourceNotFoundException("PostId " + postId + " not found");
		}
		return commentRepository.findById(commentId).map(comment -> {
			comment.setText(commentRequest.getText());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    
	}

	@Override
	public ResponseEntity<?> deleteComment(Long postId, Long commentId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    
		
	}

}
