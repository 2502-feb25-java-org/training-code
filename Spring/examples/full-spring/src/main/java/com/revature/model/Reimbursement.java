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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ERS_REIMBURSEMENT")
public class Reimbursement {
	
	@Id
	@Column(name="REIM_ID")
	@SequenceGenerator(name="REIM_ID_GEN", sequenceName="ERS_REIM_ID", allocationSize=1)
	@GeneratedValue(generator="REIM_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id; 
	private double amount;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHOR_ID", nullable=false)
	private User author;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="RESOLVER_ID")
	private User resolver;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="TYPE_ID", nullable=false)
	private Type type;
	private String description; 

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="STATUS_ID", nullable=false)
	private Status status;
	
	public Reimbursement() {}
	
	public Reimbursement(double amount, User author, User resolver, Type type, String description, Status status) {
		super();
		this.amount = amount;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
