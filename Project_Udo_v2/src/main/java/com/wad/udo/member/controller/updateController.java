package com.wad.udo.member.controller;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wad.udo.member.domain.MemberUpdateInfo;
import com.wad.udo.member.service.MemberUpdateService;

@Controller
@RequestMapping("member/myPage/update")
public class updateController {

	@Autowired
	private MemberUpdateService service;
	
	// 프로필 변경 폼 호출
	@RequestMapping(method = RequestMethod.GET)
	public String updateMyPage() {

		String view = "member/updateForm";

		return view;
	}

	// 프로필 변경
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> updateMember(@RequestParam("oldFile") String oldFile, MemberUpdateInfo updateInfo, MultipartHttpServletRequest request) throws NoSuchAlgorithmException, GeneralSecurityException {
		
		int result = service.updateMember(request, oldFile, updateInfo);
		
		System.out.println("updateInfo::::::" + updateInfo);
		System.out.println("result::::::" + result);
		
		return new ResponseEntity<String>(result > 0 ? "success" : "fail", HttpStatus.OK);
	}

}
