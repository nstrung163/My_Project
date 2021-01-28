package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KhachHangBean;
import bo.KhachHangBo;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/KhachHangController")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KhachHangBo khachHangBo = new KhachHangBo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "showFormAdd":
			showFormAdd(request, response);
			break;
		case "addNewCustomer":
			insertCustomer(request, response);
			break;
		case "showFormEdit":
			showFormAdd(request, response);
			break;
		case "updateCustomer":
			updateCustomer(request, response);
			break;
		case "deleteCustomer":
			deleteCustomer(request, response);
			break;
		case "searchCustomer":
			searchCustomer(request, response);
			break;
		default:
			showListCustomer(request, response);
			break;
		}
	}

	private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String keyword = new String (request.getParameter("keyword").getBytes ("iso-8859-1"), "UTF-8");
		KhachHangBean khachHangBean = new KhachHangBean();
		khachHangBean.setHoTen(keyword);
		khachHangBean.setDiaChi(keyword);
		khachHangBean.setSoDienThoai(keyword);
		khachHangBean.setTenDn(keyword);
		ArrayList<KhachHangBean> listCustomer = new ArrayList<KhachHangBean>();
		if(khachHangBean != null) {
			listCustomer = khachHangBo.searchCustomer(khachHangBean);
		}
		request.setAttribute("listCustomer", listCustomer);
		request.getRequestDispatcher("admin-customer.jsp").forward(request, response);
		
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String maKh = request.getParameter("maKh");
		if( maKh != null) {
			khachHangBo.deleteCustomer(Long.parseLong(maKh));
		}
		response.sendRedirect("KhachHangController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tenDn = request.getParameter("tenDn");
		String hoTen = new String (request.getParameter("hoTen").getBytes ("iso-8859-1"), "UTF-8");
		String diaChi = new String (request.getParameter("diaChi").getBytes ("iso-8859-1"), "UTF-8");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(khachHangBo.checkDuplicateUser(tenDn)) {
			KhachHangBean khachHangBean = new KhachHangBean(hoTen, diaChi, soDienThoai, email, tenDn, pass);
			KhachHangBo khachHangBo = new KhachHangBo();
			khachHangBo.addNewKhachHang(khachHangBean);
			response.sendRedirect("KhachHangController");
		} else {
			request.setAttribute("errMessage", "Tên đăng nhập đã tồn tại!");
			request.getRequestDispatcher("admin-customer-add.jsp").forward(request, response);
		}
	}

	private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maKh = request.getParameter("maKh");
		if(maKh != null) {
			request.setAttribute("khachHangBean", khachHangBo.findCustomerByMaKh(Long.parseLong(maKh)));
			request.getRequestDispatcher("admin-customer-add.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("admin-customer-add.jsp").forward(request, response);
		}
	}

	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maKh = request.getParameter("maKh");
		String tenDn = request.getParameter("tenDn"); 
		String hoTen = new String (request.getParameter("hoTen").getBytes ("iso-8859-1"), "UTF-8");
		String diaChi = new String (request.getParameter("diaChi").getBytes ("iso-8859-1"), "UTF-8");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(!khachHangBo.checkDuplicateUser(tenDn)) {
			KhachHangBean khachHangBean = new KhachHangBean(Long.parseLong(maKh), hoTen, diaChi, soDienThoai, email, tenDn, pass);
			khachHangBo.updateCustomer(khachHangBean);
		}
		response.sendRedirect("KhachHangController");
	}
	private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<KhachHangBean> listCustomer = khachHangBo.getAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		request.getRequestDispatcher("admin-customer.jsp").forward(request, response);
	}
}
