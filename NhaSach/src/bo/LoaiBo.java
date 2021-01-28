package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class LoaiBo {
	LoaiDao loaiDao = new LoaiDao();
	/**
	 * Lấy địa chỉ đầu tiên của mảng bên LoaiBo
	 */
	ArrayList<LoaiBean> ds;

	/**
	 * Get all loại sách
	 * 
	 * @return danh sách loại sách
	 */
	public ArrayList<LoaiBean> getLoai(){
		// Để trỏ đến 1 vùng nhớ của Dao
		ds = loaiDao.getLoaiSach();
		return ds;
	}
	
	/**
	 * Thêm mới loại sách
	 * @param loaiBean
	 * @return
	 */
	public boolean insertBookType(LoaiBean loaiBean) {
		return loaiDao.insertBookType(loaiBean);
	}
	
	/**
	 * Check duplicate book type by maLoai
	 * 
	 * @param maLoai
	 * @return
	 */
	public boolean checkDuplicateMaLoai(String maLoai) {
		return loaiDao.chekcDuplicateMaLoai(maLoai);
	}
	
	/**
	 * Find book type by maLoai 
	 * @param maLoai
	 * @return
	 */
	public LoaiBean findBookTypeByMaLoai(String maLoai) {
		return loaiDao.findLoaiByMaLoai(maLoai);
	}
	
	/**
	 * Update book type
	 * @param loaiBean
	 * @return
	 */
	public boolean updateBookType(LoaiBean loaiBean) {
		return loaiDao.updateBookType(loaiBean);
	}
	
	/**
	 * Delete book type 
	 * 
	 * @param maLoai
	 * @return 
	 */
	public boolean deleteBookType(String maLoai) {
		return loaiDao.deleteBookType(maLoai);
	}
}
