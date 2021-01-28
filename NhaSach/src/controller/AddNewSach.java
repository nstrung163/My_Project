package controller;

import java.io.File;
import java.io.IOException;
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

import bean.Sachbean;
import bo.Sachbo;
import common.util.CommonUtil;

/**
 * Servlet implementation class AddNewSach
 */
@WebServlet("/AddNewSach")
public class AddNewSach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewSach() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
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
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String data = fileItem.getFieldName();
					String maloai	= "";
					String anh	= "";
					String tensach = "";
					String tacgia = "";
					String gia = "";
					String masach= "";
					String soLuong = "";
					Date ngayNhap = null;
					if (data.equals("maLoai")) {
						 masach = fileItem.getString();
					}
					if (data.equals("anh")) {
						anh = fileItem.getString();
					}
					if (data.equals("tenSach")) {
						tensach = fileItem.getString();
					}
					if (data.equals("tacGia")) {
						tacgia = fileItem.getString();
					}
					if (data.equals("gia")) {
						gia = fileItem.getString();
					}
					if (data.equals("maSach")) {
						masach = fileItem.getString();
					}
					if (data.equals("soLuong")) {
						soLuong = fileItem.getString();;
					}
					if (data.equals("ngayNhap")) {
						ngayNhap = CommonUtil.cvStringToDate(fileItem.getString(), "yyyy-MM-dd");
					}
					Sachbean sachbean = new Sachbean(maloai, anh, tensach, tacgia, Integer.parseInt(gia), masach, Integer.parseInt(soLuong), ngayNhap);
					Sachbo sachbo = new Sachbo();
					sachbo.themMoiSach(sachbean);
					response.sendRedirect("SachControllerAdmin");
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
