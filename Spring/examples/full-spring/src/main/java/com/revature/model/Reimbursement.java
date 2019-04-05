package com.revature.model;

public class Reimbursement {
	
	private int id; 
	private double amount;
	private User author;
	private User resolver;
	private Type type;
	private String description; 
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
