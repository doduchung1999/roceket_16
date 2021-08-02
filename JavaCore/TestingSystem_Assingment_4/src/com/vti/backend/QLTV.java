package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.QuanLyTV.*;

public class QLTV {
	private static int ID = 0;
	private ArrayList<TaiLieu> listTaiLieu;
	private Scanner sc;

	public QLTV() {
		listTaiLieu = new ArrayList<TaiLieu>();
		sc = new Scanner(System.in);
	}

	public void menu() {
		int chooseMenu;
		do {
			System.out.println("Lua chon chuc nang ban muon dug");
			System.out.println("1. Them moi tai lieu");
			System.out.println("2. Xoa tai lieu");
			System.out.println("3. Hien thi tai lieu");
			System.out.println("4. tim kiem tai lieu");
			System.out.println("5.thoat");
			chooseMenu = sc.nextInt();
			sc.nextLine();
			switch (chooseMenu) {
			case 1:
				addTaiLieu();
				break;
			case 2:
				xoaTaiLieu();
				break;
			case 3:
				printTaiLieu();
				break;
			case 4:
				findTaiLieu();
				break;
			case 5:
				return;

			}

		} while (chooseMenu <= 5);
	}
	private void addTaiLieu() {
		System.out.println("Nhap loai tai lieu(1. Sach, 2. TapChi, 3. Bao)");
		int chooseLoaiTL = sc.nextInt();
		switch(chooseLoaiTL) {
		case 1:
			System.out.println("Nhap ten NXB");
			String NXB = sc.next();
			System.out.println("Nhap so ban phat hanh");
			int soBan = sc.nextInt();
			System.out.println("Nhap ten tac gia");
			String tenTG = sc.next();
			System.out.println("Nhap so trang");
			int soTrang = sc.nextInt();
			ID++;
			TaiLieu book = new Sach(ID, NXB, soBan, tenTG, soTrang);
			listTaiLieu.add(book);
			break;
		case 2:
			System.out.println("Nhap ten NXB");
			String NXB1 = sc.next();
			System.out.println("Nhap so ban phat hanh");
			int soBan1 = sc.nextInt();
			System.out.println("Nhap so phat hanh");
			int soPhatHanh = sc.nextInt();
			System.out.println("Nhap ngay phat hanh");
			int dd = sc.nextInt();
			System.out.println("Nhap thang phat hanh");
			int mm = sc.nextInt();
			System.out.println("Nhap nam phat hanh");
			int yy = sc.nextInt();
			LocalDate ngayPhatHanh= LocalDate.of(yy, mm, dd);
			ID++;
			TaiLieu tapchi = new TapChi(ID, NXB1, soBan1, soPhatHanh, ngayPhatHanh);
			listTaiLieu.add(tapchi);
			break;
		case 3:
			System.out.println("Nhap ten NXB");
			String NXB2 = sc.next();
			System.out.println("Nhap so ban phat hanh");
			int soBan2 = sc.nextInt();
			System.out.println("Nhap ngay phat hanh");
			int dd1 = sc.nextInt();
			System.out.println("Nhap thang phat hanh");
			int mm1 = sc.nextInt();
			System.out.println("Nhap nam phat hanh");
			int yy1 = sc.nextInt();
			LocalDate ngayPhatHanh1= LocalDate.of(yy1, mm1, dd1);
			ID++;
			TaiLieu bao = new Bao(ID, NXB2, soBan2, ngayPhatHanh1);
			listTaiLieu.add(bao);
			break;
			default:
				break;
		}
	}
	
	private void findTaiLieu() {
		System.out.println("Nhap id tai lieu muon tim");
		int i = sc.nextInt();
		System.out.println(listTaiLieu.get(i-1));
	}
	private void printTaiLieu() {
		for (TaiLieu taiLieu : listTaiLieu) {
			System.out.println(taiLieu);
		}
	}
	private void xoaTaiLieu() {
		System.out.println("Nhap id tai lieu muon xoa");
		int idxoa = sc.nextInt();
		boolean check = false;
		for (TaiLieu taiLieu : listTaiLieu) {
			if(taiLieu.getId() == idxoa) {
				check = true;
			}
			
		}
		if(check) {
			listTaiLieu.removeIf(taiLieu -> taiLieu.getId() == idxoa);
			for (TaiLieu taiLieu : listTaiLieu) {
				System.out.println("xoa thanh cong");
				System.out.println(taiLieu);
			}
		}else 
			System.out.println("Ma nhap sai");
	}

	public static void main(String[] args) {
		QLTV ex5 = new QLTV();
		ex5.menu();
	}

}
