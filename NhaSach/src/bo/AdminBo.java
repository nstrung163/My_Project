package bo;

import bean.AdminBean;
import dao.AdminDao;

public class AdminBo {
	AdminDao adminDao = new AdminDao();
	public boolean adminValidation(AdminBean adminBean) {
		return adminDao.adminValidate(adminBean);
	}
}
