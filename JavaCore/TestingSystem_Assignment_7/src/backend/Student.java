package backend;

public class Student {
	private static int count = 0;
	private int id;
	private String name;
	private static String collect = "BK";
	public static int moneyGroup;
	public Student(int id, String name) {
		count++;
		this.id = count;
		this.name = name;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name +", collect: " + getCollect() +  "]";
	}
	public static String getCollect() {
		return collect;
	}
	public static void setCollect(String collect) {
		Student.collect = collect;
	}
	
}
