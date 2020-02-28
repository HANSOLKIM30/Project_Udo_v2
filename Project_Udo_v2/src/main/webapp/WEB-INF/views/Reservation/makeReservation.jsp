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
						<h1 class="title"
							style="font-family: 'Gothic A1', sans-serif; line-height: 150%">지금,
							스쿠터를 대여해 보세요.</h1>
						<h4 style="line-height: 150%">
							우도 여행을 계획하고 계신가요?<br>그렇다면 스쿠터를 대여하고 우도의 정취를 느껴보세요.<br>
						</h4>
						<br>
					</div>
				</div>
			</div>
		</div>
		<div class="main main-raised">
			<div class="container">
				<div class="section text-center">
					<h2 class="title"
						style="font-family: 'Gothic A1', sans-serif; letter-spacing: 4px;">대여할
						스쿠터를 선택해주세요.</h2>
					<br>
					<div class="team">
						<div class="row">
							<div class="col-md-4">
								<div class="team-player">
									<div class="card card-plain">
										<div class="col-md-6 ml-auto mr-auto">
											<img src="../assets/img/moter1.jpg" alt="Thumbnail Image"
												class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											Lambretta Innocenti <br> <small
												class="card-description text-muted">30,000 won / 6
												hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> <input
												class="form-check-input" type="radio" name="bikes"
												id="rv_bike" value="1"> <span class="circle">
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
											<img src="../assets/img/moter2.jpg" alt="Thumbnail Image"
												class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											VESPA 50 Special <br> <small
												class="card-description text-muted">30,000 won / 6
												hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> <input
												class="form-check-input" type="radio" name="bikes"
												id="rv_bike" value="2"> <span class="circle">
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
											<img src="../assets/img/moter3.jpg" alt="Thumbnail Image"
												class="img-raised rounded-circle img-fluid">
										</div>
										<br>
										<h4 class="card-title">
											VESPA Piaggio <br> <small
												class="card-description text-muted">30,000 won / 6
												hours</small>
										</h4>
										<div class="form-check">
											<label class="form-check-label"> <input
												class="form-check-input" type="radio" name="bikes"
												id="rv_bike" value="3"> <span class="circle">
													<span class="check"></span>
											</span>
											</label>
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

			$('#form').submit(function() {
				var bikes = document.getElementsByName('bikes');
				var bike; // bike 값 선택.
				for (var i = 0; i < bikes.length; i++) {
					if (bikes[i].checked) {
						bike = bikes[i].value;
					}
				}

				if (typeof bike == "undefined") {
					alert('스쿠터를 선택해주세요.');
				} else {
					showRv(bike, idx);
				}

				return false;
			});
		});

		/*GET by rv_bike*/
		function showRv(bike, idx) {

			var html = '';
			html += '<table class="table">';

			$.ajax({
						url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/weekChk/'
								+ bike,
						type : 'GET',
						success : function(data) {

							var weekInfoList = data.weekInfoList;
							var chkRvAmList = data.chkRvAmList;
							var chkRvPmList = data.chkRvPmList;

							for (var i = 0; i < 3; i++) {

								if (i == 0) {
									html += '<tr>';
									for (var j = 0; j < weekInfoList.length; j++) {

										html += '<td>';
										html += weekInfoList[j].month + '.';
										html += weekInfoList[j].date + '.';
										html += changeDay(weekInfoList[j].day);
										html += '</td>';

									}
									html += '</tr>';

								} else if (i == 1) {
									html += '<tr>';

									for (var j = 0; j < weekInfoList.length; j++) {

										var rv_date = weekInfoList[j].year
												+ '-' + weekInfoList[j].month
												+ '-' + weekInfoList[j].date;
										var rv_time = 2;

										html += '<td>';

										if (chkRvAmList[j].chkRvAm == true) {
											html += '<button class="btn btn-light" onclick=\"insert(\''
													+ rv_date
													+ '\','
													+ bike
													+ ','
													+ rv_time
													+ ','
													+ idx
													+ ')\">예약하기</button>';
										} else {
											html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">예약완료</p>';
										}

										html += '</td>';
									}
									html += '</tr>';

								} else if (i == 2) {
									html += '<tr>';
									for (var j = 0; j < weekInfoList.length; j++) {

										var rv_date = weekInfoList[j].year
												+ '-' + weekInfoList[j].month
												+ '-' + weekInfoList[j].date;
										var rv_time = 3;

										html += '<td>';

										if (chkRvPmList[j].chkRvPm == true) {
											html += '<button class="btn btn-light" onclick=\"insert(\''
													+ rv_date
													+ '\','
													+ bike
													+ ','
													+ rv_time
													+ ','
													+ idx
													+ ')\">예약하기</button>';
										} else {
											html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">예약완료</p>';
										}

										html += '</td>';
									}
									html += '</tr>';
								}
							}
							html += '</table>';

							$('#timeTable').html(html);

						},

						error : function(e) {
							alert('error!')
						}

					});
		}

		/*POST*/
		function insert(rv_date, rv_bike, rv_time, idx) {

			var result = confirm('예약하시겠습니까?');

			if (result) {

				$
						.ajax({
							url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/reservation/'
									+ idx,
							type : 'POST',
							data : {
								rv_date : rv_date,
								rv_time : rv_time,
								rv_bike : rv_bike
							},
							success : function(data) {
								if (data == "success") {
									alert('예약되었습니다.');
									showRv(rv_bike, idx);
								}
							}
						});

			} else {
				alert('취소되었습니다!');
			}

		}

		/*요일 데이터를 문자로 변경*/
		function changeDay(day) {

			var sDay = null;

			switch (day) {
			case 1:
				sDay = "Sun";
				break;

			case 2:
				sDay = "Mon";
				break;

			case 3:
				sDay = "Tue";
				break;

			case 4:
				sDay = "Wed";
				break;

			case 5:
				sDay = "Thu";
				break;

			case 6:
				sDay = "Fri";
				break;

			case 7:
				sDay = "Sat";
				break;
			}
			return sDay;
		}
	</script>
</body>
</html>
