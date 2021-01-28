package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import bean.Sachbean;

public class Sachdao {

	DungChung dc = new DungChung();

	/**
	 * Get all book
	 * 
	 * @return list book
	 * @throws Exception
	 */
	public ArrayList<Sachbean> getsach() {

		ArrayList<Sachbean> ds = new ArrayList<Sachbean>();
		try {
			dc.KetNoi();
			String sql = "SELECT * FROM SACH";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				int gia = rs.getInt("gia");
				String masach = rs.getString("masach");
				Sachbean sach = new Sachbean(maloai, anh, tensach, tacgia, gia, masach);
				ds.add(sach);
			}
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	/**
	 *  Get all sách Admin
	 *  
	 * @return danh sách sách
	 */
	public ArrayList<Sachbean> getAllSachAD() {

		ArrayList<Sachbean> ds = new ArrayList<Sachbean>();
		try {
			dc.KetNoi();
			String sql = "SELECT * FROM sach ORDER BY CONVERT(DATE, NgayNhap) desc";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				int gia = rs.getInt("gia");
				String masach = rs.getString("masach");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				Sachbean sach = new Sachbean(maloai, anh, tensach, tacgia, gia, masach, soLuong, ngayNhap);
				ds.add(sach);
			}
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	/**
	 * Thêm mới một quyển sách
	 * @param sachbean
	 */
	public void insertBook(Sachbean sachbean) {
		String sql = "INSERT INTO sach VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, sachbean.getMasach());
			ps.setString(2, sachbean.getTensach());
			ps.setInt(3, sachbean.getSoLuong());
			ps.setInt(4, sachbean.getGia());
			ps.setString(5, sachbean.getMaloai());
			ps.setInt(6, 1);
			System.out.println("anh: " + sachbean.getAnh());
			ps.setString(7, sachbean.getAnh());
			java.util.Date date = sachbean.getNgayNhap();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
			ps.setDate(8, sqlDate);
			ps.setString(9, sachbean.getTacgia());
			ps.executeUpdate();
			System.out.println("Thêm mới sách thành công ở DAO!");
		} catch (Exception e) {
			System.out.println("Thêm mới sách thất bại ở DAO!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Update sách 
	 * @param sachbean
	 * @return boolean
	 */
	public boolean updateBook(Sachbean sachbean) {
		boolean rowUpdate = false;
		String sql = "UPDATE sach SET tensach = ?, soluong = ?, gia = ?, maloai = ?, NgayNhap = ?, tacgia = ?, anh = ? WHERE masach = ?";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, sachbean.getTensach());
			ps.setInt(2, sachbean.getSoLuong());
			ps.setInt(3, sachbean.getGia());
			ps.setString(4, sachbean.getMaloai());
			java.util.Date date = sachbean.getNgayNhap();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
			ps.setDate(5, sqlDate);
			ps.setString(6, sachbean.getTacgia());
			ps.setString(7, sachbean.getAnh());
			ps.setString(8, sachbean.getMasach());
			rowUpdate = ps.executeUpdate() > 0;
			System.out.println("Cập nhật sách thành công!");
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Cập nhập sách thất bại:" + e.getMessage());
			e.printStackTrace();
		}
		return rowUpdate;
	}
	
	/**
	 * Xóa quyển sách theo mã sách
	 * @param maSach
	 */
	public void deleteBook(String maSach) {
		String sql = "DELETE Sach WHERE masach = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, maSach);
			preparedStatement.executeUpdate();
			System.out.println("Xóa sách thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Xóa sách thất bại!");
		}
	}
	
	/**
	 * Tìm kiếm sách theo mã sách, tên sách, mã loại
	 * 
	 * @param sachbean
	 * @return danh sách sách tìm được
	 */
	public ArrayList<Sachbean> searchBook(Sachbean sachbean) {
		ArrayList<Sachbean> dsBook = new ArrayList<Sachbean>();
		String sql = "SELECT * FROM sach WHERE masach = ? OR tensach like ? OR maloai = ?";
		try {
			dc.KetNoi();
//			sachbean.getTensach().replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, sachbean.getMasach());
			preparedStatement.setString(2,"%" + sachbean.getTensach() + "%");
			preparedStatement.setString(3, sachbean.getMaloai());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String maloai	= resultSet.getString("maLoai");
				String anh		= resultSet.getString("anh");
				String tensach	= resultSet.getString("tenSach");
				String tacgia	= resultSet.getString("tacGia");
				int gia			= resultSet.getInt("gia");
				String masach	= resultSet.getString("maSach");
				int soLuong		= resultSet.getInt("soLuong");
				Date ngayNhap	= resultSet.getDate("ngayNhap");
				dsBook.add(new Sachbean(maloai, anh, tensach, tacgia, gia, masach, soLuong, ngayNhap));
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tìm kiếm sách thất bại ở Dao: "  + e.getMessage());
		}
		return dsBook;
	}
	
	public boolean checkDuplicateMaSach(String maSach){
		boolean flag = false;
		String sql = "SELECT * FROM Sach WHERE maSach = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, maSach);
			ResultSet resultSet = preparedStatement.executeQuery();
			flag = !resultSet.next();
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Check duplicate mã sách failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Tìm kiếm sách theo mã sách
	 * 
	 * @param maSach
	 * @return
	 */
	public Sachbean findSachByMaSach(String maSach) {
		Sachbean sachbean = null;
		String sql = "SELECT maLoai, anh, tenSach, tacGia, gia, maSach, soLuong, ngayNhap   FROM Sach WHERE maSach = ?";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, maSach);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maloai = rs.getString("maLoai");
				String anh = rs.getString("anh");
				String tensach = rs.getString("tenSach");
				String tacgia = rs.getString("tacGia");
				int gia = rs.getInt("gia");
				String masach = rs.getString("maSach");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				sachbean = new Sachbean(maloai, anh, tensach, tacgia, gia, masach, soLuong, ngayNhap);
			}
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sachbean;
	}
	
