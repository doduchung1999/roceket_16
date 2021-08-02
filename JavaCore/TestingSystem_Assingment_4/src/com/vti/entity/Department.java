package com.vti.entity;

public class Department {
		public int id;
		public String name;
		public void printD() {
			System.out.println("id: "+ id);
			System.out.println("ten: "+ name);
			System.out.println();
		}
		public Department() {
			super();
		}
		public Department(String name) {
			super();
			this.id = 0;
			this.name = name;
		}
		
	

}
