package com.wad.udo.reservation.dao;

import java.util.List;

import com.wad.udo.reservation.domain.ReservationInfo;

public interface ReservationSessionDao {

	// 예약하기
	public int insertReservation(ReservationInfo reservationInfo);
	// 예약 변경
	public int updateReservation(ReservationInfo reservationInfo);
	// 예약 취소
	public int deleteReservation(int idx);	
	// 오전 예약현황 보여주기(일주일 간: 리스트에 담아서 7개 객체 뿌려주기)
	public List<ReservationInfo> selectAMReservation(int scooter, String startWeekDate, String endWeekDate);
	// 오후 예약 현황 보여주기(일주일 간: 리스트에 담아서 7개 객체 뿌려주기)
	public List<ReservationInfo> selectPMReservation(int scooter, String startWeekDate, String endWeekDate);
	// 예약 현황 보여주기(회원)
	public List<ReservationInfo> selectListByUIdx(int uIdx);
	// 일주일 간의 예약정보 보여주기(회원)
	public List<ReservationInfo> selectWeekListByUIdx(String startWeekDate, String endWeekDate);
	// 전체 예약 내역 보여주기(관리자)
	public List<ReservationInfo> selectList();
	// 일주일 간의 예약정보 보여주기(관리자)
	public List<ReservationInfo> selectWeekList(String startWeekDate, String endWeekDate);
	
}
