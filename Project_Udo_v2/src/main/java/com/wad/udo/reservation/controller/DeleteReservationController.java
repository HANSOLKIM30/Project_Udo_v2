package com.wad.udo.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.service.ReservationDeleteService;

@Controller
@RequestMapping("reservation/myReservation/cancle")
public class DeleteReservationController {

	@Autowired
	private ReservationDeleteService service;
	
	@RequestMapping(value = "{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> cancleReservation(@PathVariable("idx") int idx){
		
		int result = service.cancleReservation(idx);
		
		System.out.println("예약번호 확인:::::: " + idx);
		
		return new ResponseEntity<String>(result > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
