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
@Table(name="ERS_REIM_TYPE")
public class Type {
	
	@Id
	@Column(name="TYPE_ID")
	@SequenceGenerator(name="T_ID_GEN", sequenceName="ERS_TYPE_ID", allocationSize=1)
	@GeneratedValue(generator="T_ID_GEN", strategy=GenerationType.SEQUENCE)	
	private int id;
	private String type;
	
	public Type() {}

	public Type(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
