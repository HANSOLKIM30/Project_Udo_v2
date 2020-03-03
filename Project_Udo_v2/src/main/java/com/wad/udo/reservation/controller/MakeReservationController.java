package com.wad.udo.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ReservationRegisterInfo;
import com.wad.udo.reservation.service.ReservationMakeService;

@Controller
@RequestMapping("reservation/makeReservation")
public class MakeReservationController {

	@Autowired
	private ReservationMakeService service;

	// 예약 페이지 호출
	@RequestMapping(method = RequestMethod.GET)
	public String getMakeReservationForm() {
		return "reservation/makeReservation";
	}
	

	// 스쿠터 예약하기
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> makeReservation(ReservationRegisterInfo regInfo, HttpSession session) {
		
		System.out.println(regInfo);
		
		int result = service.makeReservation(regInfo, session);

		return new ResponseEntity<String>(result > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
