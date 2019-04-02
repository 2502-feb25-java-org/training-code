package com.revature.autowired;

public class Employee {
	
	private int id;
	private String name;
	private Department dept;
	
	public Employee() {}

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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee " + id + ") name=" + name + ", dept=" + dept.getName() ;
	}
	
	

}
