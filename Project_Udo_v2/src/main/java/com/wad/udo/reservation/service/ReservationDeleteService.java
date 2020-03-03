package com.wad.udo.reservation.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;

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
}
