package Test2;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Locale;

import taoData.Account;
import taoData.Department;
import taoData.Group;
import taoData.Position;
import taoData.Position.PositionName;

public class Excersice1v3 {

	public static void main(String[] args) {
		// Khoi tao du lieu
//	Department
		Department D1 = new Department();
		D1.id = 1;
		D1.name = "phong sale";

		Department D2 = new Department();
		D2.id = 2;
		D2.name = "phong dev";

		Department D3 = new Department();
		D3.id = 3;
		D3.name = "phong bao ve";
//	Position
		Position P1 = new Position();
		P1.id = 1;
		P1.name = PositionName.DEV;

		Position P2 = new Position();
		P2.id = 2;
		P2.name = PositionName.PM;

		Position P3 = new Position();
		P3.id = 3;
		P3.name = PositionName.SCRUM_MASTER;

		Position P4 = new Position();
		P4.id = 4;
		P4.name = PositionName.TEST;
//	GROUP	
		Group G1 = new Group();
		G1.id = 1;
		G1.name = "Java fresher";
		G1.createDate = LocalDate.now();

		Group G2 = new Group();
		G2.id = 1;
		G2.name = "C# fresher";
		G2.createDate = LocalDate.now();

		Group G3 = new Group();
		G3.id = 3;
		G3.name = "C++ fresher";
		G3.createDate = LocalDate.now();
//	Account
		Account A1 = new Account();
		A1.id = 1;
		A1.userName = "abc";
		A1.email = "abc@mail";
		A1.fullName = "nguyen van a";
		A1.dName = D3;
		A1.pName = P2;
		A1.createDate = LocalDate.of(2020, 02, 12);
		Group[] groupAcc1 = { G1, G2 };
		A1.groups = groupAcc1;

		Account A2 = new Account();
		A2.id = 2;
		A2.userName = "abcd";
		A2.email = "abcd@mail";
		A2.fullName = "nguyen van ab";
		A2.dName = D1;
		A2.pName = P1;
		A2.createDate = LocalDate.of(2020, 02, 13);
		Group[] groupAcc2 = { G1, G2, G3 };
		A2.groups = groupAcc2;

		Account A3 = new Account();
		A3.id = 3;
		A3.userName = "abcasw";
		A3.email = "abccv@mail";
		A3.fullName = "nguyen van asd";
		A3.dName = D2;
		A3.pName = P2;
		A3.createDate = LocalDate.now();
		Group[] groupAcc3 = { G1, G3 };
		A3.groups = groupAcc3;
//	GroupAccount
		G1.member = new Account[] { A1, A2 };
		G2.member = new Account[] { A1, A3 };
		G3.member = new Account[] { A2 };

//		Question1
		System.out.println("Question1");
		if (A2.dName == null) {
			System.out.println(" Nhan vien nay chua co phong ban.");
		} else {
			System.out.println("Nhan vien thuoc phong ban:" + A2.dName.name);
		}
//		Question2
		System.out.println("question2");
		if (A2.groups == null) {
			System.out.println("Nhan vien nay chua co group");
		} else {
			int countGroup = A2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Nhan vien nay la Java Fresher, C# Freshser");
			}
			if (countGroup == 3) {
				System.out.println("Nhan vien nay la nguoi quan trong");
			}
			if (countGroup >= 4) {
				System.out.println("Nhan vien nay la nguoi tam chuyen, tham gia tat ca cac group");
			}
		}
//	Question3
		System.out.println();
		System.out.println("Question3");
		System.out.println(
				A2.dName == null ? "Nhan vien chua co phong ban" : "Phong ban cua nhan vien: " + A2.dName.name);
//	Question4
		System.out.println();
		System.out.println("Question4");
		System.out
				.println(A1.pName.name.toString() == "DEV" ? "Nguoi nay la developer" : "nguoi nay ko phai developer");
//	Question5
		System.out.println();
		System.out.println("Question5");
		if (G1.member == null) {
			System.out.println("group1  chua co thanh vien");
		} else {
			int countMember = G1.member.length;
			switch (countMember) {
			case 1:
				System.out.println("Nhom 1 co 1 thanh vien");
				break;
			case 2:
				System.out.println("Nhom 1 co 2 thanh vien");
				break;
			case 3:
				System.out.println("Nhom 1 co 3 thanh vien");
				break;
			default:
				System.out.println("Nhom 1co nhieu thanh vien");
				break;
			}
		}
//	Question6
		System.out.println();
		System.out.println("Quetion6");
		if (A2.groups == null) {
			System.out.println("Nhan vien chua co group");
		} else {
			int countGroup = A2.groups.length;
			switch (countGroup) {
			case 1:
				System.out.println("Group cua nhan vien la Java Fresher, C# fresher");
				break;
			case 2:
				System.out.println("Group cua nhan vien la Java Fresher, C# fresher");
				break;
			case 3:
				System.out.println("Nhan vien quan trong");
				break;
			default:
				System.out.println("Nhan vien nhieu chuyen");
			}
		}
//	Question7
		System.out.println();
		System.out.println("Question7");
		String positionName = A1.pName.name.toString();
		switch (positionName) {
		case "DEV":
			System.out.println("La developer");
			break;
		default:
			System.out.println("Khong la developer");
			break;
		}
//	Question8
		System.out.println();
		System.out.println("Question8");
		Account[] accArray = { A1, A2, A3 };
		for (Account account : accArray) {
			System.out.println("AccoutId: " + account.id);
			System.out.println("Email: " + account.email);
			System.out.println("Name: " + account.fullName);
		}
//	Question9
		System.out.println();
		System.out.println("Question9");
		Department[] dArray = { D1, D2, D3 };
		for (Department department : dArray) {
			System.out.println("id: " + department.id);
			System.out.println("name: " + department.name);
		}
//	Question10
		System.out.println();
		System.out.println("Question10");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println("Thong tin acc " + (i + 1) + ": ");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Fullname: " + accArray[i].fullName);
			System.out.println("phong ban: " + accArray[i].dName.name);
		}
