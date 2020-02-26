package com.wad.udo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "member/myPage/logout")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		// 세션 무효화 시킴으로서  로그아웃
		session.invalidate();
		
		// 로그인 페이지로 이동
		String view = "member/loginForm";
		
		return view;
		
	}
}
