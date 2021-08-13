package backend;

public class Excersice1 {
	public void question1() {
		Student[] stusentArray = new Student[3];
		System.out.println("khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên " + (i + 1 + ":"));
			Student st = new Student();
			stusentArray[i] = st;
		}
		System.out.println("Thông tin các sinh viên vừa nhập: ");
		for (int i = 0; i < stusentArray.length; i++) {
			System.out.println(stusentArray[i]);
		}
		System.out.println("Chuyển các sinh viên sang Đại học công nghệ:");

		Student.setCollect("Đại học Công nghệ ");
		System.out.println("Thông tin sinh viên sau khi chuyển ");
		for (int i = 0; i < stusentArray.length; i++) {
			System.out.println(stusentArray[i]);
		}
	}

	public void question2() {

		Student[] stusentArray = new Student[3];
		System.out.println("khởi tạo 3 sinh viện");
		for (int i = 0; i < 3; i++) {
		System.out.println("Sinh viên " + (i + 1 + ":"));
		Student st = new Student();
		stusentArray[i] = st;
		}
		System.out.println("Các sinh viên nộp quỹ, mỗi bạn 100K: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 300));
		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");

		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50));
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20));
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");

		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
		System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k: ");

		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));
		}
}
