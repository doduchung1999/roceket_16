import java.util.Date;

public class Question {
	int id;
	String content;
	CategoryQuestion cq;
	TypeQuestion tq;
	Account creator;
	Date createDate;
	public void printQ() {
		System.out.println("id: "+ id);
		System.out.println("Noi dung: "+ content);
		System.out.println("the loai: "+ cq.name);
		System.out.println("loai: "+ tq.type);
		System.out.println("nguoi tao: "+ creator.fullName);
		System.out.println("ngay tao: "+ createDate);
		System.out.println(" ");
	}
}
