package com.wad.udo.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;

@Service("verifyService")
public class MemberVerifyService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	public String updateVerify(String uId, String code) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		int rCnt = dao.updateVerify(uId, code);
		
		return rCnt > 0 ? "Success" : "Fail";
		
	}
	
	/*
	 * public int reMailService() {
	 * 
	 * }
	 */

}
