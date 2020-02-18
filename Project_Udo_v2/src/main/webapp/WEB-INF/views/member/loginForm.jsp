<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->
	
	<body class="login-page sidebar-collapse">
		<!-- 네비게이션 시작 -->
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<!-- 네비게이션 끝  -->
		<br>
		<br>
		<div class="page-header header-filter"
			style="background-image: url('../assets/img/udo1.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-6 ml-auto mr-auto">
						<div class="card">
							<form class="form" method="post" id="loginForm" onsubmit="return false">
								<div class="card-header card-header-primary text-center">
									<h4 class="card-title">Login</h4>
								</div>
								<div class="card-body" style="margin-left: 20px">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="material-icons">person_outline</i>
											</span>
										</div>
										<div  class="form-group">
											<input type="email" class="form-control" placeholder="ID..."
											id="uId" name="uId">
											<span class="bmd-help" id="id-warning"></span>
										</div>
									</div>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="material-icons">lock_outline</i>
											</span>
										</div>
										<div  class="form-group">
											<input type="password" class="form-control"
											placeholder="Password..." id="uPW" name="uPW">
											<span class="bmd-help" id="pw-warning"></span>
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-primary btn-link btn-lg" value="LOGIN">									
									<div class="nav-tabs">
										<div class="nav-tabs-wrapper">
											<ul class="nav nav-tabs" data-tabs="tabs">
												<li class="nav-item"><a class="nav-link" href="#">
														<p class="text-primary" style="font-size: 11px">계정을
															분실하셨나요?</p>
												</a></li>
												<li class="nav-item">
													<p class="text-primary" style="font-size: 11px"></p>
												</li>
												<li class="nav-item"><a class="nav-link" href="#">
														<p class="text-primary" style="font-size: 11px">아직 계정이
															없으신가요?</p>
												</a></li>
											</ul>
										</div>
									</div>
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
			$('#loginForm').submit(function(){
				
				//ID, PW 값 받아오기
				var uId = $('#uId').val();
				console.log(uId);	//확인
				var uPW = $('#uPW').val();
				console.log(uPW);	//확인
				
				if(uId == ""){
					$('#id-warning').html("아이디를 입력해주세요.");
					$('#uId').focus();
				} else if(uPW == ""){
					$('#pw-warning').html("패스워드를 입력해주세요.");
					$('#uPW').focus();
				} else{
					$.ajax({
						url: "<c:url value='/member/login' />",
						type: 'POST',
						data: $('#loginForm').serialize(),
						success: function(data){
							console.log("성공");
							if(data == 'loginfailed'){
								alert("등록되지 않은 아이디거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
								//input 값 비우기
								$('#id-warning').html("");	//warning 값 비우기
								$('#pw-warning').html("");
							} else if(data == 'unverified'){
								alert("이메일 미인증 사용자 입니다.");
							} else{
								alert('성공');
							}
						},
						error: function(data){
							console.log("에러:::" + data);
						}
					})
				}
			});
		});
	</script>
</body>
</html>
