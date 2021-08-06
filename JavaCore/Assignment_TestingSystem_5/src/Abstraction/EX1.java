package Abstraction;

import java.util.ArrayList;
import java.util.Scanner;
import Abstraction.News;

public class EX1 {
	private Scanner sc;
	private ArrayList<News> listNews;

	public EX1() {
		sc = new Scanner(System.in);
		listNews = new ArrayList<News>();
	}

	public void Ques2() {
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("Lua chon chuc nang");
			System.out.println("1. Insert news");
			System.out.println("2. View news");
			System.out.println("3. Average rate");
			System.out.println("4. thoat");
			int choose = sc.nextInt();

			switch (choose) {
			case 1:
				InsertNew();
				break;
			case 2:
				for (News news1 : listNews) {
					news1.Display();
					}
				break;
			case 3:
				System.out.println("Danh gia trung binh");
				for (News news1 : listNews) {
					System.out.println(news1.Calculate());
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Lua chon lai");
				break;
			}
		}
	}

	private void InsertNew() {
		System.out.println("Nhap id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap Title");
		String title = sc.nextLine();
		System.out.println("Nhap PublishDate");
		String publishDate = sc.nextLine();
		System.out.println("Nhap Author");
		String author = sc.nextLine();
		System.out.println("Nhap Content");
		String content = sc.nextLine();
		System.out.println("Nhap danh gia 1:");
		int rate1 = sc.nextInt();
		System.out.println("Nhap danh gia 2:");
		int rate2 = sc.nextInt();
		System.out.println("Nhap danh gia 3:");
		int rate3 = sc.nextInt();
		int[] rates = { rate1, rate2, rate3 };
		News news = new News(id, title, publishDate, author, content, rates);
		listNews.add(news);
	}

//	private void View() {
//		for (News news1 : listNews) {
//			news1.Display();
//
//		}
//	}
//
//	private void AVGrate() {
//		System.out.println("Danh gia trung binh");
//		for (News news1 : listNews) {
//			System.out.println(news1.Calculate());
//		}
//	}
}
