<%@page import="bean.LoaiBean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.LichSuMuaHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="asset/css/normalize.css"> 
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/trang-chu.css">
<link rel="stylesheet" href="asset/css/gio-hang.css">
<link rel="stylesheet" href="asset/css/responsive.css"> 
<link rel="stylesheet" href="asset/css/responsive-history-buy.css">
</head>
<body class="d-flex flex-column h-100">
	<div class="container-fluid top-banner">
      <div class="row">
        <img src="asset/img/header-img.png" alt="Image top" class="mx-auto"/>
      </div>
    </div>
    <div class="header-area">
    	<!-- Nav PC -->
		<div class="container menu-top">
			<nav class="navbar navbar-expand-lg navbar-light">
			 	<div class="nav-logo">
					<a class="navbar-brand" href="SachController">
						<img alt="Logo" src="asset/img/book.png"> <span class="logo">BOOK STORE</span>
					</a>
				  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				  	<span class="navbar-toggler-icon"></span>
				   	</button>
			 	</div>
			 	<div class="nav-menu">
				  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
				    	<ul class="navbar-nav">
				    	  <li class="nav-item">
				    	  	 <section class="container search-box">
								<form class="form-inline my-2 my-lg-0 " action="SachController" method="POST"> 
							      <input id="search-input" type="search" name="keyword" class="form-control mr-sm-2 lab-search" placeholder="Bạn cần tìm gì..." aria-label="Search">
							     <button type="submit" name="submitTimKiem" class="btn btn-search" >
							     	<span class="icon-search"><i class="fas fa-search"></i></span>
								</button>
							    </form>
							</section>	
				    	  </li>
				    	  <li class="nav-item">
					        <a class="nav-link" href="<%=request.getContextPath()%>/LichSuMuaHangCotroller">
						        <i class="fas fa-history"></i>
						        <p>LỊCH SỬ MUA HÀNG</p>
					        </a>
					      </li>
					      <li class="nav-item">
					        <a class="nav-link" href="GioHangController">
						        <i class="gio-hang fas fa-shopping-cart">
						         	<% GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
							        if (gioHangBo == null) { %>
							        
							        	<div class="so-luong-sp">0</div>
							        <% } else { %>
							        	<div class="so-luong-sp"><%=gioHangBo.ds.size() %></div>
							        <% } %>
						        </i>
						        <p>GIỎ HÀNG</p>
					        </a>
					      </li>
				    	  <li class="nav-item">
								<%if(request.getSession(false).getAttribute("user") == "null" ) { %>
									<jsp:include page="dang-nhap.jsp"></jsp:include>
									<jsp:include page="dang-ky.jsp"></jsp:include>
									<div class="text-center group-dang-nhap">
										<a href="" type="button" class="nav-link" data-toggle="modal" data-target="#dangNhapModal">
											<i class="fas fa-sign-in-alt"></i>
											<p>ĐĂNG NHẬP</p>
										</a>
										
									</div>
								<%} else { %>
									<div class="text-center group-dang-nhap">
									  <%-- <span class="nav-link ten-nguoi-dung">Xin chào: <%=request.getSession().getAttribute("hoTen") %></span> --%>
									  <a href="<%=request.getContextPath()%>/DangNhapController?action=userLogout" type="button" class="nav-link">
									  	<i class="fas fa-sign-out-alt"></i>
									  	<p>ĐĂNG XUẤT</p>
									  </a>
									</div>
								<% } %>
							</li>
				   		</ul>
				  	</div>
			 	</div>
			</nav>
		</div>

    	<!-- Nav mobile -->
    	<div class="nav-mobile__area">
    		<div class="nav-logo">
				<a class="navbar-brand" href="SachController">
					<img alt="Logo" src="asset/img/book.png"> <span class="logo">BOOK STORE</span>
				</a>
		 	</div>
    		<div class="nav__mobile-icon">
	    		 <!-- Bars icon input -->
			 	<label for="nav-mobile-input" class="nav__bars-btn">
		            <i class="nav__bars-btn--icon fas fa-bars"></i>
		        </label>
		        <input type="checkbox" hidden class="nav__input" id="nav-mobile-input">
		        <label for="nav-mobile-input" class="nav__overlay"></label>
		        
		        <!-- Search -->
		        <section class="search-box">
					<form class=" form-search" action="SachController" method="POST"> 
				      <input id="search-input" type="search" name="keyword" class="form-control mr-sm-2 lab-search" placeholder="Bạn cần tìm gì..." aria-label="Search">
				     <button type="submit" name="submitTimKiem" class="btn btn-search" >
				     	<span class="icon-search"><i class="fas fa-search"></i></span>
					</button>
				    </form>
				</section>
				
				<!-- Giỏ hàng -->
				<a class="nav-link" href="GioHangController">
			        <i class="gio-hang-icon fas fa-shopping-cart">
			         	<% if (gioHangBo == null) { %>
				        	<div class="so-luong-sp">0</div>
				        <% } else { %>
				        	<div class="so-luong-sp"><%=gioHangBo.ds.size() %></div>
				        <% } %>
			        </i>
		        </a>
		        <!-- Account -->
		        <label for="nav-mobile-input-account" class="nav__bars-btn">
		            <i class=" account nav__bars-btn--icon fas far fa-user"></i>
		        </label>
		        <input type="checkbox" hidden class="nav__input-account" id="nav-mobile-input-account">
		        <label for="nav-mobile-input-account" class="nav__overlay"></label>
				<!-- Nav mobile accout -->
				<div class="nav__mobile-account">
					<label for="nav-mobile-input-account" class="nav__mobile-close-account">
		 				<i class="fas fa-times"></i>
		 			</label>
		 			<h2 class="nav__mobile-title">TÀI KHOẢN</h2>
		 			<%if(request.getSession(false).getAttribute("user") != null ) { %>
		 				<span class="nav-link ten-nguoi-dung">Xin chào: <%=request.getSession().getAttribute("hoTen") %></span>
		 			<%} %>
					<ul class="nav__account-list">
						<%if(request.getSession(false).getAttribute("user") == null ) { %>
						<li class="nav__account-item">
							<a href="" class="nav__account-link"><i class="account-icon fas fa-sign-in-alt"></i>Đăng nhập </a>
						</li>
						<li class="nav__account-item">
							<a href="" class="nav__account-link"><i class="account-icon far fa-registered"></i></i>Đăng ký </a>
						</li>
						<% } else { %>
						<li class="nav__account-item">
							<a href="<%=request.getContextPath()%>/DangNhapController?action=userLogout" class="nav__account-link"><i class="account-icon fas fa-sign-out-alt"> </i>Đăng xuất</a>
						</li>
						<%} %>
						<li class="nav__account-item">
							 <a class="nav__account-link" href="<%=request.getContextPath()%>/LichSuMuaHangCotroller">
					       		 <i class="account-icon fas fa-history"></i> Lịch sử mua hàng
				       		 </a>
						</li>
					</ul>
				</div>
			
				<div class="nav__mobile">
					<label for="nav-mobile-input" class="nav__mobile-close">
		 				<i class="fas fa-times"></i>
		 			</label>
		 			<ul class="nav__mobile-list">
				    	 <li class="list-group-item list-group-item-danh-muc">Danh mục sách 
				    	  	<div class="show-hidden-area">
								<span class="xem-them">Xem thêm<i class="icon-arrow-down fas fa-sort-down"></i></span>
								<span class="an-bot d-none">Ẩn bớt<i class="icon-arrow-up fas fa-sort-up"></i></span>
							</div>
						</li>
						<% // Hiển thị loại sách
							ArrayList<LoaiBean> dsLoaiSach = (ArrayList<LoaiBean>) request.getAttribute("dsLoaiSach");
							if(dsLoaiSach == null) { %>
								<p></p>
						<%} else { %>
						<%
							for(LoaiBean loaiSach: dsLoaiSach) { 
						%>
						<li class="list-group-item">
							<a href="SachController?maLoai=<%=loaiSach.getMaLoai()%>" class="list-group-item-link"><%=loaiSach.getTenLoai() %></a>
						</li>
						<% } %>
						<%} %>
					 </ul>
					 
		    	</div>
    		</div>
    	</div>
    </div>
    <!-- Main content -->
	<div class="container main-content">
		<div class="gio-hang-area">
			<h4 class="dat-hang-title">Lịch sử mua hàng của bạn</h4>
			<%
			if(request.getAttribute("dsLichSuMuaHang").equals("isEmpty")) { %>
				<p class="gio-hang-trong">Bạn chưa từng mua hàng tại nhà sách. Mời bạn 
					<button class="btn btn-primary btn-chon-mua-hang" type="button">
						<a class="tiep-tuc-mua-hang" href="<%=request.getContextPath()%>/SachController">chọn mua hàng</a>
					</button>
				</p>
			<% } else { 
				ArrayList<LichSuMuaHangBean> dsLichSuMuaHangBean = (ArrayList<LichSuMuaHangBean>) request.getAttribute("dsLichSuMuaHang");
				%>
				<div>Số lượng sách đã mua: <%=dsLichSuMuaHangBean.size() %></div>
				<div class="gio-hang">
					<ul class="danh-sach-gio-hang">
						<%
							// Hiển thị lịch sử mua hàng
							for (LichSuMuaHangBean l: dsLichSuMuaHangBean) {
						
						%>
						<li class="chi-tiet-gio-hang">
							<div class="chi-tiet-trai"> 
								<img class="chi-tiet-anh" src="<%=l.getAnh()%>" alt="Chi tiết sản phẩm">
							</div>
							<div class="chi-tiet-phai">
								<div class="chi-tiet-phai-tren">
									<span class="ten-sach"><%=l.getTenSach()%></span>
									<%
										Date ngayMuaDate = l.getNgayMua();
										SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
										String ngayMua = formatter.format(ngayMuaDate);
									%>
									<span class="ngay-mua">Ngày mua: <%=ngayMua%></span>
								</div>
								<span class="tac-gia">Tác giả: <%=l.getTacGia()%></span>
								<div class="chi-tiet-phai-duoi">
									<div class="form-left">
									<%
										DecimalFormat formatterCurrency = new DecimalFormat("###, ###, ###");
									%>
										<span class="gia">Giá: <%=formatterCurrency.format(l.getGia())%>đ</span>
									</div>
									<div class="form-right">
										<span class="thanh-tien">Số lượng mua: <%=l.getSoLuongMua()%></span>
									</div>
									<div class="form-right">
										<span class="thanh-tien">Thành tiền: <%=formatterCurrency.format(l.getThanhTien()) %>đ</span>
									</div>
								<% if(l.isDaMua()) { %>
									<div class="form-right">
										<span class="da-mua">Trạng thái: Đã thanh toán</span>
									</div>
								<%} else {%>
									<div class="form-right">
										Trạng thái:<span class="da-mua"> Đang đặt mua</span>
									</div>
									<%} %>
								   </div>
							</div>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			<%}%>
		</div>
	</div>
	<script type="text/javascript" src="asset/plugins/jquery/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="asset/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="asset/js/history-buy.js"></script>
</body>
</html>