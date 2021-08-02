package com.vti.entity.QuanLyTV;

public class TaiLieu {
	private int id;
	private String tenNXB;
	private int soBanPhatHanh;

	public TaiLieu(int id, String tenNXB, int soBanPhatHanh) {
		this.id = id;
		this.tenNXB = tenNXB;
		this.soBanPhatHanh = soBanPhatHanh;
	}

	@Override
	public String toString() {
		return "TaiLieu [id=" + id + ", tenNXB=" + tenNXB + ", soBanPhatHanh=" + soBanPhatHanh + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}

}
