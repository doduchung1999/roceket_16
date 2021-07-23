package Test2;

import java.time.LocalDate;
import java.util.Random;

public class Excersice4 {

	public static void main(String[] args) {
		Question1();
		Ques2();
		Ques3();
		Ques4();
		Ques5();
		Ques6();
		Ques7();
	}

	static void Question1() {
		System.out.println("Ques1");
		Random random = new Random();
		int a = random.nextInt();
		System.out.println("So a: " + a);
	}

	static void Ques2() {
		System.out.println();
		System.out.println("Ques2");
		Random random = new Random();
		float f = random.nextFloat();
		System.out.println("so thuc f: " + f);
	}

	static void Ques3() {
		System.out.println();
		System.out.println("Ques3");
		String A[] = { "a", "b", "c" };
		Random random = new Random();
		int i = random.nextInt(A.length);
		System.out.println(A[i]);
	}

	static void Ques4() {
		System.out.println();
		System.out.println("Ques4");
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		Random random = new Random();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDate);
	}

	static void Ques5() {
		System.out.println();
		System.out.println("Ques5");
		Random random = new Random();
		int now = (int) LocalDate.now().toEpochDay();
		int randomDay = now - random.nextInt(365);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDay);
		System.out.println(resultDate);
	}
	
	static void Ques6() {
		System.out.println();
		System.out.println("Ques6");
		Random random = new Random();
		int maxDay = (int)LocalDate.now().toEpochDay();
		int randomDate = random.nextInt(maxDay);
		LocalDate resultDate1 = LocalDate.ofEpochDay(randomDate);
		System.out.println(resultDate1);
	}
	
	static void Ques7() {
		System.out.println();
		System.out.println("Ques7");
		int min = 100;
		int max = 999;
		Random random = new Random();
		int b = min + random.nextInt(max - min +1);
		System.out.println(b);
	}

}
