package com.wad.udo.reservation.dao;

import java.util.List;

import com.wad.udo.reservation.domain.ReservationInfo;

public interface RvSessionDao {

	public int insertRv(ReservationInfo rvInfo);
	public int updateRv(ReservationInfo rvInfo);
	public int deleteRv(int rv_idx);
	public List<ReservationInfo> selectListByIdx(int idx);
	public List<ReservationInfo> selectListByBikeAm(int rv_bike, String rv_date1, String rv_date2);
	public List<ReservationInfo> selectListByBikePm(int rv_bike, String rv_date1, String rv_date2);
	public List<ReservationInfo> selectList();
	
}
