package com.cms.repository;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Comment;

@Repository
public interface CommentRepository extends  JpaRepository<Comment,Long>{
	List<Comment> findByBy(String username);
	List<Comment> findByDateOfComment(Date date);
}
