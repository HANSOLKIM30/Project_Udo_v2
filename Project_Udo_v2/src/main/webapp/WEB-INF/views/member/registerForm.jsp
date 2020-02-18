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
            	margin: -15px; 
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
                        <form class="form" method="post" id="registerForm" enctype="multipart/form-data">
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
                                       <label for="email" class="bmd-label-floating">ID...</label>
                                       
                                       <input type="email" class="form-control" id="uId" name="uId">
                                       <input type="checkbox" id="idcheck" style="display: none;">
                                       <span class="bmd-help">필수입력 사항입니다.</span>
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
                                        <label for="pw" class="bmd-label-floating" >Password...</label>
                                        <input type="text" class="form-control" id="uPW" name="uPW">
                                        <span class="bmd-help">필수입력 사항입니다.</span>
                                    </div>
                                </div>
                                
                                <!--Confrim PW-->
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">check</i>
                                        </span>
                                    </div>
                                    <div class="form-group">
                                        <label for="con_pw" class="bmd-label-floating">Confirm Password...</label>
                                        <input type="text" class="form-control" id="confrim_uPW">
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
                                        <label for="name" class="bmd-label-floating">Name...</label>
                                        <input type="text" class="form-control" name="uName">
                                        <span class="bmd-help">필수입력 사항입니다.</span>
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
			
			// 1. id 중복체크
			$('#uId').focusout(function(){
				
			});
			
		});
	</script>
</body>
</html>
