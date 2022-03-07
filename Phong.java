package DoAnQuanLyKhachSan;

public class Phong {
	String loaiPhong;
	int soPhong;
	int soGiuong;
	double giaTien;
	String trangThaiPhong;
	String khachThue;
	String ngayThue;
	public Phong() {
	
	}
	
	public Phong(String loaiPhong, int soPhong, int soGiuong, double giaTien, String trangThaiPhong, String khachThue, String ngayThue) {
		this.loaiPhong = loaiPhong;
		this.soPhong = soPhong;
		this.soGiuong = soGiuong;
		this.giaTien = giaTien;
		this.trangThaiPhong = trangThaiPhong;
		this.khachThue = khachThue;
		this.ngayThue = ngayThue;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public int getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public String getTrangThaiPhong() {
		return trangThaiPhong;
	}
	public void setTrangThaiPhong(String trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}
	public String getKhachThue() {
		return khachThue;
	}
	public void setKhachThue(String khachThue) {
		this.khachThue = khachThue;
	}
	public String getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(String ngayThue) {
		this.ngayThue = ngayThue;
	}
	
}
