package com.wad.udo.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.service.ReservationListService;

@Controller
public class ListController {

	@Autowired
	private ReservationListService service;
	
	@RequestMapping(value = "/rv/list/allList", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationInfo>> getAllList() {

		List<ReservationInfo> list = service.selectAllList();

		ResponseEntity<List<ReservationInfo>> entity = new ResponseEntity<List<ReservationInfo>>(list, HttpStatus.OK);

		return entity;
	}

	@RequestMapping(value = "/rv/list/myRvList/{idx}", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationInfo>> getBikeIdx(@PathVariable("idx") int idx) {
		
		List<ReservationInfo> list = service.selectListByIdx(idx);

		ResponseEntity<List<ReservationInfo>> entity = new ResponseEntity<List<ReservationInfo>>(list, HttpStatus.OK);

		return entity;
	}
}
