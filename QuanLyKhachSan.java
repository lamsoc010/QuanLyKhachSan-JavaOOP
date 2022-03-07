package DoAnQuanLyKhachSan;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachSan {

	public static void main(String[] args) {
		ArrayList<QuanLyPhong> phongTest = new ArrayList<>();
		ArrayList<QuanLyNhanVien> nhanVienTest = new ArrayList<>();
		ArrayList<QuanLyKhachHang> khachHangTest = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int dem = phongTest.size();
		QuanLyPhong qLP = new QuanLyPhong();
		phongTest = qLP.docFile();
		QuanLyNhanVien qLNV = new QuanLyNhanVien();
		nhanVienTest = qLNV.docFileNhanVien();
		if (phongTest.size() > dem)
			System.out.println("Đọc File thành công!!!");
		int chon;
		do {
			Main.showMenu();
			while (true) {
				try {
					System.out.println("-------------Mời bạn chọn-----------");
					chon = Integer.parseInt(sc.next());
					if (chon >= 1 && chon <= 3)
						break;
					else
						System.out.println("Vui lòng chọn 1 trong 3 chức năng trên!!!");
				} catch (Exception e) {
					System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
				}
			}

			switch (chon) {
			case 1: {
				QuanLyKhachHang.nhapKhachHang(khachHangTest);
				int luaChon;
				do {
					Main.menuKhachHang();
					while (true) {
						try {
							System.out.println("----------Mời bạn chọn---------");
							luaChon = Integer.parseInt(sc.next());
							if (luaChon >= 1 && luaChon <= 5)
								break;
							else
								System.out.println("Vui lòng chọn 1 trong 5 chức năng trên!!!");
						} catch (Exception e) {
							System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
						}
					}
					switch (luaChon) {
					case 1: {
						QuanLyPhong.hamHienThiPhongTrong(phongTest);
						break;
					}
					case 2: {
						QuanLyPhong.hamHienThiPhongTrong(phongTest);
						QuanLyPhong.datPhong(phongTest, khachHangTest);
						break;
					}
					case 3: {
						QuanLyPhong.huyPhong(phongTest, khachHangTest);
						break;
					}
					case 4: {
						QuanLyNhanVien.hamHienThi(nhanVienTest);
						break;
					}
					}
				} while (luaChon != 5);
				break;
			}
			case 2: {
				System.out.print("Mời bạn nhập mã nhân viên:");
				String checkMaNV = sc.next();
				System.out.print("Mời bạn nhập mật khẩu:");
				String matKhau = sc.next();
				int index = -1;
				int index1 = -1;
				for (int i = 0; i < nhanVienTest.size(); i++) {
					if (nhanVienTest.get(i).getMaNhanVien().equalsIgnoreCase(checkMaNV))
						index = i;
					if (nhanVienTest.get(i).getMatKhau().equals(matKhau))
						index1 = i;
				}
				if (index == -1)
					System.out.println("Bạn đã nhập sai mã nhân viên, rất tiếc không thể đăng nhập!!");
				if (index1 == -1)
					System.out.println("Bạn đã nhập sai mật khẩu, rất tiếc không thể đăng nhập!!");
				if(index != -1 && index1 != -1){
					System.out.println("Đăng nhập thành công!!");
					int luaChon1;
					do {
						Main.menuNhanVien();
						while (true) {
							try {
								System.out.println("-------Mời bạn chọn------");
								luaChon1 = Integer.parseInt(sc.next());
								if (luaChon1 >= 1 && luaChon1 <= 3)
									break;
								else
									System.out.println("Vui lòng chọn 1 trong 3 chức năng trên!!!");
							} catch (Exception e) {
								System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
							}
						}
						switch (luaChon1) {
						case 1: {
							int luaChon2;
							do {
								Main.menuTacDongPhong();
								while (true) {
									try {
										System.out.println("-------Mời bạn chọn------");
										luaChon2 = Integer.parseInt(sc.next());
										if (luaChon2 >= 1 && luaChon2 <= 7)
											break;
										else
											System.out.println("Vui lòng chọn 1 trong 7 chức năng trên!!!");
									} catch (Exception e) {
										System.err.println("Bạn đã nhập sai(Vui lòng nhập số)");
									}
								}
								switch (luaChon2) {
								case 1: {
									QuanLyPhong.hamHienThiPhong(phongTest);
									break;
								}
								case 2: {
									QuanLyPhong.themPhong(phongTest);
									break;
								}
								case 3: {
									QuanLyPhong.xoaPhong(phongTest);
									break;
								}
								case 4: {
									QuanLyPhong.chinhSuaPhong(phongTest);
									break;
								}
								case 5: {
									QuanLyPhong.sapXepPhong(phongTest);
									break;
								}
								case 6: {
									QuanLyPhong.timKiemPhong(phongTest, khachHangTest);
									break;
								}
								}
							} while (luaChon2 != 7);
							break;
						}
						case 2: {
							QuanLyPhong.tinhTienPhong(phongTest, khachHangTest);
							break;
						}
						}
					} while (luaChon1 != 3);
					break;
				}
				break;
			}
			case 3: {
				System.out.println("Cám ơn bạn đã đến với VL.Group!!!");
				break;
			}
			}
		} while (chon != 3);
	}

}
