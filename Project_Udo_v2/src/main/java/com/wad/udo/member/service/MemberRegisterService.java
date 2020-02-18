package com.wad.udo.member.service;

import java.io.File;
import java.io.IOException;

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

	// 회원가입 service
	public int registMember(HttpServletRequest request, MemberRegisterInfo regInfo) {
	
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberInfo = regInfo.toMemberInfo();	// MemberRegisterInfo 형태로 받아와서 데이터베이스에 저장할 수 있도록 memberInfo형태로 변형(uPhoto 제외) 
		
		
		int resultCnt = 0;	//결과값 변수: insert 성공 시 1, 실패 시 0
		
		// uPhoto 저장 process
		String path = "/userImages";
		String dir = request.getSession().getServletContext().getRealPath(path);
		String newFileName = "";
		
		try {
			if(regInfo.getuPhoto() != null) {
			
				// 겹치지 않도록 새로운 파일이름 생성
				newFileName = memberInfo.getuId() + System.nanoTime() + "";
				
				// 파일을 서버의 지정 경로에 저장
				regInfo.getuPhoto().transferTo(new File(dir, newFileName));
				
				// 데이터 베이스에 저장하기 위한 파일 이름 set
				memberInfo.setuPhoto(newFileName);			
			}
			
			// memberInfo객체에서 uPhoto까지 set하였으므로 dao의 insert 실행
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

}
