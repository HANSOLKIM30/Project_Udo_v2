package com.wad.udo.member.service;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.AES256Util;
import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.MemberUpdateInfo;

@Service("memberUpdateService")
public class MemberUpdateService {

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	@Autowired
	private AES256Util aesUtil;
	
	// update 실행
	public int updateMember(MultipartHttpServletRequest request, String oldFile, MemberUpdateInfo updateInfo) throws NoSuchAlgorithmException, GeneralSecurityException {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberInfo = updateInfo.toMemberInfo();
		
		int result = 0;	// insert 결과 값 변수: insert 성공 시 1, 실패 시 0
		
		
		// 사진 저장 경로 설정
		String path = "/uploadFile";
		String dir = request.getSession().getServletContext().getRealPath(path);
		System.out.println("사진 저장 경로::::::" + dir);
		
		// 겹치지 않도록 새로운 파일명 지정
		String newFileName = "";
		try {
			
			// 새로운 프로필 사진이 올라왔다면,
			if(updateInfo.getNewFile() != null) {
				
				// 프로필 사진 교체
				newFileName = "new" + memberInfo.getuId() + System.nanoTime();
				
				updateInfo.getNewFile().transferTo(new File(dir, newFileName));
				
				System.out.println("새로운 파일 이름 : " + newFileName);
				
				//새로운 파일 저장
				memberInfo.setuPhoto(newFileName);
				// 이전 파일 삭제
				new File(dir, oldFile).delete();
				
			}else {	//새로운 사진이 올라와있지 않다면,
				
				memberInfo.setuPhoto(oldFile);	//기존 파일 경로 그대로 memberInfo에 저장
			}
			
			// uPW encrypt
			if(memberInfo.getuPW() != null) {
				memberInfo.setuPW(aesUtil.encrypt(updateInfo.getuPW()));
			}
			
			result = dao.updateMember(memberInfo);	// 데이터베이스 업데이트
			
			if(result > 0) {	// 업데이트 성공 시, session 값 변경
				
				// 기존 세션 무효화
				request.getSession(false).invalidate();
				// 세션이 없을 시 하나 만들고, 새로운 memberInfo를 통한 loginInfo 객체를 세션에 저장(myPage에서 session을 통해 변수들의 값을 뿌려주니까!)
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
			}
					
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
		
}