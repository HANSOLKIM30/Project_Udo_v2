package com.wad.udo.reservation.domain;

public class ReservationInfo {

	private int idx;
	private int uId;	// member객체의 uId
	private String date;
	private int time;
	private int scooter;	// 스쿠터 번호 1,2,3

	public ReservationInfo() {
	}

	public ReservationInfo(int idx, int uId, String date, int time, int scooter) {
		this.idx = idx;
		this.uId = uId;
		this.date = date;
		this.time = time;
		this.scooter = scooter;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getScooter() {
		return scooter;
	}

	public void setScooter(int scooter) {
		this.scooter = scooter;
	}

	@Override
	public String toString() {
		return "ReservationInfo [idx=" + idx + ", uId=" + uId + ", date=" + date + ", time=" + time + ", scooter="
				+ scooter + "]";
	}
}
