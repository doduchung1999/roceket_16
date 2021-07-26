package bai3;

public class Excersice3 {

	public static void main(String[] args) {
		Ques1();
		Ques2();
		Ques3();
	}
	
	private static void Ques1() {
		Integer i =5000;
		System.out.printf("%2.2f", (float) i);
	}
	
	private static void Ques2() {
		String s = "1234";
		int i = Integer.parseInt(s);
		System.out.println("So i: "+ i);
	}
	
	private static void Ques3() {
		Integer i = 1234567;
		int i1 = i.intValue();
		System.out.println(i1);
	}

}
