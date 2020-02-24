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
		 <div class="page-header header-filter" data-parallax="true" style="background-image: url('../assets/img/udo4.jpg')">
	        <div class="container text-center">
	          	<div>
	                <h2 class="title" style="font-family: 'Gothic A1', sans-serif; line-height: 150%">
	                    <i class="material-icons" style="font-size: 60px;">warning</i><br>
	                                             이메일 미인증 회원입니다.<br> 
	                                             이메일 인증 후 다시 로그인 해 주세요.
	                </h2>
	                <br>
	                <a href="<c:url value='/member/login' />">로그인 하기</a>
            	</div>
	            <div style="padding: 20px;">
	                <h6>이메일을 받지 못하셨나요?&nbsp;&nbsp;<a href=#>다시 이메일 받기</a></h6>
	            </div>
	        </div>
	    </div>
		<!-- 푸터 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- 푸터 끝  -->	
	</body>
</html>