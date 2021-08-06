package Polymorphism;

import java.util.ArrayList;
import java.util.Scanner;


public class Exceesice1 {
	private Scanner sc;
	private ArrayList<Student> listStudent;

	public Exceesice1() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();

	}
	void taoStudent() {
//		Student st = new Student("ah", 1);
//		Student st2 = new Student("ah", 2);
//		Student st3 = new Student("ah", 3);
//		Student st4 = new Student("ah", 3);
//		Student st5 = new Student("ah", 3);
//		Student st6 = new Student("ah", 2);
//		Student st7 = new Student("ah", 2);
//		Student st8 = new Student("ah", 2);
//		Student st9 = new Student("ah", 1);
//		Student st1 = new Student("ah", 1);
		for (int i = 0; i < 10; i++) {
			Student st = new Student("ng "+i, i/3);
			listStudent.add(st);
		}
		
	}
	void diemDanh() {
		System.out.println("ca lop diem danh");
		for (Student student : listStudent) {
			student.diemDanh();
		}
	}
	void nhom1HocBai() {
		System.out.println("nhom 1 hoc bai");
		for (Student student : listStudent) {
			if(student.getGroup() == 1) {
				student.hocBai();
			}
		}
	}
	void nhom2DonVS() {
		System.out.println("nhom 2 don vs");
		for (Student student : listStudent) {
			if(student.getGroup() == 2) {
				student.diDonVS();
			}
		}
	}
	public static void main(String[] args) {
		Exceesice1 ex1 = new Exceesice1();
		ex1.taoStudent();
		ex1.diemDanh();
		ex1.nhom1HocBai();
		ex1.nhom2DonVS();
	}

}
