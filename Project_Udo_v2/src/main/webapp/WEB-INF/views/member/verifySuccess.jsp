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
	                    <i class="material-icons" style="font-size: 60px;">how_to_reg</i><br>
	                                             인증되었습니다.<br>
	                                             로그인 후 정상적인 서비스 실행이 가능합니다.<br> 
	                                             감사합니다.
	                </h2>
	            </div>
	        </div>
	    </div>
		<!-- 푸터 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- 푸터 끝  -->
	</body>
</html>