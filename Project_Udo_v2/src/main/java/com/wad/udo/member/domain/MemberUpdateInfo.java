package com.wad.udo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberUpdateInfo {
	
	private String uId;
	private String uPW;
	private String uName;
	private String uPhone;
	private MultipartFile newFile;
	
	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getuPW() {
		return uPW;
	}


	public void setuPW(String uPW) {
		this.uPW = uPW;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuPhone() {
		return uPhone;
	}


	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}


	public MultipartFile getNewFile() {
		return newFile;
	}


	public void setNewFile(MultipartFile newFile) {
		this.newFile = newFile;
	}

	// database 등록을 위해 memberInfo로 변환
	public MemberInfo toMemberInfo() {
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setuId(this.uId);
		memberInfo.setuPW(this.uPW);
		memberInfo.setuName(this.uName);
		memberInfo.setuPhone(this.uPhone);
		//newFile → 서비스에서 처리
		
		return memberInfo;
	}


	@Override
	public String toString() {
		return "MemberUpdateInfo [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhone=" + uPhone
				+ ", newFile=" + newFile + "]";
	}
	
	

}
