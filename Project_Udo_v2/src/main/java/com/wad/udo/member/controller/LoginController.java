package com.wad.udo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wad.udo.member.service.MemberLoginService;

@Controller
@RequestMapping(value = "member/login")
public class LoginController {

	@Autowired
	private MemberLoginService service;
	
	 // login page 반환
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		
		String view = "member/loginForm";
		
		return view;
	}
	
	// 로그인 시 controller
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestParam("uId") String id,
						@RequestParam("uPW") String pw,
						HttpServletRequest request) {
		
		String code = "loginfailed";
		
		// login 후, 이메일 인증처리 여부 파악 
		int loginChk = 0;
		
		loginChk = service.login(id, pw, request);
		
		System.out.println("loginChk::::::" + loginChk);
		switch(loginChk) {
		case 1: 
			code = "unverified";
			break;
		case 2:
			code = "success";
			break;
		}
		
		return new ResponseEntity<String>(code, HttpStatus.OK);	
	}
}
