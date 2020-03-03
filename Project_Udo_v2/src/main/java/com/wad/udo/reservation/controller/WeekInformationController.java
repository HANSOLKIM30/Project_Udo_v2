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
import com.wad.udo.reservation.domain.WeekInformation;
import com.wad.udo.reservation.domain.WeekDate;
import com.wad.udo.reservation.service.WeekInformationService;

@Controller
@RequestMapping("reservation/weekInfomation")
public class WeekInformationController {

	@Autowired
	private WeekInformationService service;
	
	//url 경로로 변수 받아오기
	@RequestMapping(value = "{scooter}", method = RequestMethod.GET)
	public ResponseEntity<WeekInformation> getWeekInformation(@PathVariable("scooter") int scooter) {
		
		// 당일부터 일주일간의 날짜 정보를 클라이언트에 뿌려준다.
		List<WeekDate> weekInfoList = service.getWeekInfo();
		// 당일부터 일주일간 특정 스쿠터의 오전 예약 정보를 클라이언트에 뿌려준다.
		List<CheckAM> checkAMReservationList = service.getAMReservation(scooter);
		// 당일부터 일주일간 특정 스쿠터의 오후 예약 정보를 클라이언트에 뿌려준다.
		List<CheckPM> checkPMReservationList = service.getPMReservation(scooter);
		
		// 위의 세 리스트를 담아갈 객체 초기화
		WeekInformation weekInformation = new WeekInformation();
		
		// 객체 안에 리스트 암아주기
		weekInformation.setWeekInfoList(weekInfoList);
		weekInformation.setCheckAMReservationList(checkAMReservationList);
		weekInformation.setCheckPMReservationList(checkPMReservationList);
		
		//responseEntity에 담아서 클라이언트로 송부
		return new ResponseEntity<WeekInformation>(weekInformation, HttpStatus.OK);
	}
}
