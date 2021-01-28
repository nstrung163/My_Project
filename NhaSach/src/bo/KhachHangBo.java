package bo;

import java.util.ArrayList;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khachHangDao = new KhachHangDao();
	
	/**
	 * Get all customer
	 * 
	 * @return list customer
	 */
	public ArrayList<KhachHangBean> getAllCustomer() {
		return khachHangDao.getAllKhachHang();
	}
	
	/**
	 * Search customer
	 * 
	 * @param khachHangBean
	 * @return list customer
	 */
	public ArrayList<KhachHangBean> searchCustomer(KhachHangBean khachHangBean) {
		return khachHangDao.searchCustomer(khachHangBean);
	}
	
	/**
	 * Check duplicate tenDn
	 * 
	 * @param tenDn
	 * @return boolean
	 */
	public boolean checkDuplicateUser(String tenDn) {
		return khachHangDao.checkDuplicateTenDn(tenDn);
	}
	
	/**
	 * Customer register account
	 * 
	 * @param khachHangBean
	 */
	public void addNewKhachHang(KhachHangBean khachHangBean) {
		 khachHangDao.insertKhachHang(khachHangBean);
	}
	
	/**
	 * Find customer by maKh
	 * 
	 * @param maKh
	 * @return KhachHangBean
	 */
	public KhachHangBean findCustomerByMaKh(Long maKh) {
		return khachHangDao.findCustomerByMaKh(maKh);
	}
	
	/**
	 * Update customer
	 * 
	 * @param khachHangBean
	 * @return boolean
	 */
	public boolean updateCustomer(KhachHangBean khachHangBean) {
		return khachHangDao.updateCustomer(khachHangBean);
	}
	
	/**
	 * Get maKh by tenDn
	 * @param tenDn
	 * @return maKh
	 */
	public Long getMaKh(String tenDn){
		return khachHangDao.getMaKh(tenDn);
	}
	
	/**
	 * Delete customer by maKh
	 * 
	 * @param maKh
	 * @return boolean
	 */
	public boolean deleteCustomer(Long maKh) {
		return khachHangDao.deleteCustomer(maKh);
	}
	
	/**
	 * Check customer login
	 * 
	 * @param khachHangBean
	 * @return boolean
	 */
	public boolean checkLoginKhachHang(KhachHangBean khachHangBean) {
		return khachHangDao.checkLoginUser(khachHangBean);
	}
	
	/**
	 * Get name of customer by tenDn
	 * @param tenDn
	 * @return name customer
	 */
	public String getNameCustomer(String tenDn) {
		return khachHangDao.getTenKh(tenDn);
	}
	
}
