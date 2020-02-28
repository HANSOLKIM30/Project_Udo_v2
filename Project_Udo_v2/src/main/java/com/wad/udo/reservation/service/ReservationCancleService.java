package com.wad.udo.reservation.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;

@Service("delService")
public class ReservationCancleService {

	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;
	
	public int delService(int rv_idx) {
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		int rCnt = dao.deleteRv(rv_idx);
		
		System.out.println("?��?�� 결과값�? "+rCnt);
		
		return rCnt;
	}
}
