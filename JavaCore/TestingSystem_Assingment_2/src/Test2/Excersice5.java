package Test2;

import java.time.LocalDate;
import java.util.Scanner;

import taoData.*;
import taoData.Position.PositionName;

public class Excersice5 {
	public static void main(String[] args) {
		Ques1();
		Ques2();
		Ques3();
		Ques4();
		Ques5();
		Ques6();
		Ques7();
	}

	static void Ques1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ques1");
		System.out.println("Nhap 3 so: ");
		int a, b, c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		System.out.print("a: " + a + "; b: " + b + "; c: " + c);
	}

	static void Ques2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ques2");
		System.out.println("Nhap 2 so thuc: ");
		float f1, f2;
		f1 = sc.nextFloat();
		f2 = sc.nextFloat();
		System.out.println("f1: " + f1 + "; f2: " + f2);
	}

	static void Ques3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ques3");
		System.out.println("Nhap ho ten: ");
		String s = sc.next();
		System.out.println("ho ten: " + s);
	}

	private static void Ques4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ques4");
		System.out.println("Nhap ngay sinh: ");
		int date = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		LocalDate ngaysinh = LocalDate.of(year, month, date);
		System.out.println("ngay sinh: " + ngaysinh);
	}

	static void Ques5() {
		System.out.println();
		System.out.println("Ques5");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap account ");

		Account acc = new Account();
		System.out.print("Nhap ID: ");

		acc.id = sc.nextInt();
		System.out.print("Nhap email: ");
		acc.email = sc.next();
		System.out.print("Nhap userName: ");
		acc.userName = sc.next();
		System.out.print("Nhap fullName: ");
		acc.fullName = sc.next();
		System.out.print("Nhap PositionId: ");

		int posNum = sc.nextInt();
		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.DEV;
			acc.pName = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.TEST;
			acc.pName = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.SCRUM_MASTER;
			acc.pName = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.pName = pos4;
			break;
		default:
			Position pos5 = new Position();
			pos5.name = null;
			acc.pName = pos5;
		}
		System.out.println("Account, ID: " + acc.id + "Email: " + acc.email + " UserName: " + acc.userName
				+ " FullName: " + acc.fullName + "Position: " + acc.pName.name);
	}

	static void Ques6() {
		System.out.println();
		System.out.println("Ques6");
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap department");
		Department D = new Department();
		System.out.print("nhap id: ");
		D.id = sc.nextInt();
		System.out.print("Nhap ten: ");
		D.name = sc.next();
		System.out.println("ID: " + D.id + "; Ten:" + D.name);
	}
	
	static void Ques7() {
		System.out.println();
		System.out.println("Ques7");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i%2==0) {
			System.out.println("dayla so chan");
		}else
			System.out.println("ko phai so chan");
	}
}
