package bean;

public class ChiTietHoaDonBean {
	private Long maChiTietHD;
	private String maSach;
	private int soLuongMua;
	private Long maHoaDon;
	/**
	 * 
	 */
	public ChiTietHoaDonBean() {
		super();
	}
	/**
	 * @param maSach
	 * @param soLuongMua
	 * @param maHoaDon
	 */
	public ChiTietHoaDonBean(String maSach, int soLuongMua, Long maHoaDon) {
		super();
		this.maSach = maSach;
		this.soLuongMua = soLuongMua;
		this.maHoaDon = maHoaDon;
	}
	/**
	 * @return the maChiTietHD
	 */
	public Long getMaChiTietHD() {
		return maChiTietHD;
	}
	/**
	 * @param maChiTietHD the maChiTietHD to set
	 */
	public void setMaChiTietHD(Long maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
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
	
	
}
