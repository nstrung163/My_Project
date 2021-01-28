package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bean.KhachHangBean;
import bo.AdminBo;
import bo.KhachHangBo;
import dao.KhachHangDao;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "userLogin":
			loginUser(request, response);
			break;
		case "userRegister":
			addNewUser(request, response);
			break;
		case "userLogout":
			logoutUser(request, response);
			break;
		case "adminLogin":
			loginAdmin(request, response);
			break;
		default:
			break;
		}
	}

	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		AdminBean adminBean = new AdminBean(tenDangNhap, matKhau, true);
		AdminBo adminBo = new AdminBo();
		if(adminBo.adminValidation(adminBean)) {
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("True");
		} else {
			request.getRequestDispatcher("dang-nhap-admin.jsp").forward(request, response);
		}
	}

	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			response.sendRedirect("SachController");
			System.out.println("Bạn đã đăng xuất thành công!");
		}
	}

	private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tenDn = request.getParameter("tenDn");
		String hoTen = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		KhachHangBean khachHangBean = new KhachHangBean(hoTen, diaChi, soDienThoai, email, tenDn, pass);
		KhachHangBo khachHangBo = new KhachHangBo();
		if(khachHangBo.checkDuplicateUser(tenDn)) {
			response.setContentType("text/html; charset: UTF-8");
			response.getWriter().write("True");
			khachHangBo.addNewKhachHang(khachHangBean);
		}
	}
	
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String tenDn = request.getParameter("tenDn");
		String pass = request.getParameter("pass");
		KhachHangBean khachHangBean = new KhachHangBean();
		khachHangBean.setTenDn(tenDn);
		khachHangBean.setPass(pass);
		KhachHangDao khachHangDao = new KhachHangDao();
		String hoTen = khachHangDao.getTenKh(tenDn);
		KhachHangBo khachHangBo = new KhachHangBo();
		if(khachHangBo.checkLoginKhachHang(khachHangBean)) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("user", tenDn);
			request.setAttribute("checkDangNhap", tenDn);
			session.setAttribute("hoTen", hoTen);
			response.setContentType("text/html; charset: UTF-8");
			response.getWriter().write("True");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
