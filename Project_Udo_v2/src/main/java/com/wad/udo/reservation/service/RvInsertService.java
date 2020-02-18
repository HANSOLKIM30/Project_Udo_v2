package com.wad.udo.reservation.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.RvSessionDao;
import com.wad.udo.reservation.domain.RvInfo;
import com.wad.udo.reservation.domain.RvRegInfo;

@Service("reservationService")
public class RvInsertService {

	@Autowired
	private SqlSessionTemplate template;
	
	private RvSessionDao dao;
	
	public int insertRv(RvRegInfo regInfo, HttpServletRequest request, int idx) {
		
		dao = template.getMapper(RvSessionDao.class);
		
		RvInfo rvInfo = regInfo.toRvInfo();
		
		rvInfo.setIdx(idx);
		
		int rCnt = dao.insertRv(rvInfo);

		System.out.println("?��?�� 결과값�? "+rCnt);
		
		return rCnt;
	}

}
