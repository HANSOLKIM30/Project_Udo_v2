<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<body class="landing-page sidebar-collapse">
	   <!-- 네비게이션 시작 -->
		<%@ include file="/WEB-INF/views/frame/navigation.jsp"%>
		<!-- 네비게이션 끝  -->
	    <div class="page-header header-filter" data-parallax="true" style="background-image: url('../assets/img/udo3.jpg')">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-6">
	                    <h1 class="title" style="font-family: 'Gothic A1', sans-serif; line-height: 150%">내가 예약한 스쿠터.</h1>
	                    <h4 style="line-height: 150%">내가 예약한 스쿠터를 확인하고 예약사항을 변경 할 수 있습니다.<br>
	                    </h4>
	                    <br>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="main main-raised">
	        <div class="container">
	            <div class="section text-center">
	                <br>
	                <div class="team">
	                    <div class="row">
	                        <div class="col-md-6 ml-auto mr-auto">
	                            <ul class="nav nav-pills nav-pills-icons justify-content-center" role="tablist">
	                                <li class="nav-item"><a class="nav-link active" href="#MYRV" role="tab" data-toggle="tab"> <i class="material-icons">event_available</i>
	                                        나의 예약현황
	                                    </a></li>
	                                <li class="nav-item"><a class="nav-link" href="#CHGRV" role="tab" data-toggle="tab"> <i class="material-icons">event_note</i>
	                                        나의 예약변경
	                                    </a></li>
	                            </ul>
	                        </div>
	
	                    </div>
	                    <div class="tab-content tab-space">
	                        <div class="tab-pane text-center gallery" id="MYRV">
	                            <div class="row">
	                                <p>씨발 ㅋㅋ</p>
	                                <div id="myReservation"></div>
	                            </div>
	                        </div>
	                        <div class="tab-pane text-center gallery" id="CHGRV">
	                            <div class="row">
	                                <div id="AlltimeTable">
	                                    <div id="bike1" style="display: none; border-spacing: 2px; border-collapse: separate;">
	                                        <h5>하얀 스쿠터 예약정보</h5>
	                                        <hr>
	                                        <table class="table">
	                                            <div id="bikeTimeTable1"></div>
	                                        </table>
	                                    </div>
	                                    <br>
	                                    <div id="bike2" style="display: none; border-spacing: 2px; border-collapse: separate;">
	                                        <h5>빨간 스쿠터 예약정보</h5>
	                                        <hr>
	                                        <table class="table">
	                                            <div id="bikeTimeTable2"></div>
	                                        </table>
	                                    </div>
	                                    <br>
	                                    <div id="bike3" style="display: none; border-spacing: 2px; border-collapse: separate;">
	                                        <h5>파란 스쿠터 예약정보</h5>
	                                        <hr>
	                                        <table class="table">
	                                            <div id="bikeTimeTable3"></div>
	                                        </table>
	                                    </div>
	                                </div>
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

	<script>
		$(document).ready(function() {
			
		});

		//GET by idx
		function showMyReservation() {

			$.ajax({
				url : ''+ idx,
				type : 'GET',
				success : function(data) {

				},

				error : function() {
							
				}
			});
		}

	

		/*DELETE*/
		function delelteMyReservation(idx) {

			var result = confirm('');

			if (result) {
				$.ajax({
					url : '' + idx,
					type : 'DELETE',
					success : function(data) {
								
					},
					error : function() {
						
					}
				});
			} 
			location.reload();
		}


	</script>
</body>
</html>
