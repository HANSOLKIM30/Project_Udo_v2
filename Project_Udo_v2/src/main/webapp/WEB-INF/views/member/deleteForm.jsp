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
		style="background-image: url('../../assets/img/udo1.jpg')">
        <div class="container text-center">
            <div class="row">
                <div class="col-lg-6 col-md-6 ml-auto mr-auto">
                    <h2 class="title" style="font-family: 'Gothic A1', sans-serif">
                        정말 회원탈퇴 하시겠어요?
                    </h2>
                    <div class="text-center">
                        회원탈퇴를 하시게 되면, UDO의 서비스를 이용할 수 없어요.
                        <i class="fas fa-sad-tear"></i>
                    </div>
                    <hr style="width: 450px; color: darkorchid; border: thin solid">
                    <br>
                    <form class="form" method="post" id="deleteForm" onsubmit="return false">
                        <div class="row">
                            <div class="col-lg-7 col-md-6 ml-auto mr-auto">
                                <div style="margin-bottom: 25px">
                                    <div>
                                        <p style="font-size: 11px;">그래도 회원탈퇴를 원하시면 아래에 비밀번호를 입력해주세요.</p>
                                    </div>
                                    <div>
                                        <input type="password" id="uPW">
                                        <div class="text-left">
											<span id="uPWCheck" style="font-size: 11px; color: #F4483C;">
                                            </span>
										</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="회원탈퇴">
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
			$('#deleteForm').submit(function() {
				
				var uPW = $('#uPW').val();
	
				$('#uPWCheck').html("");
				
				if (uPW == "") { // id가 null 값일 때.
					$('#uPWCheck').html("<i class=\"material-icons\" style=\"font-size: 11px; color: #F4483C;\">error_outline</i>&nbsp필수 입력 사항입니다.");
					$('#uPW').focus();
				} else {
					$.ajax({
						url : "<c:url value='/member/myPage/delete' />",
						type : 'POST',
						data : {
							uPW : uPW
							},
						success : function(data) {
							if (data == "success") {
								alert("회원탈퇴 처리 되었습니다.");
								location.href = "<c:url value='/' />"
							} else{
								alert("비밀번호를 잘못 입력하셨습니다.");
								$('#uPWCheck').html("");
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