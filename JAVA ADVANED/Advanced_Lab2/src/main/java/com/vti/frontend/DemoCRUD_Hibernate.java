package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DemoCRUD_Hibernate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choose = menu();
		switch (choose) {
		case 1:
			showAll();
			break;
		case 2:
			System.out.println("Nhập vào id:");
			short id = scanner.nextShort();
			showDepartmentByID(id);
			break;
		case 3:
			System.out.println("Nhập vào name: ");
			String name =scanner.nextLine();
			showDepartmentByName(name);
			break;
		case 4:
			System.out.println("Tạo phòng mới");
			System.out.println("Nhập tên phòng cần tạo: ");
			String createName = scanner.nextLine();
			Department department = new Department();
			department.setName(createName);
			createDepartment(department);
			showAll();
			break;

		default:
			break;
		}
	}

	private static int menu() {
		while (true) {
			System.out.println("Chương trình quản lý phòng ban..");
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Tìm phòng ban theo Name");
			System.out.println("4. Tạo mới 1 phòng");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int i = sc.nextInt();
				if ((i == 1) || (i == 2) || (i == 3) || (i == 4)) {
					return i;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("Nhap lai");
			}
		}

	}

	private static void createDepartment(Department dep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		depRepository.createDepartment(dep);
	}

	private static void showAll() {
		DepartmentRepository depRepository = new DepartmentRepository();
		List<Department> ListDep = depRepository.getAllDepartments();
		for (Department department : ListDep) {
			System.out.println("ID: " + department.getId() + "Name: " + department.getName());
		}
	}

	private static void showDepartmentByName(String name) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depByName = depRepository.getDepartmentName(name);
		if (depByName == null) {
			System.out.println("Không có phòng ban này");
		} else {
			System.out.println(depByName.toString());
		}
	}

	private static void showDepartmentByID(short id) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depByID = depRepository.getDepartmentID(id);
		System.out.println(depByID.toString());
	}
}
