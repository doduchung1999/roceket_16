package com.vti.entity.QuanLyTV;

import java.time.LocalDate;

public class Bao extends TaiLieu{

	public Bao(int id, String tenNXB, int soBanPhatHanh, LocalDate ngayPhatHanh) {
		super(id, tenNXB, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
	}
	
	private LocalDate ngayPhatHanh;

	@Override
	public String toString() {
		return super.toString() + "Bao [ngayPhatHanh=" + ngayPhatHanh + "]";
	}
	
	

}
