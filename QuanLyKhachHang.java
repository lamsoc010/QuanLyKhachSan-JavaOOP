package DoAnQuanLyKhachSan;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachHang extends KhachHang {

	public QuanLyKhachHang() {
		super();
	}

	public QuanLyKhachHang(String ten, int tuoi,String diaChi, String soChungMinh) {
		super(ten,tuoi,diaChi, soChungMinh);
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập địa chỉ: ");
		diaChi = sc.nextLine();
		while(true) {
			try {
				System.out.print("Nhập số CMND: ");
				soChungMinh = sc.nextLine();
				if(soChungMinh.length()==9)
					break;
				else 
					System.out.println("Số CMND gồm 9 chữ số");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai( Số CMND gồm 9 số)");
			}
		}
	}
	
	public void hienThi() {
		System.out.format("|%5s|%4s|%11s|%11s|", ten, tuoi, diaChi, soChungMinh);
		System.out.println("");
		System.out.println("----------------------------------------------");
	}

	public static void nhapKhachHang(ArrayList<QuanLyKhachHang> khachHangTest) {
		QuanLyKhachHang qLKH = new QuanLyKhachHang();
		qLKH.nhapThongTin();
		khachHangTest.add(qLKH);
	}

	public static void hienThiKhachHang(ArrayList<QuanLyKhachHang> khachHangTest) {
		System.out.println("----------------------------------------------");
		System.out.println("| Tên |Tuổi|  Địa Chỉ  | Số chứng minh |");
		System.out.println("----------------------------------------------");
		for (int i = 0; i < khachHangTest.size(); i++) {
			khachHangTest.get(i).hienThi();
		}
	}

}
