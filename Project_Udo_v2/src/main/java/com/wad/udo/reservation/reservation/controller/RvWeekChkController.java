package com.wad.udo.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.ChkRvAm;
import com.wad.udo.reservation.domain.ChkRvPm;
import com.wad.udo.reservation.domain.WeekChkInfo;
import com.wad.udo.reservation.domain.WeekInfo;
import com.wad.udo.reservation.service.RvWeekChkService;

@Controller
public class RvWeekChkController {

	@Autowired
	private RvWeekChkService service;
	
	@RequestMapping(value = "/rv/weekChk/{rv_bike}", method = RequestMethod.GET)
	public ResponseEntity<WeekChkInfo> getWeek(@PathVariable("rv_bike") int rv_bike) {
		
		List<WeekInfo> weekInfoList = service.getWeekInfo();
		List<ChkRvAm> chkRvAmList = service.getChkRvAm(rv_bike);
		List<ChkRvPm> chkRvPmList = service.getChkRvPm(rv_bike);
		
		WeekChkInfo weekChkInfo = new WeekChkInfo();
		
		weekChkInfo.setWeekInfoList(weekInfoList);
		weekChkInfo.setChkRvAmList(chkRvAmList);
		weekChkInfo.setChkRvPmList(chkRvPmList);
		
		ResponseEntity<WeekChkInfo> entity = new ResponseEntity<WeekChkInfo>(weekChkInfo, HttpStatus.OK);
		
		return entity;
	}
}
