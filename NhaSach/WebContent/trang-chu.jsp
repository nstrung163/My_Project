<%@page import="java.util.List"%>
<%@page import="bean.PageModel"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="bo.GioHangBo"%>
<%@page import="bo.LoaiBo"%>
<%@page import="bean.LoaiBean"%>
<%@page import="bean.Sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK STORE</title>
<link rel="stylesheet" href="asset/css/normalize.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/trang-chu.css">
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
								<form class="form-inline my-2 my-lg-0 " action="SachController?action=timKiemSach" method="POST"> 
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
						        <i class="gio-hang-icon fas fa-shopping-cart">
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
								<%if(request.getSession(false).getAttribute("user") == null ) { %>
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
					<form class=" form-search" action="SachController?action=timKiemSach" method="POST"> 
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
				    	  <li class="list-group-item list-group-item-danh-muc">Danh mục sách <div class="show-hidden-area">
						<span class="xem-them">Xem thêm<i class="icon-arrow-down fas fa-sort-down"></i></span>
						<span class="an-bot d-none">Ẩn bớt<i class="icon-arrow-up fas fa-sort-up"></i></span>
					</div></li>
						<% // Hiển thị loại sách
							ArrayList<LoaiBean> dsLoaiSach = (ArrayList<LoaiBean>) request.getAttribute("dsLoaiSach");
							for(LoaiBean loaiSach: dsLoaiSach) { 
						%>
						<li class="list-group-item">
							<a href="SachController?keyword=<%=loaiSach.getMaLoai()%>&action=timKiemLoai" class="list-group-item-link"><%=loaiSach.getTenLoai() %></a>
						</li>
						<% } %>
					 </ul>
		    	</div>
    		</div>
    	</div>
    </div>
  
	<div class="container main-content">
		<!-- Danh mục loại sách -->
		<div class="danh-muc-loai-sach col-xl-3">
			<ul class="list-group">
				<li class="list-group-item list-group-item-danh-muc ">Danh mục sách</li>
			<% // Hiển thị loại sách
				/* ArrayList<LoaiBean> dsLoaiSach = (ArrayList<LoaiBean>) request.getAttribute("dsLoaiSach"); */
				for(LoaiBean loaiSach: dsLoaiSach) { 
			%>
				<li class="list-group-item">
					<a href="SachController?keyword=<%=loaiSach.getMaLoai()%>&action=timKiemLoai" class="list-group-item-link"><%=loaiSach.getTenLoai() %></a>
				</li>
			<% } %>
			</ul>
			<div class="show-hidden-area">
				<span class="xem-them">Xem thêm<i class="icon-arrow-down fas fa-sort-down"></i></span>
				<span class="an-bot d-none">Ẩn bớt<i class="icon-arrow-up fas fa-sort-up"></i></span>
			</div>
		</div>
		<!-- Carousel -->
		<div class="carousel-area col-xl-9 ">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img class="d-block w-100" src="asset/img/slide1.jpg" alt="First slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/slide2.jpg" alt="Second slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/slide3.jpg" alt="Third slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/slide4.jpg" alt="Third slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/slide5.png" alt="Third slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/christmas.jpg" alt="Third slide">
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="asset/img/christmas2.png" alt="Third slide">
			    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Lùi</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Kế tiếp</span>
			  </a>
			</div>
		</div>
	</div>
    
	<!-- Hiển thị sách -->
	<div class="container hien-thi-sach"> <!-- col-xl-10 -->
		<h2 class="tieu-de-sach">Sách đang bán chạy</h2>
		<div class="card-deck">
			<%
				ArrayList<Sachbean> ds = (ArrayList<Sachbean>) request.getAttribute("dssach");
				for (Sachbean sach : ds) {
			%>
		  <div class=" col-sm-2 card">
			  <img class="card-img-top" src="<%=sach.getAnh() %>" alt="Card image">
			  <div class="card-body">
			    <h4 class=" book-text card-title"><%=sach.getTensach()%></h4>
			    <p class="book-text card-text">Tác giả: <%=sach.getTacgia()%></p>
			    <p class="card-text book-price"><%=sach.getGia()%>đ</p>
			    <a class="book-by" href="GioHangController?action=themSach&maLoai=<%=sach.getMaloai()%>&maSach=<%=sach.getMasach()%>
			      	&ts=<%=sach.getTensach()%>&anh=<%=sach.getAnh()%>&tg=<%=sach.getTacgia()%>&gia=<%=sach.getGia()%>">
					<img alt="Đặt mua" src="asset/img/buynow.jpg">
				</a>
			  </div>
	      </div>
	      <%
				}
			%>
		</div>
	</div>
	
	<!-- Pagination -->
	<% PageModel paginationList =(PageModel)request.getAttribute("paginationList"); %>
	<div class="container pagination-area">
		<nav aria-label="Page navigation ">
		  <ul class="pagination">
		    <li class="page-item <%= paginationList.getFirstPage() == 0 ? "disabled" : ""%> ">
		   		 <a class="page-link"  href="SachController?pageNumber=<%= paginationList.getFirstPage()%>" data-index="<%=paginationList.getFirstPage()%>">Trang Đầu</a>
		    </li>
		    <li class="page-item <%= paginationList.getPrevPage() == 0 ? "disabled" : ""%> ">
		    	<a class="page-link"  href="SachController?pageNumber=<%= paginationList.getPrevPage()%>" data-index="<%=paginationList.getPrevPage()%>">Lùi</a>
			</li>
		   	<% for(Integer i : paginationList.getPageNumberList()) { %>
				 <li class="page-item <%= i == paginationList.getCurrentPage() ? "active": ""%>">
				 	<a class="page-link" href="SachController?pageNumber=<%=i%>" data-index=<%=i %>>
				 		<%=i%>
				 	</a>
				 </li>
		   	<% } %>
		     <li class="page-item <%= paginationList.getNextPage() == 0 ? "disabled" : ""%>">
		   		 <a class="page-link"  href="SachController?pageNumber=<%=paginationList.getNextPage()%>" data-index="<%=paginationList.getNextPage()%>">Xem tiếp</a>
		    </li>
		    <li class="page-item <%= paginationList.getLastPage() == 0 ? "disabled" : ""%>">
		    	<a class="page-link" href="SachController?pageNumber=<%=paginationList.getLastPage()%>" data-index="<%=paginationList.getLastPage()%>">Trang Cuối</a>
			</li>
		  </ul>
		</nav>
	</div>
	<!-- <footer class="footer">
		<div class="container">
			<a class="nav-link"  href="">© 2020 Copyright: Nguyễn Sanh Trưng</a>
		</div>
	</footer> -->
	<div class="container footer-area">
		<footer class="footer-distributed">
	      <div class="footer-left">
	        <h3>BookStore<span><img alt="Logo" src="asset/img/book.png"></span></h3>
	        <p class="footer-links">
	          <a href="#" class="link-1">Home</a>
	          <a href="#">Blog</a>
	          <a href="#">Pricing</a>
	          <a href="#">About</a>
	          <a href="#">Faq</a>
	          <a href="#">Contact</a>
	        </p>
	        <p class="footer-company-name">BookStore © 2020</p>
	      </div>
	      <div class="footer-center">
	        <div>
	          <i class="fas fa-map-marker"></i>
	          <p><span>77 Nguyễn Huệ</span> Huế, Việt Nam</p>
	        </div>
	        <div>
	          <i class="fas fa-phone-square"></i>
	         <a href="tel:19001575">19001575</a>
	        </div>
	        <div>
	          <i class="fas fa-envelope-square"></i>
	          <p><a href="mailto:bookstore@bts.com">bookstore@bst.com</a></p>
	        </div>
	      </div>
	
	      <div class="footer-right">
	        <p class="footer-company-about">
	          <span>Giới thiệu về BookStore</span>
	          Bookstore được thành lập 1990 với một lịch sử lâu dài, luôn mang đến cho đọc giả những quyển sách hay, ý nghĩa.
	        </p>
	        <div class="footer-icons">
	          <a href="#"><i class="fab fa-facebook-square"></i></a>
	          <a href="#"><i class="fab fa-twitter-square"></i></a>
	          <a href="#"><i class="fab fa-linkedin"></i></a>
	          <a href="#"><i class="fab fa-youtube-square"></i></a>
	        </div>
	      </div>
	    </footer>
	</div>
	<script type="text/javascript" src="asset/plugins/jquery/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="asset/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="asset/js/main.js"></script>
</body>
</html>