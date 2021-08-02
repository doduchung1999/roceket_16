package com.vti.entity.QuanLyTV;

public class Sach extends TaiLieu {
	public Sach(int id, String tenNXB, int soBanPhatHanh, String tenTG, int soTrang) {
		super(id, tenNXB, soBanPhatHanh);
		this.soTrang = soTrang;
		this.tenTG = tenTG;
	}

	private String tenTG;
	private int soTrang;
	@Override
	public String toString() {
		return super.toString() + "Sach [tenTG=" + tenTG + ", soTrang=" + soTrang + "]";
	}
	
	
	

}
