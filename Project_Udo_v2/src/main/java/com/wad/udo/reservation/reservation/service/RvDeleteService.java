package com.wad.udo.reservation.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.RvSessionDao;

@Service("delService")
public class RvDeleteService {

	@Autowired
	private SqlSessionTemplate template;
	
	private RvSessionDao dao;
	
	public int delService(int rv_idx) {
		
		dao = template.getMapper(RvSessionDao.class);
		
		int rCnt = dao.deleteRv(rv_idx);
		
		System.out.println("?‚­? œ ê²°ê³¼ê°’ì? "+rCnt);
		
		return rCnt;
	}
}
