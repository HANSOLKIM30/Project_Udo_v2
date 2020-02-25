package com.wad.udo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class myPageController {

	@RequestMapping(value = "member/myPage", method = RequestMethod.GET)
	public String myPage(){
		
		String view = "member/myPage";
		
		return view; 
	}
}
