package com.vti.entity.QuanLyTV;

import java.time.LocalDate;

public class TapChi extends TaiLieu {

	private int soPhatHanh;
	private LocalDate thangPhatHanh;
	
	public TapChi(int id, String tenNXB, int soBanPhatHanh, int soPhatHanh, LocalDate thangPhatHanh) {
		super(id, tenNXB, soBanPhatHanh);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "TapChi [soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + ", toString()="
				+ super.toString() + ", getId()=" + getId() + ", getTenNXB()=" + getTenNXB() + ", getSoBanPhatHanh()="
				+ getSoBanPhatHanh() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
