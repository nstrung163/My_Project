package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bean.PageModel;
import bean.Sachbean;
import bo.LoaiBo;
import bo.Sachbo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int PAGE_SIZE = 11;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "timKiemSach":
			timKiemSach(request, response);
			break;
		case "timKiemLoai":
			timKiemSach(request, response);
			break;
		default:
			hienThiTrangChu(request, response);
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
	
	private void hienThiTrangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Sachbo sachBo = new Sachbo();
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
		String pageNumberStr = request.getParameter("pageNumber");
		
		if(pageNumberStr != null) {
			int pageNumber = Integer.parseInt(pageNumberStr);
			int totalPage = sachBo.getTotalRowBook() / PAGE_SIZE;
			request.setAttribute("paginationList", new PageModel(pageNumber, totalPage));
			if(pageNumber != 1){
				pageNumber = pageNumber - 1;
				pageNumber = pageNumber * PAGE_SIZE + 1;
			}
			request.setAttribute("dssach", sachBo.getCurrentPageSach(pageNumber, pageNumber + PAGE_SIZE));
			request.setAttribute("dsLoaiSach", dsLoaiSach);
			request.getRequestDispatcher("trang-chu.jsp").forward(request, response);
		} else {
			int totalPage = sachBo.getTotalRowBook();
			request.setAttribute("dssach", sachBo.getCurrentPageSach(1, 1 + PAGE_SIZE));
			request.setAttribute("paginationList", new PageModel(1, totalPage));
			request.setAttribute("dsLoaiSach", dsLoaiSach);
			request.getRequestDispatcher("trang-chu.jsp").forward(request, response);
		}
	}
	
	private void timKiemSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Sachbo sachBo = new Sachbo();
		ArrayList<Sachbean> ds = sachBo.getsach();
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
//		String maLoai = request.getParameter("keyword");
		String keyword = request.getParameter("keyword");
		Sachbean sachbean = new Sachbean();
		sachbean.setMaloai(keyword);
		sachbean.setTensach(keyword);
		sachbean.setMasach(keyword);
		ds = sachBo.searchBook(sachbean);
		request.setAttribute("dssach", ds);
		request.setAttribute("dsLoaiSach", dsLoaiSach);
		request.getRequestDispatcher("trang-chu.jsp").forward(request, response);
	}
	
	
//	public void phanTrang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// Pagnination
//		int currentPage = 1;
//		int recordsPerPage = 1;
//		try {
//			if (request.getParameter("currentPage") != null) {
//				currentPage = Integer.parseInt(request.getParameter("currentPage"));
//			}	
//			if (request.getParameter("recordsPerPage") != null) {
//				recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
////		int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
//		
//		Sachdao sachdao = new Sachdao();
//		ArrayList<Sachbean> listSach = sachdao.listSach(currentPage, recordsPerPage);
//		request.setAttribute("listSach", listSach);
//		int rows = sachdao.getTotalRows();
//		int nOfPages = rows / recordsPerPage;
//		
//		if(nOfPages % recordsPerPage > 0) {
//			nOfPages++;
//		}
//		
//		request.setAttribute("noOfPages", nOfPages);
//        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("recordsPerPage", recordsPerPage);
//	}

}
