package com.vti.backend;

import com.vti.entity.Student;

public class Excersice4 {
	
	public static void Demo() {
		Student student1 = new Student( 1, "st1", "ha noi");
		Student student2 = new Student( 2, "st2", "da nang");
		Student student3 = new Student( 3, "st3", "hcm");
		student1.congDiem(4f);
		student2.congDiem(6f);
		student3.congDiem(8f);
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}
	
	
}
