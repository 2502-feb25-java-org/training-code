package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Account {
	
	@Id
	@SequenceGenerator(allocationSize=1, name="acc_seq_gen", sequenceName="acc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acc_seq_gen")
	private int id;
	private int customerId;
	private double balance;
	
	public Account() {}
	
	public Account(int id, int customerId, double balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
