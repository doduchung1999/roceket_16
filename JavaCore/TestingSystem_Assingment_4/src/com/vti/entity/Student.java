package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float diemHocLuc;

	public Student(int id, String name, String hometown) {
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.diemHocLuc = (float) 0;
	}

	public float getDiemHocLuc() {
		return diemHocLuc;
	}

	public void setDiemHocLuc(float diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}
	
	public void congDiem(float diemHocLuc) {
		this.diemHocLuc = this.diemHocLuc + diemHocLuc;
	}

	@Override
	public String toString() {
		String rank = null;
		if(this.diemHocLuc<4) {
			rank = "yeu";
		}else if(this.diemHocLuc<6) {
			rank = "trung binh";
		}else if(this.diemHocLuc<8) {
			rank = "kha";
		}else if(this.diemHocLuc<=10) {
			rank = "gioi";
		}
		return "Student [id=" + id + ", name=" + name + ", hometown=" + hometown + ", diemHocLuc=" + diemHocLuc +", rank =" + rank + "]";
	}
	
	

}
