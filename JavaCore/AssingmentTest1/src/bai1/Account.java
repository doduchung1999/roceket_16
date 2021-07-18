import java.util.Date;

public class Account {
	int id;
	String userName;
	String email;
	String fullName;
	Department dName;
	Position pName;
	Date createDate;
	public void printA() {
		System.out.println("id: "+ id);
		System.out.println("username: "+ userName);
		System.out.println("email: "+ email);
		System.out.println("ten: "+ fullName);
		System.out.println("phong: "+ dName.name);
		System.out.println("chuc vu: "+ pName.name);
		System.out.println("ngay tao: "+ createDate);
		System.out.println(" ");
	}
}
