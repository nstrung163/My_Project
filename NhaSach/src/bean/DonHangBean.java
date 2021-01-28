package bean;

import java.util.Date;

public class DonHangBean {
	private Long maHoaDon;
	private Long maKH;
	private String hoTen;
	private String soDT;
	private String diaChi;
	private String maSach;
	private String tenSach;
	private int soLuongMua;
	private int gia;
	private double thanhTien;
	private Date ngayMua;
	private boolean daMua;
	
	/**
	 * @param maHoaDon
	 * @param maKH
	 * @param hoTen
	 * @param soDT
	 * @param diaChi
	 * @param maSach
	 * @param tenSach
	 * @param soLuongMua
	 * @param gia
	 * @param ngayMua
	 * @param daMua
	 */
	public DonHangBean(Long maHoaDon, Long maKH, String hoTen, String soDT, String diaChi, String maSach, String tenSach,
			int soLuongMua, int gia, Date ngayMua, boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhTien = soLuongMua * gia;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	/**
	 * Constructor DonHang
	 * 
	 * @param maHoaDon
	 * @param maKH
	 * @param hoTen
	 * @param soDT
	 * @param diaChi
	 * @param maSach
	 * @param tenSach
	 * @param soLuongMua
	 * @param gia
	 * @param thanhTien
	 * @param ngayMua
	 * @param daMua
	 */
	public DonHangBean(Long maHoaDon, Long maKH, String hoTen, String soDT, String diaChi, String maSach, String tenSach,
			int soLuongMua, int gia, double thanhTien, Date ngayMua, boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhTien = thanhTien;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	/**
	 * @return the maHoaDon
	 */
	public Long getMaHoaDon() {
		return maHoaDon;
	}
	/**
	 * @param maHoaDon the maHoaDon to set
	 */
	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	/**
	 * @return the maKH
	 */
	public Long getMaKH() {
		return maKH;
	}
	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(Long maKH) {
		this.maKH = maKH;
	}
	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}
	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	/**
	 * @return the soDT
	 */
	public String getSoDT() {
		return soDT;
	}
	/**
	 * @param soDT the soDT to set
	 */
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @return the maSach
	 */
	public String getMaSach() {
		return maSach;
	}
	/**
	 * @param maSach the maSach to set
	 */
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	/**
	 * @return the tenSach
	 */
	public String getTenSach() {
		return tenSach;
	}
	/**
	 * @param tenSach the tenSach to set
	 */
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	/**
	 * @return the soLuongMua
	 */
	public int getSoLuongMua() {
		return soLuongMua;
	}
	/**
	 * @param soLuongMua the soLuongMua to set
	 */
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	/**
	 * @return the gia
	 */
	public int getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(int gia) {
		this.gia = gia;
	}
	/**
	 * @return the thanhTien
	 */
	public double getThanhTien() {
		return thanhTien;
	}
	/**
	 * @param thanhTien the thanhTien to set
	 */
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	/**
	 * @return the ngayMua
	 */
	public Date getNgayMua() {
		return ngayMua;
	}
	/**
	 * @param ngayMua the ngayMua to set
	 */
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	/**
	 * @return the daMua
	 */
	public boolean isDaMua() {
		return daMua;
	}
	/**
	 * @param daMua the daMua to set
	 */
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
	
	
}
