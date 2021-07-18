import java.util.Date;

public class GroupAccount {
	Group name;
	Account member;
	Date joinDate;
	public void printGA() {
		System.out.println("GroupName: "+ name);
		System.out.println("Thanh vien: "+ member.fullName);
		System.out.println("ngay tao: "+ joinDate);
	}
}
