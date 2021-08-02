package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDate createDate;
	public Account[]  member;
	public void printG() {
		System.out.println("id: "+ id);
		System.out.println("ten group: "+ name);
		System.out.println("nguoi tao: "+ creator.fullName);
		System.out.println("ngay tao: "+ createDate);
		System.out.println("cac thanh vien: "+ member);
		System.out.println();
	}
}
