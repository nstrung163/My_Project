<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- ĐĂNG KÝ -->
 	<form id="formDangKy" action="<%=request.getContextPath()%>/DangNhapController?action=userRegister" method="post">
		<div class="modal fade" id="dangKyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <!--Content-->
		    <div class="modal-content form-elegant">
		      <!--Header-->
		      <div class="modal-header text-center title-dang-ky ">
		        <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">Đăng ký thành viên</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <!--Body-->
		      <div class="modal-body mx-2">
		        <div class="md-form mb-4">
		          <label data-error="wrong" data-success="right" for="Form-email1">Họ và tên:</label>
		          <input type="text" id="hoTen" class="form-control validate input-username" name="hoTen" required>
		        </div>
		        
		        <div class="md-form mb-2">
		          <label data-error="wrong" data-success="right" for="Form-dia-chi">Địa chỉ:</label>
		          <input type="text" id="diaChi" class="form-control validate input-username" name="diaChi" required>
		        </div>
		        
		        <div class="md-form mb-2">
		          <label data-error="wrong" data-success="right" for="Form-so-dien-thoai">Số Điện Thoại:</label>
		          <input type="number" id="soDienThoai" class="form-control validate input-username" name="soDienThoai" required>
		        </div>
		        
		        <div class="md-form mb-2">
		          <label data-error="wrong" data-success="right" for="Form-email">Email:</label>
		          <input type="email" id="email" class="form-control validate input-username" name="email" required>
		        </div>
		        
		        <div class="md-form mb-2">
		          <label data-error="wrong" data-success="right" for="Form-ten-dang-nhap">Tên đăng nhập:</label>
		          <input type="text" id="tenDnRegister" class="form-control validate input-username" name="tenDn" required>
		          <span style="color: red;" id="result"></span>
		        </div>
		        
				<div class="md-form mb-2">
		          <label data-error="wrong" data-success="right" for="Form-mat-khau">Mật khẩu:</label>
		          <input type="password" id="passRegister" class="form-control validate input-username" name="pass" required>
		        </div>
		        
				<!-- Error Message -->
				<span style="color:red"> <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage") %></span>
			
		        <div class="d-flex justify-content-center mb-2">
		        	<button id="registerUser" type="submit" class="btn blue-gradient btn-block btn-rounded z-depth-1a">Đăng ký</button>
		        </div>
		        <div class="modal-footer mx-5 pt-3 mb-1">
		        	<p class="font-small grey-text d-flex justify-content-end">Đã có tài khoản 
		        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	         				 <a href="" type="button" class="blue-text ml-1 dang-nhap" data-toggle="modal" data-target="#dangNhapModal">Đăng nhập</a>
	       		 		</button>
		        	</p>
		      	</div>
		      </div>
		    </div>
		  </div>
		</div>
	</form> 
