//package controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.HoaDonBean;
//import dao.HoaDonDao;
//import dao.KhachHangDao;
//
///**
// * Servlet implementation class HoaDonController
// */
//@WebServlet("/HoaDonController")
//public class HoaDonController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public HoaDonController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			taoHoaDon(request, response);
//		} catch (ServletException | IOException | SQLException  e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//	private void taoHoaDon(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException,  SQLException  {
//		HttpSession session = request.getSession();
//		KhachHangDao khachHangDao = new KhachHangDao();
//		HoaDonDao hoaDonDao = new HoaDonDao();
//		
//		String tenDn = (String) session.getAttribute("user");
//		Long maKh = khachHangDao.getMaKh(tenDn);
//		
//		HoaDonBean hoaDonBean = new HoaDonBean();
//		hoaDonBean.setMaKh(maKh);
//		hoaDonBean.setDaMua(false);
//		
//		hoaDonDao.insertHoaDon(hoaDonBean);
//		//Remove session ở ssGioHang khi thanh toán
//		session.removeAttribute("ssGioHang");
////		if (khachHangDao.getMaKh(tenDn) != 0) {
////			hoaDonDao.insertHoaDon(hoaDonBean);
////		}
//		response.sendRedirect("SachController");
//	}
//	
//
//}
