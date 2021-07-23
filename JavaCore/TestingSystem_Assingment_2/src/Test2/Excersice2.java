package Test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import taoData.Account;

public class Excersice2 {

	public static void main(String[] args) {
		Ques1();
		Ques2();
		Ques3();
		Ques4();
		Ques5();
		Ques6();
	}
	static void Ques1() {
		int a= 5;
		System.out.printf("%d%n", a);
	}
	static void Ques2() {
		int a= 100000000;
		System.out.printf("%d%n", a);
	}
	static void Ques3() {
		float a = 5.234234f;
		System.out.printf("%5.4f%n", a);
	}
	static void Ques4() {
		String a = "Nguyen Van A";
		System.out.printf("Ho va ten: "+ a + "\n");
		System.out.printf("Ten toi la: \""+ a + "\" va toi dang doc than\n");
	}
	static void Ques5() {
		String time = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(time);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}
	static void Ques6() { 
		System.out.printf("|%-8s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-30s|%n","id","userName","email","FullName","phong","chuc vu","group","ngay tao");
	}
}
