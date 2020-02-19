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
           	 	margin-bottom: 5px
        	}
    	</style>
	</head>	
	<body class="llogin-page sidebar-collapse">
		<!-- 네비게이션 시작 -->
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<!-- 네비게이션 끝  -->
		<br>
		<br>
		<div class="page-header header-filter"
			style="background-image: url('../assets/img/udo1.jpg'); background-size: cover; background-position: top center;">
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
								<div class="input-group" style="margin-top: 5px">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">email</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                       <label for="uId" class="bmd-label-floating">ID...</label>
                                        <input type="text" class="form-control" id="uId" name="uId">
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
                                        <label for="uPW" class="bmd-label-floating" >Password...</label>
                                        <input type="password" class="form-control" id="uPW" name="uPW">
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
                                        <label for="confirm_uPW" class="bmd-label-floating">Confirm Password...</label>
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
                                        <label for="uName" class="bmd-label-floating">Name...</label>
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
                                        <label for="uPhone" class="bmd-label-floating">Phone...</label>
                                        <input type="text" class="form-control" id="uPhone" name="uPhone">
                                        <span class="bmd-help" id="nameCheck"></span>
                                    </div>
                                </div>
                                
                                <!--Photo-->
                                <div class="row" style="margin-top: 25px">
                                    <div class="col-md-2">
                                        <span class="input-group-text">
                                            <i class="material-icons">camera</i>
                                        </span>
                                    </div>
                                    <div class="col-md-1" style="margin-left: -10px; margin-top: 6px">
                                        <input type="file" style="color: #868686" name="uPhoto">
                                    </div>
                                    <span style="font-size: 11px; color: #868686; margin-top: 36px; margin-left: -15px">* 프로필 사진을 선택해주세요.</span>
                                </div>
                            </div><!-- /.cardbody-->
                            
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary btn-link btn-wd btn-lg" value="Sign Up">
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
				                $('#uId').focus();
							} else if(data == "notExist"){		// 존재하지 않을 경우
								// span block 처리
								$('#idCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp사용 가능한 멋진 아이디입니다.</p>");
							} else{	//이메일 양식을 따르지 않았을 경우
								// span block 처리
								$('#idCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp이메일 형식이 아닙니다.</p>");
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
							}else{	//유효성 검사 통과 실패 시
								// span block 처리
								$('#PWCheck').css("display","block");
								// span 문구 및 css 재설정
				                $('#PWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">8~16자, 숫자, 특수문자 포함.</p>");
							}
						},
						error: function(data){
							console.log("에러::::::" + data);
						}
					});
				}
			});
			
			// ** 3. confirm PW 
			$('#confrim_uPW').focusout(function(){			
				// uPW 값 받아오기
				var uPW = $('#uPW').val();
				// confrim_uPW 값 받아오기
				var confirm_uPW = $('#confirm_uPW').val();
				// 재입력 시 기존 span 값 모두 비워주기
				$('#confirmPWCheck').html("");
				
				if(confirm_uPW==""){
					$('#confirmPWCheck').css("display","block");
					$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
				} else{
					// 값 비교			
					if(uPW == confirm_uPW){	// 비밀번호 확인 시 일치할 경우
						// span block 처리
						$('#confirmPWCheck').css("display","block");
						// span 문구 및 css 재설정
		                $('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #4CAF50;\">done</i><p style=\"font-size: 10px; color: #4CAF50; float: right\">&nbsp비밀번호가 일치합니다.</p>");					
					} else{	// 비밀번호 확인 시 일치하지 않을 경우
						// span block 처리
						$('#confirmPWCheck').css("display","block");
						// span 문구 및 css 재설정
						$('#confirmPWCheck').html("<i class=\"material-icons\" style=\"font-size: 10px; color: #F4483C;\">clear</i><p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp비밀번호가 일치하지 않습니다.</p>");	
					}
				}
			});
			
			// ** 4. phone 중복 확인
			
			// ** 5. form 전송
			$('#registerForm').submit(function(){
				var uId = $('#uId').val();
				var uPW = $('#uPW').val();
				var confrim_uPW = $('#confrim_uPW').val();
				var uName = $('#uName').val();
				var uPhone = $('#uPhone').val();
				
				//id가 null 값이면 입력되게 한다.
				if(uId == ""){
					$('#idCheck').css("display","block");
					$('#idCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i> <p style=\"font-size: 10px; color: #F4483C; float: right\">&nbsp필수 입력 사항입니다.</p>");
					$('#uId').focus();
				}
			});
		});
	</script>
</body>
</html>
