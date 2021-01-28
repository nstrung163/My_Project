<%@page import="bean.KhachHangBean"%>
<%@page import="java.text.DateFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div class="nav-bg">
		<div class="container header-top">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="nav-left">
				  <a class="navbar-brand" href="KhachHangController">
				  	<img alt="Logo" src="asset/img/book.png" class="img-logo"> <span class="logo">BOOK STORE</span>
				  </a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse nav-top" id="navbarTogglerDemo02">
				    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				      <li class="nav-item ">
				        <a class="nav-link " href="SachControllerAdmin"><i class="icon-nav fas fa-book"></i>Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link " href="LoaiSachController"><i class="icon-nav fas fa-swatchbook"></i>Loại Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link active-link" href="KhachHangController"><i class="icon-nav fas fa-user"></i>Khách Hàng</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link " href="DonHangController"><i class="icon-nav fas fa-money-check-alt"></i>Đơn Hàng</a>
				      </li>
				    </ul>
				  </div>
				</div>
				<div class="nav-right">
					 <a class="nav-link dang-xuat" href="">Đăng xuất</a>
				</div>
			</nav>
		</div>
	</div>
	<div class="container title-management">
		<div class="title-name">Quản Lý Khách Hàng</div>
		<button type="button" class="btn btn-success btn-add-new"><i class="icon-add fas fa-plus-square"></i>
			<a href="KhachHangController?action=showFormAdd" class="btn-link-add">Thêm Mới Khách Hàng</a>
		</button>
	</div>
	
	<div class="container search-area">
		<form class="form-inline my-2 my-lg-0 form-search" action="<%=request.getContextPath()%>/KhachHangController?action=search" method="post">
	      <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Bạn cần tìm gì...">
	      <button class="btn btn-outline-success my-2 my-sm-0 btn-search" type="submit"><i class="icon-search fas fa-search"></i></button>
	    </form>
	</div>
	
	<!-- Form add new customer and Edit customer -->
	<% KhachHangBean khachHangBean = (KhachHangBean) request.getAttribute("khachHangBean"); %>
	<%if(khachHangBean == null) { %> 
	<div class=" col-sm-6 form-edit-book">
 		<form action="KhachHangController?action=addNewCustomer" method="post" class="form-add-new-book-type">
			<div class="modal-header">
				<h5 class="modal-title">Thêm Mới Khách Hàng</h5>
			</div>
			<div class="modal-body">
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-email1">Họ và tên:</label>
		          <input type="text" id="hoTen" class="form-control validate " name="hoTen" required>
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-dia-chi">Địa chỉ:</label>
		          <input type="text" id="diaChi" class="form-control validate " name="diaChi" required>
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-so-dien-thoai">Số Điện Thoại:</label>
		          <input type="number" id="soDienThoai" class="form-control validate " name="soDienThoai" required>
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-email">Email:</label>
		          <input type="email" id="email" class="form-control validate " name="email" required>
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-ten-dang-nhap">Tên đăng nhập:</label>
		          <input type="text" id="tenDnRegister" class="form-control validate " name="tenDn" required>
		          <!-- Error Message -->
				  <span class="errMessage required-field"><%=request.getAttribute("errMessage") != null ? request.getAttribute("errMessage") : ""%></span>
		        </div>
		        
				<div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-mat-khau">Mật khẩu:</label>
		          <input type="password" id="passRegister" class="form-control validate " name="pass" required>
		        </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary">Hủy bỏ</button>
				<button type="submit" class="btn btn-primary">Lưu</button>
			</div>
		</form>
	</div>
	<% } else {%>
	<div class=" col-sm-6 form-edit-book">
 		<form action="KhachHangController?action=updateCustomer" method="post" class="form-add-new-book-type">
			<div class="modal-header">
				<h5 class="modal-title">Chỉnh Sữa Thông Tin Khách Hàng</h5>
			</div>
			<div class="modal-body">
		         <input type="hidden" name="maKh" required value="<%=khachHangBean.getMaKh()%>">
				<div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-email1">Họ và tên:</label>
		          <input type="text" id="hoTen" class="form-control validate " name="hoTen" required value="<%=khachHangBean.getHoTen()%>">
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-dia-chi">Địa chỉ:</label>
		          <input type="text" id="diaChi" class="form-control validate " name="diaChi" required value="<%=khachHangBean.getDiaChi()%>" >
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-so-dien-thoai">Số Điện Thoại:</label>
		          <input type="number" id="soDienThoai" class="form-control validate " name="soDienThoai" required value="<%=khachHangBean.getSoDienThoai()%>">
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-email">Email:</label>
		          <input type="email" id="email" class="form-control validate " name="email" required value="<%=khachHangBean.getEmail()%>" >
		        </div>
		        
		        <div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-ten-dang-nhap">Tên đăng nhập:</label>
		          <input type="text" id="tenDnRegister" class="form-control validate " name="tenDn" required value="<%=khachHangBean.getTenDn()%>" readonly="readonly">
		          <!-- Error Message -->
				  <span class="errMessage required-field"><%=request.getAttribute("errMessage") != null ? request.getAttribute("errMessage") : ""%></span>
		        </div>
		        
				<div class="form-group">
		          <label data-error="wrong" data-success="right" for="Form-mat-khau">Mật khẩu:</label>
		          <input type="password" id="passRegister" class="form-control validate " name="pass" required value="<%=khachHangBean.getPass()%>">
		        </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary">Hủy bỏ</button>
				<button type="submit" class="btn btn-primary">Lưu</button>
			</div>
		</form>
	</div>
	<% } %>
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