	/**
	 * Kiểm tra sự tồn tại của ảnh
	 * @param img
	 * @return boolean
	 */
	public boolean checkImageExist(String img) {
		boolean flag = false;
		String sql = "SELECT * FROM sach WHERE anh = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, img);
			ResultSet resultSet = preparedStatement.executeQuery();
			flag = !resultSet.next();
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Kiểm tra ảnh thất bại!");
			e.printStackTrace();
		}
		return flag;
	}
	

	/**
	 * Get book current page
	 * @param currentPage
	 * @param pageSide
	 * @return
	 */
	public ArrayList<Sachbean> getBookCurrentPage(int currentPage, int pageSide) {

		ArrayList<Sachbean> dsSach = new ArrayList<Sachbean>();
		String sql = "SELECT * \r\n" + "FROM (SELECT  ROW_NUMBER() OVER(ORDER BY tensach) as STT, * \r\n"
				+ "	    FROM sach) AS sachTemp\r\n" + "WHERE STT BETWEEN ? AND ?";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setInt(1, currentPage);
			ps.setInt(2, pageSide);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				int gia = rs.getInt("gia");
				String masach = rs.getString("masach");
				dsSach.add(new Sachbean(maloai, anh, tensach, tacgia, gia, masach));
			}
			System.out.println("STT từ: " + currentPage + " đến " + pageSide);
			System.out.println("Tổng số sách trên 1 page là :" + dsSach.size());
			dc.cn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Get sách trên 1 trang thất bại!");
		}
		return dsSach;
	}
	
	/**
	 * Get total rows book
	 * @return total
	 */
	public int getTotalRowBook() {
		String sql = "SELECT COUNT(masach) as TotalRow FROM sach";
		int total = 0;
		try {
			dc.KetNoi();
			Statement st = dc.cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt("TotalRow");
			}
			System.out.println("Tổng số dòng của bảng sách là: " + total);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tính tổng số dòng trên bảng sách thất bại");
		}
		return total;
	}
//	public ArrayList<Sachbean> listSach(int currentPage, int recordsPerPage) {
//
//		ArrayList<Sachbean> dsSach = new ArrayList<Sachbean>();
//		int start = currentPage * recordsPerPage - recordsPerPage;
//		String sql = "SELECT * \r\n" + "FROM (SELECT  ROW_NUMBER() OVER(ORDER BY tensach) as STT, * \r\n"
//				+ "	    FROM sach) AS sachTemp\r\n" + "WHERE STT BETWEEN ? AND ?";
//		try {
//			dc.KetNoi();
//			PreparedStatement ps = dc.cn.prepareStatement(sql);
//			ps.setInt(1, start);
//			ps.setInt(2, recordsPerPage);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				String maloai = rs.getString("maloai");
//				String anh = rs.getString("anh");
//				String tensach = rs.getString("tensach");
//				String tacgia = rs.getString("tacgia");
//				int gia = rs.getInt("gia");
//				String masach = rs.getString("masach");
//				dsSach.add(new Sachbean(maloai, anh, tensach, tacgia, gia, masach));
//			}
//			System.out.println("Get sách trên 1 trang thành công");
//			dc.cn.close();
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Get sách trên 1 trang thất bại!");
//		}
//		return dsSach;
//	}
}
