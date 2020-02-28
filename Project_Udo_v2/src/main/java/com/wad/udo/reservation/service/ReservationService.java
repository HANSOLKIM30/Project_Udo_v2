package com.wad.udo.reservation.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.domain.ReservationRegisterInfo;

@Service("reservationService")
public class ReservationService {

	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;
	
	public int insertRv(ReservationRegisterInfo regInfo, HttpServletRequest request, int idx) {
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		ReservationInfo rvInfo = regInfo.toRvInfo();
		
		rvInfo.setIdx(idx);
		
		int rCnt = dao.insertRv(rvInfo);

		System.out.println("?��?�� 결과값�? "+rCnt);
		
		return rCnt;
	}

}
