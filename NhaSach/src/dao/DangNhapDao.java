package dao;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.DangNhapBean;

public class DangNhapDao {

	public String xacThucUser(DangNhapBean dangNhapBean) throws Exception {
		
		String tenDangNhap = dangNhapBean.getTenDangNhap();
		String matKhau = dangNhapBean.getMatKhau();
		
		DungChung dc = new DungChung();
		ResultSet resultSet = null;
		
		String tenDangNhapDB = "";
		String matKhauDB = "";
		dc.KetNoi();
		Statement statement = dc.cn.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM KhachHang");
		try {
			while(resultSet.next()) {
				tenDangNhapDB = resultSet.getString("tenDangNhap");
				matKhauDB = resultSet.getString("matKhau");
				
				if(tenDangNhap.equals(tenDangNhapDB) && matKhau.equals(matKhauDB)) {
					return "user";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Thông tin đăng nhập người dùng không hợp lệ!";
	}
}
