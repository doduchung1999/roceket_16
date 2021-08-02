package com.vti.entity;

public class CongNhan extends CanBo {
	public CongNhan(String ten, int tuoi, String diaChi, GioiTinh gioiTinh, int bac) {
		super(ten, tuoi, diaChi, gioiTinh);
		this.bac = bac;
	}

	private int bac;

	@Override
	public String toString() {
		return super.toString() + "CongNhan [bac=" + bac + "]";
	}

}
