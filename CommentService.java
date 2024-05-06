package com.cms.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.cms.model.Comment;
import com.cms.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	CommentRepository repository;
	
	
	public ResponseEntity<?> getAllComments() 
	{
		List<Comment> cList=repository.findAll();
		if (cList.isEmpty())
			return new ResponseEntity<String>("No records available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Comment>>(cList, HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<?> createComment(Comment comment)
	{
		Comment com= repository.save(comment);
		return new ResponseEntity<Comment>(com, HttpStatus.OK);
	    
	}
	
	
	public ResponseEntity<?> updateComment(Comment comment) 
	{   if(repository.existsById(comment.getId()))
	{
		Comment com= repository.save(comment);
		return new ResponseEntity<Comment>(com, HttpStatus.OK);
	}
	else
		return new ResponseEntity<String>("No Id exist", HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<?> deleteComment(@PathVariable("id")  long id) 
	{
		if(repository.existsById(id)) {
			Optional<Comment> op = repository.findById(id);
			Comment cb=op.get();
			repository.deleteById(id);
			return new ResponseEntity<Comment>(cb, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("No Id exist", HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<?> getCommentsByUsername(@RequestParam String username)
	{
		List<Comment> cList = repository.findByBy(username);
		if(cList.isEmpty())
			return new ResponseEntity<String>("No Records", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Comment>>(cList, HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<?> getCommentsByDate(@RequestParam Date date)
	{
		List<Comment> cList =repository.findByDateOfComment(date);
		if(cList.isEmpty())
			return new ResponseEntity<String>("No records", HttpStatus.NOT_FOUND);
	 else
		return new ResponseEntity<List<Comment>>(cList, HttpStatus.OK);
	}
	
}



