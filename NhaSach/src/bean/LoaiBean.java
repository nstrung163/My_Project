package bean;

public class LoaiBean {
	private String maLoai;
	private String tenLoai;
	
	public LoaiBean() {
	}
	/**
	 * @param maLoai
	 * @param tenLoai
	 */
	public LoaiBean(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
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
	 * @return the tenLoai
	 */
	public String getTenLoai() {
		return tenLoai;
	}
	/**
	 * @param tenLoai the tenLoai to set
	 */
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	
}
