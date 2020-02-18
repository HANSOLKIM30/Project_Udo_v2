package com.wad.udo.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.RvRegInfo;
import com.wad.udo.reservation.service.RvInsertService;

@Controller
public class RvController {

	@Autowired
	private RvInsertService rvService;

	@RequestMapping(value = "reservation/makeReservation")
	public String getMakeReservationForm() {
		return "reservation/makeReservation";
	}
	
	@RequestMapping(value = "reservation/changeReservation")
	public String getChangeReservationForm() {
		return "reservation/changeReservation";
	}
	
	
	@RequestMapping(value = "/rv/reservation/{idx}", method = RequestMethod.POST)
	public ResponseEntity<String> reservation(RvRegInfo regInfo, HttpServletRequest request, @PathVariable("idx") int idx) {
		
		System.out.println(regInfo);
		
		int cnt = rvService.insertRv(regInfo, request, idx);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
