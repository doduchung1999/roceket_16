package taoData;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String userName;
	public String email;
	public String fullName;
	public Department dName;
	public Position pName;
	public static LocalDate createDate;
	public Group[] groups;

	public void printA() {
		System.out.println("id: " + id);
		System.out.println("username: " + userName);
		System.out.println("email: " + email);
		System.out.println("ten: " + fullName);
		System.out.println("phong: " + dName.name);
		System.out.println("chuc vu: " + pName.name);
		System.out.println("ngay tao: " + createDate);
		System.out.println("tham gia cac group: " + listGroup());
		System.out.println();
	}

	public String listGroup() {
		String s = " list group = [ ";
		for (Group g : groups) {
			s += g.name + " , ";
		}
		s += " ]";
		return s;
	}

//	public String getGroups() {
//		return groups.toString();
//	}
//	@Override
//	public String toString() {
//		return "Account [id=" + id + ", userName=" + userName + ", email=" + email + ", fullName=" + fullName
//				+ ", dName=" + dName + ", pName=" + pName + ", createDate=" + createDate + ", groups="
//				+ Arrays.toString(groups) + "]";
//	}
}
