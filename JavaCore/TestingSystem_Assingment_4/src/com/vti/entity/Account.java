package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int id;
	public String userName;
	public String email;
	public String fullName;
	public Department dName;
	public static LocalDate createDate;
	public Group[] groups;

	public void printA() {
		System.out.println("id: " + id);
		System.out.println("username: " + userName);
		System.out.println("email: " + email);
		System.out.println("ten: " + fullName);
		System.out.println("phong: " + dName.name);
		System.out.println("ngay tao: " + createDate);
		System.out.println("tham gia cac group: " + listGroup());
		System.out.println();
	}

	public Account() {
		super();
	}

	public Account(int id, String userName, String email, String fullName) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
	}

	public String listGroup() {
		String s = "list group [";
		for (Group group : groups) {
			s += group.name + ", ";
		}
		s += "]";
		return s;

	}
}
