package com.wad.udo.member.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wad.udo.member.domain.MemberRegisterInfo;
import com.wad.udo.member.service.MemberRegisterService;

@Controller
public class RegisterController {

	@Autowired
	private MemberRegisterService regService;
	
	// register page 반환
	@RequestMapping(value = "member/register", method = RequestMethod.GET)
	public String regForm() {
		String view = "member/registerForm";
		return view;
	}
	
	// 회원가입 시 controller
	// MemberRegisterInfo 객체를 parameter로 담음으로서 커맨드 객체로 활용 가능
	// form에서 넘어오는 값들이 MemberRegisterInfo 커맨드 객체에 자동으로 저장(uId/uPW/uName/uPhoto);
	@RequestMapping(value = "member/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(MemberRegisterInfo regInfo, HttpServletRequest request) {
		
		System.out.println(regInfo);	// 잘 받아왔는지 toString으로 확인
		
		int resultCnt = 0;	//결과값에 대한 변수
		
		try {
			resultCnt = regService.registMember(request, regInfo);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("resultCnt::::::" + resultCnt);
		
		return new ResponseEntity<String>(resultCnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
	
	// id check controller
	@RequestMapping(value = "member/checkId", method = RequestMethod.GET)
	public ResponseEntity<String> idCheck(@RequestParam("uId") String uId){
		
		String code = "";
		
		char idCheck = regService.checkId(uId); // Y: id 있음 / N: id 없음 / E: 이메일 형식 아님
	
		System.out.println("idChk(Y: id 있음 / N: id 없음 / E: 이메일 형식 아님)::::::" + idCheck);
		
		switch(idCheck) {
		case 'Y': 
			code = "exist";
			break;
		case 'N':
			code = "notExist";
			break;
		case 'E':
			code = "notEmail";
			break;
		}
		
		return new ResponseEntity<String>(code, HttpStatus.OK);
	}
	
	// PW check controller
	@RequestMapping(value = "member/checkPW", method = RequestMethod.GET)
	public ResponseEntity<String> PWCheck(@RequestParam("uPW") String uPW){
		
		boolean pwCheck = regService.checkPW(uPW);
		
		// 정규표현식에 적합한지 여부 확인 위해 콘솔에 출력
		System.out.println("비밀번호가 유효성검증을 통과했는가::::::" + pwCheck);
				
		// true: 유효성 검사 통과 / fail: 유효성 검사 통과하지 못함
		return new ResponseEntity<String>(pwCheck==true?"success":"fail", HttpStatus.OK);
	}
	
	// phone check controller
	@RequestMapping(value = "member/checkPhone", method=RequestMethod.GET)
	public ResponseEntity<String> phoneCheck(@RequestParam("uPhone") String uPhone){
		
		String code = "";
		
		char phoneCheck = regService.checkPhone(uPhone); // Y: id 있음 / N: id 없음 / E: 이메일 형식 아님
		
		System.out.println("phoneChk(Y: 폰번호 있음 / N: 폰번호 없음 / P: 핸드폰번호 형식 아님)::::::" + phoneCheck);
		
		switch(phoneCheck) {
		case 'Y': 
			code = "exist";
			break;
		case 'N':
			code = "notExist";
			break;
		case 'P':
			code = "notPhone";
			break;
		}
		
		return new ResponseEntity<String>(code, HttpStatus.OK);
	}
	
}
