package com.wad.udo.member.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.AES256Util;
import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.MemberRegisterInfo;

@Service("memberRegisterService")
public class MemberRegisterService {

	@Autowired
	private SqlSessionTemplate template;

	@Autowired
	private AES256Util aesUtil;
	
	@Autowired
	private MailSenderService mailService;
	
	private MemberSessionDao dao;

	// member register service
	public int registMember(MultipartHttpServletRequest request, MemberRegisterInfo regInfo) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
	
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberInfo = regInfo.toMemberInfo();	// MemberRegisterInfo type으로 받은 객체를  memberInfo type의 객체로 변경(uPhoto 제외: 하단에서 처리) 
		
		
		int result = 0;	// insert 결과 값 변수: insert 성공 시 1, 실패 시 0
		
		// uPhoto set process
		String path = "/uploadFile";
		String dir = request.getSession().getServletContext().getRealPath(path);
		System.out.println("사진 저장 경로::::::" + dir);
		
		String newFileName = "";
		
		try {
			
			if(regInfo.getuPhoto() != null) {
			
				// user가 올린 image file name이 중복되지 않도록 새로운 file name 지정 
				newFileName = memberInfo.getuId() + System.nanoTime() + "";
				
				// 파일을 서버의 지정 경로에 저장
				regInfo.getuPhoto().transferTo(new File(dir, newFileName));
				
				// 데이터베이스 저장을 하기 위한 파일이름 set
				memberInfo.setuPhoto(newFileName);			
			}
			
		}  catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// uPW set process
		if(regInfo.getuPW() != null) {
			memberInfo.setuPW(aesUtil.encrypt(regInfo.getuPW()));
		}
		
		// memberInfo의 uPhoto, uPW 변수까지 set하였으므로 dao에서 insert 실행
		result = dao.insertMember(memberInfo);
		
		// 인증 이메일 발송
		mailService.sendVerifyMail(request, memberInfo.getuId(), memberInfo.getCode());
		
		return result;
	}
	
	//id check service
	public char checkId(String uId) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		char idCheck = dao.selectMemberById(uId)!=null ? 'Y' :'N'; // id 유무 체크 - Y: id 있음 / N: id 없음
		
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
			idCheck = 'E';	// E: id가 이메일 형태가 아님 - 값 변경
		}
		
		return idCheck;
	}
	
	// 비밀번호 유효성 검사 service
	public boolean checkPW(String uPW) {
		
		boolean pwCheck;
		
		// 비밀번호 유효성 검사(1.비밀번호 8자리 이상 / 2.숫자 포함 / 3.특수문자 포함)
		// 비밀번호 유효성 검사를 위한 정규표현식
		String regex = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$";
		// 정규표현식 컴파일
		Pattern pattern = Pattern.compile(regex);
		// 문자 매칭
		Matcher matcher = pattern.matcher(uPW);
		
		pwCheck = matcher.find();

		return pwCheck;
	}
	
	//phone check service
	public char checkPhone(String uPhone) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		char phoneCheck = dao.selectMemberByPhone(uPhone)!=null ? 'Y' : 'N';	// phone 유무 체크 - Y: phone 있음 / N: phone 없음
		
		// 핸드폰번호 양식인지 유효성 검사
		// 핸드폰번호 유효성 검사를 위한 정규표현식
		String regex = "^01[016789]-\\d{3,4}-\\d{4}$";
		// 정규표현식 컴파일
		Pattern pattern = Pattern.compile(regex);
		// 문자 매칭
		Matcher matcher = pattern.matcher(uPhone);
		// 정규표현식인지 체크
		boolean isregx = matcher.find();
		// 정규표현식에 적합한지 여부 확인 위해 콘솔에 출력
		System.out.println("핸드폰번호 형태인가::::::" + isregx);
		
		if(isregx == false) {
			phoneCheck = 'P';	//핸드폰번호 양식이 아니라면 P를 반환하고 메서드 종료
		}	
		
		return phoneCheck;		
	}

}
