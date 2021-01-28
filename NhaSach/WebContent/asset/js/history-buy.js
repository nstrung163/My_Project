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
})
