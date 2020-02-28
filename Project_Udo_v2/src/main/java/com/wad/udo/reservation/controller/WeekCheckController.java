package com.wad.udo.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.reservation.domain.CheckAM;
import com.wad.udo.reservation.domain.CheckPM;
import com.wad.udo.reservation.domain.WeekCheckInfo;
import com.wad.udo.reservation.domain.WeekInfo;
import com.wad.udo.reservation.service.WeekCheckService;

@Controller
public class WeekCheckController {

	@Autowired
	private WeekCheckService service;
	
	@RequestMapping(value = "/rv/weekChk/{rv_bike}", method = RequestMethod.GET)
	public ResponseEntity<WeekCheckInfo> getWeek(@PathVariable("rv_bike") int rv_bike) {
		
		List<WeekInfo> weekInfoList = service.getWeekInfo();
		List<CheckAM> chkRvAmList = service.getChkRvAm(rv_bike);
		List<CheckPM> chkRvPmList = service.getChkRvPm(rv_bike);
		
		WeekCheckInfo weekChkInfo = new WeekCheckInfo();
		
		weekChkInfo.setWeekInfoList(weekInfoList);
		weekChkInfo.setChkRvAmList(chkRvAmList);
		weekChkInfo.setChkRvPmList(chkRvPmList);
		
		ResponseEntity<WeekCheckInfo> entity = new ResponseEntity<WeekCheckInfo>(weekChkInfo, HttpStatus.OK);
		
		return entity;
	}
}
