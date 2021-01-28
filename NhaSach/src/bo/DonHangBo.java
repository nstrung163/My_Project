package bo;

import java.util.ArrayList;

import bean.DonHangBean;
import dao.DonHangDao;

public class DonHangBo {

	private DonHangDao donHangDao = new DonHangDao();
	
	/**
	 * Get all DonHang BO
	 * 
	 * @return ArrayList<DonHangBean
	 */
	public ArrayList<DonHangBean> getAllDonHang() {
		return donHangDao.getAllDonHang();
	}
	
	/**
	 * Confirm DonHang
	 * 
	 * @param daMua
	 * @param maHoaDon
	 * @return boolean
	 */
	public boolean updateDonHang(boolean daMua, Long maHoaDon) {
		return donHangDao.updateDonHang(daMua, maHoaDon);
	}
	
	/**
	 * Update quantity of DonHang
	 * 
	 * @param soLuongMua
	 * @param maHoaDon
	 * @param maSach
	 * @return boolean
	 */
	public boolean updateQuantityOfDonHang(int soLuongMua, Long maHoaDon, String maSach) {
		return donHangDao.updateQuantityDonHang(soLuongMua, maHoaDon, maSach);
	}
	
	/**
	 * Delete ChiTietDonHang BO
	 * 
	 * @param maHoaDon
	 * @param maSach
	 * @return boolean
	 */
	public boolean deleteChiTietDonHang(Long maHoaDon, String maSach) {
		return donHangDao.deleteChiTietHoaDon(maHoaDon, maSach);
	}
	
	/**
	 * Search DonHang by name and phone number of customer
	 * 
	 * @param hoTen
	 * @param soDT
	 * @return ArrayList<DonHangBean>
	 */
	public ArrayList<DonHangBean> searchDonHang(String hoTen, String soDT) {
		return donHangDao.searchDonHang(hoTen, soDT);
	}
}
