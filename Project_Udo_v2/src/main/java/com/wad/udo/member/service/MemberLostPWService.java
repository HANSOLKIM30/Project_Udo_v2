package com.wad.udo.member.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.AES256Util;

@Service("lostService")
public class MemberLostPWService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	@Autowired
	private MailSenderService mailService;
	
	@Autowired
	private AES256Util aesUtil;
	
	// 이메일 유효성 검사 진행
	public int checkId(String uId) {
		
		int idCheck = 0;
		
		// 이메일 양식인지 유효성 검사
		// 이메일 유효성 검사를 위한 정규표현식
		String regex = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		// 정규표현식 컴파일
		Pattern pattern = Pattern.compile(regex);
		// 문자 매칭
		Matcher matcher = pattern.matcher(uId);
		// 정규표현식인지 체크
		boolean isregx = matcher.find();
		// 정규표현식에 적합한지 여부 확인 위해 콘솔에 출력
		System.out.println("이메일 형태인가::::::" + isregx);
		// 이메일 형태가 아닐 때		
		if(isregx == false) {
			idCheck = 1;	// 1: id가 이메일 형태가 아님 - 값 변경
		}
		
		return idCheck;
	}

	// 임시 패스워드 임시발급 및 임시 패스워드 이메일 송부
	public String tempPW(String uId) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		// 임시 패스워드 발급
		// 현재 시간(초)를 통한 난수 발생
		Random r = new Random(System.nanoTime());
		
		StringBuffer sb = new StringBuffer();
		
		// 영문+숫자 8자리 난수 발생
		for(int i = 0; i< 8; i++) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char)(r.nextInt(26)+97));
			}
		}
		
		// 확인
		System.out.println("Buffer 임시비밀번호:::::: " + sb);
		
		// String 변환
		String tempPW = sb.toString();
		
		// 확인
		System.out.println("임시비밀번호:::::: " + tempPW);
		
		//임시비밀번호 복호화
		String tempEncryptPW = aesUtil.encrypt(tempPW);
		
		// 데이터베이스 업데이트
		int result = dao.updateTempPassword(tempEncryptPW, uId);
		
		System.out.println("임시비밀번호 결과값::::::" + result);
		
		// 업데이트 시에만 임시비밀번호 메일 송부
		if(result > 0) {
			mailService.sendTempPW(tempPW, uId);
		}
	
		return result > 0? "success" : "fail";
	}

}
