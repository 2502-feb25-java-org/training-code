package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * If there are a lot of queries in HQL or native SQL, there can 
 * be a lot of code throughout the application in a messy way
 * Hibernate's named queries allow us to define HQL or native SQL 
 * queries in a central location and use them anywhere in the code 
 */
@NamedQueries({
	@NamedQuery(name="getLongPosts", 
			query="FROM Post WHERE length(body)>250")
})


@Entity
@Table(name="BLOG_POST")
public class Post {

	@Id
	@Column(name="POST_ID")
	@SequenceGenerator(name="P_SEQ_GEN", sequenceName="P_SEQ", allocationSize=1)
	@GeneratedValue(generator="P_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String subject;
	private String body;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="AUTHOR_ID", nullable=false)
	private User author;
	
	public Post() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", subject=" + subject + ", body=" + body + ", author=" + author + "]";
	}
	
	
}
