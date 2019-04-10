/*
* @author Peter Alagna
*/ 

package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="HERO")
@XmlRootElement(name = "hero")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="heroSequence")
	@SequenceGenerator(name="heroSequence", sequenceName="HERO_SEQ", allocationSize=1)
	@Column(name="H_ID")
	@XmlAttribute
	private int id;
	
	@Column(name="H_NAME")
	@XmlElement
	private String name;
	
	@Column(name="H_SUPER_POWER")
	@XmlElement
	private String superPower;
	
	@Column(name="H_HAS_CAPE")
	@XmlElement
	private boolean hasCape;
	
	public Hero() {}

	public Hero(String name, String superPower, boolean hasCape) {
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}
	
	public Hero(int id, String name, String superPower, boolean hasCape) {
		this.id = id;
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public boolean isHasCape() {
		return hasCape;
	}

	public void setHasCape(boolean hasCape) {
		this.hasCape = hasCape;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", superPower=" + superPower + ", hasCape=" + hasCape + "]";
	}
}
