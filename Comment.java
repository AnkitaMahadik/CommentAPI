package com.cms.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="Comments")
public class Comment {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String by;
		private String text;
		private Date dateOfComment;
		
		public Comment() {
		}
		
		public Comment(Long id, String by, String text, Date dateOfComment) {
			super();
			this.id = id;
			this.by = by;
			this.text = text;
			this.dateOfComment = dateOfComment;
		}
		

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBy() {
			return by;
		}
		public void setBy(String by) {
			this.by = by;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Date getDateOfComment() {
			return dateOfComment;
		}
		public void setDateOfComment(Date dateOfComment) {
			this.dateOfComment = dateOfComment;
		}
		
}
