package com.wad.udo.member.domain;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberInfo {

	private int idx;
	private String uId;
	@JsonIgnore
	private String uPW;
	private String uName;
	private String uPhoto;

	private char verify;

	@JsonIgnore
	private String code;
	

	// default ������ �ʼ�
	public MemberInfo() {
		getRandonString();
	}

	public MemberInfo(String uId, String uPW, String uName, String uPhoto) {
		super();
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhoto = uPhoto;
		getRandonString();	// code
	}

	public MemberInfo(int idx, String uId, String uPW, String uName, String uPhoto) {
		super();
		this.idx = idx;
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhoto = uPhoto;
		getRandonString();	// code
	}

	// �������� Getter/Setter ����
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
	
	// ������ Ȯ���� ���� toString �������̵�
	@Override
	public String toString() {
		
		return "MemberInfo [idx=" + idx + ", uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhoto=" + uPhoto + "]";
	
	}

	// MemberInfo ��ü -> ���ǿ� ����� �����θ� ������ LoginInfo ��ü ��ȯ
	public LoginInfo toLoginInfo() {

		return new LoginInfo(uId, uName, uPhoto);

	}
	
	// ��й�ȣ üũ Ȯ��
	public boolean pwChk(String pw) {
		return uPW != null && uPW.trim().length()>0 && uPW.equals(pw);
	}
	
	// ����+���� ���� �߻�
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
		
		System.out.println("���� �ڵ� ���� : " + sb);

		setCode(sb.toString());
	}
}
