package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wad.udo.member.service.MemberVerifyService;

@Controller
public class VerifyController {

	@Autowired
	private MemberVerifyService service;
	
	// 이메일 내 인증 링크 눌렀을 때 페이지 반환
	@RequestMapping(value = "member/verify", method =RequestMethod.GET)
	public String verify(@RequestParam("uId") String uId, @RequestParam("code") String code) {
		
		String result = service.updateVerify(uId, code);
		
		System.out.println("update verify::::::" + result);
		
		return "/member/verify" + result;
	}
	
	// 이메일 미인증 회원 로그인 시 페이지 반환
	@RequestMapping(value = "member/unVerified")
	public String notVerified() {
		return "/member/unVerified"; 
	}
	
}
