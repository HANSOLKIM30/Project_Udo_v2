package com.wad.udo.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.service.RvDeleteService;

@Controller
public class RvDeleteController {

	@Autowired
	private RvDeleteService deleteService;
	
	@RequestMapping(value = "/rv/delete/{rv_idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> reservation(@PathVariable("rv_idx") int rv_idx){
		
		int cnt = deleteService.delService(rv_idx);
		
		System.out.println("?��?�� ?�� 번호?�� ::::::: " + rv_idx);
		System.out.println("?��?�� 값�? ::::::: " + cnt);
		
		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
