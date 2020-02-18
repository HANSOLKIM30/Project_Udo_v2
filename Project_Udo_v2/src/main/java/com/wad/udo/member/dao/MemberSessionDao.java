package com.wad.udo.member.dao;

import com.wad.udo.member.domain.MemberInfo;

public interface MemberSessionDao {
	
	public MemberInfo selectMemberById(String uId);
	
	public MemberInfo selectMemberByIdx(int idx);
	
	public int insertMember(MemberInfo memberInfo);

}