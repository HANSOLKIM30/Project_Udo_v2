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
	    <div class="page-header header-filter" data-parallax="true" style="background-image: url('../assets/img/udo5.jpg')">
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
                <div class="" style="font-family: 'Gothic A1', sans-serif;">
                    <div>
                        <h2 class="title" style="font-family: 'Gothic A1', sans-serif;">${loginInfo.uId}님의 예약 상황입니다.</h2>
                        <div class="description">
                            <div style="margin: 30px">
                                <p><i class="fas fa-check"> 오늘 이전 예약은 취소가 되지 않습니다.</i></p>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-12 ml-auto mr-auto" id="dataRow">
                            <div class="row" style='margin-top: 20px'>
                                <div class="col-md-6">
                                    <div class="row">
                                            <div class="col-md-6">
                                                <div class="text-center">
                                                    <h5 class="title">No.</h5>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="text-center">
                                                    <h5 class="title" style="font-family: 'Gothic A1', sans-serif;">스쿠터 정보</h5>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="text-center">
                                                <h5 class="title" style="font-family: 'Gothic A1', sans-serif;">예약 정보</h5>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                        	<div class="text-center">
                                                <h5 class="title" style="font-family: 'Gothic A1', sans-serif;">취소하기</h5>
                                            </div>
                                        </div>
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
			 showMyReservation();
		});

		// uIdx를 통한 회원의 예약정보 가져오기
		function showMyReservation() {
			$.ajax({
				url : "<c:url value='/reservation/myReservation/list' />",
				type : 'GET',
				success : function(data) {
					
					if(data == ""){
						
						var source = "<div style='margin-top: 100px'>";
						source += "<h2 class='title' style='font-family: \"Gothic A1\", sans-serif; line-height: 150%'>";
						source += " <i class='material-icons' style='font-size: 60px;'>warning</i><br>";
						source += "예약 내역이 없습니다.";
						source += "</h2>";
						source += "</div>";

						$('#dataRow').html(source);
						
					} else {
						// data 변수로 받아오기
						var myReservationList = data;
						// 리스트의 변수를 받아오기
						var myReservation;
						
						for(var i = 0; i < myReservationList.length; i++){
							
							var num = i+1;
							//데이터 하나마다 한줄씩 생성
							var source = "<div class='row' style='margin-top: 20px'>";
							source += "<div class='col-md-6'>";
							source += " <div class='row'>";
							source += "<div class='col-md-6'>";
							source += "<div class='text-center' id='num" + i + "'>";
							source += "</div>";
							source += "</div>";
							source += "<div class='col-md-6'>";
							source += "<div class='text-center' id='scooterPic" + i + "' style=\"margin-bottom: -20px\">";
							source += "</div>";
							source += "<div class='text-center' id='scooter" + i + "'>";
							source += "</div>";
							source += "</div>";
							source += "</div>";
							source += "</div>";
							source += "<div class='col-md-6'>";
							source += "<div class='row'>";
							source += "<div class='col-md-6'>";
							source += "<div class='text-center' id='date" + i + "'>";
							source += "</div>";
							source += "</div>";
							source += "<div class='col-md-6' style='padding: 20px;'>";
							source += "<div class='text-center' id='cancel" + i + "'>";
							source += "</div>";
							source += "</div>";
							source += "</div>";
							source += "</div>";
							source += "</div>";	
							$('#dataRow').append(source);
							
	                        myReservation = myReservationList[i];
							
							$('#num' + i).html("<div><h5 class='title' id='showNum" + i + "'>"+ num +"</h5></div>");
							
							var date = myReservation.date;
							var year = date.substr(0,4);
							var month = date.substr(4,2);
							var day = date.substr(6,2);
							var time = myReservation.time;
							var AMPM;
							if(time == 2){
								AMPM = "오전";
							} else{
								AMPM = "오후"
							}
							$('#date' + i).html("<div><h5 class='title' id='showDate" + i + "' style=\"font-family: 'Gothic A1', sans-serif;\">" + year + "-" + month + "-" + day+ " " + AMPM +"</h5></div>");
	
							var scooter = myReservation.scooter;
							if(scooter == 1){
								$('#scooterPic' + i).html("<img src='../assets/img/moter1.jpg' class='rounded-circle' style='width: 50px; height: auto'>");
								$('#scooter' + i).html("<div><h5 class='title' id='showName" + i + "'>Lambretta Innocenti</h5></div>");
							} else if(scooter == 2){
								$('#scooterPic' + i).html("<img src='../assets/img/moter2.jpg' class='rounded-circle' style='width: 50px; height: auto'>");
								$('#scooter' + i).html("<div><h5 class='title' id='showName" + i + "'>VESPA 50 Special</h5></div>");
							} else {
								$('#scooterPic' + i).html("<img src='../assets/img/moter3.jpg' class='rounded-circle' style='width: 50px; height: auto'>");
								$('#scooter' + i).html("<div><h5 class='title' id='showName" + i + "'>VESPA Piaggio</h5></div>");
							}
							
							var idx = myReservation.idx;
							
							var reservationDate = year + month + day;
							var isPast = isPastDate(reservationDate); 
							if(isPast){
								$('#showNum' + i).css("color","#999999");
								$('#showDate' + i).css("color","#999999");
								$('#showName' + i).css("color","#999999");
								$('#scooterPic' + i).css("opacity","0.2");
								$('#cancel' + i).html("<button class='btn btn-round btn-sm' style='pointer-events: none'>취소불가</button>");
							} else{
								$('#cancel' + i).html("<button class='btn btn-primary btn-round btn-sm' onclick='cancleMyReservation(" + idx + ")'>취소하기</button>");
							}
							
						}
					}
				},

				error : function(data) {
					console.log("에러");	
				}
			});
		}

		// 예약 취소하기
		function cancleMyReservation(idx) {

			var result = confirm("예약을 취소하시겠습니까?");

			if (result) {
				$.ajax({
					url : "<c:url value='/reservation/myReservation/cancle' />" + "/" + idx,
					type : 'DELETE',
					success : function(data) {
						if(data == "success"){
							alert("예약이 취소되었습니다.");
						} else{
							alert("오류입니다. 관리자에게 문의하세요.");
						}	
					},
					error : function(data) {
						console.log("에러");	
					}
				});
			} 
			location.reload();
		}

		// 오늘날짜 구해서 이전 예약인지 확인하기
		function isPastDate(reservationDate){
			
			var date = new Date();
			var year = date.getFullYear();
			var month = new String(date.getMonth()+1);
			var date = new String(date.getDate());
			
			if(month.length == 1){
				month = "0" + month;
			}
			if(date.length == 1){
				date = "0" + date;
			}
			
			var today = parseInt(year + month + date, 10);
			var intReservationDate = parseInt(reservationDate);
			console.log("오늘 날짜::::::" + today + " 예약날짜:::::" + intReservationDate);
			
			if(today >= reservationDate){
				return true;	
			} else{
				return false;
			}
		}

	</script>
</body>
</html>
