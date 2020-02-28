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
	    <div class="page-header header-filter" data-parallax="true" style="background-image: url('../../assets/img/udo3.jpg')">
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
		$(document)
				.ready(
						function() {
							var idx = sessionStorage.getItem("idx");
							if (idx == null) {
								alert('ë¡ê·¸ì¸ ì ì¬ì©í  ì ìë ìë¹ì¤ ìëë¤!');
								location.href = 'loginForm.html';
							}
							showOnlyMyRv(idx);
						});

		//GET by idx
		function showOnlyMyRv(idx) {
			var html = '';
			html += '<table class="table" style="text-align: center; font-size: 18px;">';
			html += '<thead class="thead-dark">';
			html += '<tr>';
			html += '<th>ìì½ë²í¸</th>';
			html += '<th>ìì´ë</th>';
			html += '<th>ì¤ì¿ í°</th>';
			html += '<th>ìì½ì¼ì</th>';
			html += '<th>ì¤ì /ì¤í</th>';
			html += '<th>ìì /ì­ì </th>';
			html += '</tr>';
			html += '</thead>'

			$
					.ajax({
						url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/list/myRvList/'
								+ idx,
						type : 'GET',
						success : function(data) {

							if (data == '') {
								html += '<tr>';
								html += '<td colspan=\'6\' style="font-size: 20px; color: crimson;">ìì½ë ì¤ì¿ í°ê° ììµëë¤!!</td>';
								html += '</tr>';
							}

							var today = getToday();

							for (var i = 0; i < data.length; i++) {
								var rv_idx = data[i].rv_idx;
								var idx = data[i].idx;
								var rv_bike = data[i].rv_bike;
								var rv_date = data[i].rv_date;
								var rv_time = data[i].rv_time;

								if (rv_date < today) {

									var str_rv_time = "";
									switch (rv_time) {
									case 2:
										str_rv_time = 'ì¤ì ';
										break;
									case 3:
										str_rv_time = 'ì¤í';
										break;
									}
									html += '<tr>';
									html += '<td>' + rv_idx + '</td>';
									html += '<td>' + idx + '</td>';
									html += '<td>' + rv_bike
											+ 'ë² ì¤ì¿ í°</td>';
									html += '<td>' + rv_date + '</td>';
									html += '<td>' + str_rv_time + '</td>';
									html += '<td>ì§ë ìì½ìëë¤!</td>';
									html += '</tr>';
								} else {
									var str_rv_time = "";
									switch (rv_time) {
									case 2:
										str_rv_time = 'ì¤ì ';
										break;
									case 3:
										str_rv_time = 'ì¤í';
										break;
									}
									html += '<tr>';
									html += '<td>' + rv_idx + '</td>';
									html += '<td>' + idx + '</td>';
									html += '<td>' + rv_bike
											+ 'ë² ì¤ì¿ í°</td>';
									html += '<td>' + rv_date + '</td>';
									html += '<td>' + str_rv_time + '</td>';
									html += '<td>';
									html += '<button class="btn btn-primary btn-sm" onclick=\"showAllRv('
											+ idx
											+ ')\">ìì </button> &nbsp;';
									html += '<button class="btn btn-primary btn-sm" onclick=\"del('
											+ rv_idx + ')\">ì­ì </button>';
									html += '</td>';
									html += '</tr>';
								}
							}
							html += '</table>';
							$('#myReservation').html(html);
						},

						error : function(e) {
							alert("error!");
						}
					});
		}

		function update(rv_date, bike, rv_time, rv_idx, idx) {

			$
					.ajax({
						url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/reservation',
						type : 'PUT',
						data : JSON.stringify({
							rv_idx : rv_idx,
							idx : idx,
							rv_date : rv_date,
							rv_time : rv_time,
							rv_bike : bike
						}),
						contentType : 'application/json; charset=utf-8',
						success : function(data) {

							if (data == "success") {
								alert('ìì ëììµëë¤.');
								location.reload();
							}
						},
						error : function(e) {
							alert('error!');
						}
					});
		}

		/*DELETE*/
		function del(rv_idx) {

			var result = confirm('ì­ì íìê² ìµëê¹?');

			if (result) {
				$
						.ajax({
							url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/delete/'
									+ rv_idx,
							type : 'DELETE',
							success : function(data) {
								if (data == "success") {
									alert('ì­ì ëììµëë¤.');
								}
							},
							error : function(e) {
								alert('error!');
							}
						});
			} else {
				alert('ì·¨ìëììµëë¤!');
			}
			location.reload();
		}

		/*GET by rv_bike*/
		function showAllRv(idx) {
			$
					.ajax({
						url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/list/myRvList/'
								+ idx,
						type : 'GET',
						success : function(mydata) {

							for (var m = 0; m < mydata.length; m++) {
								var rv_idx = mydata[m].rv_idx;
								var idx = mydata[m].idx;
								var rv_date = mydata[m].rv_date;
								var rv_time = mydata[m].rv_time;
								var bike = mydata[m].rv_bike;
								timeTable(rv_idx, idx, rv_date, rv_time, bike);
							}
						}
					});
		}

		function timeTable(rv_idx, idx, rv_date, rv_time, bike) {
			$
					.ajax({
						url : 'http://ec2-13-209-6-70.ap-northeast-2.compute.amazonaws.com:8080/Project_Udo/rv/weekChk/'
								+ bike,
						type : 'GET',
						success : function(data) {

							var weekInfoList = data.weekInfoList;
							var chkRvAmList = data.chkRvAmList;
							var chkRvPmList = data.chkRvPmList;

							var html = '';

							for (var i = 0; i < 3; i++) {

								if (i == 0) {
									html += '<tr style="text-align: center;">';
									for (var j = 0; j < weekInfoList.length; j++) {
										html += '<td style="font-size: 16px;">';
										html += weekInfoList[j].month + '.';
										html += weekInfoList[j].date + '.';
										html += changeDay(weekInfoList[j].day);
										html += '</td>';
									}
									html += '</tr>';
								} else if (i == 1) {
									html += '<tr>';

									for (var j = 0; j < weekInfoList.length; j++) {

										var new_rv_date = weekInfoList[j].year
												+ '-' + weekInfoList[j].month
												+ '-' + weekInfoList[j].date;
										var new_rv_time = 2;

										html += '<td>';

										if (chkRvAmList[j].chkRvAm == true) {
											html += '<button class="btn btn-light" onclick=\"update(\''
													+ new_rv_date
													+ '\','
													+ bike
													+ ','
													+ new_rv_time
													+ ','
													+ rv_idx
													+ ','
													+ idx
													+ ')\">ìì½ìì </button>';
										} else {
											var myidx = sessionStorage
													.getItem("idx");
											if (idx == myidx) {
												html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">ëì ìì½</p>';
											} else {
												html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">ìì½ìë£</p>';
											}
										}
										html += '</td>';
									}
									html += '</tr>';
								} else if (i == 2) {
									html += '<tr>';
									for (var j = 0; j < weekInfoList.length; j++) {

										var new_rv_date = weekInfoList[j].year
												+ '-' + weekInfoList[j].month
												+ '-' + weekInfoList[j].date;
										var new_rv_time = 3;

										html += '<td>';

										if (chkRvPmList[j].chkRvPm == true) {
											html += '<button class="btn btn-light" onclick=\"update(\''
													+ new_rv_date
													+ '\','
													+ bike
													+ ','
													+ new_rv_time
													+ ','
													+ rv_idx
													+ ','
													+ idx
													+ ')\">ìì½ìì </button>';
										} else {
											var myidx = sessionStorage
													.getItem("idx");
											if (idx == myidx) {
												html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">ëì ìì½</p>';
											} else {
												html += '<p style="font-size: 13px; color: crimson; text-align: center; padding-top:10px;">ìì½ìë£</p>';
											}
										}
										html += '</td>';
									}
								}

								html += '</tr>';
								if (bike == 1) {
									$('#bikeTimeTable1').html(html);
									$('#bike1').css('display', 'block');
								}
								if (bike == 2) {
									$('#bikeTimeTable2').html(html);
									$('#bike2').css('display', 'block');
								}
								if (bike == 3) {
									$('#bikeTimeTable3').html(html);
									$('#bike3').css('display', 'block');
								}
							}
						},

						error : function(e) {
							alert('error!')
						}

					});
		}

		/*ìì¼ ë°ì´í°ë¥¼ ë¬¸ìë¡ ë³ê²½*/
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

		function getToday() {

			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!
			var yyyy = today.getFullYear();

			if (dd < 10) {
				dd = '0' + dd;
			}

			if (mm < 10) {
				mm = '0' + mm;
			}

			today = yyyy + '-' + mm + '-' + dd;

			return today;
		}
	</script>
</body>
</html>
