package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.GioiTinh;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

public class QLCB {
	private ArrayList<CanBo> listCanBo;
	private Scanner sc;

	public QLCB() {
		sc = new Scanner(System.in);
		listCanBo = new ArrayList<CanBo>();
	}

	public void Ques2() {
		menu();
	}

	public void menu() {
		int menuChoose;
		while (true) {
			System.out.println("lua chon chuc nang ban muon dung:");
			System.out.println("1. Them can bo");
			System.out.println("2. Tim can bo");
			System.out.println("3. Hien thi can bo");
			System.out.println("4. Xoa can bo");
			System.out.println("5. Thoat");
			menuChoose = sc.nextInt();
			sc.nextLine();
			switch (menuChoose) {
			case 1:
				addCanBo();
				break;
			case 2:
				findCanBo();
				break;
			case 3:
				displayCanBo();
				break;
			case 4:
				deleteCanBo();
				break;
			case 5:
				return;
			default:
				System.out.println("Nhap dung so di");
				break;
			}
		}
	}

	private void addCanBo() {
		System.out.println("Lua chon loai can bo:");
		System.out.println("1. Cong nhan");
		System.out.println("2. Ky su");
		System.out.println("3. NhanVien");

		int chooseadd = sc.nextInt();
		switch (chooseadd) {
		case 1:
			System.out.println("Nhap vao ten cong nhan");
			String tenCongNhan = sc.next();
			System.out.println("Nhap vao tuoi cong nhan");
			int tuoiCongNhan = sc.nextInt();
			System.out.println("Nhap vao gioi tinh(1.male, 2.female, 3.unknown)");
			int ganGioiTinh = sc.nextInt();
			GioiTinh gender = null;
			switch (ganGioiTinh) {
			case 1:
				gender = GioiTinh.MALE;
				break;
			case 2:
				gender = GioiTinh.FEMALE;
				break;
			case 3:
				gender = GioiTinh.UNKNOWN;
				break;
			}
			System.out.println("Nhap dia chi cong nhan");
			String diaChiCongNhan = sc.next();
			System.out.println("Nhap bac cua cong nhan");
			int bacCN = sc.nextInt();
			sc.nextLine();
			CanBo CN = new CongNhan(tenCongNhan, tuoiCongNhan, diaChiCongNhan, gender, bacCN);
			listCanBo.add(CN);
			break;
		case 2:
			System.out.println("Nhap vao ten ky su");
			String tenKS = sc.next();
			System.out.println("Nhap vao tuoi kysu");
			int tuoiKS = sc.nextInt();
			System.out.println("Nhap vao gioi tinh(1.male, 2.female, 3.unknown)");
			int ganGioiTinh2 = sc.nextInt();
			GioiTinh gender2 = null;
			switch (ganGioiTinh2) {
			case 1:
				gender2 = GioiTinh.MALE;
				break;
			case 2:
				gender2 = GioiTinh.FEMALE;
				break;
			case 3:
				gender2 = GioiTinh.UNKNOWN;
				break;
			}
			System.out.println("Nhap dia chi ky su");
			String diaChiKS = sc.next();
			System.out.println("Nhap nganh cua ky su");
			String nganhKS = sc.next();
			CanBo KS = new KySu(tenKS, tuoiKS, diaChiKS, gender2, nganhKS);
			listCanBo.add(KS);
			break;
		case 3:
			System.out.println("Nhap vao ten nhan vien");
			String tenNV = sc.next();
			System.out.println("Nhap vao tuoi nhan vien");
			int tuoiNV = sc.nextInt();
			System.out.println("Nhap vao gioi tinh(1.male, 2.female, 3.unknown)");
			int ganGioiTinh3 = sc.nextInt();
			GioiTinh gender3 = null;
			switch (ganGioiTinh3) {
			case 1:
				gender3 = GioiTinh.MALE;
				break;
			case 2:
				gender3 = GioiTinh.FEMALE;
				break;
			case 3:
				gender3 = GioiTinh.UNKNOWN;
				break;
			}
			System.out.println("Nhap dia chi nhan vien");
			String diaChiNV = sc.next();
			System.out.println("Nhap cong viec cua nhann vien");
			String congViecNV = sc.next();
			CanBo NV = new NhanVien(tenNV, tuoiNV, diaChiNV, gender3, congViecNV);
			listCanBo.add(NV);
			break;
			default:
				break;
		}
	}
	private void findCanBo() {
		System.out.println("Nhap ten muon tim:");
		String findName  = sc.next();
		for (CanBo canBo : listCanBo) {
			if(canBo.getName().equals(findName)) {
				System.out.println(canBo);
			}else
				System.out.println("ko co");
		}
	}
	private void displayCanBo() {
		for (CanBo canBo : listCanBo) {
			System.out.println(canBo);
		}
	}
	private void deleteCanBo() {
		System.out.println("Nhap ten can bo muon xoa");
		String tenCBxoa = sc.next();
		listCanBo.removeIf(CanBo -> CanBo.getName().equals(tenCBxoa));
		displayCanBo();
	}
	public static void main(String[] args) {
		QLCB ex5 = new QLCB();
		ex5.Ques2();
	}

}
