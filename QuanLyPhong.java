package DoAnQuanLyKhachSan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;


public class QuanLyPhong extends Phong {
	public QuanLyPhong() {
		super();
	}

	public QuanLyPhong(String loaiPhong, int soPhong, int soGiuong, double giaTien, String trangThaiPhong,
			String khachThue, String ngayThue) {
		super(loaiPhong, soPhong, soGiuong, giaTien, trangThaiPhong, khachThue, ngayThue);
	}

	public static ArrayList<QuanLyPhong> phongTest;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Nhập loại phòng: ");
				loaiPhong = sc.next();
				if (loaiPhong.equalsIgnoreCase("thuong") || loaiPhong.equalsIgnoreCase("vip"))
					break;
				else
					System.out.println("Loại phòng chỉ có THUONG hoặc VIP");
			} catch (Exception e) {
				System.err.println("Loại phòng chỉ có VIP hoặc THUONG");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập số phòng: ");
				soPhong = Integer.parseInt(sc.next());
				if (soPhong > 100)
					break;
				else
					System.out.println("Số phòng gồm 3 chữ số");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Số phòng gồm 3 số)");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập số giường: ");
				soGiuong = Integer.parseInt(sc.next());
				if (soGiuong >= 1)
					break;
				else
					System.out.println("Số giường phải >= 1");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Số giường >= 1)");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập giá tiền: ");
				giaTien = Double.parseDouble(sc.next());
				if (giaTien >= 1)
					break;
				else
					System.out.println("Giá tiền không được âm");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập lại)");
			}
		}
		trangThaiPhong = "TRONG";
		khachThue = "KHONG";
		ngayThue = "KHONG";
	}

	public void hienThiPhong() {
		System.out.format("|%10s|%8s|%9s|%10s|%10s|%12s|%11s|", loaiPhong, soPhong, soGiuong, giaTien, trangThaiPhong,
				khachThue, ngayThue);
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------");

	}

	@Override
	public String toString() {
		return loaiPhong + "\t" + soPhong + "\t" + soGiuong + "\t" + giaTien + "\t" + trangThaiPhong + "\t" + khachThue
				+ "\t" + ngayThue;
	}

	public ArrayList<QuanLyPhong> docFile() {
		ArrayList<QuanLyPhong> phongTest = new ArrayList<>();
		try {
			FileReader fr = new FileReader("QuanLyPhong.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				String txt[] = line.split("\\s+");
				String loaiPhong = txt[0];
				int soPhong = Integer.parseInt(txt[1]);
				int soGiuong = Integer.parseInt(txt[2]);
				double giaTien = Double.parseDouble(txt[3]);
				String trangThaiPhong = txt[4];
				String khachThue = txt[5];
				String ngayThue = txt[6];
				phongTest.add(
						new QuanLyPhong(loaiPhong, soPhong, soGiuong, giaTien, trangThaiPhong, khachThue, ngayThue));
			}
			fr.close();
			br.close();
		} catch (Exception e) {
		}
		return phongTest;
	}

	public void ghiFile(ArrayList<QuanLyPhong> phongTest) {
		try {
			FileWriter fw = new FileWriter("QuanLyPhong.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Phong phong : phongTest) {
				bw.write(phong.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void hamNhapPhong(ArrayList<QuanLyPhong> phongTest) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				System.out.println("Nhập số phòng cần nhập: ");
				n = Integer.parseInt(sc.nextLine());
				if (n > 0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		for (int i = 0; i < n; i++) {
			QuanLyPhong qLP = new QuanLyPhong();
			qLP.nhap();
			phongTest.add(qLP);
		}
	}

	public static void hamHienThiPhong(ArrayList<QuanLyPhong> phongTest) {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("|Loại Phòng|Số Phòng|Số Giường| Giá Tiền |Trạng Thái| Khách Thuê | Ngày Thuê |");
		System.out.println("------------------------------------------------------------------------------");
		for (int i = 0; i < phongTest.size(); i++) {
			phongTest.get(i).hienThiPhong();
		}
	}

	public static void hamHienThiPhongTrong(ArrayList<QuanLyPhong> phongTest) {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("|Loại Phòng|Số Phòng|Số Giường| Giá Tiền |Trạng Thái| Khách Thuê | Ngày Thuê |");
		System.out.println("------------------------------------------------------------------------------");
		for (int i = 0; i < phongTest.size(); i++) {
			if (phongTest.get(i).getTrangThaiPhong().equalsIgnoreCase("trong"))
				phongTest.get(i).hienThiPhong();
		}
	}

	public static void docFilePhongBanDau(ArrayList<QuanLyPhong> phongTest, ArrayList<QuanLyNhanVien> nhanVienTest) {
		int dem = phongTest.size();
		QuanLyPhong qLP = new QuanLyPhong();
		phongTest = qLP.docFile();
		QuanLyNhanVien qLNV = new QuanLyNhanVien();
		nhanVienTest = qLNV.docFileNhanVien();
		if (phongTest.size() > dem)
			System.out.println("Đọc File thành công!!!");
	}

	public static void themPhong(ArrayList<QuanLyPhong> phongTest) {
		Scanner sc = new Scanner(System.in);
		int themPhong;
		while (true) {
			try {
				System.out.println("Nhập số phòng cần nhập: ");
				themPhong = Integer.parseInt(sc.nextLine());
				if (themPhong > 0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		QuanLyPhong qLP = new QuanLyPhong();
		for (int i = 0; i < themPhong; i++) {
			qLP.nhap();
			phongTest.add(qLP);
		}
		qLP.ghiFile(phongTest);
		hamHienThiPhong(phongTest);
	}

	public static void chinhSuaPhong(ArrayList<QuanLyPhong> phongTest) {
		Scanner sc = new Scanner(System.in);
		int soPhongCanChinhSua;
		while (true) {
			try {
				System.out.println("Nhập số phòng cần chỉnh sửa:");
				soPhongCanChinhSua = Integer.parseInt(sc.nextLine());
				if (soPhongCanChinhSua > 0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		int index = -1;
		QuanLyPhong qLP = new QuanLyPhong();
		for (int j = 0; j < phongTest.size(); j++) {
			if (phongTest.get(j).getSoPhong() == soPhongCanChinhSua) {
				qLP.nhap();
				phongTest.set(j, qLP).getLoaiPhong();
				phongTest.set(j, qLP).getSoPhong();
				phongTest.set(j, qLP).getSoGiuong();
				phongTest.set(j, qLP).getGiaTien();
				phongTest.set(j, qLP).getTrangThaiPhong();
				index = j;
			}
		}
		if (index == -1)
			System.out.println("Không tìm thấy phòng để chỉnh sửa");
		else {
			System.out.println("Chỉnh sửa thành công!!!");
			qLP.ghiFile(phongTest);
			hamHienThiPhong(phongTest);
		}
	}
	public static void xoaPhong(ArrayList<QuanLyPhong> phongTest) {
		Scanner sc = new Scanner(System.in);
		hamHienThiPhong(phongTest);
		int soPhongCanXoa;
		while (true) {
			try {
				System.out.println("Nhập số phòng cần xoá: ");
				soPhongCanXoa = Integer.parseInt(sc.nextLine());
				if (soPhongCanXoa > 0)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		int index = -1;
		for (int j = 0; j < phongTest.size(); j++) {
			if (phongTest.get(j).getSoPhong() == soPhongCanXoa) {
				phongTest.remove(j);
				index = j;
			}
		}
		if(index == -1 )
			System.out.println("Phòng này không tồn tại!!");
		else 
			System.out.println("Xoá phòng thành công!!");
	}

	public static void sapXepPhong(ArrayList<QuanLyPhong> phongTest) {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("|*1 Sắp xếp theo giá tiền giảm dần |");
		System.out.println("|*2 Sắp xếp theo giá tiền tăng dần |");
		System.out.println("------------------------------------");
		int chon;
		while (true) {
			try {
				System.out.println("------------Mời bạn chon------------");
				chon = Integer.parseInt(sc.nextLine());
				if (chon > 0 && chon != 3)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
			}
		}
		switch (chon) {
		case 1: {
			Collections.sort(phongTest, new Comparator<QuanLyPhong>() {
				@Override
				public int compare(QuanLyPhong o1, QuanLyPhong o2) {
					if (o1.getGiaTien() > o2.getGiaTien())
						return -1;
					else
						return 1;
				}
			});
			QuanLyPhong qLP = new QuanLyPhong();
			qLP.ghiFile(phongTest);
			hamHienThiPhong(phongTest);
			break;
		}
		case 2: {
			Collections.sort(phongTest, new Comparator<QuanLyPhong>() {
				@Override
				public int compare(QuanLyPhong o1, QuanLyPhong o2) {
					if (o1.getGiaTien() > o2.getGiaTien())
						return 1;
					else
						return -1;
				}
			});
			QuanLyPhong qLP = new QuanLyPhong();
			qLP.ghiFile(phongTest);
			hamHienThiPhong(phongTest);
			break;
		}
		}
	}

	public static void timKiemPhong(ArrayList<QuanLyPhong> phongTest, ArrayList<QuanLyKhachHang> khachHangTest) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("|*1 Tìm kiếm theo số phòng                   |");
		System.out.println("|*2 Tìm kiếm theo số CMND khách hàng đã thuê |");
		System.out.println("----------------------------------------------");
		int luaChon;
		while (true) {
			try {
				System.out.println("-----------------Mời bạn chọn-----------------");
				luaChon = Integer.parseInt(sc.next());
				if (luaChon == 1 || luaChon == 2)
					break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai, vui lòng nhập lại!!!");
			}
		}
		switch (luaChon) {
		case 1: {
			int soPhongCanTim;
			while (true) {
				try {
					System.out.println("Mời bạn nhập số phòng cần tìm kiếm ");
					soPhongCanTim = Integer.parseInt(sc.next());
					if (soPhongCanTim > 100)
						break;
				} catch (Exception e) {
					System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
				}
			}
			int index = -1;
			for (int i = 0; i < phongTest.size(); i++)
				if (phongTest.get(i).getSoPhong() == soPhongCanTim) {
					System.out
							.println("|-----------------------Phòng bạn cần tìm-VL.Group---------------------------|");
					System.out
							.println("|----------------------------------------------------------------------------|");
					System.out
							.println("|Loại Phòng|Số Phòng|Số Giường| Giá Tiền |Trạng Thái| Khách Thuê | Ngày Thuê |");
					System.out
							.println("|----------------------------------------------------------------------------|");
					phongTest.get(i).hienThiPhong();
					index = i;
				}
			if (index == -1)
				System.out.println("Không tìm thấy phòng theo số phòng");
			break;
		}
		case 2: {
			String cMND;
			while (true) {
				try {
					System.out.println("Mời bạn nhập CMND khách hàng");
					cMND = sc.next();
					if (cMND.length() == 9)
						break;
				} catch (Exception e) {
					System.err.println("Bạn đã nhập sai( Số CMND gồm 9 số)");
				}
			}
			int index = -1;
			for (int i = 0; i < phongTest.size(); i++)
				if (phongTest.get(i).getKhachThue().equalsIgnoreCase(cMND)) {
					index = i;
				}
			if (index == -1)
				System.out.println("Không tìm thấy phòng theo CMND khách hàng!!!");
			else {
				System.out
				.println("|-----------------------Phòng bạn cần tìm-VL.Group---------------------------|");
		System.out
				.println("------------------------------------------------------------------------------");
		System.out
				.println("|Loại Phòng|Số Phòng|Số Giường| Giá Tiền |Trạng Thái| Khách Thuê | Ngày Thuê |");
		System.out
				.println("------------------------------------------------------------------------------");
				for (int i = 0; i < phongTest.size(); i++)
					if (phongTest.get(i).getKhachThue().equalsIgnoreCase(cMND)) {
						phongTest.get(i).hienThiPhong();
					}
			}
			break;
		}
		}
	}

	public static void datPhong(ArrayList<QuanLyPhong> phongTest, ArrayList<QuanLyKhachHang> khachHangTest) {
		Scanner sc = new Scanner(System.in);
		int soPhongMuonDat;
		while (true) {
			try {
				System.out.println("Nhập số phòng bạn muốn đặt");
				soPhongMuonDat = Integer.parseInt(sc.next());
				if (soPhongMuonDat >= 100)
					break;
				else
					System.out.println("Số phòng bao gồm 3 chữ số!");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai(Số phòng gồm 3 số)");
			}
		}

		int index1 = -1;
		int index = -1;
		for (int i = 0; i < phongTest.size(); i++)
			if (phongTest.get(i).getSoPhong() == soPhongMuonDat) {
				index1 = i;
				if (phongTest.get(i).getTrangThaiPhong().equalsIgnoreCase("trong"))
					index = i;
			}
		if (index1 == -1)
			System.out.println("Phòng này không tồn tại, bạn vui lòng chọn phòng khác!!!");
		else {
			if (index == -1)
				System.out.println("Phòng này đã hết, bạn vui lòng chọn phòng khác!!!");
			else {
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				Calendar cal = Calendar.getInstance();
				Date today = null;
				today = cal.getTime();
				Date date = null;
				df.setLenient(false);
				while (true) {
					try {
						System.out.println("Nhập ngày tháng đặt(VD: 15-4-2021):");
						date = df.parse(sc.next());
						if (date.compareTo(df.parse(df.format(today))) >= 0)
							break;
						else
							System.out.println("Ngày đặt không thể nhỏ hơn ngày hiện tại!");
					} catch (ParseException e) {
						System.err.println("Bạn đã nhập sai(Vui lòng nhập đúng định dạng ngày-tháng-năm)");
					}
				}
				c1.setTime(date);
				Date date1 = null;
				while (true) {
					try {
						System.out.println("Nhập ngày dự kiến trả phòng:");
						date1 = df.parse(sc.next());
						if (date1.compareTo(date) >= 0)
							break;
						else
							System.out.println("Ngày trả phòng không được nhỏ hơn ngày đặt phòng!!");
					} catch (ParseException e) {
						System.err.println("Bạn đã nhập sai(Vui lòng nhập đúng định dạng ngày-tháng-năm)");
					}
				}
				c2.setTime(date1);
				long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
				double giaTienPhong = 1;
				double giaPhong = 1;
				for (int i = 0; i < phongTest.size(); i++)
					if (phongTest.get(i).getSoPhong() == soPhongMuonDat) {
						giaPhong = phongTest.get(i).getGiaTien();
						giaTienPhong = phongTest.get(i).getGiaTien() * noDay;
					}
				String CMNDKhachThue = "";
				for (int i = 0; i < khachHangTest.size(); i++)
					CMNDKhachThue = khachHangTest.get(i).getSoChungMinh();
				String dinhDangNgayDat = df.format(date);
				String dinhDangNgayTra = df.format(date1);
				System.out.println("|---------------------Check Lại Thông Tin-VL.Group-------------------------|");
				System.out.println("|CMND Khách| Ngày Thuê | Ngày Trả |Số Ngày Thuê| Giá Phòng | Tiền Phải Trả |");
				System.out.println("|--------------------------------------------------------------------------|");
				System.out.format("|%10s|%11s|%9s|%12s|%11s|%15s|", CMNDKhachThue, dinhDangNgayDat, dinhDangNgayTra,
						noDay, giaPhong, giaTienPhong);
				System.out.println("");
				System.out.println("|--------------------------------------------------------------------------|");
				int luaChon;
				while (true) {
					try {
						System.out.println("Sau khi kiểm tra thông tin, bạn có đồng ý đặt không");
						System.out.println("*1 Có");
						System.out.println("*2 Không");
						luaChon = Integer.parseInt(sc.next());
						if (luaChon == 1 || luaChon == 2)
							break;
					} catch (Exception e) {
						System.err.println("Bạn đã nhập sai, vui lòng nhập lại");
					}
				}
				switch (luaChon) {
				case 1:
					for (int i = 0; i < phongTest.size(); i++) {
						if (phongTest.get(i).getSoPhong() == soPhongMuonDat) {
							phongTest.get(i).setTrangThaiPhong("HET");
							for (int j = 0; j < khachHangTest.size(); j++)
								phongTest.get(i).setKhachThue(khachHangTest.get(j).getSoChungMinh());
							phongTest.get(i).setNgayThue(dinhDangNgayDat);
						}
					}
					QuanLyPhong qLP = new QuanLyPhong();
					qLP.ghiFile(phongTest);
					System.out.println("Chúc mừng bạn đã đặt phòng thành công!!");
					break;
				case 2:
					System.out.println("Cám ơn bạn!!!");
					break;
				}
			}
		}
	}

	public static void huyPhong(ArrayList<QuanLyPhong> phongTest, ArrayList<QuanLyKhachHang> khachHangTest) {
		Scanner sc = new Scanner(System.in);
		String cMNDHuyPhong;
		while(true) {
			try {
				System.out.println("Nhập CMND đã thuê cần huỷ phòng:");
				cMNDHuyPhong = sc.next();
				if(cMNDHuyPhong.length()==9)
					break;
				else
					System.out.println("Số CMND phải bao gồm 9 chữ số!!!");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai, vui lòng nhập lại!!!");
			}
		}
		int soPhongDaThue;
		while(true) {
			try {
				System.out.println("Nhập số phòng đã thuê");
				soPhongDaThue = sc.nextInt();
				if(soPhongDaThue >= 100)
					break;
				else
					System.out.println("Số phòng phải gồm 3 chữ số!!!");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai, vui lòng nhập lại!!!");
			}
		}
		int index = -1;
		int index1 = -1;
		
		for (int i = 0; i < phongTest.size(); i++) {
			if (phongTest.get(i).getKhachThue().equalsIgnoreCase(cMNDHuyPhong)) {
				if (phongTest.get(i).getSoPhong() == soPhongDaThue) {
					phongTest.get(i).setTrangThaiPhong("TRONG");
					phongTest.get(i).setKhachThue("KHONG");
					phongTest.get(i).setNgayThue("KHONG");
					index1 = i;
				}
				index = i;
			}

		}
		if (index == -1)
			System.out.println("CMND này chưa thuê phòng nào");
		else {
			if (index1 == -1)
				System.out.println("CMND này không thuê phòng này!");
			else
				System.out.println("Huỷ phòng thành công");
		}
	}

	public static void tinhTienPhong(ArrayList<QuanLyPhong> phongTest, ArrayList<QuanLyKhachHang> khachHangTest) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		df.setLenient(false);
		Date date1 = null;
		Date date = null;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		System.out.println("------------------------------------------");
		System.out.println("|*1 Tìm phòng theo số phòng để tính tiền |");
		System.out.println("|*2 Tìm phòng theo số CMND khách hàng    |");
		int luaChon;
		while (true) {
			try {
				System.out.println("----------------Mời bạn chọn--------------");
				luaChon = Integer.parseInt(sc.next());
				if (luaChon == 1 || luaChon == 2)
					break;
				else
					System.out.println("Bạn vui lòng chọn 1 trong 2 chức năng trên!");
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai, vui lòng nhập lại!!!");
			}
		}
		switch (luaChon) {
		case 1: {
			int soPhongTinhTien;
			while (true) {
				try {
					hamHienThiPhong(phongTest);
					System.out.println("Nhập số phòng muốn tính tiền:");
					soPhongTinhTien = Integer.parseInt(sc.next());
					if (soPhongTinhTien >= 1)
						break;
					else
						System.out.println("Số phòng gồm 3 chữ số!");
				} catch (Exception e) {
					System.err.println("Bạn đã nhập sai(Vui lòng nhập số)!!!");
				}
			}
			int index = -1;
			int index1 = -1;
			for (int i = 0; i < phongTest.size(); i++)
				if (phongTest.get(i).getSoPhong() == soPhongTinhTien) {
					index1 = i;
					if (phongTest.get(i).getTrangThaiPhong().equalsIgnoreCase("HET")) {
						try {
							date = df.parse(phongTest.get(i).getNgayThue());
						} catch (Exception e) {
						}
						c1.setTime(date);
						while (true) {
							try {
								System.out.println("Nhập ngày trả phòng: ");
								date1 = df.parse(sc.next());
								if (date1.compareTo(date) >= 0)
									break;
								else
									System.out.println("Ngày trả phòng không được nhỏ hơn ngày thuê phòng!");
							} catch (Exception e) {
								System.err.println("Bạn đã nhập sai( Vui lòng nhập đúng định dang ngày-tháng-năm)");
							}
						}
						c2.setTime(date1);

						long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
						double giaTienThue = 1;
						giaTienThue = phongTest.get(i).getGiaTien() * noDay;
						String CMNDKhachThue = "";
						int soPhongThue = 0;
						soPhongThue = phongTest.get(i).getSoPhong();
						CMNDKhachThue = phongTest.get(i).getKhachThue();
						String dinhDangNgayDat = df.format(date);
						String dinhDangNgayTra = df.format(date1);
						System.out.println("|--------------------------Tính Tiền-VL.Group-------------------------|");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.println("|CMND Khách|Số Phòng| Ngày Thuê | Ngày Trả |Số Ngày Thuê|Tiền Phải Trả|");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.format("|%10s|%8s|%11s|%10s|%12s|%13s|", CMNDKhachThue, soPhongThue, dinhDangNgayDat,
								dinhDangNgayTra, noDay, giaTienThue);
						System.out.println("");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.println("--------------Check lại thông tin và trả CMNĐ cho khách----------------");
						phongTest.get(i).setTrangThaiPhong("TRONG");
						phongTest.get(i).setKhachThue("KHONG");
						phongTest.get(i).setNgayThue("KHONG");
						QuanLyPhong qLP = new QuanLyPhong();
						qLP.ghiFile(phongTest);
						index = i;
						break;
					}
				}
			if(index1 == -1)
				System.out.println("Phòng này không tồn tại!!");
			else
				if (index == -1)
					System.out.println("Phòng này chưa có người thuê!!");
			break;
		}
		case 2: {
			hamHienThiPhong(phongTest);
			System.out.println("Nhập số CMND khách muốn tính tiền:");
			String soCMND = sc.next();
			int index = -1;
			for (int i = 0; i < phongTest.size(); i++)
				if (phongTest.get(i).getKhachThue().equalsIgnoreCase(soCMND)) {
					System.out.println("");
					System.out.println("CMND này đã thuê phòng: "+phongTest.get(i).getSoPhong());
					if (phongTest.get(i).getTrangThaiPhong().equalsIgnoreCase("HET")) {
						try {
							date = df.parse(phongTest.get(i).getNgayThue());
						} catch (Exception e) {
						}
						c1.setTime(date);
						while (true) {
							try {
								System.out.println("Nhập ngày trả phòng: ");
								date1 = df.parse(sc.next());
								if (date1.compareTo(date) >= 0)
									break;
								else
									System.out.println("Ngày trả phòng không được nhỏ hơn ngày thuê phòng!");
							} catch (Exception e) {
							}
						}
						c2.setTime(date1);
						long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
						double giaTienThue = 1;
						giaTienThue = phongTest.get(i).getGiaTien() * noDay;
						String CMNDKhachThue = "";
						int soPhongThue = 0;
						soPhongThue = phongTest.get(i).getSoPhong();
						CMNDKhachThue = phongTest.get(i).getKhachThue();
						String dinhDangNgayDat = df.format(date);
						String dinhDangNgayTra = df.format(date1);
						System.out.println("|--------------------------Tính Tiền-VL.Group-------------------------|");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.println("|CMND Khách|Số Phòng| Ngày Thuê | Ngày Trả |Số Ngày Thuê|Tiền Phải Trả|");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.format("|%10s|%8s|%11s|%10s|%12s|%13s|", CMNDKhachThue, soPhongThue, dinhDangNgayDat,
								dinhDangNgayTra, noDay, giaTienThue);
						System.out.println("");
						System.out.println("|---------------------------------------------------------------------|");
						System.out.println("--------------Check lại thông tin và trả CMNĐ cho khách----------------");
						phongTest.get(i).setTrangThaiPhong("TRONG");
						phongTest.get(i).setKhachThue("KHONG");
						phongTest.get(i).setNgayThue("KHONG");
						QuanLyPhong qLP = new QuanLyPhong();
						qLP.ghiFile(phongTest);
						index = i;
					}
				}
			if (index == -1)
				System.out.println("CMND này chưa thuê phòng nào!!");
			break;
		}
		}
	}

	public static void thongKePhong(ArrayList<QuanLyPhong> phongTest) {
		
		System.out.println("|---------------Thông Kê Doanh Thu- VL.Group---------------|");

	}
}
