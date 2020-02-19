package com.wad.udo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegisterInfo {

	private String uId;
	private String uPW;
	private String uName;
	private String uPhone;
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
	
	
	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public MultipartFile getuPhoto() {
		return uPhoto;
	}
	
	public void setuPhoto(MultipartFile uPhoto) {
		this.uPhoto = uPhoto;
	}
	
	@Override
	public String toString() {
		return "MemberRegisterInfo [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhone=" + uPhone + ", uPhoto=" + uPhoto + "]";
	}
	
	// Register로 받은 변수들을 데이터베이스에 저장하기 위해 MemberInfo 형태로 변환 
	public MemberInfo toMemberInfo() {
		
		MemberInfo memberInfo = new MemberInfo();
		
		// idx: 데이터베이스 내에서 Auto Increase
		memberInfo.setuId(this.uId);
		memberInfo.setuPW(this.uPW);
		memberInfo.setuName(this.uName);
		memberInfo.setuPhone(this.uPhone);
		// uPhoto: service에서 처리
		// verify: 데이터베이스 내에서 'N'처리 되도록 처리 → 메일 인증 시 'Y' 변경
		// code: default 생성자에서 자동 생성
		
		return memberInfo;	
	}
}
