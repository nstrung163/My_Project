package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChiTietHoaDonBean;
import bean.GioHangBean;
import bean.HoaDonBean;
import bean.LoaiBean;
import bo.GioHangBo;
import bo.LoaiBo;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.KhachHangDao;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HoaDonDao hoaDonDao = new HoaDonDao();
    ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoaiBo loaiBo = new LoaiBo();
			ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
			request.setAttribute("dsLoaiSach", dsLoaiSach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String action = request.getParameter("action") != null ? request.getParameter("action"): "none";
		switch (action) {
		case "suaGioHang":
			suaGioHang(request, response);
			break;
		case "xoaSach":
			xoaSach(request, response);
			break;
		case "themSach":
			themSach(request, response);
			break;
		case "thanhToan":
			thanhToan(request, response);
			break;
		default:
			hienThiGioHang(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void hienThiGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = new GioHangBo();
		gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		session.setAttribute("ssGioHang", gioHangBo);
		request.getRequestDispatcher("gio-hang.jsp").forward(request, response);
	}
	
	private void thanhToan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = new GioHangBo();
		gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		
		//Tạo mới 1 hóa đơn
		KhachHangDao khachHangDao = new KhachHangDao();
		HoaDonDao hoaDonDao = new HoaDonDao();
		String tenDn = (String) session.getAttribute("user");
		Long maKh = khachHangDao.getMaKh(tenDn);
		HoaDonBean hoaDonBean = new HoaDonBean();
		hoaDonBean.setMaKh(maKh);
		hoaDonBean.setDaMua(false);
		hoaDonDao.insertHoaDon(hoaDonBean);
		//Remove session ở ssGioHang khi thanh toán
		session.removeAttribute("ssGioHang");
		
		//Lấy số hóa đơn mới tạo
		Long maxMaHoaDon = hoaDonDao.getMaMaxHoaDon();
		
		//Insert dữ liệu vào chi tiết hóa đơn với maHoaDon = maxMaHoaDon
		for(GioHangBean g : gioHangBo.ds) {
			ChiTietHoaDonBean chiTietHoaDonBean = new ChiTietHoaDonBean(g.getMaSach(), g.getSoLuong(), maxMaHoaDon);
			chiTietHoaDonDao.insertChiTietHD(chiTietHoaDonBean);
		}
		response.sendRedirect("GioHangController");
	}
	
	private void themSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maLoai = request.getParameter("maLoai");
		String maSach = request.getParameter("maSach");
		String tenSach = request.getParameter("ts");
		String anh = request.getParameter("anh");
		String tacGia = request.getParameter("tg");
		String gia = request.getParameter("gia");
		
		// Mua hàng lần đầu
		if (maSach != null) {
			GioHangBo gioHangBo;
			if (session.getAttribute("ssGioHang") == null) {
				gioHangBo = new GioHangBo();
				session.setAttribute("ssGioHang", gioHangBo);
			}
		gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		gioHangBo.ThemSach(maLoai, maSach, tenSach, anh, tacGia, Double.parseDouble(gia), 1);
		
//		Long maxMaHoaDon = hoaDonDao.getMaMaxHoaDon();
//		ChiTietHoaDonBean chiTietHoaDonBean = new ChiTietHoaDonBean(maSach, 1, maxMaHoaDon);
//		chiTietHoaDonDao.insertChiTietHD(chiTietHoaDonBean);
		
		session.setAttribute("ssGioHang", gioHangBo);
		response.sendRedirect("GioHangController");
		
		}
	}
	
	private void suaGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		String maLoai	= request.getParameter("maLoai");
		String maSach	= request.getParameter("maSach");
		String tenSach	= request.getParameter("ts");
		String anh		= request.getParameter("anh");
		String tacGia 	= request.getParameter("tg");
		String gia 		= request.getParameter("gia");
		String soLuongSua	= request.getParameter("soLuongCapNhat");
		int slSua		= (!soLuongSua.isEmpty() ? Integer.parseInt(soLuongSua) : 1);
		gioHangBo.suaGioHang(maLoai, maSach, tenSach, anh, tacGia, Double.parseDouble(gia), slSua);
		
//		Long maxMaHoaDon = hoaDonDao.getMaMaxHoaDon();
//		ChiTietHoaDonBean chiTietHoaDonBean = new ChiTietHoaDonBean(maSach, slSua, maxMaHoaDon);
//		chiTietHoaDonDao.updateChiTietHD(chiTietHoaDonBean);
		
		session.setAttribute("ssGioHang", gioHangBo);
		response.sendRedirect("GioHangController");
	}
	
	private void xoaSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		String maSach = request.getParameter("maSach");
		gioHangBo.xoa(maSach);
		session.setAttribute("ssGioHang", gioHangBo);
		
//		Long maxMaHoaDon = hoaDonDao.getMaMaxHoaDon();
//		ChiTietHoaDonBean chiTietHoaDonBean = new ChiTietHoaDonBean();
//		chiTietHoaDonBean.setMaHoaDon(maxMaHoaDon);
//		chiTietHoaDonBean.setMaSach(maSach);
//		chiTietHoaDonDao.deleteChiTietHD(chiTietHoaDonBean);
//		request.setAttribute("action", "xoaSach");
		response.sendRedirect("GioHangController");
		}
	
}
