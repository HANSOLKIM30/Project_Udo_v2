package com.wad.udo.reservation.domain;

import java.util.List;

public class WeekInformation {
	
	//클라이언트에 뿌려줄 정보
	private List<CheckAM> checkAMReservationList;	// 오늘부터 일주일 간의 checkAM객체(오전예약)를 저장하는 List
	private List<CheckPM> checkPMReservationList;	// 오늘부터 일주일 간의 checkPM객체(오후예약)를 저장하는 List
	private List<WeekDate> weekInfoList;	// 오늘부터 일주일 간의 날짜를 보여주는 객체
	
	public WeekInformation() {
	}
	
	public WeekInformation(List<CheckAM> checkAMReservationList, List<CheckPM> checkPMReservationList, List<WeekDate> weekInfoList) {
		this.checkAMReservationList = checkAMReservationList;
		this.checkPMReservationList = checkPMReservationList;
		this.weekInfoList = weekInfoList;
	}

	public List<CheckAM> getCheckAMReservationList() {
		return checkAMReservationList;
	}

	public void setCheckAMReservationList(List<CheckAM> checkAMReservationList) {
		this.checkAMReservationList = checkAMReservationList;
	}

	public List<CheckPM> getCheckPMReservationList() {
		return checkPMReservationList;
	}

	public void setCheckPMReservationList(List<CheckPM> checkPMReservationList) {
		this.checkPMReservationList = checkPMReservationList;
	}

	public List<WeekDate> getWeekInfoList() {
		return weekInfoList;
	}

	public void setWeekInfoList(List<WeekDate> weekInfoList) {
		this.weekInfoList = weekInfoList;
	}

	@Override
	public String toString() {
		return "WeekCheckInfo [checkAMReservationList=" + checkAMReservationList + ", checkPMReservationList="
				+ checkPMReservationList + ", weekInfoList=" + weekInfoList + "]";
	}	
}
