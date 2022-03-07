package DoAnQuanLyKhachSan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanVien extends NhanVien {
	public QuanLyNhanVien() {
		super();
	}
	public QuanLyNhanVien(String ten, int tuoi, String maNhanVien, double heSoLuong, String sDT,String matKhau) {
		super(ten, tuoi, maNhanVien, heSoLuong, sDT, matKhau);
	}
	public static ArrayList<QuanLyNhanVien> nhanVienTest;
	@Override	
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên: ");
		maNhanVien = sc.nextLine();
		System.out.println("Nhập hệ hố lương: ");
		heSoLuong = sc.nextDouble();
		System.out.println("Nhập số điện thoại: ");
		sDT = sc.next();
	}
	
public void hienThiNhanVien() {
		System.out.format("|%6s|%4s|%13s|",ten,tuoi,sDT);
		System.out.println("");
		System.out.println("---------------------------");
	}
	
public ArrayList<QuanLyNhanVien> docFileNhanVien() {
		ArrayList<QuanLyNhanVien> nhanVienTest = new ArrayList<>();
		try {
			FileReader fr = new FileReader("QuanLyNhanVien.txt");
			BufferedReader br = new BufferedReader(fr);
			String line ="";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String txt[] = line.split("\\s+");
				String ten = txt[0];
				int tuoi = Integer.parseInt(txt[1]);
				String maNhanVien = txt[2];
				double heSoLuong = Double.parseDouble(txt[3]);
				String sDT = txt[4];
				String matKhau = txt[5];
				nhanVienTest.add(new QuanLyNhanVien(ten, tuoi, maNhanVien, heSoLuong, sDT, matKhau));
			}
		} catch (Exception e) {
		}
		return nhanVienTest;
	}
	
public static void hamNhap(ArrayList<QuanLyNhanVien> nhanVienTest) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			try {
				System.out.println("Nhập số nhân viên cần nhập: ");
				n = Integer.parseInt(sc.nextLine());
				if(n>0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		for (int i = 0; i < n; i++) {
			QuanLyNhanVien qLNV = new QuanLyNhanVien();
			qLNV.nhapThongTin();
			nhanVienTest.add(qLNV);
		}
	}
	
public static void hamHienThi(ArrayList<QuanLyNhanVien> nhanVienTest) {
		System.out.println("|---------VL.Group--------|");
		System.out.println("|---Danh sách nhân viên---|");
		System.out.println("| Tên |Tuổi|Số điện thoại |");
		System.out.println("|-------------------------|");
		for(int i=0; i< nhanVienTest.size();i++) 
			nhanVienTest.get(i).hienThiNhanVien();
		System.out.println("Hãy liên hệ với nhân viên để được tư vấn chi tiết cụ thể!!Xin cám ơn quý khách!!");
	}
	
public static void checkNhanVien(ArrayList<QuanLyNhanVien> nhanVienTest) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vui lòng nhập mã nhân viên của bạn: ");
		String maNhanVien = sc.next();
		for(int i=0; i< nhanVienTest.size();i++) {
			
		}
	}
	
//public static void main(String[] args) {
//		ArrayList<QuanLyNhanVien> nhanVienTest = new ArrayList<>();
////		hamNhap(nhanVienTest);
////		hamHienThi(nhanVienTest);
//		int dem = nhanVienTest.size();
//		QuanLyNhanVien qLNV = new QuanLyNhanVien();
//		nhanVienTest = qLNV.docFileNhanVien();
//		if(nhanVienTest.size()>dem)
//			System.out.println("Đọc File thành công!!!");
//		hamHienThi(nhanVienTest);
//	}
}
