import java.util.Date;

public class Program {

	public static void main(String[] args) {
		
		Department D1 = new Department();
		D1.id = 1;
		D1.name = "sale";
		Department D2 = new Department();
		D2.id = 2;
		D2.name = "phong dev";
		Department D3 = new Department();
		D3.id = 3;
		D3.name = "phong bao ve";
		D2.printD();
		
		Position P1 = new Position();
		P1.id = 1;
		P1.name = "dev";
		Position P2 = new Position();
		P2.id = 2;
		P2.name = "dev2";
		Position P3 = new Position();
		P3.id = 3;
		P3.name = "sale";
		P2.printP();
		
		Account A1= new Account();
		A1.id= 1;
		A1.userName = "abc";
		A1.email ="abc@mail";
		A1.fullName = "nguyen van a";
		A1.dName = D3;
		A1.pName = P2;
		A1.createDate= new Date("2021/05/12");
		Account A2= new Account();
		A2.id= 2;
		A2.userName = "abcd";
		A2.email ="abcd@mail";
		A2.fullName = "nguyen van ab";
		A2.dName = D1;
		A2.pName = P1;
		A2.createDate= new Date("2021/03/04");
		Account A3= new Account();
		A3.id= 3;
		A3.userName = "abcasw";
		A3.email ="abccv@mail";
		A3.fullName = "nguyen van asd";
		A3.dName = D2;
		A3.pName = P2;
		A3.createDate= new Date("2021/01/02");
		A2.printA();
		
		CategoryQuestion CQ1 = new CategoryQuestion();
		CQ1.id = 1;
		CQ1.name = "Hoi ve mysql";
		CategoryQuestion CQ2 = new CategoryQuestion();
		CQ2.id = 2;
		CQ2.name = "Hoi ve java";
		CategoryQuestion CQ3 = new CategoryQuestion();
		CQ3.id = 3;
		CQ3.name = "Hoi ve C++";
		CQ1.printCQ();
		
		TypeQuestion TQ1 = new TypeQuestion();
		TQ1.id = 1;
		TQ1.type = "cau hoi de";
		TypeQuestion TQ2 = new TypeQuestion();
		TQ2.id = 2;
		TQ2.type = "cau hoi de";
		TypeQuestion TQ3 = new TypeQuestion();
		TQ3.id = 3;
		TQ3.type = "cau hoi de";
		TQ3.printTQ();
		TQ2.printTQ();
		
		Question Q1 = new Question();
		Q1.id = 1;
		Q1.tq = TQ2;
		Q1.cq = CQ1;
		Q1.content = "cau hoi 1";
		Q1.creator = A1;
		Q1.createDate = new Date("2020/03/04");
		Question Q2 = new Question();
		Q2.id = 2;
		Q2.tq = TQ2;
		Q2.cq = CQ1;
		Q2.content = "cau hoi 2";
		Q2.creator = A1;
		Q2.createDate = new Date("2020/03/04");
		Question Q3 = new Question();
		Q3.id = 3;
		Q3.tq = TQ2;
		Q3.cq = CQ1;
		Q3.content = "cau hoi 3";
		Q3.creator = A1;
		Q3.createDate = new Date("2020/03/04");
		Q3.printQ();
		
		Answer AW1 =new Answer();
		AW1.id = 1;
		AW1.content = "tra loi cau1";
		AW1.q = Q1;
		AW1.isCorrect = true;
		Answer AW2 =new Answer();
		AW2.id = 2;
		AW2.content = "tra loi cau2";
		AW2.q = Q2;
		AW2.isCorrect = true;
		Answer AW3 =new Answer();
		AW3.id = 3;
		AW3.content = "tra loi cau3";
		AW3.q = Q3;
		AW3.isCorrect = false;
		AW2.printAW();
		
		Exam E1 = new Exam();
		E1.id = 1;
		E1.code = " QID";
		E1.title = " RE2";
		E1.cateEx = CQ1;
		E1.duration = 90;
		E1.creator = A2;
		E1.createDate = new Date("2020/01/12");
		Exam E2 = new Exam();
		E2.id = 2;
		E2.code = " QID";
		E2.title = " RE2";
		E2.cateEx = CQ1;
		E2.duration = 90;
		E2.creator = A2;
		E2.createDate = new Date("2020/01/12");
		Exam E3 = new Exam();
		E3.id = 1;
		E3.code = " QID";
		E3.title = " RE2";
		E3.cateEx = CQ1;
		E3.duration = 90;
		E3.creator = A2;
		E3.createDate = new Date("2020/01/12");
		E2.printE();
		
		ExamQuestion EQ1 = new ExamQuestion();
		EQ1.ex =E2;
		EQ1.question = Q1;
		ExamQuestion EQ2 = new ExamQuestion();
		EQ2.ex =E2;
		EQ2.question = Q1;
		ExamQuestion EQ3 = new ExamQuestion();
		EQ3.ex =E3;
		EQ3.question = Q3;
		EQ2.printEQ();
	}
	
}
