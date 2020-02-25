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
<body>
	<div class="page-header header-filter" data-parallax="true"
		style="background-image: url('../assets/img/udo1.jpg')">
		<div class="container text-center">
			<div class="row">
				<div class="col-lg-6 col-md-6 ml-auto mr-auto">
					<h2 class="title" style="font-family: 'Gothic A1', sans-serif">비밀번호찾기</h2>
					<hr style="width: 300px; color: darkorchid; border: thin solid">
					<br>
					<form class="form" method="post" id="findForm" onsubmit="return false">
						<div class="row">
							<div class="col-lg-6 col-md-6 ml-auto mr-auto">
								<div class="row" style="margin-bottom: 25px">
									<div class="col-md-4">
										<span>아이디</span>
									</div>
									<div>
										<input type="text" id="uId">
										<div class="text-left">
											<span id="uIdCheck" style="font-size: 11px; color: #F4483C;">
                                            </span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="text-center" style="margin-top:25px;">
							<input type="submit" class="btn btn-primary" value="비밀번호 찾기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 푸터 시작 -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<!-- 푸터 끝  -->
	<!-- 스크립트 시작 -->
	<script type="text/javascript">
		$(document).ready(function() {
			// 비밀번호 찾기 submit
			$('#uIdCheck').html("");
			
			$('#findForm').submit(function() {
				var uId = $('#uId').val();

			if (uId == "") { // id가 null 값일 때.
				$('#uIdCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i>&nbsp필수 입력 사항입니다.");
				$('#uId').focus();
			} else {
				$.ajax({
					url : "<c:url value='/member/lostPW' />",
					type : 'POST',
					data : {
						uId : uId
						},
					success : function(data) {
						if (data == "success") {
							alert("가입하신 이메일로 비밀번호가 전송되었습니다.");
							location.href = "<c:url value='/member/login' />"
						}else if(data == "notEmail"){
							$('#uIdCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i>&nbsp이메일 형식이 아닙니다.");
							$('#uId').focus();
						} else{
							alert("사용자를 찾을 수 없습니다. 이메일을 다시 한번 확인해주세요.");
							$('#uIdCheck').html("");
						}
					},
					error : function(data) {
						console.log("에러");
					}
				});
			}
		});
	});
	</script>
	<!-- 스크립트 끝 -->
</body>
</html>