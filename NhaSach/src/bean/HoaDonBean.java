package bean;

import java.util.Date;

public class HoaDonBean {
	private Long maHoaDon;
	private Long maKh;
	private Date ngayMua;
	private boolean daMua;
	
	/**
	 * 
	 */
	public HoaDonBean() {
		super();
	}
	/**
	 * @param maKh
	 * @param ngayMua
	 * @param daMua
	 */
	public HoaDonBean(Long maKh, Date ngayMua, boolean daMua) {
		super();
		this.maKh = maKh;
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
	 * @return the maKh
	 */
	public Long getMaKh() {
		return maKh;
	}
	/**
	 * @param maKh the maKh to set
	 */
	public void setMaKh(Long maKh) {
		this.maKh = maKh;
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
	
	
}
