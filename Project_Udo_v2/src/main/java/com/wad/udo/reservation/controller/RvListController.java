package com.wad.udo.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.RvInfo;
import com.wad.udo.reservation.service.RvListService;

@Controller
public class RvListController {

	@Autowired
	private RvListService service;
	
	@RequestMapping(value = "/rv/list/allList", method = RequestMethod.GET)
	public ResponseEntity<List<RvInfo>> getAllList() {

		List<RvInfo> list = service.selectAllList();

		ResponseEntity<List<RvInfo>> entity = new ResponseEntity<List<RvInfo>>(list, HttpStatus.OK);

		return entity;
	}

	@RequestMapping(value = "/rv/list/myRvList/{idx}", method = RequestMethod.GET)
	public ResponseEntity<List<RvInfo>> getBikeIdx(@PathVariable("idx") int idx) {
		
		List<RvInfo> list = service.selectListByIdx(idx);

		ResponseEntity<List<RvInfo>> entity = new ResponseEntity<List<RvInfo>>(list, HttpStatus.OK);

		return entity;
	}
}
