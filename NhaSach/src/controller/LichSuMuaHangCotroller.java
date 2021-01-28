package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LichSuMuaHangBean;
import bean.LoaiBean;
import bo.LichSuMuaHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class LichSuMuaHangCotroller
 */
@WebServlet("/LichSuMuaHangCotroller")
public class LichSuMuaHangCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuMuaHangCotroller() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hienThiLichSuMuaHang(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void hienThiLichSuMuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tenDn = (String) session.getAttribute("user");
		LichSuMuaHangBo lichSuMuaHangBo = new LichSuMuaHangBo();
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
		if(tenDn != null) {
			ArrayList<LichSuMuaHangBean> dsLichSuMuaHang = lichSuMuaHangBo.getAllLichSuMuaHang(tenDn);
			if(dsLichSuMuaHang.size() == 0) {
				request.setAttribute("dsLichSuMuaHang", "isEmpty");
				request.getRequestDispatcher("lich-su-mua-hang.jsp").forward(request, response);
			} else {
				request.setAttribute("dsLichSuMuaHang", dsLichSuMuaHang);
				request.getRequestDispatcher("lich-su-mua-hang.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("dsLichSuMuaHang", "isEmpty");
			request.getRequestDispatcher("lich-su-mua-hang.jsp").forward(request, response);
		}
		request.setAttribute("dsLoaiSach", dsLoaiSach);
		
	}
}
