package DoAnQuanLyKhachSan;

public class NhanVien extends Nguoi{
	String maNhanVien;
	double heSoLuong;
	String sDT;
	String matKhau;
	
	public NhanVien() {
		super();
	}
	
	public NhanVien(String ten,int tuoi,String maNhanVien, double heSoLuong, String sDT,String matKhau) {
		super(ten,tuoi);
		this.maNhanVien = maNhanVien;
		this.heSoLuong = heSoLuong;
		this.sDT = sDT;
		this.matKhau = matKhau;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getMatKhau() {
		return matKhau;
	}
	
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
}
