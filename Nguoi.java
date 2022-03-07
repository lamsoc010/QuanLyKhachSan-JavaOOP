package DoAnQuanLyKhachSan;

import java.util.Scanner;

public class Nguoi {
	String ten;
	int tuoi;
	
	public Nguoi() {
	}
	
	public Nguoi(String ten, int tuoi) {
		this.ten = ten;
		this.tuoi = tuoi;
	}
	
	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		ten = sc.next();
		while (true) {
			try {
				System.out.print("Nhập tuổi: ");
				tuoi = Integer.parseInt(sc.next());
				if (tuoi >= 0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	
}
