package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bo.LoaiBo;

/**
 * Servlet implementation class LoaiSachController
 */
@WebServlet("/LoaiSachController")
public class LoaiSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiBo loaiBo = new LoaiBo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "addNewBookType":
			insertBookType(request, response);
			break;
		case "showFormAdd":
			showAddNewBookType(request, response);
			break;
		case "edit":
			showAddNewBookType(request, response);
			break;
		case "updateBookType":
			updateBookType(request, response);
			break;
		case "delete":
			deleteBookType(request, response);
			break;
		default:
			showListBookType(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showListBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		ArrayList<LoaiBean> listBookType = new ArrayList<LoaiBean>();
		listBookType = loaiBo.getLoai();
		request.setAttribute("listBookType", listBookType);
		request.getRequestDispatcher("admin-loai.jsp").forward(request, response);
	}
	
	private void showAddNewBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String maLoai = request.getParameter("maLoai");
		if(maLoai != null) {
			request.setAttribute("loaiBean", loaiBo.findBookTypeByMaLoai(maLoai));
		}
		request.getRequestDispatcher("admin-loai-add.jsp").forward(request, response);
	}
	
	private void updateBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String maLoai = request.getParameter("maLoai");
		String tenLoai = new String (request.getParameter("tenLoai").getBytes("iso-8859-1"), "UTF-8");
		LoaiBean loaiBean = new LoaiBean(maLoai, tenLoai);
		if(maLoai != null && tenLoai != null) {
			loaiBo.updateBookType(loaiBean);
		}
		response.sendRedirect("LoaiSachController");
	}
	private void insertBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maLoai = request.getParameter("maLoai");
		String tenLoai = new String (request.getParameter("tenLoai").getBytes ("iso-8859-1"), "UTF-8");
		LoaiBean loaiBean = new LoaiBean(maLoai, tenLoai);
		if( loaiBo.checkDuplicateMaLoai(maLoai)) {
			loaiBo.insertBookType(loaiBean);
			response.sendRedirect("LoaiSachController");
		} else {
			request.setAttribute("errMessage", "Mã Loại Sách đã bị trùng!");
			request.getRequestDispatcher("admin-loai-add.jsp").forward(request, response);
		}
	}
	
	private void deleteBookType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String maLoai = request.getParameter("maLoai");
		if(maLoai != null) {
			loaiBo.deleteBookType(maLoai);
		}
		response.sendRedirect("LoaiSachController");
	}

}
