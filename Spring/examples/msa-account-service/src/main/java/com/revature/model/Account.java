package com.revature.model;

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
	private int customerid;
	private double balance;
	
	public Account() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
}
