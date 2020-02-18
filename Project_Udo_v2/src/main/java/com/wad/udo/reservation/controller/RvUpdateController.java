package com.wad.udo.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.RvInfo;
import com.wad.udo.reservation.service.RvUpdateService;

@Controller
public class RvUpdateController {

	@Autowired
	private RvUpdateService updateService;

	@RequestMapping(value = "/rv/reservation", method = RequestMethod.POST)
	public ResponseEntity<String> reservation(@RequestBody RvInfo rvInfo){
		
		System.out.println(rvInfo);
		
		int cnt = updateService.updateRv(rvInfo);
		
		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
