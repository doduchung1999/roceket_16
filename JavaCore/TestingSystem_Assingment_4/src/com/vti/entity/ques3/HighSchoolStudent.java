package com.vti.entity.ques3;

public class HighSchoolStudent extends Student {

	private String clazz;
	private String desiredUni;

	public HighSchoolStudent(String name, int id, String clazz, String desiredUni) {
		super(name, id);
		this.clazz  = clazz;
		this.desiredUni = desiredUni;
		
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDesiredUni() {
		return desiredUni;
	}

	public void setDesiredUni(String desiredUni) {
		this.desiredUni = desiredUni;
	}

	@Override
	public String toString() {
		return "HighSchoolStudent[id: "+ super.getId()+ ", name:"+super.getName() + " ,clazz=" + clazz + ", desiredUni=" + desiredUni + "]";
	}
	
	public void question3() {
		HighSchoolStudent sv = new HighSchoolStudent("Nam", 1, "Chuyen Van", "DH cong nghe");
		System.out.println(sv);
	}
	public static void main(String[] args) {
		HighSchoolStudent sv1 = new HighSchoolStudent(null, 0, null, null);
		sv1.question3();
		HighSchoolStudent sv = new HighSchoolStudent("Nam", 1, "Chuyen Van", "DH cong nghe");
		System.out.println(sv);
	}
	

}
