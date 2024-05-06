package com.cms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cms.model.Comment;
import com.cms.service.CommentService;
import java.util.*;

@RestController
@RequestMapping("/api/v2/comments")
class CommentController {

    @Autowired
    private CommentService cs;

    @GetMapping
    public ResponseEntity<?> getAllComments() {
        return cs.getAllComments();
    }
    
    @PostMapping("/insertComment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        return cs.createComment(comment);
    }
    
    @PutMapping("/updateComment")
    public ResponseEntity<?> updateComment(@RequestBody Comment updatedComment) {
    	return cs.updateComment(updatedComment);
    }
    @GetMapping("/search")
    public ResponseEntity<?> getCommentsByUsername(@RequestParam String username) {
        return cs.getCommentsByUsername(username);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getCommentsByDate(@RequestParam Date date) {
        return cs.getCommentsByDate(date);
    }

 
    @DeleteMapping("deleteComment/{id}")
    public void deleteComment(@PathVariable Long id) {
        cs.deleteComment(id);
    }
}
