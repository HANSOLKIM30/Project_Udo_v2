package com.wad.udo.reservation.domain;

import java.util.List;

public class WeekCheckInfo {
	
	private List<CheckAM> chkRvAmList;
	private List<CheckPM> chkRvPmList;
	private List<WeekInfo> weekInfoList;
	
	public List<CheckAM> getChkRvAmList() {
		return chkRvAmList;
	}
	public void setChkRvAmList(List<CheckAM> chkRvAmList) {
		this.chkRvAmList = chkRvAmList;
	}
	public List<CheckPM> getChkRvPmList() {
		return chkRvPmList;
	}
	public void setChkRvPmList(List<CheckPM> chkRvPmList) {
		this.chkRvPmList = chkRvPmList;
	}
	public List<WeekInfo> getWeekInfoList() {
		return weekInfoList;
	}
	public void setWeekInfoList(List<WeekInfo> weekInfoList) {
		this.weekInfoList = weekInfoList;
	}
	
	public WeekCheckInfo(List<CheckAM> chkRvAmList, List<CheckPM> chkRvPmList, List<WeekInfo> weekInfoList) {
		this.chkRvAmList = chkRvAmList;
		this.chkRvPmList = chkRvPmList;
		this.weekInfoList = weekInfoList;
	}
	
	public WeekCheckInfo() {

	}
	
	
}
