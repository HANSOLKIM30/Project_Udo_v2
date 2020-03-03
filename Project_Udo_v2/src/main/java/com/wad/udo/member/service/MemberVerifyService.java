package com.wad.udo.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service("memberVerifyService")
public class MemberVerifyService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	@Autowired
	private MailSenderService mailService;
	
	// 이메일 인증 시 verify 'N' → 'Y'
	public String updateVerify(String uId, String code) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		int rCnt = dao.updateVerify(uId, code);
		
		return rCnt > 0 ? "Success" : "Fail";
		
	}
	
	public int reSendVerifyMail(HttpServletRequest request, String uId) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		// id를 통해 memberInfo의 id와 code 얻어와서 reSendVerifyMail에 적용
		MemberInfo memberInfo = dao.selectMemberById(uId);
		
		mailService.reSendVerifyMail(request, memberInfo.getuId(), memberInfo.getCode());
		
		//성공 시 1 반환하여 verifySuccess / verifyFail 실행될 수 있도록 처리
		return 1;
	}
}
