package bean;

public class AdminBean {
	private String tenDangNhap;
	private String matKhau;
	private boolean quyen;
	/**
	 * @param tenDangNhap
	 * @param matKhau
	 * @param quyen
	 */
	public AdminBean(String tenDangNhap, String matKhau, boolean quyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	/**
	 * @return the tenDangNhap
	 */
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	/**
	 * @param tenDangNhap the tenDangNhap to set
	 */
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @return the quyen
	 */
	public boolean isQuyen() {
		return quyen;
	}
	/**
	 * @param quyen the quyen to set
	 */
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
}
