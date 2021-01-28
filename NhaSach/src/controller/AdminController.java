package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("dang-nhap-admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	private void checkDangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String tenDangNhap = request.getParameter("tenDangNhap");
//		String matKhau = request.getParameter("matKhau");
//		AdminBean adminBean = new AdminBean(tenDangNhap, matKhau, true);
//		AdminBo adminBo = new AdminBo();
//		if(adminBo.adminValidation(adminBean)) {
//			response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().write("True");
//		} else {
//			request.getRequestDispatcher("dang-nhap-admin.jsp").forward(request, response);
//		}
//	}
}
