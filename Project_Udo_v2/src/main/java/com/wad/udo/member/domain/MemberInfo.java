package com.wad.udo.member.domain;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberInfo {

	private int idx;
	private String uId;
	@JsonIgnore
	private String uPW;
	private String uName;
	private String uPhone;
	private String uPhoto;

	private char verify;

	@JsonIgnore
	private String code;
	
	// default 생성자
	public MemberInfo() {
		getRandonString();
	}

	public MemberInfo(String uId, String uPW, String uName, String uPhone, String uPhoto) {
		super();
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPhoto = uPhoto;
		getRandonString();	// code
	}

	public MemberInfo(int idx, String uId, String uPW, String uName, String uPhone, String uPhoto) {
		super();
		this.idx = idx;
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPhoto = uPhoto;
		getRandonString();	// code
	}

	// Getter/Setter 메서드 시작
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

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

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		
		return "MemberInfo [idx=" + idx + ", uId=" + uId + ", uPW=" + uPW + ", uName=" + uName  + ", uPhone=" + uPhone + ", uPhoto=" + uPhoto + "]";
	
	}

	// MemberInfo 객체 → LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {

		return new LoginInfo(idx, uId, uName, uPhone, uPhoto);

	}
	
	// 영문+숫자 난수 발생
	public void getRandonString() {
		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<20; i++) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char)(r.nextInt(26)+97));
			}
		}
		
		System.out.println("난수 코드 생성 : " + sb);

		setCode(sb.toString());
	}
}
