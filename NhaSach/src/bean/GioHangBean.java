package bean;

public class GioHangBean {

	private String maSach;
	private String tenSach;
	private String tacGia;
	private double gia;
	private int soLuong;
	private double thanhTien;
	private String anh;
	private String maLoai;
	
	/**
	 * @param maSach
	 * @param tenSach
	 * @param tacGia
	 * @param gia
	 * @param soLuong
	 */
	public GioHangBean(String maLoai, String maSach, String tenSach,String anh , String tacGia, double gia, int soLuong) {
		this.maLoai = maLoai;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.anh = anh;
		this.tacGia = tacGia;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = soLuong * gia;
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
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}
	/**
	 * @return the maLoai
	 */
	public String getMaLoai() {
		return maLoai;
	}
	/**
	 * @param maLoai the maLoai to set
	 */
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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
	
	
}
