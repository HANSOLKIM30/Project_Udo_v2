package com.wad.udo.reservation.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;

@Service("rvUpdateService")
public class ReservationChangeService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;

	public int updateRv(ReservationInfo rvInfo) {
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		int rCnt = dao.updateRv(rvInfo);
		
		System.out.println("?��?��?��?�� 결과값�? "+rCnt);
		
		return rCnt;
	}
}
