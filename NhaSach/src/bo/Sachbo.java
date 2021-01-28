package bo;

import java.util.ArrayList;

import bean.Sachbean;
import dao.Sachdao;

public class Sachbo {

	Sachdao sachdao = new Sachdao();
	ArrayList<Sachbean> ds;

	/**
	 * Lấy toàn bộ sách
	 * 
	 * @return Danh sách sách
	 * @throws Exception 
	 */
	public ArrayList<Sachbean> getsach() {
		ds = sachdao.getsach();
		return ds;
	}
	
	/**
	 * Get danh sách sách cho trang admin
	 * @return danh sách sách Admin
	 */
	public  ArrayList<Sachbean> getAllSachAd() {
		ds = sachdao.getAllSachAD();
		return ds;
	}
	
	/**
	 * Kiểm tra tự tồn tại của mã sách
	 * @param img
	 * @return boolean
	 */
	public boolean checkImageBook(String img) {
		return sachdao.checkImageExist(img);
	}
	
	public boolean checkDuplicateMaSach(String maSach) {
		return sachdao.checkDuplicateMaSach(maSach);
	}
	
	/**
	 * Thêm mới 1 quyển sách
	 * 
	 * @param sachbean
	 */
	public void themMoiSach(Sachbean sachbean) {
		sachdao.insertBook(sachbean);
	}
	
	/**
	 * Update sach
	 * @param sachbean
	 * @return sachbean
	 */
	public boolean capNhapSach(Sachbean sachbean) {
		return sachdao.updateBook(sachbean);
	}
	
	/**
	 * Xóa sách
	 * 
	 * @param maSach
	 */
	public void xoaSach(String maSach) {
		sachdao.deleteBook(maSach);
	}
	
	/**
	 * Search book 
	 * 
	 * @param sachbean
	 * @return
	 */
	public ArrayList<Sachbean> searchBook(Sachbean sachbean) {
		return sachdao.searchBook(sachbean);
	}
	/**
	 * Tìm kiếm sách theo mã sách
	 * 
	 * @param maSach
	 * @return sách
	 */
	public Sachbean findSachByMaSach(String maSach) {
		return sachdao.findSachByMaSach(maSach);
	}
	
	/**
	 * Get book on current page BO
	 * @param currentPage
	 * @param pageSide
	 * @return
	 */
	public ArrayList<Sachbean> getCurrentPageSach(int currentPage, int pageSide) {
		return sachdao.getBookCurrentPage(currentPage, pageSide);
	}
	
	/**
	 * Get total row book
	 * @return total
	 */
	public int getTotalRowBook() {
		return sachdao.getTotalRowBook();
	}
	
//	public ArrayList<Sachbean> TimKiemSachTheoMa(String maLoai) {
//		ds = sachdao.getsach();
//		ArrayList<Sachbean> ketQuaTimKiem = new ArrayList<Sachbean>();
//		for( Sachbean sach: ds ) {
//			if(sach.getMaloai().trim().equalsIgnoreCase(maLoai.trim()))
//				 ketQuaTimKiem.add(sach);
//		}
//		return ketQuaTimKiem;
//	}
	
//	/**
//	 * Tìm kiếm sách theo tên
//	 * 
//	 * @param keyword
//	 * @return danh sách ketQuaTimKiem
//	 * @throws Exception 
//	 */
//	public ArrayList<Sachbean> TimKiemSachTheoTen (String keyword) {
//		ArrayList<Sachbean> ketQuaTimKiem = new ArrayList<Sachbean>();
//		ds = sachdao.getsach();
//		for( Sachbean sach: ds) {
//			if (sach.getTensach().toLowerCase().contains(keyword.toLowerCase()) || 
//				sach.getTacgia().toLowerCase().contains(keyword.toLowerCase()))
//				ketQuaTimKiem.add(sach);
//		}
//		return ketQuaTimKiem;
//	}
//	
//	/**
//	 * 
//	 * Chi tiết sách
//	 * 
//	 * @param maSach
//	 * @return Chi tiết sách
//	 */
//	public ArrayList<Sachbean> ChiTietSach(String maSach) {
//		ArrayList<Sachbean> ketQuaTraVe =new ArrayList<Sachbean>();
//		for (Sachbean sach: ds ) {
//			if (sach.getMasach().toLowerCase().contains(maSach.toLowerCase()))
//				ketQuaTraVe.add(sach);
//		}
//		return ketQuaTraVe;
//	}
	
}
