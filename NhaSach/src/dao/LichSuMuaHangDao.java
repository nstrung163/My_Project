package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	
	DungChung dc = new DungChung();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<LichSuMuaHangBean> getLichSuMuaHangByTenDn(String tenDn) {
		
		ArrayList<LichSuMuaHangBean> dsLichSuMuaHang = new ArrayList<LichSuMuaHangBean>();
		String sql = "SELECT anh, tensach, tacgia, gia, SoLuongMua, (s.gia * cthd.SoLuongMua) as 'ThanhTien', NgayMua, damua\r\n" + 
					 "FROM (sach as s INNER JOIN ChiTietHoaDon as cthd on s.masach = cthd.MaSach)\r\n" + 
					 "	 INNER JOIN hoadon AS hd ON hd.MaHoaDon = cthd.MaHoaDon\r\n" + 
					 "	 INNER JOIN KhachHang AS kh ON hd.makh = kh.makh\r\n" + 
					 "WHERE kh.tendn = ?";
		try {
			dc.KetNoi();
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, tenDn);
			rs = ps.executeQuery();
			while(rs.next()) {
				String anh = rs.getString("anh");
				String tenSach = rs.getString("tensach");
				String tacGia = rs.getString("tacgia");
				double gia = rs.getDouble("gia");
				int soLuongMua = rs.getInt("SoLuongMua");
				double thanhTien = rs.getDouble("ThanhTien");
				Date ngayMua = rs.getDate("NgayMua");
				boolean daMua = rs.getBoolean("daMua");
				dsLichSuMuaHang.add(new LichSuMuaHangBean(anh, tenSach, tacGia, gia, soLuongMua, thanhTien, ngayMua, daMua));
			}
			dc.cn.close();
			System.out.println("Get all lịch sử mua hàng thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Get all lịch sử mua hàng thất bại!");
		}
		return dsLichSuMuaHang;
	}
	
}
