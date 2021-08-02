import com.vti.entity.Account;
import com.vti.entity.Department;

public class Excersice1 {
	Department d = new Department("sale");
	Account a = new Account(1, "as", "arw", "smx");
	public static void main(String[] args) {
		int x = 1;
		int y, z;
		y = x++;
		z =++x;
		System.out.println(x+", "+ y +", "+z);
	}
}
