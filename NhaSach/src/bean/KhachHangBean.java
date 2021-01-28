package bean;


public class KhachHangBean {
	private Long maKh;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String tenDn;
	private String pass;
	
	
	/**
	 * 
	 */
	public KhachHangBean() {
		super();
	}
	/**
	 * Constructor 
	 * 
	 * @param maKh
	 * @param hoTen
	 * @param diaChi
	 * @param soDienThoai
	 * @param email
	 * @param tenDn
	 * @param pass
	 */
	public KhachHangBean(Long maKh, String hoTen, String diaChi, String soDienThoai, String email, String tenDn,
			String pass) {
		super();
		this.maKh = maKh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.tenDn = tenDn;
		this.pass = pass;
	}
	
	/**
	 * Constructor without maKh
	 * 
	 * @param hoTen
	 * @param diaChi
	 * @param soDienThoai
	 * @param email
	 * @param tenDn
	 * @param pass
	 */
	public KhachHangBean(String hoTen, String diaChi, String soDienThoai, String email, String tenDn, String pass) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.tenDn = tenDn;
		this.pass = pass;
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
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}
	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tenDn
	 */
	public String getTenDn() {
		return tenDn;
	}
	/**
	 * @param tenDn the tenDn to set
	 */
	public void setTenDn(String tenDn) {
		this.tenDn = tenDn;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
