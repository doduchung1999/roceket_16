package com.vti.entity;

public class CanBo {
	private String ten;
	private int tuoi;
	private String diaChi;
	private GioiTinh gioiTinh;

	
	public CanBo(String ten, int tuoi, String diaChi, GioiTinh gioiTinh) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}

	public String getName() {
		return ten;
	}

	@Override
	public String toString() {
		return "CanBo [tuoi=" + tuoi + ", ten=" + ten + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + "]";
	}
	
	
}
