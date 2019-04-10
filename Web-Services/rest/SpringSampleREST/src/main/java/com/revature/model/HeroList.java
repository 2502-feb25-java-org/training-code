/*
* @author Peter Alagna
*/ 

package com.revature.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * JAX-B Doesn't know how to marshal List<>, or Set<>, or anything on the Java API.
 * 
 * We need to provide this wrapper with specific XML Binding
 *
 */
@XmlRootElement(name = "heroList")
@XmlAccessorType(XmlAccessType.FIELD)
public class HeroList {
	
	@XmlElement(name = "hero")
	private List<Hero> heroList;
	
	public HeroList() {}

	public HeroList(List<Hero> heroes) {
		this.heroList = heroes;
	}

	public List<Hero> getHeroList() {
		return heroList;
	}

	public void setHeroList(List<Hero> heroes) {
		this.heroList = heroes;
	}
}
