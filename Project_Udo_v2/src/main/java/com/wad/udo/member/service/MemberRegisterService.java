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

}
