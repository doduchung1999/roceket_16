package bai3;

import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Excersice4 {

	public static void main(String[] args) {
//		Ques1();
//		Ques2();
//		Ques3();
//		Ques4();
//		Ques5();
//		Ques6();
//		Ques10();
//		Ques13();
		Ques14();
	}

	private static void Ques1() {
		System.out.println("Ques1");
		Scanner sc = new Scanner(System.in);
		String s;
		s = sc.nextLine();
		StringTokenizer dem = new StringTokenizer(s);
		int i = dem.countTokens();
		System.out.println(i);
	}

	private static void Ques2() {
		System.out.println();
		System.out.println("Ques2");
		Scanner sc = new Scanner(System.in);
		String s1, s2;
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		String s = s1 + " " + s2;
		System.out.println(s);
	}

	static void Ques3() {
		System.out.println();
		System.out.println("Ques3");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String firstChar = name.substring(0, 1).toUpperCase();
		String afName = name.substring(1);
		System.out.println(firstChar + afName);
	}

	static void Ques4() {
		System.out.println();
		System.out.println("Ques4");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("ky tu ten: " + name.charAt(i));
		}
	}

	public static void Ques5() {
		System.out.println();
		System.out.println("Ques5");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho: ");
		String firstName = sc.nextLine();
		System.out.println("Nhep ten: ");
		String lastName = sc.nextLine();
		System.out.println("Ho ten: " + firstName + " " + lastName);
	}

	static void Ques6() {
		System.out.println();
		System.out.println("Ques6");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho va ten: ");
		String tenDem = "", name;
		name = sc.nextLine();
		// trim la chuan hoa xau ky tu
		name = name.trim();
		String[] words = name.split(" ");
		String ho = words[0];
		String ten = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
			tenDem += words[i] + " ";

		}
		System.out.println("Ho la: " + ho);
		System.out.println("Ten dem la: " + tenDem);
		System.out.println("Ten la: " + ten);
//		contains de tim xau co thanh phan giong xau trong dk if (groupName.contains("Java"))
//		equals so sah xau  if (groupName.equals("Java"))
	}

	static void Ques10() {
		System.out.println();
		System.out.println("Ques10");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi 1: ");
		String s1, s2, s = "";
		s1 = sc.nextLine();
		System.out.println("Nhap chuoi 2: ");
		s2 = sc.nextLine();
		for (int i = s1.length() - 1; i >= 0; i--) {
			s += s1.substring(i, i + 1);
		}
		if (s.equals(s2)) {
			System.out.println("La xau dao nguoc");
		} else
			System.out.println("Ko la xau dao nguoc");
	}
	static void Ques13() {
		System.out.println();
		System.out.println("Ques13");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi : ");
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			if ( check(s.charAt(i))) {
				System.out.println("True");
				return;
			}else 
				System.out.println("False");
			return;
			}
				
		}
		public static boolean check(char ch) {
			if(ch >='0' && ch <='9') {
				return true;
			}else 
				return false;
			
	}
		static void Ques14() {
			System.out.println();
			System.out.println("Ques14");
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap chuoi : ");
			String s1;
			char ch1, ch2;
			s1  = sc.nextLine();
			System.out.println("Nhap ky tu muon chuyen: ");
			ch1 = sc.nextLine().toCharArray()[0];
			System.out.println(" ky tu chuyen thanh: ");
			ch2 = sc.nextLine().toCharArray()[0];
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) == ch1) {
					s1 = s1.replace(ch1, ch2);
				}
			}
			System.out.println("chuoi sau cung: "+ s1);
		}
		
}
