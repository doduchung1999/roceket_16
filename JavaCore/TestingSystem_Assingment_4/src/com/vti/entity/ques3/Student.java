package com.vti.entity.ques3;

public abstract class Student extends Person {

	private int id;
	
	public Student(String name, int id) {
		super(name);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	



}
