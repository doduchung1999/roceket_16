import java.util.Date;

public class Group {
	int id;
	String name;
	Account creator;
	Date createDate;
	public void printG() {
		System.out.println("id: "+ id);
		System.out.println("ten group: "+ name);
		System.out.println("nguoi tao: "+ creator.fullName);
		System.out.println("ngay tao: "+ createDate);
		System.out.println(" ");
	}
}
