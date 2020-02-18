package com.wad.udo.reservation.domain;

public class RvRegInfo {

	private String rv_date;
	private int rv_time;
	private int rv_bike;
	
	public String getRv_date() {
		return rv_date;
	}
	public void setRv_date(String rv_date) {
		this.rv_date = rv_date;
	}
	public int getRv_time() {
		return rv_time;
	}
	public void setRv_time(int rv_time) {
		this.rv_time = rv_time;
	}
	public int getRv_bike() {
		return rv_bike;
	}
	public void setRv_bike(int rv_bike) {
		this.rv_bike = rv_bike;
	}
	
	
	public RvRegInfo(String rv_date, int rv_time, int rv_bike) {
		this.rv_date = rv_date;
		this.rv_time = rv_time;
		this.rv_bike = rv_bike;
	}
	
	
	public RvRegInfo() {

	}
	
	public RvInfo toRvInfo() {
		
		RvInfo rvInfo = new RvInfo();
		rvInfo.setRv_date(this.rv_date);
		rvInfo.setRv_time(this.rv_time);
		rvInfo.setRv_bike(this.rv_bike);
		
		return rvInfo;
	}
	
	@Override
	public String toString() {
		return "RvRegInfo [rv_date=" + rv_date + ", rv_time=" + rv_time + ", rv_bike=" + rv_bike + "]";
	}
	
	
}
