package com.wad.udo.member.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wad.udo.member.service.MemberLostPWService;

@Controller
public class LostPWController {

	@Autowired
	MemberLostPWService service;
	
	@RequestMapping(value = "member/lostForm", method = RequestMethod.GET)
	public String lostForm(){
		
		String view = "member/lostForm";
		
		return view; 
	}
	
	// 임시 비밀번호 발급 컨트롤러
	@RequestMapping(value = "member/lostPW", method = RequestMethod.POST)
	public ResponseEntity<String> lostPW(@RequestParam("uId") String uId) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException{
		
		/*
		 * notEmail: 유효성검사 통과 못함 
		 * success: 임시 비밀번호로 update 성공 
		 * fail: 임시 비밀번호로 update 실패
		 */
		
		String code = "";
		if(service.checkId(uId) == 1) {
			code = "notEmail";
		}else {
			code = service.tempPW(uId);
		}
		
		return new ResponseEntity<String>(code, HttpStatus.OK);
	}
}
