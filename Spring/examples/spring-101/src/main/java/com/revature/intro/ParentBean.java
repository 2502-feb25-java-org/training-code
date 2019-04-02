package com.revature.intro;

public class ParentBean {
	
	private int id;
	private HelloSpring dependency;
	
	public ParentBean() {}

	public ParentBean(int id, HelloSpring dependency) {
		super();
		this.id = id;
		this.dependency = dependency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HelloSpring getDependency() {
		return dependency;
	}

	public void setDependency(HelloSpring dependency) {
		this.dependency = dependency;
	}

	@Override
	public String toString() {
		return "ParentBean [id=" + id + ", dependency=" + dependency + "]";
	}
	
	
	
	

}
