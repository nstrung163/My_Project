package bean;

import java.util.Date;

public class Sachbean {
	private String maloai;
	private String anh;
	private String tensach;
	private String tacgia;
	private int gia;
	private String masach;
	
	private int soLuong;
	private Date ngayNhap;

	/**
	 * Constructor Sachbean no parameter
	 */
	public Sachbean() {
		super();
	}


	/**
	 * Constructor Sachbean
	 * 
	 * @param maloai
	 * @param anh
	 * @param tensach
	 * @param tacgia
	 * @param gia
	 * @param masach
	 */
	public Sachbean(String maloai, String anh, String tensach, String tacgia, int gia, String masach) {
		super();
		this.maloai = maloai;
		this.anh = anh;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.masach = masach;
	}

	
	/**
	 * 
	 * @param maloai
	 * @param anh
	 * @param tensach
	 * @param tacgia
	 * @param gia
	 * @param masach
	 * @param soLuong
	 * @param ngayNhap
	 */
	public Sachbean(String maloai, String anh, String tensach, String tacgia, int gia, String masach, int soLuong,
			Date ngayNhap) {
		super();
		this.maloai = maloai;
		this.anh = anh;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.masach = masach;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
	}


	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}


	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	/**
	 * @return the ngayNhap
	 */
	public Date getNgayNhap() {
		return ngayNhap;
	}


	/**
	 * @param ngayNhap the ngayNhap to set
	 */
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}


	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

}
