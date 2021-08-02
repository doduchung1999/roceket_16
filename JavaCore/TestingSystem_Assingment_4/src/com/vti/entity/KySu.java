package com.vti.entity;

public class KySu extends CanBo {
	public KySu(String ten, int tuoi, String diaChi, GioiTinh gioiTinh, String nganh) {
		super(ten, tuoi, diaChi, gioiTinh);
		this.nganh = nganh;
	}

	private String nganh;

	@Override
	public String toString() {
		return super.toString() + "KySu [nganh=" + nganh + "]";
	}

}
