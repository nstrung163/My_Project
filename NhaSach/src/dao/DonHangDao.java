package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.DonHangBean;

public class DonHangDao {
	DungChung dc = new DungChung();
	
	/**
	 * Get all DonHang DAO
	 * @return ArrayList<DonHangBean>
	 */
	public ArrayList<DonHangBean> getAllDonHang() {
		ArrayList<DonHangBean> listDonHang = new ArrayList<DonHangBean>();
		String sql = "SELECT * FROM ViewDonHang ORDER BY CONVERT(DATE, NgayMua) DESC";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Long maHoaDon	= resultSet.getLong("maHoaDon");
				Long maKH		= resultSet.getLong("maKH");
				String hoTen	= resultSet.getString("hoTen");
				String soDT		= resultSet.getString("sodt");
				String diaChi	= resultSet.getString("diaChi");
				String maSach	= resultSet.getString("maSach");
				String tenSach	= resultSet.getString("tenSach");
				int soLuongMua	= resultSet.getInt("soLuongMua");
				int gia			= resultSet.getInt("gia");
				double thanhTien= resultSet.getDouble("thanhTien");
				Date ngayMua	= resultSet.getDate("ngayMua");
				boolean daMua	= resultSet.getBoolean("daMua");
				listDonHang.add(new DonHangBean(maHoaDon, maKH, hoTen, soDT, diaChi, maSach, tenSach, soLuongMua, gia, thanhTien, ngayMua, daMua));
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Get all DonHang failed: " + e.getMessage());
			e.printStackTrace();
		}
		return listDonHang;
	}
	
	/**
	 * Update confirm DonHang DAO
	 * 
	 * @param daMua
	 * @param maHoaDon
	 * @return
	 */
	public boolean updateDonHang(boolean daMua, Long maHoaDon){
		boolean flag = false;
		String sql = "UPDATE ViewDonHang SET damua = ? WHERE MaHoaDon = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setBoolean(1, daMua);
			preparedStatement.setLong(2, maHoaDon);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Update DonHang failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Update quantity of DonHang
	 * 
	 * @param soLuongMua
	 * @param maHoaDon
	 * @param maSach
	 * @return
	 */
	public boolean updateQuantityDonHang(int soLuongMua, Long maHoaDon, String maSach) {
		boolean flag = false;
		String sql = "UPDATE ViewDonHang SET SoLuongMua = ? WHERE MaHoaDon = ? AND MaSach = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setInt(1, soLuongMua);
			preparedStatement.setLong(2, maHoaDon);
			preparedStatement.setString(3, maSach);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Update quantity of DonHang failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Delete ChiTietHoaDon
	 * 
	 * @param maHoaDon
	 * @param maSach
	 * @return boolean
	 */
	public boolean deleteChiTietHoaDon(Long maHoaDon, String maSach) {
		boolean flag = false;
		String sql = "DELETE FROM ChiTietHoaDon WHERE MaHoaDon = ? AND MaSach = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setLong(1, maHoaDon);
			preparedStatement.setString(2, maSach);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Delete ChiTietHoaDon falied: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<DonHangBean> searchDonHang(String hoTenInput, String soDTInput){
		ArrayList<DonHangBean> listAllDonHang = new ArrayList<DonHangBean>();
		String sql = "SELECT * FROM ViewDonHang WHERE hoten LIKE ? OR sodt LIKE ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1,"%" + hoTenInput + "%");
			preparedStatement.setString(2,"%" + soDTInput + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Long maHoaDon	= resultSet.getLong("maHoaDon");
				Long maKH		= resultSet.getLong("maKH");
				String hoTen	= resultSet.getString("hoTen");
				String soDT		= resultSet.getString("soDT");
				String diaChi	= resultSet.getString("diaChi");
				String maSach	= resultSet.getString("maSach");
				String tenSach	= resultSet.getString("tenSach");
				int soLuongMua	= resultSet.getInt("soLuongMua");
				int gia			= resultSet.getInt("gia");
				double thanhTien= resultSet.getDouble("thanhTien");
				Date ngayMua 	= resultSet.getDate("ngayMua");
				boolean daMua	= resultSet.getBoolean("daMua");
				listAllDonHang.add(new DonHangBean(maHoaDon, maKH, hoTen, soDT, diaChi, maSach, tenSach, soLuongMua, gia, thanhTien, ngayMua, daMua));
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Search DonHang failed: " + e.getMessage());
			e.printStackTrace();
		}
		return listAllDonHang;
	}
}
