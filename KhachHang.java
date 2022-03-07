package DoAnQuanLyKhachSan;

public class KhachHang extends Nguoi {
	String diaChi;
	String soChungMinh;
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoChungMinh() {
		return soChungMinh;
	}
	public void setSoChungMinh(String soChungMinh) {
		this.soChungMinh = soChungMinh;
	}
	public KhachHang(String ten, int tuoi,String diaChi, String soChungMinh) {
		super(ten,tuoi);
		this.diaChi = diaChi;
		this.soChungMinh = soChungMinh;
	}
	public KhachHang() {
		super();
	}
	
}
