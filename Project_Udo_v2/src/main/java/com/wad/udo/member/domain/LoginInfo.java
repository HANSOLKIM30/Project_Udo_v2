package com.wad.udo.member.domain;

public class LoginInfo {
	
	// MemberInfo의 변수 중 login 기능에 필요한 변수로만 구성된 객체 - session에 저장
	private int idx;
	private String uId;
	private String uName;
	private String uPhone;
	private String uPhoto;
	
	public LoginInfo(int idx, String uId, String uName, String uPhone, String uPhoto) {	
		
		this.idx = idx;
		this.uId = uId;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPhoto = uPhoto;
	}

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getuId() {
		return uId;
	}

	public String getuName() {
		return uName;
	}

	
	public String getuPhone() {
		return uPhone;
	}

	public String getuPhoto() {
		return uPhoto;
	}


	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", uId=" + uId + ", uName=" + uName + ", uPhone=" + uPhone + ", uPhoto="
				+ uPhoto + "]";
	}
}
