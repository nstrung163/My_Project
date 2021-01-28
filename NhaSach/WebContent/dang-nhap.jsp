<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ĐĂNG NHẬP -->
<form name="form"  id="formDangNhap" action="<%=request.getContextPath()%>/DangNhapController?action=userLogin" method="post">
	<div class="modal fade modal-login" id="dangNhapModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <!--Content-->
	    <div class="modal-content form-elegant">
	      <!--Header-->
	      <div class="modal-header text-center">
	        <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel">Đăng nhập</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <!--Body-->
	      <div class="modal-body mx-4">
	        <!--Body-->
	        <div class="md-form mb-4">
	          <label data-error="wrong" data-success="right" >Tên đăng nhập:</label>
	          <input type="text" id="tenDn" class="form-control validate input-username" name="tenDn" required>
	        </div>
	
	        <div class="md-form pb-3">
	          <label data-error="wrong" data-success="right" >Mật khẩu:</label>
	          <input type="password" id="pass" class="form-control validate input-password" name="pass" required>
	          <p class="font-small blue-text d-flex justify-content-end"><a href="#" class="blue-text ml-1 mt-3">Quên mật khẩu?</a></p>
	        </div>
			<!-- Error Message -->
			<%-- <span style="color:red"> <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage") %></span> --%>
	
	        <div class="d-flex justify-content-center mb-3">
	         <button type="submit" class="btn blue-gradient btn-block" id="loginUser">Đăng nhập</button>
	        </div>
	        <p class="font-small dark-grey-text text-right d-flex justify-content-center mb-3 pt-2"> hoặc đăng nhập:</p>
	        <div class="row my-3 d-flex justify-content-center">
	          <!--Facebook-->
	          <button type="button" class="btn btn-white btn-rounded mr-md-3 z-depth-1a"><i class="fab fa-facebook-f text-center"></i></button>
	          <!--Google +-->
	          <button type="button" class="btn btn-white btn-rounded z-depth-1a"><i class="fab fa-google-plus-g"></i></button>
	        </div>
	      </div>
	      <!--Footer-->
	      <div class="modal-footer mx-5 pt-3 mb-1">
	        <p class="font-small grey-text d-flex justify-content-end">Không phải là thành viên?
	        	<!-- <a  href="" type="button" class="dang-ky" data-toggle="modal" data-target="#dangKyModal"> Đăng ký</a> -->
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	         		 <a  href="" type="button" class="dang-ky" data-toggle="modal" data-target="#dangKyModal"> Đăng ký</a>
	       		 </button>
	         </p>
	      </div>
	    </div>
	  </div>
	</div>
</form>







