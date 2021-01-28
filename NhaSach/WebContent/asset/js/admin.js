$(document).ready(function() {
	$('#login').on('click', function(e) {
		var tenDangNhap = $('#tenDangNhap').val();
		var matKhau = $('#matKhau').val();
		e.preventDefault();
		$.ajax({
			type: "POST",
			url: "DangNhapController" + "?action=adminLogin",
			data: {
				"tenDangNhap": tenDangNhap,
				"matKhau": matKhau
			},
			success: function(data) {
				if (data == 'True') {
					$(location).attr('href', 'SachControllerAdmin');
				} else {
					alert('Tên đăng nhập hoặc mật khẩu sai');
				}
			}
		});
	});
	
});
$(document).on('click', '[data-toggle="lightbox"]', function(event) {
	event.preventDefault();
	$(this).ekkoLightbox();
});
/* Auto change title form add to edit or edit to add  */
function showModalWithCustomizedTitle($selectedModal, title) {
	$selectedModal.find(".modal-title").text(title);
	$selectedModal.modal('show');
}
/* Rest form add new brand*/
function resetFormModal($formElement) {
	$formElement[0].reset();
	$formElement.find("input[type*='file']").val("");
	$formElement.validate().destroy();
	$formElement.find(".error-message-invalid").remove();
	$formElement.find("img").attr('src', '');
}