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
       			margin-left: -12px;
       			margin-top: 10px;
        	}
    	</style>
	</head>	
	<body class="login-page sidebar-collapse">
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<br>
		<br>
		<br>
		<br>
		<br>

		<div class="page-header header-filter" style="background-image: url('../assets/img/udo1.jpg'); background-size: cover; background-position: top center;">
		  <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 ml-auto mr-auto" id="userPage">
                    <div class="card">
                        <form class="form" method="post" id="registerForm" enctype="multipart/form-data" onsubmit="return false">
                            <div class="card-header card-header-primary text-center">
                                <h4 class="card-title">SIGN UP</h4>
                            </div>
                            <!--card-body-->
                            <div class="card-body" style="margin-left: 30px">
                                
                                <!--ID-->
								<div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">email</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                       <label for="uId" class="bmd-label-floating">ID</label>
                                        <input type="text" class="form-control" id="uId" name="uId">
                                        <input type="checkbox" id="idCheckBox_validate" style="display: none"><!--ajax를 통해 서버에서 값을 받아와야 하는 요소를 check  -->
                                        <input type="checkbox" id="idCheckBox_overlap" style="display: none">
                                        <span class="bmd-help" id="idCheck"></span> 
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
                                        <label for="uName" class="bmd-label-floating">Name</label>
                                        <input type="text" class="form-control" id="uName" name="uName">
                                        <span class="bmd-help" id="nameCheck"></span>
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
                                        <label for="uPhone" class="bmd-label-floating">Phone ('-'제외 입력)</label>
                                        <input type="text" class="form-control" id="uPhone" name="uPhone">
                                        <input type="checkbox" id="phoneCheckBox_validate" style="display: none">
                                        <input type="checkbox" id="phoneCheckBox_overlap" style="display: none">
                                        <span class="bmd-help" id="phoneCheck"></span>
                                    </div>
                                </div>
                                
                                <!--Photo-->
                                <div class="row" style="margin-top: 10px;">
                                    <div class="col-md-2">
                                        <span class="input-group-text">
                                            <i class="material-icons">camera</i>
                                        </span>
                                    </div>
                                    <div class="col-md-1" style="margin-left: -10px; margin-top: 10px">
                                        <input type="file" style="color: #868686" name="uPhoto" id="uPhoto">
                                    </div>
                                    <span style="font-size: 11px; color: #868686; margin-top: 36px; margin-left: -15px">* 프로필 사진을 선택해주세요.</span>
                                </div>
                            </div><!-- /.cardbody-->
                            
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary btn-link btn-wd btn-lg" value="SIGN UP">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<!-- 푸터 시작 -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<!-- 푸터 끝  -->
	
	<!-- 동작스크립트  -->
	<script>
		$(document).ready(function(){		
			// ** 1. id 중복체크
			$('#uId').focusout(function(){
				// id의 값을 selectById 기능 통해 변수로 받아오기
				var uId = $('#uId').val();
				// id가 null 값인지 확인
				if(uId == ""){	// id가 null 값이라면 span에 경고문구 띄워주기
					$('#idCheck').css("display","block");
					$('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{	// id가 null 값이 아니라면,
					// ajax를 통한 비동기 통신으로 uId 값이 데이터베이스에 존재하는지 확인
					$.ajax({
						url: "<c:url value='/member/checkId' />",
						type: 'GET',
						data: {
							uId: uId
						},
						success: function(data){
							console.log("id check 성공: " + data);
							// 통신 성공 시, span에  새로운 값 입력해주기 위해 기존 값 모두 비워주기
							$('#idCheck').html("");
							if(data == "exist"){	// 입력한 id가 이미 존재할 경우
								// span block 처리
								$('#idCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp사용중인 아이디입니다.</p>");
								//체크박스 처리
				                $('#idCheckBox_overlap').prop('checked', false);
							} else if(data == "notExist"){		// 존재하지 않을 경우
								// span block 처리
								$('#idCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp사용 가능한 멋진 아이디입니다.</p>");
				                //체크박스 처리
				                $('#idCheckBox_overlap').prop('checked', true);
				                $('#idCheckBox_validate').prop('checked', true);
							} else{	//이메일 양식을 따르지 않았을 경우
								// span block 처리
								$('#idCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp이메일 형식이 아닙니다.</p>");
				                // 체크박스 처리
				                $('#idCheckBox_validate').prop('checked', false);
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}						
					});
					
				}
			});
			
			// ** 2. 비밀번호 유효성 검사
			$('#uPW').focusout(function(){				
				var uPW = $('#uPW').val();
				// pw가 null 값인지 확인
				if(uPW == ""){
					$('#PWCheck').css("display","block");
					$('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{ // pw가 null 값이 아니라면,
					// pw 유효성 검사
					$.ajax({
						url: "<c:url value='/member/checkPW' />",
						type: 'GET',
						data: {
							uPW: uPW
						},
						success: function(data){
							console.log("pw check 성공: " + data);
							// 통신 성공 시, span에  새로운 값 입력해주기 위해 기존 값 모두 비워주기
							$('#PWCheck').html("");
							if(data == "success"){	// 유효성 검사 통과 시
								// span block 처리
								$('#PWCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp안전한 비밀번호입니다.</p>");
				                $('#PWCheckBox').prop('checked', true);
							}else{	//유효성 검사 통과 실패 시
								// span block 처리
								$('#PWCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">8~16자, 숫자, 특수문자 포함.</p>");
				                $('#PWCheckBox').prop('checked', false);
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}
					});
				}
			});
			
			// ** 3. confirm PW 
			$('#confirm_uPW').focusout(function(){			
				// uPW 값 받아오기
				var uPW = $('#uPW').val();
				// confirm_uPW 값 받아오기
				var confirm_uPW = $('#confirm_uPW').val();
				// 재입력 시 기존 span 값 모두 비워주기
				$('#confirmPWCheck').html("");
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
			
			// ** 4. phone 중복 확인 및 유효성 검사
			$('#uPhone').focusout(function(){			
				// uPhone 값 받아오기
				var uPhone = $('#uPhone').val();
				// 재입력 시 기존 span 값 모두 비워주기
				$('#uPhone').html("");
				if(uPhone==""){
					$('#phoneCheck').css("display","block");
					$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{	// uphone이 null 값이 아니라면,
					// 값 비교			
					$.ajax({
						url: "<c:url value='/member/checkPhone' />",
						type: 'GET',
						data: {
							uPhone: uPhone
						},
						success: function(data){
							console.log("phone check 성공: " + data);
							// 통신 성공 시, span에  새로운 값 입력해주기 위해 기존 값 모두 비워주기
							$('#phoneCheck').html("");
							if(data == "exist"){	// 중복 검사 실패 시.
								$('#phoneCheck').css("display","block");
								$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">사용 중인 번호입니다.</p>");
								// 체크박스 처리
								$('#phoneCheckBox_overlap').prop('checked', false);
							}else if(data == "notExist"){	// 중복, 유효성 검사 성공 시.
								$('#phoneCheck').css("display","block");
								$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp사용하셔도 좋은 번호입니다.</p>");
								// 체크박스 처리
								$('#phoneCheckBox_overlap').prop('checked', true);
								$('#phoneCheckBox_validate').prop('checked', true);
							} else{	// 유효성 검사 실패 시.
								$('#phoneCheck').css("display","block");
				                $('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp유효한 형식이 아닙니다.</p>");
				                // 체크박스 처리
								$('#phoneCheckBox_validate').prop('checked', false);
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}
					});
				}
			});
			
			// ** 5. form 전송
			$('#registerForm').submit(function(){
				var uId = $('#uId').val();
				var uPW = $('#uPW').val();
				var confirm_uPW = $('#confirm_uPW').val();
				var uName = $('#uName').val();
				var uPhone = $('#uPhone').val().trim();
				
				/* $('#idCheck').html("");
				$('#PWCheck').html("");
				$('#confirmPWCheck').html("");
				$('#phoneCheck').html(""); */
								
				if(uId == ""){	// id가 null 값일 때.
					$('#idCheck').css("display","block");
					$('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
					$('#uId').focus();
				} else if(uPW == ""){	// pw null 값일 때.
					$('#PWCheck').css("display","block");
					$('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
					$('#uPW').focus();
				} else if(confirm_uPW == ""){	// pw confirm null 값일 때.
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
					$('#confirm_uPW').focus();
				} else if(uPhone == ""){	// phone null 값일 때.
					$('#phoneCheck').css("display","block");
					$('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
					$('#uPhone').focus();
				} else if(!$('#idCheckBox_validate').prop('checked') || !$('#idCheckBox_overlap').prop('checked')){	// id 유효성 검사 실패
					$('#idCheck').css("display","block");
	                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp아이디를 다시 입력해주세요.</p>");
					$('#uId').focus();
				} else if(!$('#PWCheckBox').prop('checked')){	// pw 유효성 검사 실패
					$('#PWCheck').css("display","block");
	                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">8~16자, 숫자, 특수문자 포함.</p>");
					$('#uPW').focus();
				} else if(uPW != confirm_uPW){	// confirm pw - pw 불일치
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp비밀번호가 일치하지 않습니다.</p>");
					$('#confirm_uPW').focus();
				} else if(!$('#phoneCheckBox_validate').prop('checked') || !$('#phoneCheckBox_overlap').prop('checked')){	// phone 유효성 검사 실패
					$('#phoneCheck').css("display","block");
	                $('#phoneCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">반호를 다시 입력해주세요.</p>");
					$('#uPhone').focus();
				} else{	//submit
					//ajax에 담아보낼 객체 생성
					var formData = new FormData();
					var file = $('#uPhoto')[0].files[0];			
					formData.append('uId',uId);
					formData.append('uPW',uPW);
					formData.append('uName',uName);
					formData.append('uPhone',uPhone);
					if(file != undefined){
						formData.append('uPhoto',file);
					}
					//비동기통신
					$.ajax({
						url: "<c:url value='/member/register'/>",
						type: 'POST',
						data: formData,
						enctype: 'multipart/form-data',
						contentType: false,
						processData: false,						
						success: function(data){
							console.log("submit 성공: " + data);
							if(data == "success"){
								alert("성공성공");
								/* myPage 이동 */
							}else{
								alert("회원가입에 실패하였습니다. 관리자에게 문의바랍니다.");
							}
						}, 
						error: function(data){
							console.log("에러::::::" + data);
						}
					});
				}
			});
		});
	</script>
</body>
</html>
