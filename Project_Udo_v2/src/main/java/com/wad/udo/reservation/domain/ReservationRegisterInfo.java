package com.wad.udo.reservation.domain;

public class ReservationRegisterInfo {

	private String date;
	private int time;
	private int scooter;
	
	public ReservationRegisterInfo() {
	}
	
	public ReservationRegisterInfo(String date, int time, int scooter) {
		// idx: database에서 자동생성
		// uIdx: loginInfo session에서 받아옴
		// 클라이언트에서 받아올 항목들
		this.date = date;
		this.time = time;
		this.scooter = scooter;
	}
	
	// 데이터 베이스 저장 시 ReservationInfo 객체로 바꿔서 저장
	public ReservationInfo toReservationInfo() {
		
		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setDate(this.date);
		reservationInfo.setTime(this.time);
		reservationInfo.setScooter(this.scooter);
		
		return reservationInfo;
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
		return "ReservationRegisterInfo [date=" + date + ", time=" + time + ", scooter=" + scooter + "]";
	}
}
