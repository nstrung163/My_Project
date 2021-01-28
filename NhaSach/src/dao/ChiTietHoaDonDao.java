package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.ChiTietHoaDonBean;

public class ChiTietHoaDonDao {
	
	DungChung dc = new DungChung();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertChiTietHD(ChiTietHoaDonBean chiTietHoaDonBean) {
		
		String sql = "INSERT INTO ChiTietHoaDon values(?, ?, ?)";
		try {
			dc.KetNoi();
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, chiTietHoaDonBean.getMaSach());
			ps.setInt(2, chiTietHoaDonBean.getSoLuongMua());
			ps.setLong(3, chiTietHoaDonBean.getMaHoaDon());
			ps.executeUpdate();
			dc.cn.close();
			System.out.println("INSERT chi tiết hóa đơn thành công");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT chi tiết hóa đơn thành công");
		}
	}
	
//	public void updateChiTietHD(ChiTietHoaDonBean chiTietHoaDonBean) {
//		
//		String sql = "UPDATE ChiTietHoaDon SET SoLuongMua = ? WHERE MaHoaDon = ? AND MaSach = ?";
//		try {
//			dc.KetNoi();
//			ps = dc.cn.prepareStatement(sql);
//			ps.setInt(1, chiTietHoaDonBean.getSoLuongMua());
//			ps.setLong(2, chiTietHoaDonBean.getMaHoaDon());
//			ps.setString(3, chiTietHoaDonBean.getMaSach());
//			ps.executeUpdate();
//			dc.cn.close();
//			System.out.println("UPDATE số lượng sách trong chi tiết hóa đơn thành công!");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("UPDATE số lượng sách trong chi tiết hóa đơn thất bại1");
//		}
//	}
//	
//	public void deleteChiTietHD(ChiTietHoaDonBean chiTietHoaDonBean) {
//		String sql = "DELETE FROM ChiTietHoaDon WHERE MaHoaDon = ? AND MaSach = ?";
//		
//		try {
//			dc.KetNoi();
//			ps = dc.cn.prepareStatement(sql);
//			ps.setLong(1, chiTietHoaDonBean.getMaHoaDon());
//			ps.setString(2, chiTietHoaDonBean.getMaSach());
//			ps.executeUpdate();
//			System.out.println("DELETE sách thành công trong chi tiết hóa đơn");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("DELETE sách thất bại trong chi tiết hóa đơn");
//		}
//		
//	}
}
