package com.wad.udo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegisterInfo {

	private String uId;
	private String uPW;
	private String uName;
	private MultipartFile uPhoto;
	
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
	
	public MultipartFile getuPhoto() {
		return uPhoto;
	}
	
	public void setuPhoto(MultipartFile uPhoto) {
		this.uPhoto = uPhoto;
	}
	
	@Override
	public String toString() {
		return "MemberRegisterInfo [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhoto=" + uPhoto + "]";
	}
	
	// 데이터베이스에 저장할 수 있도록 MemberInfo 형태로 변환
	public MemberInfo toMemberInfo() {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setuId(this.uId);
		memberInfo.setuPW(this.uPW);
		memberInfo.setuName(this.uName);
		return memberInfo;	
	}
}
