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
@Table(name="ERS_USER_ROLE")
public class Role {
	
	@Id
	@Column(name="ROLE_ID")
	@SequenceGenerator(name="ROLE_ID_GEN", sequenceName="ERS_ROLE_ID", allocationSize=1)
	@GeneratedValue(generator="ROLE_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	private String role;
	
	public Role() {}
	
	public Role(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
