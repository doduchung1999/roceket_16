package Polymorphism;

public class Student implements IStudent {
	public static int COUNT;
	private int id;
	private String name;
	private int group;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}
	@Override
	public void diemDanh() {
		System.out.println(name + " diem danh");
	}
	@Override
	public void hocBai() {
		System.out.println(name + " hocbai");
	}
	@Override
	public void diDonVS() {
		System.out.println(name +" donVS");
	}
	public Student(String name, int group) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.group = group;
	}
	public int getGroup() {
		return group;
	}
	
}
