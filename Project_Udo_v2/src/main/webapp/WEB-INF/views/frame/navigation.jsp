<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg bg-white fixed-top navbar-expand-lg" id="sectionsNav">
	<div class="container">
		<div class="navbar-translate">
			<a class="navbar-brand" href="/udo"> 
				<i class='fas fa-water fa-2x'>
					<p style="text-align: center">UDO</p>
				</i>
			</a>
			</div>

		<div class="collapse navbar-collapse">
			<ul class="nav nav-pills nav-pills-primary ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/member/myPage' />"> 
						<i class="material-icons">face</i> My Page
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/reservation/makeReservation' />"> 
						<i class="material-icons">schedule</i> Reservation
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/reservation/myReservation' />"> 
						<i class="material-icons">check</i> My Reservation
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>