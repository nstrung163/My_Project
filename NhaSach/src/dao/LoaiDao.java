package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.LoaiBean;

public class LoaiDao {
	
	DungChung dc = new DungChung();
	
	/**
	 * Get all loại sách
	 * 
	 * @return danh sách loại
	 */
	public ArrayList<LoaiBean> getLoaiSach() {
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		
		try {
			//B1: Ket noi vao csdl
			dc.KetNoi();
			//B2: Cho thuc hien cau lenh sql
			String sql = "SELECT * FROM LOAI";
			//B3: Cho thuc hien cau len sql
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B4: Duyet qua cac loai va luu vao ds
			while(rs.next()) {
				String maLoai = rs.getString("maLoai");
				String tenLoai = rs.getString("tenLoai");
				LoaiBean loai = new LoaiBean(maLoai, tenLoai);
				ds.add(loai);
			} 
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	/**
	 * Thêm mới loại sách
	 * 
	 * @param loaiBean
	 * @return boolean
	 */
	public boolean insertBookType(LoaiBean loaiBean) {
		boolean flag = false;
		String sql = "INSERT INTO loai(maloai, tenloai) VALUES (?,?)";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, loaiBean.getMaLoai());
			preparedStatement.setString(2, loaiBean.getTenLoai());
			flag = preparedStatement.executeUpdate() > 0;
			System.out.println("Insert book type successful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert book type failed: " + e.getMessage());
		}
		return flag;
	}
	
	/**
	 * Check duplicate book type by maLoai
	 * 
	 * @param maLoai
	 * @return
	 */
	public boolean chekcDuplicateMaLoai(String maLoai) {
		boolean flag = false;
		String sql = "SELECT * FROM loai WHERE maloai = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, maLoai);
			ResultSet resultSet = preparedStatement.executeQuery();
			flag = !resultSet.next();
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check duplicate mã sách failed: " + e.getMessage());
		}
		return flag;
	}
	
	/**
	 * Find book type by MaLoai
	 * 
	 * @param maLoai
	 * @return
	 */
	public LoaiBean findLoaiByMaLoai(String maLoai) {
		LoaiBean loaiBean = new LoaiBean();
		String sql = "SELECT * FROM loai WHERE maloai = ? ";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, maLoai);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String maLoaiN = resultSet.getString("maLoai");
				String tenLoai = resultSet.getString("tenLoai");
				loaiBean = new LoaiBean(maLoaiN, tenLoai);
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Find book type failed: " + e.getMessage());
			e.printStackTrace();
		}
		return loaiBean;
	}
	
	/**
	 * Update book type 
	 * 
	 * @param loaiBean
	 * @return 
	 */
	public boolean updateBookType(LoaiBean loaiBean) {
		boolean flag = false;
		String sql = "UPDATE loai SET tenloai = ? WHERE maloai = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, loaiBean.getTenLoai());
			preparedStatement.setString(2, loaiBean.getMaLoai());
			flag =  preparedStatement.executeUpdate() > 0;
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Update book type failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean  deleteBookType(String maLoai) {
		boolean flag = false;
		String sql = "DELETE loai WHERE maloai = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, maLoai);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Delete book type failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
}
