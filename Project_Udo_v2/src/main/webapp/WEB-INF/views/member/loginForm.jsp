<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

	<head>
		<!-- 해더 시작 -->
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<!-- 해더 끝 -->
	</head>	
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
								<div class="card-body" style="margin-left: 30px">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> 
												<i class="material-icons">person_outline</i>
											</span>
										</div>
										<div  class="form-group">
											<input type="email" class="form-control" placeholder="ID..." id="uId" name="uId">
											<span class="bmd-help" id="id-warning"></span>
										</div>
									</div>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> 
												<i class="material-icons">lock_outline</i>
											</span>
										</div>
										<div  class="form-group">
											<input type="password" class="form-control" placeholder="Password..." id="uPW" name="uPW">
											<span class="bmd-help" id="pw-warning"></span>
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-primary btn-link btn-lg" value="LOGIN">									
									<div class="nav-tabs">
										<div class="nav-tabs-wrapper">
											<ul class="nav nav-tabs" data-tabs="tabs">
												<li class="nav-item">
													<a class="nav-link" href="#">
														<p class="text-primary" style="font-size: 11px">계정을 분실하셨나요?</p>
													</a>
												</li>
												<li class="nav-item">
													<p class="text-primary" style="font-size: 11px"></p>
												</li>
												<li class="nav-item">
													<a class="nav-link" href="<c:url value='/member/register' />">
														<p class="text-primary" style="font-size: 11px">아직 계정이 없으신가요?</p>
													</a>
												</li>
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

	// **문서 실행
	$(document).ready(function(){	
		// loginFrom post submit
		$('#loginForm').submit(function(){
			// id, pw null값으로 안 넘어가도록 check하기 위해 값 받아오기
			var uId = $('#uId').val();
			var uPW = $('#uPW').val();
			// id, pw 값 확인하기
			console.log("uId: " + uId + "+ uPW: " + uPW);
			// id, pw null값으로 안 넘어가도록 check
			if(uId == ""){	// id 값 null
				$('#pw-warning').html("");
				$('#id-warning').html("아이디를 입력해주세요.");
				$('#uId').focus();
			} else if(uPW == ""){	// pw 값 null
				$('#id-warning').html("");
				$('#pw-warning').html("패스워드를 입력해주세요.");
				$('#uPW').focus();
			} else{	// id, pw 둘 다 not null
				//체크 후 ajax로 서버와 비동기통신
				$.ajax({
					url: "<c:url value='/member/login' />",
					type: 'POST',
					data: $('#loginForm').serialize(),
					success: function(data){
						console.log("로그인 성공");
						if(data == 'loginfailed'){
							alert("등록되지 않은 아이디거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
							//input box, warning span 모두 빈 값으로 초기화
							$('#uId').val("");
							$('#uPW').val("");
							$('#id-warning').html("");
							$('#pw-warning').html("");
						} else if(data == 'unverified'){
							alert("이메일 미인증 사용자 입니다.");
							//******이메일 미인증 사용자 창으로 이동******
						} else{
							alert('성공');
							//******mypage로 이동******
						}
					},
					error: function(data){
						console.log("에러::::::" + data);
					}
				})			
			}		
		});
	});
</script>
</body>
</html>
