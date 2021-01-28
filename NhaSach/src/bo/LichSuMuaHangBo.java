package bo;

import java.util.ArrayList;

import bean.LichSuMuaHangBean;
import dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {

	private LichSuMuaHangDao lichSuMuaHangDao;
	
	/**
	 * Get all Lich Su Mua Hang
	 * @param tenDn
	 * @return
	 */
	public ArrayList<LichSuMuaHangBean>	getAllLichSuMuaHang(String tenDn) {
		return lichSuMuaHangDao.getLichSuMuaHangByTenDn(tenDn);
	}
}
