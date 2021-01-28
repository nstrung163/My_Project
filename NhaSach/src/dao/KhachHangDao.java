package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;

public class KhachHangDao {
	
	DungChung dc = new DungChung();
	
	/**
	 * Check customer login
	 * @param khachHangBean
	 * @return boolean
	 */
	public boolean checkLoginUser(KhachHangBean khachHangBean)  {
		boolean flag = false;
		String sql = "SELECT * FROM KhachHang WHERE tendn = ? and pass = ?";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, khachHangBean.getTenDn());
			ps.setString(2, khachHangBean.getPass());
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
			dc.cn.close();
			rs.close();
			System.out.println("Kiểm tra đăng nhập thành công ở DAO");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Kiểm tra đăng nhập thất bại ở DAO");
		}
		return flag;
	}
	
	/**
	 * Get all customer 
	 * 
	 * @return listCustomer
	 */
	public ArrayList<KhachHangBean> getAllKhachHang() {
		ArrayList<KhachHangBean> listCustomer = new ArrayList<KhachHangBean>();
		String sql = "SELECT * FROM KhachHang ORDER BY makh DESC";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Long maKh = resultSet.getLong("maKh");
				String hoTen = resultSet.getString("hoTen");
				String diaChi = resultSet.getString("diaChi");
				String soDienThoai = resultSet.getString("sodt");
				String email = resultSet.getString("email");
				String tenDn = resultSet.getString("tenDn");
				String pass = resultSet.getString("pass");
				listCustomer.add( new KhachHangBean(maKh, hoTen, diaChi, soDienThoai, email, tenDn, pass));
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Get all customer failed: " + e.getMessage());
			e.printStackTrace();
		}
		return listCustomer;
	}
	
	/**
	 * Search customer
	 * 
	 * @param khachHangBean
	 * @return listCustomer
	 */
	public ArrayList<KhachHangBean> searchCustomer(KhachHangBean khachHangBean) {
		ArrayList<KhachHangBean> listCustomer = new ArrayList<KhachHangBean>();
		String sql = "SELECT * FROM KhachHang WHERE hoten like ? or diachi like ? or sodt like ? or tendn like ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + khachHangBean.getHoTen() + "%");
			preparedStatement.setString(2, "%" + khachHangBean.getDiaChi() + "%");
			preparedStatement.setString(3, "%" + khachHangBean.getSoDienThoai() + "%");
			preparedStatement.setString(4, "%" + khachHangBean.getTenDn() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Long maKh = resultSet.getLong("maKh");
				String hoTen = resultSet.getString("hoTen");
				String diaChi = resultSet.getString("diaChi");
				String soDienThoai = resultSet.getString("sodt");
				String email = resultSet.getString("email");
				String tenDn = resultSet.getString("tenDn");
				String pass = resultSet.getString("pass");
				listCustomer.add( new KhachHangBean(maKh, hoTen, diaChi, soDienThoai, email, tenDn, pass));
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Get all customer failed: " + e.getMessage());
			e.printStackTrace();
		}
		return listCustomer;
	}
	
	
	/**
	 * Add new customer
	 * 
	 * @param khachHangBean
	 */
	public boolean insertKhachHang(KhachHangBean khachHangBean) {
		boolean flag = false;
		String sql = "insert into KhachHang values(?,?,?,?,?,?)";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ps.setString(1, khachHangBean.getHoTen());
			ps.setString(2, khachHangBean.getDiaChi());
			ps.setString(3, khachHangBean.getSoDienThoai());
			ps.setString(4, khachHangBean.getEmail());
			ps.setString(5, khachHangBean.getTenDn());
			ps.setString(6, khachHangBean.getPass());
			flag = ps.executeUpdate() > 0;
			dc.cn.close();
			System.out.println("Đăng ký khách hàng thành công ở DAO");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Đăng thất bại ở DAO");
		}
		return flag;
	}
	
	/**
	 * Find customer by maKh
	 * 
	 * @param maKhInput
	 * @return khachHangBean
	 */
	public KhachHangBean findCustomerByMaKh(Long maKhInput) {
		KhachHangBean khachHangBean = new KhachHangBean();
		String sql = "SELECT * FROM KhachHang WHERE maKh = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setLong(1, maKhInput);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Long maKh = resultSet.getLong("maKh");
				String hoTen = resultSet.getString("hoTen");
				String diaChi = resultSet.getString("diaChi");
				String soDienThoai = resultSet.getString("sodt");
				String email = resultSet.getString("email");
				String tenDn = resultSet.getString("tenDn");
				String pass = resultSet.getString("pass");
				khachHangBean = new KhachHangBean(maKh, hoTen, diaChi, soDienThoai, email, tenDn, pass);
			}
			resultSet.close();
			dc.cn.close();
		} catch (Exception e) {
			System.out.println("Find customer by maKh failed: " + e.getMessage());
			e.printStackTrace();
		}
		return khachHangBean;
	}
	
	/**
	 * Update customer
	 * 
	 * @param khachHangBean
	 * @return boolean
	 */
	public boolean updateCustomer(KhachHangBean khachHangBean) {
		boolean flag = false;
		String sql = "UPDATE KhachHang SET hoten = ?, diachi = ?, sodt = ?, email = ?, tendn = ?, pass = ? WHERE makh = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setString(1, khachHangBean.getHoTen());
			preparedStatement.setString(2, khachHangBean.getDiaChi());
			preparedStatement.setString(3, khachHangBean.getSoDienThoai());
			preparedStatement.setString(4, khachHangBean.getEmail());
			preparedStatement.setString(5, khachHangBean.getTenDn());
			preparedStatement.setString(6, khachHangBean.getPass());
			preparedStatement.setLong(7, khachHangBean.getMaKh());
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Update customer failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Delete customer by maKh
	 * 
	 * @param maKh
	 * @return boolean
	 */
	public boolean deleteCustomer(Long maKh){
		boolean flag = false;
		String sql = "DELETE KhachHang WHERE makh = ?";
		try {
			dc.KetNoi();
			PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
			preparedStatement.setLong(1, maKh);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Delete customer failed: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Check duplicate tenDn
	 * 
	 * @param tenDn
	 * @return
	 */
	public boolean checkDuplicateTenDn(String tenDn) {
		boolean flag = false;
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("SELECT * FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			ResultSet rs = ps.executeQuery();
			flag = !rs.next();
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Get maKh of customer
	 * 
	 * @param tenDn
	 * @return maKh
	 */
	public Long getMaKh(String tenDn) {
		long maKh = 0;
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("SELECT makh FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				maKh = rs.getLong("makh");
			}
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maKh;
	}
	
	/**
	 * Get name of customer by tenDn
	 * 
	 * @param tenDn
	 * @return tenKh
	 */
	public String getTenKh(String tenDn) {
		String tenKh = "";
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("SELECT hoten FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tenKh = rs.getString("hoten");
			}
			System.out.println("Tên đăng nhập của khách hàng là: " + tenKh);
			rs.close();
			dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenKh;
	}
	
}
