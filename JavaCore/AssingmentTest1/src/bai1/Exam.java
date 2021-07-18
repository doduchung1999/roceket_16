import java.util.Date;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion cateEx;
	int duration;
	Account creator;
	Date createDate;
	public void printE() {
		System.out.println("id: "+ id);
		System.out.println("Code: "+ code);
		System.out.println("Title: "+ title);
		System.out.println("The loai cau hoi: "+ cateEx.name);
		System.out.println("So phut: "+ duration);
		System.out.println("nguoi tao: "+ creator.fullName);
		System.out.println("Ngay tao: "+ createDate);
		System.out.println(" ");
	}
}
