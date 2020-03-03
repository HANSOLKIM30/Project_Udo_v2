package com.wad.udo.reservation.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.domain.LoginInfo;
import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.domain.ReservationRegisterInfo;

@Service("makeReservationService")
public class ReservationMakeService {

	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;
	
	public int makeReservation(ReservationRegisterInfo regInfo, HttpSession session) {
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		ReservationInfo reservationInfo = regInfo.toReservationInfo();
		
		// 스쿠터를 예약한 회원의 idx는 세션에서 받아오기
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		int uIdx = loginInfo.getIdx();
		reservationInfo.setuIdx(uIdx);
		
		int result = dao.insertReservation(reservationInfo);

		System.out.println("makeReservation 결과::::::"+ result);
		
		return result;
	}

}
