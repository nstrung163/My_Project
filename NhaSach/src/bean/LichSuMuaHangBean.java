package bean;

import java.util.Date;

public class LichSuMuaHangBean {
	
	private String anh;
	private String tenSach;
	private String tacGia;
	private double gia;
	private int soLuongMua;
	private Double thanhTien;
	private Date ngayMua;
	private boolean daMua;
	/**
	 * @param tenSach
	 * @param tacGia
	 * @param gia
	 * @param soLuongMua
	 * @param thanhTien
	 * @param ngayMua
	 * @param daMua
	 */
	public LichSuMuaHangBean(String anh, String tenSach, String tacGia, double gia, int soLuongMua, Double thanhTien, Date ngayMua,
			boolean daMua) {
		super();
		this.anh = anh;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.thanhTien = gia * soLuongMua;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	/**
	 * @return the anh
	 */
	public String getAnh() {
		return anh;
	}
	/**
	 * @param anh the anh to set
	 */
	public void setAnh(String anh) {
		this.anh = anh;
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
	 * @return the tacGia
	 */
	public String getTacGia() {
		return tacGia;
	}
	/**
	 * @param tacGia the tacGia to set
	 */
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	/**
	 * @return the gia
	 */
	public double getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(double gia) {
		this.gia = gia;
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
	 * @return the thanhTien
	 */
	public Double getThanhTien() {
		return thanhTien;
	}
	/**
	 * @param thanhTien the thanhTien to set
	 */
	public void setThanhTien(Double thanhTien) {
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
