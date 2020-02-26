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
	<br>
	<br>
	<br>
	<br>
	<body class="sidebar-collapse">
		<!-- 네비게이션 시작  -->
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<!-- 네비게이션 끝 -->
		
		<div class="page-header header-filter" style="background-image: url('../assets/img/udo2.jpg'); background-size: cover; background-position: top center;">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-4 col-md-6 ml-auto mr-auto">
	                    <div class="card">
	                        <div class="card-body">
		                        <div class="text-center">
		                            <!-- uPhoto 변수 설정 -->
		                            <c:set var = "uPhoto" value = "${loginInfo.uPhoto}" />
			                         <c:choose>
			                          	<c:when test="${empty uPhoto}">
			                           		<img src="../uploadFile/no_images.jpg" class="img-raised rounded-circle img-fluid" style="width: 150px; height: 150px">
			                           	</c:when>
			                           	<c:otherwise>
			                           		<img src="../uploadFile/${loginInfo.uPhoto}" class="img-raised rounded-circle img-fluid" style="width: 150px; height: auto">
			                           	</c:otherwise>
			                            </c:choose>                                
		                        </div>
		                        <br>
	                            <div class="content" style="margin: 10px;">
	                                <!--ID-->
	                                <div class="col-lg-12 col-md-6 ml-auto mr-auto">
	                                    <div class="row">
	                                        <div class="col-md-2">
	                                            <i class="material-icons">email</i>
	                                        </div>
	                                        <div class="col-md-10" id=uId>${loginInfo.uId}</div>
	                                    </div>
	                                </div>
	                                
	                                <!--Phone-->
	                                <br>
	                                <div class="col-lg-12 col-md-6 ml-auto mr-auto">
	                                    <div class="row">
	                                        <div class="col-md-2">
	                                            <i class="material-icons">face</i>
	                                        </div>
	                                        <c:set var = "uName" value = "${loginInfo.uName}"/>
	                                        <c:choose>
	                                        	<c:when test="${empty uName}">
	                                        		<div class="col-md-10" id=uName>[이름]정보가 없습니다.</div>
	                                        	</c:when>
	                                        	<c:otherwise>
	                                        		<div class="col-md-10" id=uName>${loginInfo.uName}</div>
	                                        	</c:otherwise>
	                                        </c:choose>       
	                                    </div>
	                                </div>
	                                
	                                <!--Phone-->
	                                <br>
	                                <div class="col-lg-12 col-md-6 ml-auto mr-auto">
	                                    <div class="row">
	                                        <div class="col-md-2">
	                                            <i class="material-icons">phone</i>
	                                        </div>
	                                        <div class="col-md-10" id=uPhone>${loginInfo.uPhone}</div>
	                                    </div>
	                                </div>
	                                
	                                <!--예약정보-->
	                                <br>
	                                <div class="col-lg-12 col-md-6 ml-auto mr-auto">
	                                    <div class="row">
	                                        <div class="col-md-2">
	                                            <i class="material-icons">assignment_turned_in</i>
	                                        </div>
	                                        <div class="col-md-10">예약정보 입력란</div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="card-footer">
	                            <div class="col-md-4 text-center">
	                                <a class="text-primary" href="<c:url value='/member/updateForm' />" style="font-size: 12px">
	                                	프로필 변경
	                                </a>
	                            </div>
	                            <div class="col-md-4 text-center">
	                                <a class="text-primary" href="<c:url value='/member/myPage/logout' />" style="font-size: 12px">
	                                  	로그아웃
	                                </a>
	                            </div>
	                            <div class="col-md-4 text-center">
	                                <a class="text-primary" href="<c:url value='/member/myPage/delete' />" style="font-size: 12px">
	                                   	 회원탈퇴
	                                </a>
	                            </div>
	                        </div>
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
		</script>
</body>
</html>
