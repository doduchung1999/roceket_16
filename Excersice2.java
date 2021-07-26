package bai3;

import java.time.LocalDate;

public class Excersice2 {

	public static void main(String[] args) {
		Ques1();
	}
	
	public static class Account{
		public String email;
		public String userName;
		public String fullname;
		public LocalDate createDate;
	}
	
	static void Ques1() {
		Account[] listAcc = new Account[5];
		for (int i = 0; i < listAcc.length; i++) {
			Account acc = new Account();
			acc.email = " Email " +(i+1);
			acc.fullname = "fullname" + (i+1);
			acc.userName = "Username" + (i+1);
			acc.createDate = LocalDate.now();
			listAcc[i] = acc;
			System.out.println(acc.email);
			System.out.println(acc.fullname);
			System.out.println(acc.userName);
			System.out.println(acc.createDate);
		}
	}
}
