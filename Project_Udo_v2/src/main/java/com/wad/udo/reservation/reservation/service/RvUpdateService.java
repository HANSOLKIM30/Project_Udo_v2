package com.wad.udo.reservation.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.RvSessionDao;
import com.wad.udo.reservation.domain.RvInfo;

@Service("rvUpdateService")
public class RvUpdateService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private RvSessionDao dao;

	public int updateRv(RvInfo rvInfo) {
		
		dao = template.getMapper(RvSessionDao.class);
		
		int rCnt = dao.updateRv(rvInfo);
		
		System.out.println("?óÖ?ç∞?ù¥?ä∏ Í≤∞Í≥ºÍ∞íÏ? "+rCnt);
		
		return rCnt;
	}
}
