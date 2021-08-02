package com.vti.entity;

public class NhanVien extends CanBo {
	public NhanVien(String ten, int tuoi, String diaChi, GioiTinh gioiTinh, String congViec) {
		super(ten, tuoi, diaChi, gioiTinh);
		this.congViec = congViec;
	}

	private String congViec;

	@Override
	public String toString() {
		return super.toString() + "NhanVien [congViec=" + congViec + "]";
	}

}
