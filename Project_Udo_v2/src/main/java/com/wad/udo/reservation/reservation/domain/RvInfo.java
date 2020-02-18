package com.wad.udo.reservation.domain;

public class RvInfo {

	private int rv_idx;
	private int idx;
	private String rv_date;
	private int rv_time;
	private int rv_bike;
	
	public String getRv_date() {
		return rv_date;
	}
	public void setRv_date(String rv_date) {
		this.rv_date = rv_date;
	}
	
	public int getRv_idx() {
		return rv_idx;
	}
	public void setRv_idx(int rv_idx) {
		this.rv_idx = rv_idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	
	public RvInfo(int rv_idx, int idx, String rv_date, int rv_time, int rv_bike) {
		this.rv_idx = rv_idx;
		this.idx = idx;
		this.rv_date = rv_date;
		this.rv_time = rv_time;
		this.rv_bike = rv_bike;
	}

	//default ?��?��?��
	public RvInfo() {

	}
	
	@Override
	public String toString() {
		return "RvInfo [rv_idx=" + rv_idx + ", idx=" + idx + ", rv_date=" + rv_date + ", rv_time=" + rv_time
				+ ", rv_bike=" + rv_bike + "]";
	}
	
	
	
}
