<%@page import="java.text.DecimalFormat"%>
<%@page import="bean.DonHangBean"%>
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
<link rel="stylesheet" href="asset/css/admin-don-hang.css">
</head>
<body>
	<%ArrayList<DonHangBean> listDonHang =(ArrayList<DonHangBean>) request.getAttribute("listDonHang"); %>
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
				        <a class="nav-link" href="SachControllerAdmin"><i class="icon-nav fas fa-book"></i>Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="LoaiSachController"><i class="icon-nav fas fa-swatchbook"></i>Loại Sách</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link " href="KhachHangController"><i class="icon-nav fas fa-user"></i>Khách Hàng</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link active-link" href="DonHangController"><i class="icon-nav fas fa-money-check-alt"></i>Đơn Hàng</a>
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
		<div class="title-name">Quản Lý Đơn Hàng</div>
		<!-- <button type="button" class="btn btn-success btn-add-new"><i class="icon-add fas fa-plus-square"></i>
			<a href="DonHangController?action=showFormAdd" class="btn-link-add">Thêm Mới Đơn Hàng</a>
		</button> -->
	</div>
	
	<div class="container search-area">
		<form class="form-inline my-2 my-lg-0 form-search" action="DonHangController?action=searchDonHang" method="post">
	      <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm đơn hàng">
	      <button class="btn btn-outline-success my-2 my-sm-0 btn-search" type="submit"><i class="icon-search fas fa-search"></i></button>
	    </form>
	</div>
	
	<% if(listDonHang.size() != 0) { %>
	<div class="container-fluid">
		<table class="table table-hover" id="bookInfoTable">
		  <thead class="bg-thead">
		    <tr>
		      <th scope="col" >Mã HĐ</th>
		      <!-- <th scope="col">Mã Khách Hàng</th> -->
		      <th scope="col">Họ Tên</th>
		      <th scope="col">Số Điện Thoại</th>
		      <th scope="col">Địa Chỉ</th>
		      <!-- <th scope="col">Mã Sách</th> -->
		      <th scope="col">Tên Sách</th>
		      <th scope="col">Số Lượng Mua</th>
		      <th scope="col">Giá</th>
		      <th scope="col">Thành Tiền</th>
		      <th scope="col">Ngày Mua</th>
		      <th scope="col">Đã mua</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% 
		  int countDonHang = 0;
		  for(DonHangBean dh : listDonHang) { 
			 	Date ngayMua = dh.getNgayMua();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String ngayMuapFormat = formatter.format(ngayMua);
				DecimalFormat formatterCurrency = new DecimalFormat("###, ###, ###");
				if(!dh.isDaMua()) {
		  %>
		    <tr>
		      <td scope="row" class="text-center ma-hoa-don"><%=dh.getMaHoaDon()%></td>
		      <td class="ho-ten"><%=dh.getHoTen() %></td>
		      <td class="so-dien-thoai"><%=dh.getSoDT() %></td>
		      <td class="dia-chi"><%=dh.getDiaChi() %></td>
		      <td class="ten-sach"><%=dh.getTenSach() %></td>
		      <td class="so-luong-mua text-center">
		      	<form class="form-inline" action="<%=request.getContextPath()%>/DonHangController?action=updateQuantityDonHang&maHoaDon=<%=dh.getMaHoaDon()%>&maSach=<%=dh.getMaSach()%>" method="post">
		      		<div class="form-group">
			      		<input  class="form-control so-luong-mua-input mr-2" type="number" name="soLuongMua" value="<%=dh.getSoLuongMua()%>" min="1">
			      		<button type="submit" class="btn btn-success">Cập nhật</button>
		      		</div>
		      	</form>
		      </td>
		      <td class="gia text-center"><%=formatterCurrency.format(dh.getGia())%>đ</td>
		      <td class="thanh-tien text-center"><%=formatterCurrency.format(dh.getThanhTien()) %>đ</td>
		      <td class="ngay-mua"><%=ngayMuapFormat %></td>
		      <td class="xac-nhan">
		      	<a class="btn btn-primary" role="button" href="DonHangController?action=comfirmDonHang&maHoaDon=<%=dh.getMaHoaDon()%>">Xác nhận</a>
		      </td>
		      <th class="action-book">
		      	<a href="DonHangController?action=delete&maHoaDon=<%=dh.getMaHoaDon()%>&maSach=<%=dh.getMaSach()%>" class='delete-btn'>
		      		<i class='fas fa-trash-alt '></i>
		      	</a>
		      </th>
		    </tr>
		    <% } 
				countDonHang++;
				} %>
		  </tbody>
		</table>
		<p class="result">Tổng số lượng đơn hàng là: <%=countDonHang%></p>
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