package com.wad.udo.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.service.ReservationListService;

@Controller
@RequestMapping("reservation/myReservation")
public class MyReservationContoller {

	@Autowired
	private ReservationListService service;
	
	// 나의 예약현황 페이지 호출
	@RequestMapping(method = RequestMethod.GET)
	public String getMyReservationForm() {
		return "reservation/myReservation";
	}
	
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationInfo>> showMyReservation(HttpSession session) {
		
		List<ReservationInfo> list = service.showMyReservation(session);

		ResponseEntity<List<ReservationInfo>> entity = new ResponseEntity<List<ReservationInfo>>(list, HttpStatus.OK);

		return entity;
	}
}
