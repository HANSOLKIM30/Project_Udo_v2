package com.wad.udo.member.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.AES256Util;
import com.wad.udo.member.domain.LoginInfo;
import com.wad.udo.member.domain.MemberInfo;

@Service("memberDeleteService")
public class MemberDeleteService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	@Autowired
	private AES256Util aesUtil;
	
	// 회원탈퇴
	public int signOut(HttpSession session, String uPW) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		int result = 0;

		// 세션에서 로그인 정보 받아오기
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		
		System.out.println(loginInfo);

		// 세션에서 받아온 loginInfo객체의 uId 변수를 통해 database에서 memberInfo 받아오기.
		MemberInfo memberInfo = dao.selectMemberById(loginInfo.getuId());

		// memberInfo의 uPW 변수와 입력한 uPW가 일치하는지 확인.
		if(memberInfo != null) {
			
			// memberInfo의 uPW를 복호화
			String decryptuPW = aesUtil.decrypt(memberInfo.getuPW());
			
			// 복호화값이 있고, 입력한 비밀번호와 복호화한 비밀번호가 일치한다면, 
			if(decryptuPW != null && decryptuPW.trim().length()>0 && decryptuPW.equals(uPW)) {
				
				// 데이터베이스에서 삭제 → 회원탈퇴
				result = dao.deleteMemberById(memberInfo.getuId());
				// 세션 무효화
				session.invalidate();
			}
		}
		
		// 결과값 출력
		System.out.println("삭제결과::::::" + result);
		
		return result;
	}

}
