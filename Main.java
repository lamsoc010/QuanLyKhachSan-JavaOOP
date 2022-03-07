package DoAnQuanLyKhachSan;

import java.util.Scanner;

public class Main {
	
	public static void showMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("|----------Menu-VL.Group-----------|");
		System.out.println("|----------------------------------|");
		System.out.println("|*1 Bạn là Khách Hàng              |");
		System.out.println("|*2 Bạn là Nhân Viên               |");
		System.out.println("|*3 Kết thúc chương trình          |");
		System.out.println("|----------------------------------|");
		
	}
	public static void menuKhachHang() {
		System.out.println("|--------Menu-VL.Group--------|");
		System.out.println("|-----------------------------|");
		System.out.println("|*1 Hiển thị danh sách phòng  |");
		System.out.println("|*2 Đặt phòng                 |");
		System.out.println("|*3 Huỷ phòng                 |");
		System.out.println("|*4 Liên hệ nhân viên         |");
		System.out.println("|*5 Về Trang Chủ              |");
		System.out.println("|-----------------------------|");
		
	}
	public static void menuNhanVien() {
		System.out.println("|-----Menu-VL.Group-----|");
		System.out.println("|-----------------------|");
		System.out.println("|*1 Thao tác lên phòng  |");
		System.out.println("|*2 Tính tiền           |");
		System.out.println("|*3 Đăng xuất           |");
		System.out.println("|-----------------------|");
	}
	public static void menuTacDongPhong() {
		System.out.println("|-----Menu-VL.Group-----|");
		System.out.println("|-----------------------|");
		System.out.println("|*1 Hiển thị phòng      |");
		System.out.println("|*2 Thêm phòng          |");
		System.out.println("|*3 Xoá phòng           |");
		System.out.println("|*4 Chỉnh sửa phòng     |");
		System.out.println("|*5 Sắp xếp phòng       |");
		System.out.println("|*6 Tìm kiếm phòng      |");
		System.out.println("|*7 Quay lại            |");
		System.out.println("|-----------------------|");
	}
	
}
