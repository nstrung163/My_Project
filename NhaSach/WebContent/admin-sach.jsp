<%@page import="bean.LoaiBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="bean.Sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK STORE MANAGEMENT</title>
<link rel="stylesheet" href="asset/css/normalize.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/ekko-lightbox/ekko-lightbox.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/admin-sach.css">
</head>
<body>
	<%ArrayList<Sachbean> dsSach =(ArrayList<Sachbean>) request.getAttribute("dsSach"); %>
	<div class="nav-bg">
		<div class="container header-top">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="nav-left">
				  <a class="navbar-brand" href="<%=request.getContextPath()%>/SachControllerAdmin">
				  	<img alt="Logo" src="asset/img/book.png" class="img-logo"> <span class="logo">BOOK STORE</span>
				  </a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse nav-top" id="navbarTogglerDemo02">
				    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				      <li class="nav-item ">
				        <a class="nav-link active-link" href="SachControllerAdmin"><i class="icon-nav fas fa-book"></i>Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="LoaiSachController"><i class="icon-nav fas fa-swatchbook"></i>Loại Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link " href="KhachHangController"><i class="icon-nav fas fa-user"></i>Khách Hàng</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link " href="DonHangController"><i class="icon-nav fas fa-money-check-alt"></i>Đơn Hàng</a>
				      </li>
				    </ul>
				  </div>
				</div>
				<div class="nav-right">
					 <a class="nav-link dang-xuat" href=""><i class="icon-nav fas fa-sign-out-alt"></i>Đăng xuất</a>
				</div>
			</nav>
		</div>
	</div>
	<div class="container title-management">
		<div class="title-name">Quản Lý Sách</div>
		<button type="button" class="btn btn-success btn-add-new"><i class="icon-add fas fa-plus-square"></i>
			<a href="SachControllerAdmin?action=showFormAdd" class="btn-link-add">Thêm Mới Sách</a>
		</button>
	</div>
	
	<div class="container search-area">
		<form class="form-inline my-2 my-lg-0 form-search" action="SachControllerAdmin?action=timKiemSach" method="post">
	      <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Nhập thông tin sách...">
	      <!-- <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button> -->
	      <button class="btn btn-outline-success my-2 my-sm-0 btn-search" type="submit"><i class="icon-search fas fa-search"></i></button>
	    </form>
	</div>
	
	<% if(dsSach.size() != 0) { %>
	<div class="container">
		<table class="table table-hover" id="bookInfoTable">
		  <thead class="bg-thead">
		    <tr>
		      <th scope="col" >Mã Sách</th>
		      <th scope="col">Tên Sách</th>
		      <th scope="col">Số Lượng</th>
		      <th scope="col">Giá</th>
		      <th scope="col">Mã Loại</th>
		      <th scope="col">Ảnh</th>
		      <th scope="col">Ngày Nhập</th>
		      <th scope="col">Tác Giả</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% 
		  for(Sachbean sb : dsSach) { 
			 	Date ngayNhap = sb.getNgayNhap();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String ngayNhapFormat = formatter.format(ngayNhap);
		  %>
		    <tr>
		      <td class="ma-sach" scope="row"><%=sb.getMasach()%></td>
		      <td class="ten-sach"><%=sb.getTensach()%></td>
		      <td class="so-luong-sach"><%=sb.getSoLuong()%></td>
		      <td class="gia-sach"><%=sb.getGia()%></td>
		      <td class="ma-loai-sach"><%=sb.getMaloai()%></td>
		      <td class="anh-sach">
		    	  <a  class="img-book-link" href="<%=sb.getAnh()%>" data-toggle='lightbox' data-max-width='1000'><img class='img-fluid' src="<%=sb.getAnh()%>">
		      </td>
		      <td class="ngay-nhap-sach"><%=ngayNhapFormat%></td>
		      <td class="tac-gia"><%=sb.getTacgia()%></td>
		      <th class="action-book">
		      	<a href="SachControllerAdmin?action=edit&maSach=<%=sb.getMasach()%>" class='edit-btn'>
		      		<i class='fas fa-edit'></i>
		      	</a> | 
		      	<a href="SachControllerAdmin?action=delete&maSach=<%=sb.getMasach()%>" class='delete-btn'>
		      		<i class='fas fa-trash-alt '></i>
		      	</a>
		      </th>
		      
		    </tr>
		    <%} %>
		  </tbody>
		</table>
		<p class="result">Tổng số lượng sách là: <%=dsSach.size()%></p>
		<%} else { %>
			<p class="result">Không tìm thấy kết quả với từ khóa là: <%=request.getParameter("keyword")%></p>
		<% } %>
	</div>
	<div class="contaier-fluid  bg-light page-footer">
	  <div class="footer-copyright text-center py-3">© 2020 Copyright:
	    <a href="#" class="ten"> Nguyễn Sanh Trưng</a>
	  </div>
	</div>
	<script type="text/javascript" src="asset/plugins/jquery/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="asset/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="asset/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
	<script type="text/javascript" src="asset/js/admin.js"></script>
</body>
</html>