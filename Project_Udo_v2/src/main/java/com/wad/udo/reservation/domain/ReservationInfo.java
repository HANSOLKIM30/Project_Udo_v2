package com.wad.udo.reservation.domain;

public class ReservationInfo {

	private int idx;
	private int uIdx;	// member객체의 uId
	private String date;
	private int time;	// 오전: 2, 오후: 3
	private int scooter;	// 스쿠터 번호 1,2,3

	public ReservationInfo() {
	}

	public ReservationInfo(int idx, int uIdx, String date, int time, int scooter) {
		this.idx = idx;
		this.uIdx = uIdx;
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

	public int getuIdx() {
		return uIdx;
	}

	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
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
		return "ReservationInfo [idx=" + idx + ", uIdx=" + uIdx + ", date=" + date + ", time=" + time + ", scooter="
				+ scooter + "]";
	}
}
