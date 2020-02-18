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

	// ȸ������ service
	public int registMember(HttpServletRequest request, MemberRegisterInfo regInfo) {
	
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberInfo = regInfo.toMemberInfo();	// MemberRegisterInfo ���·� �޾ƿͼ� �����ͺ��̽��� ������ �� �ֵ��� memberInfo���·� ����(uPhoto ����) 
		
		
		int resultCnt = 0;	//����� ����: insert ���� �� 1, ���� �� 0
		
		// uPhoto ���� process
		String path = "/userImages";
		String dir = request.getSession().getServletContext().getRealPath(path);
		String newFileName = "";
		
		try {
			if(regInfo.getuPhoto() != null) {
			
				// ��ġ�� �ʵ��� ���ο� �����̸� ����
				newFileName = memberInfo.getuId() + System.nanoTime() + "";
				
				// ������ ������ ���� ��ο� ����
				regInfo.getuPhoto().transferTo(new File(dir, newFileName));
				
				// ������ ���̽��� �����ϱ� ���� ���� �̸� set
				memberInfo.setuPhoto(newFileName);			
			}
			
			// memberInfo��ü���� uPhoto���� set�Ͽ����Ƿ� dao�� insert ����
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
