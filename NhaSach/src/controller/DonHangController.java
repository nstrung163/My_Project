package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DonHangBean;
import bo.DonHangBo;

/**
 * Servlet implementation class DonHangController
 */
@WebServlet("/DonHangController")
public class DonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DonHangBo donHangBo = new DonHangBo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "updateQuantityDonHang":
			updateQuantityDonHang(request, response);	
			break;
		case "comfirmDonHang":
			comfirmDonHang(request, response);	
			break;
		case "delete":
			deleteChiTietHoaDon(request, response);	
			break;
		case "searchDonHang":
			searchDonHang(request, response);	
			break;
		default:
			showListDonHang(request, response);
			break;
		}
	}

	private void searchDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ArrayList<DonHangBean> listDonHang = new ArrayList<DonHangBean>();
		
		if( keyword != null) {
			listDonHang = donHangBo.searchDonHang(keyword, keyword);
		} 
		request.setAttribute("listDonHang", listDonHang);
		request.getRequestDispatcher("admin-don-hang.jsp").forward(request, response);
	}

	private void comfirmDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String maHoaDon = request.getParameter("maHoaDon");
		if( maHoaDon != null) {
			donHangBo.updateDonHang(true, Long.parseLong(maHoaDon));
		}
		response.sendRedirect("DonHangController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showListDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DonHangBean> listDonHang = donHangBo.getAllDonHang();
		request.setAttribute("listDonHang", listDonHang);
		request.getRequestDispatcher("admin-don-hang.jsp").forward(request, response);
	}
	
	private void updateQuantityDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String maHoaDon = request.getParameter("maHoaDon");
		String maSach	= request.getParameter("maSach");
		String soLuongMua = request.getParameter("soLuongMua");
		if(maHoaDon != null && maSach != null && soLuongMua != null) {
			donHangBo.updateQuantityOfDonHang(Integer.parseInt(soLuongMua), Long.parseLong(maHoaDon), maSach);
		}
		response.sendRedirect("DonHangController");
	}
	
	private void deleteChiTietHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String maHoaDon = request.getParameter("maHoaDon");
		String maSach	= request.getParameter("maSach");
		if(maHoaDon != null && maSach != null) {
			donHangBo.deleteChiTietDonHang(Long.parseLong(maHoaDon), maSach);
		}
		response.sendRedirect("DonHangController");
	}

}
