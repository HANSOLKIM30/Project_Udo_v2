<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

	<head>
		<!-- 해더 시작 -->
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<!-- 해더 끝 -->
		<style>
       		.input-group{
       			margin-left: 20px;
       			margin-bottom: -10px;
        	}
    	</style>
	</head>	
	<body class="login-page sidebar-collapse">
		<!-- 네비게이션 시작  -->
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<!-- 네비게이션 끝 -->
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="page-header header-filter" style="background-image: url('../../assets/img/udo1.jpg'); background-size: cover; background-position: top center;">
		  <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 ml-auto mr-auto">
                    <div class="card">
                    	<div class="card-body">
                        	<form class="form" method="post" id="updateForm" enctype="multipart/form-data" onsubmit="return false">
                                <div class="text-center"> <!-- uPhoto -->
                                    <c:set var="oldPhoto" value="${loginInfo.uPhoto}" />
                                    <c:choose>
                                        <c:when test="${empty oldPhoto}">
                                            <img src="../../uploadFile/no_images.jpg" style="width: 150px; height: auto">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="../../uploadFile/${loginInfo.uPhoto}" style="width: 150px; height: auto">
                                        </c:otherwise>
                                    </c:choose>
                                    <div style="padding: 9px; margin-left: 40px;">
                                        <input type="file" style="color: #868686; font-size: 10px;" name="uPhoto" id="uPhoto">
                                    </div>
                                    
                                    
                                </div> <!-- uPhoto-->
								
								<!--ID-->
								<div class="input-group" style="margin-bottom: -35px;">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">email</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="uId" name="uId" value="${loginInfo.uId}" required readonly>
                                        <span id="idCheck" style="font-size: 11px; color: #F4483C;">
                                        	<i class="material-icons" style="font-size: 11px; color: #F4483C;">error_outline</i> 
                                        	&nbsp아이디는 수정이 불가합니다.
                                        </span> 
                                    </div>
                                </div>
								
								<!--PW-->
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">lock_outline</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                        <label for="uPW" class="bmd-label-floating" >Password</label>
                                        <input type="password" class="form-control" id="uPW" name="uPW">
                                        <input type="checkbox" id="PWCheckBox" style="display: none">
                                        <span class="bmd-help" id="PWCheck"></span>
                                    </div>
                                </div>
                                
                               <!--Confirm PW-->
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">check</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm_uPW" class="bmd-label-floating">Confirm Password</label>
                                        <input type="password" class="form-control" id="confirm_uPW" name="confirm_uPW">
                                        <span class="bmd-help" id="confirmPWCheck"></span>
                                    </div>
                                </div>
                                
                                <!--Name-->
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">face</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                    	<c:set var = "uName" value = "${loginInfo.uName}"/>
                                    	<c:choose>
                                    		<c:when test="${empty uName}">
                                    			<label for="uName" class="bmd-label-floating" >Name: 정보가 없습니다.</label>
                                        		<input type="text" class="form-control" id="uName" name="uName">
                                        		<span class="bmd-help" id="nameCheck"></span>
	                                        </c:when>
	                                        <c:otherwise>
	                                        	<label for="uName" class="bmd-label-floating" >Name: ${loginInfo.uName}</label>
                                        		<input type="text" class="form-control" id="uName" name="uName">
                                        		<span class="bmd-help" id="nameCheck"></span>
	                                        </c:otherwise>
	                                    </c:choose>
                                    	
                                    </div>
                                </div>
                                
                                <!--Phone-->
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">phone</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                    	<c:set var = "uPhone" value = "${loginInfo.uPhone}"/>
                                    	<label for="uPhone" class="bmd-label-floating" >Phone: ${loginInfo.uPhone}</label>
                                        <input type="text" class="form-control" id="uPhone" name="uPhone">
                                        <input type="checkbox" id="phoneCheckBox_validate" style="display: none">
                                        <input type="checkbox" id="phoneCheckBox_overlap" style="display: none">
                                        <span class="bmd-help" id="phoneCheck"></span>
                                    </div>
                                </div>
								<div class="text-center" style="padding-top: 5px;"> <!-- submit 버튼  -->
                                	<input type="submit" class="btn btn-primary btn-link btn-wd btn-lg" value="UPDATE">
                            	</div> <!-- submit 버튼  -->
                        	</form>
                        </div> <!-- cardbody  -->
					</div> <!-- card -->
				</div> <!-- col-lg-4... -->
			</div> <!-- row -->
		</div> <!-- container -->
	</div> <!-- background -->
	<!-- 푸터 시작 -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<!-- 푸터 끝  -->
	
	<!-- 동작스크립트  -->
	<script>
		$(document).ready(function(){
			
			// ** 1. 비밀번호 유효성 검사
			
			// uPW칸에 포커스되면 값 초기화
			$('#uPW').focus(function(){
				$('#PWCheck').html("");
				$('#PWCheckBox').prop('checked', false);
			});
			
			$('#uPW').focusout(function(){				
				var uPW = $('#uPW').val();
				// pw가 null 값인지 확인
				if(uPW == ""){
					$('#PWCheck').css("display","block");
					$('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{ // pw가 null 값이 아니라면,
					// pw 유효성 검사
					$.ajax({
						url: "<c:url value='/member/register/checkPW' />",
						type: 'GET',
						data: {
							uPW: uPW
						},
						success: function(data){
							console.log("pw check 성공: " + data);

							if(data == "success"){	// 유효성 검사 통과 시
								// span block 처리
								$('#PWCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp안전한 비밀번호입니다.</p>");
							}else{	//유효성 검사 통과 실패 시
								// span block 처리
								$('#PWCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">8~16자, 숫자, 특수문자 포함.</p>");
				                $('#PWCheckBox').prop('checked', true);
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}
					});
				}
			});
			
			// ** 2. confirm PW 
			
			// confirm_uPW칸에 포커스되면 값 초기화
			$('#confirm_uPW').focus(function(){
				$('#confirmPWCheck').html("");
			});
			
			$('#confirm_uPW').focusout(function(){			
				
				// uPW 값 받아오기
				var uPW = $('#uPW').val();
				// confirm_uPW 값 받아오기
				var confirm_uPW = $('#confirm_uPW').val();

				// confirm pw가 null 값인지 확인
				if(confirm_uPW==""){
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{	// confirm pw이 null 값이 아니라면,
					// 값 비교			
					if(uPW == confirm_uPW){	// 비밀번호 확인 시 일치할 경우
						$('#confirmPWCheck').css("display","block");
		                $('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp비밀번호가 일치합니다.</p>");					
					} else{	// 비밀번호 확인 시 일치하지 않을 경우
						$('#confirmPWCheck').css("display","block");
						$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp비밀번호가 일치하지 않습니다.</p>");	
					}
				}
			});
			
			// ** 3. phone 중복 확인 및 유효성 검사
			$('#uPhone').focus(function(){	
				$('#phoneCheckBox_overlap').prop('checked', false);
				$('#phoneCheckBox_validate').prop('checked', false);
				$('#phoneCheck').html("");
			});
			
			$('#uPhone').focusout(function(){
				
				// uPhone 값 받아오기
				var uPhone = $('#uPhone').val();

				if(uPhone!="" && uPhone!="<c:out value='${uPhone}' />"){
					$.ajax({
						url: "<c:url value='/member/register/checkPhone' />",
						type: 'GET',
						data: {
							uPhone: uPhone
						},
						success: function(data){
							console.log("phone check 성공: " + data);

							if(data == "exist"){	// 중복 검사 실패 시.
								$('#phoneCheck').css("display","block");
								$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">사용 중인 번호입니다.</p>");
								// 체크박스 처리
								$('#phoneCheckBox_overlap').prop('checked', true);
							}else if(data == "notExist"){	// 중복, 유효성 검사 성공 시.
								$('#phoneCheck').css("display","block");
								$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp사용하셔도 좋은 번호입니다.</p>");
							} else{	// 유효성 검사 실패 시.
								$('#phoneCheck').css("display","block");
				                $('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp유효한 형식이 아닙니다.('-'필수)</p>");
				                // 체크박스 처리
								$('#phoneCheckBox_validate').prop('checked', true);
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}
					});		
				}
			});
			
			// ** 4. form 전송
			$('#updateForm').submit(function(){
				
				var uId = $('#uId').val();	//세션의 uId값 받아오기
				var uPW = $('#uPW').val();
				var confirm_uPW = $('#confirm_uPW').val();
				var uName = $('#uName').val();
				var uPhone = $('#uPhone').val();
				var oldFile = "<c:out value='${oldPhoto}' />";
					
				if(uPW == ""){	// pw null 값일 때.
					$('#PWCheck').css("display","block");
					$('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else if(confirm_uPW == ""){	// pw confirm null 값일 때.
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else if($('#PWCheckBox').prop('checked')){	// pw 유효성 검사 실패
					$('#PWCheck').css("display","block");
	                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">8~16자, 숫자, 특수문자 포함.</p>");
				} else if(uPW != confirm_uPW){	// confirm pw - pw 불일치
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp비밀번호가 일치하지 않습니다.</p>");
				} else if($('#phoneCheckBox_validate').prop('checked')){	// uPhone 값이 null이 아닐 때 진행
					$('#phoneCheck').css("display","block");
		            $('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">유효한 형식이 아닙니다.('-'필수)</p>");	
				} else if($('#phoneCheckBox_overlap').prop('checked')){
					$('#phoneCheck').css("display","block");
		            $('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp사용 중인 번호입니다.</p>");	
				} else{	//submit
					
					// null값 일 경우, session 값으로 입력되게 처리
					if(uName == ""){
						uName = "<c:out value='${loginInfo.uName}' />";
					}
					
					if(uPhone == ""){
						uPhone = "<c:out value='${loginInfo.uPhone}' />";
					}
					
					var formData = new FormData();
					var file = $('#uPhoto')[0].files[0];			
					formData.append('uId',uId);
					formData.append('uPW',uPW);
					formData.append('uName',uName);
					formData.append('uPhone',uPhone);
					formData.append('oldFile',oldFile);
					
					if(file != undefined){
						formData.append('newFile',file);
					}
					
					// 비동기통신
					$.ajax({
						url: "<c:url value='/member/myPage/update'/>",
						type: 'POST',
						data: formData,
						enctype: 'multipart/form-data',
						contentType: false,
						processData: false,						
						success: function(data){
							console.log("submit 성공: " + data);
							if(data == "success"){
								alert("회원정보가 수정되었습니다.");
								location.href = "<c:url value='/member/myPage' />"
								/* myPage 이동 */
							}else{
								alert("수정이 실패하였습니다. 관리자에게 문의바랍니다.");
							}
						}, 
						error: function(data){
							console.log("에러");
						}
					});
				}
			});
		});
	</script>
</body>
</html>
