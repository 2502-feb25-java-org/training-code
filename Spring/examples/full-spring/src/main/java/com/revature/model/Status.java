package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ERS_REIM_STATUS")
public class Status {
	
	@Id
	@Column(name="STATUS_ID")
	@SequenceGenerator(name="S_ID_GEN", sequenceName="ERS_STATUS_ID", allocationSize=1)
	@GeneratedValue(generator="S_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	private String status;
	
	public Status() {}

	public Status(String status) {
		super();
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
