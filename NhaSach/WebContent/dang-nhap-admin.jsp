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
<link rel="stylesheet" href="asset/css/dang-nhap-admin.css">
</head>
<body>
	<section class="login-block">
		<div class="container">
			<div class="row">
				<div class="col-md-4 login-sec">
					<h2 class="text-center">ĐĂNG NHẬP ADMIN</h2>
					<form class="login-form" action="DangNhapController?action=adminLogin" method="POST">
						<div class="form-group">
							<label  class="">Tên tài khoản:</label>
							<input type="text" class="form-control" placeholder="" id="tenDangNhap" name="tenDangNhap" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="">Mật khẩu:</label>
							<input type="password" class="form-control" placeholder=""  id="matKhau" name="matKhau" required="required">
						</div>
						<div class="form-check d-flex justify-content-center pl-0">
							<button type="submit" class="btn btn-login" id="login">Đăng nhập</button>
						</div>
					</form>
				</div>
				<div class="col-md-8 banner-sec">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>Steve Jobs</h2>
										<p> Để biến những ý tưởng thú vị trở thành hiện thực và những công nghệ còn non yếu thành một công ty có thể tiếp tục đổi mới trong nhiều năm trời, ta cần nhiều kỷ luật.</p>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg" alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>Steve Jobs</h2>
										<p>Anh không thể chỉ hỏi khách hàng xem họ muốn gì và rồi cố đem nó cho họ. Tới lúc anh hoàn thiện nó, họ đã muốn thứ mới mẻ khác rồi.</p>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg" alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>Walter Scott</h2>
										<p>Thành công hay thất bại trong kinh doanh là do thái độ trong suy nghĩ nhiều hơn là khả năng suy nghĩ.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="asset/plugins/jquery/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="asset/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="asset/js/admin.js"></script>
</body>
</html>