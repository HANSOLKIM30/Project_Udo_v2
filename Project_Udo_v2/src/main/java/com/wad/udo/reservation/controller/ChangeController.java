package com.wad.udo.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.service.ReservationChangeService;

@Controller
public class ChangeController {

	@Autowired
	private ReservationChangeService updateService;

	// 예약 변경 페이지 호출
	@RequestMapping(value = "reservation/changeReservation")
	public String getChangeReservationForm() {
		return "scooter/changeReservation";
	}

	@RequestMapping(value = "/rv/reservation", method = RequestMethod.POST)
	public ResponseEntity<String> reservation(@RequestBody ReservationInfo rvInfo) {

		System.out.println(rvInfo);

		int cnt = updateService.updateRv(rvInfo);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