//	Question11
		System.out.println();
		System.out.println("Question11");
		for (int i = 0; i < dArray.length; i++) {
			System.out.println("Thong tin acc " + (i + 1) + ": ");
			System.out.println("id: " + dArray[i].id);
			System.out.println("name: " + dArray[i].name);
		}
//	Question12
		System.out.println();
		System.out.println("Question12");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin acc " + (i + 1) + ": ");
			System.out.println("id: " + dArray[i].id);
			System.out.println("name: " + dArray[i].name);
		}
//	Question13
		System.out.println();
		System.out.println("Question13");
		for (int i = 0; i < accArray.length; i++) {
			if (i != 1) {
				System.out.println("Thong tin acc " + (i + 1) + ": ");
				System.out.println("id: " + accArray[i].id);
				System.out.println("UserName: " + accArray[i].userName);
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Fullname: " + accArray[i].fullName);
				System.out.println("phong ban: " + accArray[i].dName.name);
				System.out.println("Chuc vu: " + accArray[i].pName.name);
				System.out.println("Ngay tao: " + accArray[i].createDate);
				System.out.println("group: " + accArray[i].listGroup());
			}
		}
//	Question14
		System.out.println();
		System.out.println("Question14");
		for (int i = 0; i < accArray.length; i++) {
			if (i < 4) {
				System.out.println("Thong tin acc " + (i + 1) + ": ");
				System.out.println("id: " + accArray[i].id);
				System.out.println("UserName: " + accArray[i].userName);
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Fullname: " + accArray[i].fullName);
				System.out.println("phong ban: " + accArray[i].dName.name);
				System.out.println("Chuc vu: " + accArray[i].pName.name);
				System.out.println("Ngay tao: " + accArray[i].createDate);
				System.out.println("group: " + accArray[i].listGroup());
			}
		}
//	Question15
		System.out.println();
		System.out.println("Question15");
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.print(i + " ");
		}
//	Question16
		System.out.println();
		System.out.println("Question16");
		int i = 0;
		while (i < 20) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
//	question17
		System.out.println();
		System.out.println("Question17");
		int i1 = 0;
		do {
			if (i1 % 2 == 0) {
				System.out.print(i1 + " ");
			}
			i1++;
		} while (i1 < 20);
		Ques1();
	}
	static void Ques1() {
//		Question1 ex3
			System.out.println();
			System.out.println("Question1 Ex3");
			Locale locate = new Locale("vn", "VN");
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locate);
			String date = dateFormat.format(Account.createDate);
			System.out.println(date);
	}
}
