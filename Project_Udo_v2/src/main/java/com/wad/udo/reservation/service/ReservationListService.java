package com.wad.udo.reservation.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.ReservationInfo;

@Service("rvListService")
public class ReservationListService {

	@Autowired
	private SqlSessionTemplate template;

	private ReservationSessionDao dao;

	// ?���? 리스?�� 출력
	public List<ReservationInfo> selectAllList() {

		dao = template.getMapper(ReservationSessionDao.class);

		List<ReservationInfo> list = dao.selectList();

		return list;
	}

	// ?��?��번호�? ?��?�� 리스?�� 출력
	public List<ReservationInfo> selectListByIdx(int idx) {

		dao = template.getMapper(ReservationSessionDao.class);

		List<ReservationInfo> list = dao.selectListByIdx(idx);

		return list;
	}

	public List<ReservationInfo> selectListByBikeAm(int rv_bike, String rv_date1, String rv_date2) {

		dao = template.getMapper(ReservationSessionDao.class);

		List<ReservationInfo> list = dao.selectListByBikeAm(rv_bike, rv_date1, rv_date2);

		return list;
	}

	public List<ReservationInfo> selectListByBikePm(int rv_bike, String rv_date1, String rv_date2) {

		dao = template.getMapper(ReservationSessionDao.class);

		List<ReservationInfo> list = dao.selectListByBikePm(rv_bike, rv_date1, rv_date2);

		return list;
	}
}
