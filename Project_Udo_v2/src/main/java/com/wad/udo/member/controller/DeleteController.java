package com.wad.udo.member.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wad.udo.member.service.MemberDeleteService;

@Controller
@RequestMapping("member/myPage/delete")
public class DeleteController {

	@Autowired
	private MemberDeleteService memberDeleteService;
	
	// 회원탈퇴 폼(비밀번호 입력으로 재확인) 불러오기
	@RequestMapping(method = RequestMethod.GET)
	public String DeleteForm() {
		
		String view = "member/deleteForm";
		
		return view;
	}
	
	// 회원탈퇴
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> DeleteMember(HttpSession session, @RequestParam("uPW") String uPW) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		int result = memberDeleteService.signOut(session, uPW);
		
		System.out.println("회원탈퇴 시 예약한 스쿠터 삭제 결과값::::::" + result);
		System.out.println("회원탈퇴 결과값::::::" + result);
		
		return new ResponseEntity<String>(result > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
