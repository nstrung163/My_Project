package bo;

import java.util.ArrayList;

import bean.GioHangBean;

public class GioHangBo {

	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();

	/**
	 * Hàm thêm mới sách
	 * 
	 * @param maSach
	 * @param tenSach
	 * @param anh
	 * @param tacGia
	 * @param gia
	 * @param soLuong
	 * 
	 * @return Danh sách giỏ hàng
	 */
	public void ThemSach(String maLoai, String maSach, String tenSach, String anh, String tacGia, double gia, int soLuong) {
		for (GioHangBean gioHangBean : ds) {
			if (gioHangBean.getMaSach().equals(maSach)) {
				int soLuongSach = gioHangBean.getSoLuong() + soLuong;
				gioHangBean.setSoLuong(soLuongSach);
				return;
			}
		}
		ds.add(new GioHangBean(maLoai, maSach, tenSach, anh, tacGia, gia, soLuong));
	}

	public void suaGioHang(String maLoai, String maSach, String tenSach, String anh, String tacGia, double gia, int soLuong) {
		/*
		 * int n = ds.size(); for (int i = 0; i < n; i++) { if (
		 * ds.get(i).getTenSach().toLowerCase().trim().equalsIgnoreCase(tenSach.
		 * toLowerCase().trim())) { maSach = ds.get(i).getMaSach(); tenSach =
		 * ds.get(i).getTenSach(); tacGia = ds.get(i).getTacGia(); anh =
		 * ds.get(i).getAnh(); // ds.get(i).setTacGia(tacGia); int soLuongSach =
		 * ds.get(i).getSoLuong() + soLuong; ds.get(i).setSoLuong(soLuongSach); double
		 * thanhTien = soLuongSach * ds.get(i).getGia();
		 * ds.get(i).setThanhTien(thanhTien); return; } }
		 */
		for (GioHangBean gioHangBean : ds) {
			if (gioHangBean.getMaSach().equals(maSach)) {
				gioHangBean.setSoLuong(soLuong);
				double thanhTien = soLuong * gioHangBean.getGia();
				gioHangBean.setThanhTien(thanhTien);
				return;
			}
		}
		ds.add(new GioHangBean(maLoai, maSach, tenSach, anh, tacGia, gia, soLuong));
	}

	/**
	 * Hàm tính tổng tiền
	 * 
	 * @return Tổng tiền
	 */
	public double TongTien() {
		int n = ds.size();
		double s = 0.0;
		for (int i = 0; i < n; i++) {
			s += ds.get(i).getThanhTien();
		}
		return s;
	}

	/**
	 * Xóa sản phẩm khỏi giỏ hàng
	 * 
	 * @param maSach
	 */
	public void xoa(String maSach) {
		for (GioHangBean gioHangBean : ds) {
			if (gioHangBean.getMaSach().toLowerCase().trim().equalsIgnoreCase(maSach.toLowerCase().trim())) {
				ds.remove(gioHangBean);
				break;
			}
		}
	}
}
