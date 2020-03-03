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
		<div class="page-header header-filter" data-parallax="true"
			style="background-image: url('../assets/img/udo3.jpg')">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1 class="title" style="font-family: 'Gothic A1', sans-serif; line-height: 150%">지금, 스쿠터를 대여해 보세요.</h1>
						<h4 style="line-height: 150%">우도 여행을 계획하고 계신가요?<br>그렇다면 스쿠터를 대여하고 우도의 정취를 느껴보세요.<br></h4>
						<br>
					</div>
				</div>
			</div>
		</div>
		<div class="main main-raised">
			<div class="container">
				<div class="section text-center">
					<h2 class="title" style="font-family: 'Gothic A1', sans-serif; letter-spacing: 4px;">대여할 스쿠터를 선택해주세요.</h2>
					<br>
					<div class="team">
						<div class="row">
							<div class="col-md-4">
								<div class="team-player">
									<div class="card card-plain">
										<div class="col-md-6 ml-auto mr-auto">
											<img src="../assets/img/moter1.jpg" alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											Lambretta Innocenti<br> 
											<small class="card-description text-muted">30,000 won / 6 hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> 
												<input class="form-check-input" type="radio" name="scooter" id="scooter" value="1"> 
												<span class="circle">
													<span class="check"></span>
												</span>
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="team-player">
									<div class="card card-plain">
										<div class="col-md-6 ml-auto mr-auto">
											<img src="../assets/img/moter2.jpg" alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											VESPA 50 Special<br> 
											<small class="card-description text-muted">30,000 won / 6 hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> 
												<input class="form-check-input" type="radio" name="scooter" id="scooter" value="2">
												<span class="circle">
													<span class="check"></span>
												</span>
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="team-player">
									<div class="card card-plain">
										<div class="col-md-6 ml-auto mr-auto">
											<img src="../assets/img/moter3.jpg" alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											VESPA Piaggio<br>
											<small class="card-description text-muted">30,000 won / 6 hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> 
												<input class="form-check-input" type="radio" name="scooter" id="scooter" value="3"> 
												<span class="circle">
													<span class="check"></span>
												</span>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				<!--예약여부 확인 시작-->
                <div style="margin-top: 50px; font-family: 'Gothic A1', sans-serif; display: none;" id="reservationList">
                    <div class="text-center">
                        <h2 class="title" id="scooterName"></h2>
                        <div class="description">
                            <div>
                                <p><i class="fas fa-check"> 예약서비스는 금일부터 일주일 단위로 이루어집니다.</i></p>
                            </div>
                        </div>
                        <div class="description text-center">
                            <p><i class="fas fa-check"> 대여시간은 오전과 오후로 나뉘어집니다. (6시간 기준)</i> </p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-12 ml-auto mr-auto">
                            <!--날짜 표시 div-->
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="row">
                                        <div class="col-md-6"></div>
                                        <!-- 1 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date0"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 2 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date1"></h4>
                                        </div>
                                        <!-- 3 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date2"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 4 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date3"></h4>
                                        </div>
                                        <!-- 5 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date4"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 6 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date5"></h4>
                                        </div>
                                        <!-- 7 -->
                                        <div class="col-md-6">
                                            <h4 class="title" id="date6"></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--요일 표시 div-->
                            <div class="row" style="margin-top: -30px; margin-bottom: 1px;">
                                <div class="col-md-3">
                                    <div class="row">
                                        <div class="col-md-6"></div>
                                        <!-- 1 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day0"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 2 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day1"></h4>
                                        </div>
                                        <!-- 3 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day2"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 4 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day3"></h4>
                                        </div>
                                        <!-- 5 -->
                                        <div class="col-md-6">
                                           <h4 class="description" id="day4"></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                    	<!-- 6 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day5"></h4>
                                        </div>
                                        <!-- 7 -->
                                        <div class="col-md-6">
                                            <h4 class="description" id="day6"></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 오전 예약 여부 div -->
                            <div class="row" style="margin-top: 20px">
                                <div class="col-md-3">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <i class="fas fa-cloud-sun fa-3x"></i>
                                        </div>
                                        <!-- 1 -->
                                        <div class="col-md-6" id="AM0">
                                            <div id="AM0Can" style="display: none"></div>
                                            <div id="AM0Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 2 -->
                                        <div class="col-md-6" id="AM1">
                                            <div id="AM1Can" style="display: none"></div>
                                            <div id="AM1Cant" style="display: none"></div>
                                        </div>
                                        <!-- 3 -->
                                        <div class="col-md-6" id="AM2">
                                            <div id="AM2Can" style="display: none"></div>
                                            <div id="AM2Cant" style="display:none;"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 4 -->
                                        <div class="col-md-6" id="AM3">
                                            <div id="AM3Can" style="display: none"></div>
                                            <div id="AM3Cant" style="display: none"></div>
                                        </div>
                                        <!-- 5 -->
                                        <div class="col-md-6" id="AM4">
                                            <div id="AM4Can" style="display: none"></div>
                                            <div id="AM4Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 6 -->
                                        <div class="col-md-6" id="AM5">
                                            <div id="AM5Can" style="display: none"></div>
                                            <div id="AM5Cant" style="display: none"></div>
                                        </div>
                                        <!-- 7 -->
                                        <div class="col-md-6" id="AM6">
                                            <div id="AM6Can" style="display: none"></div>
                                            <div id="AM6Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 오후 예약 여부 div-->
                            <div class="row" style="margin-top: 20px">
                                <div class="col-md-3">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div>
                                                <i class="fa fa-cloud-moon fa-3x"></i>
                                            </div>
                                        </div>
                                        <!-- 1 -->
                                        <div class="col-md-6" id="PM0">
                                            <div id="PM0Can" style="display: none"></div>
                                            <div id="PM0Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 2 -->
                                        <div class="col-md-6" id="PM1">
                                            <div id="PM1Can" style="display: none"></div>
                                            <div id="PM1Cant" style="display: none"></div>
                                        </div>
                                        <!-- 3 -->
                                        <div class="col-md-6" id="PM2">
                                            <div id="PM2Can" style="display: none"></div>
                                            <div id="PM2Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 4 -->
                                        <div class="col-md-6" id="PM3">
                                            <div id="PM3Can" style="display: none"></div>
                                            <div id="PM3Cant" style="display: none"></div>
                                        </div>
                                        <!-- 5 -->
                                        <div class="col-md-6" id="PM4">
                                            <div id="PM4Can" style="display: none"></div>
                                            <div id="PM4Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="row">
                                        <!-- 6 -->
                                        <div class="col-md-6" id="PM5">
                                            <div id="PM5Can" style="display: none"></div>
                                            <div id="PM5Cant" style="display: none"></div>
                                        </div>
                                        <!-- 7 -->
                                        <div class="col-md-6" id="PM6">
                                            <div id="PM6Can" style="display: none"></div>
                                            <div id="PM6Cant" style="display: none"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--예약여부 확인 끝-->
				</div>
			</div>
		</div>
	<!-- 푸터 시작 -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<!-- 푸터 끝  -->
	
	<script>
		$(document).ready(function() {
			$('input[name="scooter"]').click(function(){
				
				var scooter = $('input[name="scooter"]:checked').val();
				
				// 현재 예약상황 보여주기
				showScooterName(scooter);
				showWeekInformation(scooter);
				$('#reservationList').css("display", "block");
			});
		});

		function showScooterName(scooter){
			if(scooter == 1){
				$('#scooterName').html("Lambretta Innocenti");
			} else if(scooter == 2){
				$('#scooterName').html("VESPA 50 Special");
			} else{
				$('#scooterName').html("VESPA Piaggio");
			}
		}
		
		// 선택한 스쿠터에 대한 현재 예약상황
		function showWeekInformation(scooter) {
			$.ajax({
				url : '/udo/reservation/weekInfomation/' + scooter,
				type : 'GET',
				success : function(data) {
					
					console.log(data);
					
					// 오늘부터 일주일간 날짜 정보
					var weekInfoList = data.weekInfoList;
					// 일주일 간 오전 예약 여부
					var checkAMReservationList = data.checkAMReservationList;						
					// 일주일 간 오후 예약 여부
					var checkPMReservationList = data.checkPMReservationList;
	
					// 날짜 정보 파싱해서 div에 값 뿌려주기
					for (var i = 0; i < 7; i++) {

						var showDate = weekInfoList[i].year + "-" + weekInfoList[i].month + "-" + weekInfoList[i].date;
						
						// 날짜 출력
						$('#date' + i).html(showDate);
						
						// 요일 출력
						var day = weekInfoList[i].day;
						$('#day' + i).html(day);					
					}
					
					// 오전 예약 정보
					for (var i = 0; i < 7; i++) {
						var available = checkAMReservationList[i].checkAM;
						if(available == true){
							$('#AM' + i + 'Can').css("display", "block");
							$('#AM' + i + 'Cant').css("display", "none");
							$('#AM' + i + 'Can').html("<button class='btn btn-primary btn-round btn-sm' onclick='makeReservation(" + weekInfoList[i].year +  weekInfoList[i].month + weekInfoList[i].date + "," + 2 + "," + scooter + ")'><i class='material-icons'>favorite</i> 예약하기</button>");
						} else{
							$('#AM' + i + 'Cant').css("display", "block");
							$('#AM' + i + 'Can').css("display", "none");
							$('#AM' + i + 'Cant').html("<button class='btn btn-round btn-sm' style='pointer-events: none;'><i class='material-icons'>close</i> 예약불가</button>")
						}
					}
					
					// 오후 예약 정보
					for (var i = 0; i < 7; i++) {
						var available = checkPMReservationList[i].checkPM;
						if(available == true){
							$('#PM' + i + 'Can').css("display", "block");
							$('#PM' + i + 'Cant').css("display", "none");
							$('#PM' + i + 'Can').html("<button class='btn btn-primary btn-round btn-sm' onclick='makeReservation(" + weekInfoList[i].year +  weekInfoList[i].month + weekInfoList[i].date + "," + 3 + "," + scooter + ")'><i class='material-icons'>favorite</i> 예약하기</button>");
						} else{
							$('#PM' + i + 'Cant').css("display", "block");
							$('#PM' + i + 'Can').css("display", "none");
							$('#PM' + i + 'Cant').html("<button class='btn btn-round btn-sm' style='pointer-events: none;'><i class='material-icons'>close</i> 예약불가</button>")

						}
					}
				},
				error: function(data){
					console.log("에러");
				}
			});
		}

		// 예약하기
		function makeReservation(fullDate, time, scooter) {
	
			var reservationDate = String(fullDate);
			console.log("reservationDate:::::" + reservationDate);
			var month = reservationDate.substr(4,2);
			var date = reservationDate.substr(6,2);
			var AMPM;
			
			if(time == 2){
				AMPM = "오전";
			} else{
				AMPM = "오후"
			}
			
			var result = confirm(month+ "월 " + date + "일 " + AMPM +"에 예약하시겠습니까?");
			if(result) {
				$.ajax({
					url : '/udo/reservation/makeReservation',
					type : 'POST',
					data: {
						date: reservationDate,
						time: time,
						scooter: scooter,
					},
					success : function(data) {
						if(data=="success"){
							alert("성공적으로 예약되었습니다.");
							location.href = "<c:url value='/reservation/myReservation' />";
						} else{
							alert("예약에 실패하였습니다.");
							location.reload();
						}
					},
					error: function(data){
						console.log("에러");
					}
				});
			}
		}
		
	</script>
</body>
</html>
