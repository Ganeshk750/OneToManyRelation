package com.ganesh.apis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ganesh.apis.model.Comment;

public interface CommentService {
	
	Page<Comment> getAllCommentsByPostId(Long postId, Pageable pageable);
	
	Comment createComment(Long postId ,Comment comment);
	 
	Comment updateComment(Long postId, Long commentId, Comment commentRequest);
	
	ResponseEntity<?> deleteComment(Long postId, Long commentId);
}
