$(document).ready(function() {
	/* Check login admin*/
	$('#registerUser').on('click', function(e) {
		var tenDn = $('#tenDnRegister').val();
		var hoTen = $('#hoTen').val();
		var diaChi = $('#diaChi').val();
		var soDienThoai = $('#soDienThoai').val();
		var email = $('#email').val();
		var pass = $('#passRegister').val();
		e.preventDefault();
		$.ajax({
			type: 'POST',
			url: 'DangNhapController' + '?action=userRegister',
			data: {
				tenDn: tenDn,
				hoTen: hoTen, 
				diaChi: diaChi, 
				soDienThoai: soDienThoai,
				email: email,
				pass: pass,
			},
			success: function(data) {
				if(data == 'True') {
					alert('Đăng ký tài khoản thành công!');
					$(location).attr('href','SachController');
				} else {
			        alert('Tên đăng nhập đã bị trùng!');
				}
			}
		})
	})
	/* Check user login*/
	$('#loginUser').on('click', function(e) {
		var tenDn = $('#tenDn').val();
		var pass = $('#pass').val();
		e.preventDefault();
		$.ajax({
			type: 'POST',
			url: 'DangNhapController' + '?action=userLogin',
			data: {
				tenDn: tenDn,
				pass: pass
			},
			success: function(data) {
				if(data == 'True') {
					alert('Đăng nhập thành công!');
					$(location).attr('href','SachController');
				} else {
			        alert('Tên tài khoản hoặc mật khẩu không đúng!');
				}
			}
		})
	})
	/* Hidden and show more items*/
	var max = 10;
	$('ul, li').each(function() {
		$(this).find('li').each(function(index) {
			if (index >= max) {
				$(this).hide();
			}
		})
	})
	$('.an-bot').on('click', function(event) {
		event.preventDefault();
		$('.an-bot').addClass("d-none");
		$('.xem-them').removeClass("d-none");
		$('ul, li').each(function() {
			$(this).find('li').each(function(index) {
				if (index >= max) {
					$(this).hide();
				}
			})
		})
	})
	$('.xem-them').on('click', function(event) {
		event.preventDefault();
		$('.an-bot').removeClass("d-none");
		$('.xem-them').addClass("d-none");
		$('ul, li').each(function() {
			$(this).find('li').each(function(index) {
				$(this).show();
			})
		})
	})
	
	
	/*Check duplicate of tenDn*/
	/*	var resultDuplicate = "";
	$('#tenDn').on('change',(function() {
		var tenDn = $('#tenDn').val();
		var hoTen = $('#hoTen').val();
		var diaChi = $('#diaChi').val();
		var soDienThoai = $('#soDienThoai').val();
		var email = $('#email').val();
		var pass = $('#pass').val();
		$.ajax({
			type: 'POST',
			data: {
					tenDn: tenDn,
					hoTen: hoTen, 
					diaChi: diaChi, 
					soDienThoai: soDienThoai,
					email: email,
					pass: pass,
					},
			url: 'KhachHangController',
			success: function(data) {
				$('#result').html(result);
				resultDuplicate = $('#result').html();
				$("#formDangKy").submit(function(event) {
					if(!Boolean(resultDuplicate)) {
						alert( "Đăng ký thành công!" );
						event.preventDefault();
					} else {
						alert( "Tên đăng nhập đã bị trùng!" );
						event.preventDefault();
					}
				})
			}
		})
	})
	)*/
})
$('.carousel').carousel({
  interval: 4000
})
function getFormattedNgayMua(ngayMua) {
	var date = new Date(ngayMua);
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();
	if (date < 10) { date = '0' + date }
	if (month < 10) { month = '0' + month }
	return day + '/' + month + '/' + year;
}