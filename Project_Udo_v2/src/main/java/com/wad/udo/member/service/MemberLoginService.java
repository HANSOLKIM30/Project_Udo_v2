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
	 * ���� ���¸� 3�� ���·� ����: return ���� 
	 * boolean -> int 
	 * 0 - �α��� ���� 
	 * 1 - ������ ����
	 * 2 - ���� �α���
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
			// verify �� üũ
			if(memberInfo.getVerify()=='Y') {
				// ���ǿ� ����(setAttribute)
				// loginChk ���°��� ����	
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
