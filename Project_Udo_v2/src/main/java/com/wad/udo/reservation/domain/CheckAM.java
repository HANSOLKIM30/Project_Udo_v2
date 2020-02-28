package com.wad.udo.reservation.domain;

public class CheckAM {

	private boolean checkAM;	// 오전 예약 확인

	public CheckAM() {
	}
		
	public CheckAM(boolean checkAM){
		this.checkAM = checkAM;
	}


	public boolean isCheckAM() {
		return checkAM;
	}


	public void setCheckAM(boolean checkAM) {
		this.checkAM = checkAM;
	}


	@Override
	public String toString() {
		return "CheckAM [checkAM=" + checkAM + "]";
	}
}
