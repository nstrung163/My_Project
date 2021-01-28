package controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.LoaiBean;
import bean.Sachbean;
import bo.LoaiBo;
import bo.Sachbo;
import common.util.CommonUtil;
import common.util.FileHelper;

/**
 * Servlet implementation class SachControllerAdmin
 */
@WebServlet("/SachControllerAdmin")
public class SachControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachControllerAdmin() {
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
		case "edit":
			showFormEdit(request, response);
			break;
		case "updateSach":
			updateSach(request, response);
			break;
		case "addNewBook":
			themSach(request, response);
			break;
		case "showFormAdd":
			showFormAdd(request, response);
			break;
		case "delete":
			xoaSach(request, response);
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
		ArrayList<Sachbean> ds = sachBo.getAllSachAd();
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
		request.setAttribute("dsSach", ds);
		request.setAttribute("dsLoaiSach", dsLoaiSach);
		request.getRequestDispatcher("admin-sach.jsp").forward(request, response);
	}
	
	private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maSach = request.getParameter("maSach");
		Sachbo sachbo = new Sachbo();
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
		Sachbean sach = sachbo.findSachByMaSach(maSach);
		request.setAttribute("sach", sach);
		request.setAttribute("dsLoaiSachEdit", dsLoaiSach);
		request.getRequestDispatcher("admin-sach-sua.jsp").forward(request, response);
	}
	private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		LoaiBo loaiBo = new LoaiBo();
		ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
		request.setAttribute("dsLoaiSachEdit", dsLoaiSach);
		request.getRequestDispatcher("admin-sach-them.jsp").forward(request, response);
	}
	private void themSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			Sachbo sachbo = new Sachbo();
			String maLoai	= "";
			String anh	= "";
			String tenSach = "";
			String tacGia = "";
			String gia = "";
			String maSach= "";
			String soLuong = "";
			Date ngayNhap = null;
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();// tên file họ chuyển thêm và trước ảnh mà images_sach
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vt = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vt - 1) + "\\NhaSach\\WebContent\\image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						
						String ramdonStr = new BigInteger(130, new SecureRandom()).toString(32).substring(0, 6);
						String typeFile = nameimg.substring(nameimg.lastIndexOf('.'), nameimg.length());
						String newFileName = CommonUtil.cvDatoToString(new Date(), "yyyyMMdd-HHmm") + ramdonStr;
						String fileImg = dirUrl + File.separator + newFileName + typeFile;
						anh = "image_sach/" + newFileName + typeFile;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							System.out.println("Lưu file thất bại!");
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String data = fileItem.getFieldName();
					if (data.equals("maLoai")) {
						 maLoai = fileItem.getString();
					}
					if (data.equals("tenSach")) {
						tenSach = new String (fileItem.getString("UTF-8"));
					}
					if (data.equals("tacGia")) {
						tacGia = new String (fileItem.getString("UTF-8"));
					}
					if (data.equals("gia")) {
						gia = fileItem.getString();
					}
					if (data.equals("maSach")) {
						maSach = fileItem.getString();
					}
					if (data.equals("soLuong")) {
						soLuong = fileItem.getString();;
					}
					if (data.equals("ngayNhap")) {
						ngayNhap = CommonUtil.cvStringToDate(fileItem.getString(), "yyyy-MM-dd");
					}
				}
			}
			Sachbean sachbean = new Sachbean(maLoai, anh, tenSach, tacGia, Integer.parseInt(gia), maSach, Integer.parseInt(soLuong), ngayNhap);
			if(sachbo.checkDuplicateMaSach(maSach)) {
				sachbo.themMoiSach(sachbean);
				response.sendRedirect("SachControllerAdmin");
			} else {
				request.setAttribute("errMessage", "Mã Sách đã tồn tại!");
				LoaiBo loaiBo = new LoaiBo();
				ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
				request.setAttribute("dsLoaiSachEdit", dsLoaiSach);
				request.getRequestDispatcher("admin-sach-them.jsp").forward(request, response);
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	private void updateSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			Sachbo sachbo = new Sachbo();
			String maLoai	= "";
			String anh	= "";
			boolean anhFlag = true;
			String tenSach = "";
			String tacGia = "";
			String gia = "";
			String maSach= "";
			String soLuong = "";
			Date ngayNhap = null;
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField() && sachbo.checkImageBook("image_sach/" + fileItem.getName()) && !fileItem.getName().equals("")) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();// tên file họ chuyển thêm và trước ảnh mà images_sach
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vt = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vt - 1) + "\\NhaSach\\WebContent\\image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						
						String ramdonStr = new BigInteger(130, new SecureRandom()).toString(32).substring(0, 6);
						String typeFile = nameimg.substring(nameimg.lastIndexOf('.'), nameimg.length());
						String newFileName = CommonUtil.cvDatoToString(new Date(), "yyyyMMdd-HHmm") + ramdonStr;
						String fileImg = dirUrl + File.separator + newFileName + typeFile;
						anh = "image_sach/" + newFileName + typeFile;
						anhFlag = false;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							System.out.println("Lưu file thất bại!");
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String data = fileItem.getFieldName();
					
					if (data.equals("anhOld") && anhFlag) {
						 anh = fileItem.getString();
					}
					if (data.equals("maLoai")) {
						 maLoai = fileItem.getString();
					}
					if (data.equals("tenSach")) {
						tenSach = new String (fileItem.getString().getBytes ("iso-8859-1"), "UTF-8");
					}
					if (data.equals("tacGia")) {
						tacGia = new String (fileItem.getString().getBytes ("iso-8859-1"), "UTF-8");
					}
					if (data.equals("gia")) {
						gia = fileItem.getString();
					}
					if (data.equals("maSach")) {
						maSach = fileItem.getString();
					}
					if (data.equals("soLuong")) {
						soLuong = fileItem.getString();;
					}
					if (data.equals("ngayNhap")) {
						ngayNhap = CommonUtil.cvStringToDate(fileItem.getString(), "yyyy-MM-dd");
					}
				}
			}
			Sachbean sachbean = new Sachbean(maLoai, anh, tenSach, tacGia, Integer.parseInt(gia), maSach, Integer.parseInt(soLuong), ngayNhap);
			sachbo.capNhapSach(sachbean);
			response.sendRedirect("SachControllerAdmin");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	private void xoaSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSach = request.getParameter("maSach");
		Sachbo sachbo = new Sachbo();
		Sachbean sachbean = sachbo.findSachByMaSach(maSach);
		String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
		int vt = dirUrl.indexOf(".metadata");
		dirUrl = dirUrl.substring(0, vt - 1) + "\\NhaSach\\WebContent\\";
		String fileNameUrl = dirUrl + sachbean.getAnh();
		System.out.println("Đường dẫn xóa ảnh là: " + fileNameUrl);
		if(maSach != null) {
			sachbo.xoaSach(maSach);
			FileHelper.deleteFile(fileNameUrl);
		}
		response.sendRedirect("SachControllerAdmin");
	}
	private void timKiemSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSach = request.getParameter("keyword");
		String tenSach = request.getParameter("keyword");
		String maLoai = request.getParameter("keyword");
		Sachbean sachbean = new Sachbean();
		sachbean.setMasach(maSach);
		sachbean.setTensach(tenSach);
		sachbean.setMaloai(maLoai);
		Sachbo sachbo = new Sachbo();
		ArrayList<Sachbean> dsSach =  sachbo.searchBook(sachbean);
		request.setAttribute("dsSach", dsSach);
		request.getRequestDispatcher("admin-sach.jsp").forward(request, response);
	}
}
