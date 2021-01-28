package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AdminBean;

public class AdminDao {
	DungChung dc = new DungChung();
	public boolean adminValidate(AdminBean adminBean) {
		
		boolean temp = false;
		String sql = "SELECT * FROM DangNhap WHERE TenDangNhap = ? and MatKhau = ? and Quyen = ?";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, adminBean.getTenDangNhap());
			ps.setString(2, adminBean.getMatKhau());
			ps.setBoolean(3, adminBean.isQuyen());
			ResultSet rs = ps.executeQuery();
			temp = rs.next();
			rs.close();
			dc.cn.close();
			System.out.println("Kiểm tra thông tin admin thành công ở DAO");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Kiểm tra thông tin admin thất bại! DAO");
		}
		return temp;
	}
}
