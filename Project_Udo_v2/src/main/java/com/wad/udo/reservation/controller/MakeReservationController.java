package com.wad.udo.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ReservationRegisterInfo;
import com.wad.udo.reservation.service.ReservationService;

@Controller
@RequestMapping("reservation/makeReservation")
public class MakeReservationController {

	@Autowired
	private ReservationService service;

	// 예약 페이지 호출
	@RequestMapping(method = RequestMethod.GET)
	public String getMakeReservationForm() {
		return "reservation/makeReservation";
	}
	

	// 스쿠터 예약하기
	@RequestMapping(value = "{idx}", method = RequestMethod.POST)
	public ResponseEntity<String> reservation(ReservationRegisterInfo regInfo, HttpServletRequest request, @PathVariable("idx") int idx) {
		
		System.out.println(regInfo);
		
		int cnt = service.insertRv(regInfo, request, idx);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
