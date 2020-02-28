package com.wad.udo.reservation.domain;

public class CheckPM {

	private boolean checkPM;	// 오후 예약 확인

	public CheckPM() {
	}
	
	public CheckPM(boolean checkPM) {
		this.checkPM = checkPM;
	}

	public boolean isCheckPM() {
		return checkPM;
	}

	public void setCheckPM(boolean checkPM) {
		this.checkPM = checkPM;
	}

	@Override
	public String toString() {
		return "CheckPM [checkPM=" + checkPM + "]";
	}
}
