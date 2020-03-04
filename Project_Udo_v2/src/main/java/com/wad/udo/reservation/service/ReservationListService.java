package com.wad.udo.reservation.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.domain.LoginInfo;
import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;

@Service("reservationListService")
public class ReservationListService {

	@Autowired
	private SqlSessionTemplate template;

	private ReservationSessionDao dao;

	// 회원별 리스트 출력
	public List<ReservationInfo> showMyReservation(HttpSession session) {

		dao = template.getMapper(ReservationSessionDao.class);

		// 스쿠터를 예약한 회원의 uIdx는 세션에서 받아오기
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		int uIdx = loginInfo.getIdx();
		
		System.out.println("예약 회원 uIdx::::::" + uIdx);
		
		List<ReservationInfo> list = dao.selectListByUIdx(uIdx);

		return list;
	}
}
