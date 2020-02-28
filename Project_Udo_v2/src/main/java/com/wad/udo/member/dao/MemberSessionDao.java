package com.wad.udo.member.dao;

import com.wad.udo.member.domain.MemberInfo;

public interface MemberSessionDao {
	
	public MemberInfo selectMemberById(String uId);
	
	public int insertMember(MemberInfo memberInfo);
	
	public MemberInfo selectMemberByPhone(String uPhone);
	
	public int updateVerify(String uId, String code);
	
	public int updateTempPassword(String tempuPW, String uId);
	
	public int deleteMemberById(String uId);
	
	public int updateMember(MemberInfo memberInfo);

}
