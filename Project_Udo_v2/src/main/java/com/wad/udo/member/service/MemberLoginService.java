package com.wad.udo.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service("loginService")
public class MemberLoginService {

	/*
	 * 수정 내용  : 인증 상태를 3개 상태로 구분 
	 *  boolean -> int
	 *  0 - 로그인 실패
	 *  1 - 미인증 계정 로그인	
	 *  2 - 정상 로그인
	 */

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	public int login(String id, String pw, HttpServletRequest request) {

		dao = template.getMapper(MemberSessionDao.class);
		
		int loginChk = 0;

		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		if (memberInfo != null && memberInfo.pwChk(pw)) {
			// verify 값 체크
			if(memberInfo.getVerify()=='Y') {
				// 세션에 저장(setAttribute)
				// loginChk 상태값을 변경
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
				loginChk = 2;
			} else {
				request.getSession(true).setAttribute("reEmail", memberInfo.getuId());
				loginChk = 1;
			}
		}

		return loginChk;
	}
}
