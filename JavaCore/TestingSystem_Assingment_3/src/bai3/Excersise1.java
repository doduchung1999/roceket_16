package bai3;

import java.util.Scanner;

public class Excersise1 {

	public static void main(String[] args) {
		Question1();
		Question2va3();
		Question4();
		}
	static void Question1() {
		float Salary1 ;
		float Salary2 ;
		Salary1 = (float) 5240.5;
		Salary2 = (float) 100970.005;
		int aSalary1 = (int) Salary1;
		int bSalary2 = (int) Salary2;
		System.out.println("luong acc 1: "+ aSalary1);
		System.out.println("luong acc 2: "+ bSalary2);
	}
	static void Question2va3() {
		int min = 0;
		int max = 99999;
		int a = (int) ((Math.random() * max) + min);
		if (a<10) {
			String b = String.valueOf(a);
			System.out.println("So co 5 chu so la: "+"0000" + b);
		}else if(a<100) {
			String b = String.valueOf(a);
			System.out.println("So co 5 chu so la: "+"000" + b);
		}else if(a<1000) {
			String b = String.valueOf(a);
			System.out.println("So co 5 chu so la: "+"00" + b);
		}else if(a<10000) {
			String b = String.valueOf(a);
			System.out.println("So co 5 chu so la: "+"0" + b);
		}else 
			System.out.println("so co 5 chu so la: "+ a);
		
//	Question3
		if (a<10) {
			String b = String.valueOf(a);
			System.out.println("2 chu so cuoi la: "+"0" + b);
		}else if(a<100) {
			String b = String.valueOf(a);
			System.out.println("2 chu so cuoi la: " + b);
		}else if(a<1000) {
			String b = String.valueOf(a);
			System.out.println("2 chu so cuoi la: "+b.substring(1));
		}else if(a<10000) {
			String b = String.valueOf(a);
			System.out.println("2 chu so cuoi la: " + b.substring(2));
		}else { 
			String b = String.valueOf(a);
			System.out.println("2 chu so cuoi la: "+ b.substring(3) );
		}
	}
	static void Question4(){
		Scanner scanner = new Scanner(System.in);
		int a, b;
		System.out.println("Nhap so a, b:");
		a = scanner.nextInt();
		b = scanner.nextInt();
		float c = (float)a/b;
		System.out.println("thuong a/b = "+ c);
	}
	
}
