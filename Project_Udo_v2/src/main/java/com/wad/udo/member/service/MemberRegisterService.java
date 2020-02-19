package com.wad.udo.member.service;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.MemberRegisterInfo;

@Service("registerService")
public class MemberRegisterService {

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	// member register service
	public int registMember(HttpServletRequest request, MemberRegisterInfo regInfo) {
	
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberInfo = regInfo.toMemberInfo();	// MemberRegisterInfo type으로 받은 객체를  memberInfo type의 객체로 변경하여 database에 저장(uPhoto 제외: 하단에서 처리) 
		
		
		int resultCnt = 0;	// insert 결과 값 변수: insert 성공 시 1, 실패 시 0
		
		// uPhoto set process
		String path = "/userImages";
		String dir = request.getSession().getServletContext().getRealPath(path);
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
			
			// memberInfo의 uPhoto 변수까지 set하였으므로 dao에서 insert 실행
			resultCnt = dao.insertMember(memberInfo);
			
		}  catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	//id check service
	public char checkId(String uId) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		char idCheck = dao.selectMemberById(uId)!=null ? 'Y' :'N'; // id 유무 체크 변수 - Y: id 있음 / N: id 없음
		
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
		
		System.out.println("!!!!!!!!!!!!!!!" + idCheck);
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

}
