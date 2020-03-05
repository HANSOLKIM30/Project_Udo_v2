package com.wad.udo.reservation.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.domain.LoginInfo;
import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;

@Service("reservationDeleteService")
public class ReservationDeleteService {

	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;
	
	// 예약번호를 통한 삭제
	public int cancleReservation(int idx) {
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		int result = dao.deleteReservation(idx);
		
		System.out.println("cancleReservation 결과::::::" + result);
		
		return result;
	}
	
	// 회원탈퇴 시 모든 예약 삭제
	public int deleteAllReservation(HttpSession session) {
		
		dao = template.getMapper(ReservationSessionDao.class);

		int result = 0;
		
		// 탈퇴할 회원의 uidx는 세션에서 받아오기
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		int uIdx = loginInfo.getIdx();

		List<ReservationInfo> reservationList = dao.selectListByUIdx(uIdx);
		
		if(reservationList.size() > 0) {
			result = dao.deleteAllReservation(uIdx);
		} else {
			result = 2;
		}
		

		System.out.println("deleteAllReservation 결과::::::" + result);
		
		return result;
	}
}
