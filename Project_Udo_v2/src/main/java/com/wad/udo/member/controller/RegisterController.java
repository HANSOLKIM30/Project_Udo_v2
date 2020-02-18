package com.wad.udo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wad.udo.member.domain.MemberRegisterInfo;

@Controller
@RequestMapping(value = "member/register")
public class RegisterController {

	// register page 반환
	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		String view = "member/registerForm";
		return view;
	}
	
	// 회원가입 시 controller
	// MemberRegisterInfo 객체를 parameter로 담음으로서 커맨드 객체로 활용 가능
	// form에서 넘어오는 값들이 MemberRegisterInfo 커맨드 객체에 자동으로 저장(uId/uPW/uName/uPhoto);
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> register(MemberRegisterInfo regInfo, HttpServletRequest request) {
		
		System.out.println(regInfo);	// 잘 받아왔는지 toString으로 확인
		
		int resultCnt = 0;	//결과값에 대한 변수
		
		System.out.println("resultCnt::::::" + resultCnt);
		
		return new ResponseEntity<String>(resultCnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
