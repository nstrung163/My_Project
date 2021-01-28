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
				  <a class="navbar-brand" href="SachControllerAdmin">
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
					 <a class="nav-link dang-xuat" href="">Đăng xuất</a>
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
		<form class="form-inline my-2 my-lg-0 form-search" action="<%=request.getContextPath()%>/SachControllerAdmin?action=timKiemSach" method="post">
	      <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Nhập thông tin sách...">
	      <!-- <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button> -->
	      <button class="btn btn-outline-success my-2 my-sm-0 btn-search" type="submit"><i class="icon-search fas fa-search"></i></button>
	    </form>
	</div>
	
	<!-- Modal form add new book and Edit book -->
	<% Sachbean sachBean =(Sachbean) request.getAttribute("sach"); %>
	<div class=" col-sm-6 form-edit-book">
		<form  action="SachControllerAdmin?action=updateSach" class="form-book-info" enctype= "multipart/form-data" role="form" method="post">
			<div class="modal-header">
				<h5 class="modal-title">Chỉnh sửa thông tin sách</h5>
			</div>
			<% if(sachBean != null) { %>
			<div class="modal-body">
				<div class="form-group d-none">
					<label >Mã Sách:</label>
					<input type="text" class="form-control" name="maSach"  placeholder="Mã sách" readonly="readonly" value="<%=sachBean.getMasach()%>">
				</div>
				<div class="form-group ten-sach-form">
					<label >Tên Sách:<span class="required-field">(*)</span></label>
					<input type="text" class="form-control" name="tenSach"  placeholder="Tên sách" value="<%=sachBean.getTensach()%>" >
				</div>
				
				<div class="form-group">
					<label >Sô Lượng: <span class="required-field">(*)</span></label>
					<input type="text" class="form-control" name="soLuong"placeholder="Số lượng sách" value="<%=sachBean.getSoLuong()%>">
				</div>
				<div class="form-group ">
					<label >Giá <span class="required-field">(*)</span></label>
					<input type="text" class="form-control" name="gia" placeholder="Giá của sách" value="<%=sachBean.getGia()%>">
				</div>
				
				<!-- Loại Sách -->
				<div class="form-group">
					<label >Loại Sách:</label>
					<select  class="form-control" name ="maLoai">
						<!-- <option selected="selected">Chọn loại sách...</option> -->
						<% ArrayList<LoaiBean> dsLoaiSachEdit = (ArrayList<LoaiBean>) request.getAttribute("dsLoaiSachEdit"); %>
						<% for(LoaiBean loaiSach : dsLoaiSachEdit) { %>
							<option selected="selected" value="<%=loaiSach.getMaLoai()%>" class="form-select"><%=loaiSach.getTenLoai()%></option>
						<% } %>
					</select>
				</div>
				<div class="form-group">
					<label >Ngày Nhập:<span class="required-field">(*)</span></label>
					<input type="date" class="form-control" name="ngayNhap" value="<%=sachBean.getNgayNhap()%>">
				</div>
				<div class="form-group" >
					<label>Ảnh <span class="required-field">(*)</span></label>
					<div class="anh-sach anh-sach-form">
						<img alt="Anh sach" src="<%=sachBean.getAnh()%>">
					</div>
					<input type="file" class="form-control upload-image" name="anh" accept="image/*" />
					<input type="hidden" class="old-img" id="image" name="anhOld" value="<%=sachBean.getAnh()%>"> 
				</div>
				<div class="form-group">
					<label>Tác Giả </label>
					<input type="text" class="form-control" name="tacGia" value="<%=sachBean.getTacgia()%>">
				</div>
			</div>
			<% } %>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary">Hủy bỏ</button>
				<button type="submit" class="btn btn-primary">Lưu</button>
			</div>
		</form>
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