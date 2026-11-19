package com.mycompany.do_an;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuong;

    public SanPham(String maSP, String tenSP, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public double getDonGia() { return donGia; }
    public int getSoLuong() { return soLuong; }

    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}
