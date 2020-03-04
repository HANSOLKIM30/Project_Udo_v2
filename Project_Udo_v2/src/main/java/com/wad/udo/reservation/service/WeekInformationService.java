package com.wad.udo.reservation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.ReservationSessionDao;
import com.wad.udo.reservation.domain.CheckAM;
import com.wad.udo.reservation.domain.CheckPM;
import com.wad.udo.reservation.domain.ReservationInfo;
import com.wad.udo.reservation.domain.WeekDate;

@Service("weekInformationService")
public class WeekInformationService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private ReservationSessionDao dao;
	
	// 날짜계산: 오늘부터 일주일간의 날짜를 보여준다.
	// 주의: 일주일 중 한 달의 마지막 날짜가 걸려있을 때는 다음달로 넘어가는 것 구현
	
	// 요일 계산
	public int calcDay(int day) {
			
		if (day > 7) {
			day = day-7;
		} 	

		return day;
	}
		
	// 일 계산
	public int calcDate(int year, int month, int date) {
		
		switch(month) {
		
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			
			if (date > 31) {
				date = date-31;
			} 
			
			break;

		case 4: case 6: case 9: case 11:

			if (date > 30) {
				date = date-30;
			}
			
			break;

		case 2:
			if (year % 4 == 0 && year  % 100 != 0 || year  % 400 == 0) {
				if (date > 29) {
					date = date-29;
				}
			} else {
				if (date > 28) {
					date = date-28;
				}
			}
			break;
		}
		
		return date;
	}
	
	// 월 계산
	public int calcMonth(int year, int month, int date) {
		
		switch(month) {
		
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			
			if (date > 31) {
				if(month==12) {
					month = 1;
				}else {
					month ++;
				}
			} 
			
			break;

		case 4: case 6: case 9: case 11:

			if (date > 30) {
				month ++;
			}
			
			break;

		case 2:
			if (year % 4 == 0 && year  % 100 != 0 || year  % 400 == 0) {
				if (date > 29) {
					month ++;
				}
			} else {
				if (date > 28) {
					month ++;
				}
			}
			break;
		}
		
		return month;
	}

	// 년 계산
	public int calcYear(int year, int month, int date) {
		if(month==12 && date==31) {
			year ++;
		}
		return year;
	}

	// 위에서  정의한 메서드 대로  년, 월, 일, 요일을 일주일 단위로 계산해 listWeekDate객체에 담아 반환: listWeekDate 내  weekDate 객체 7개
	public List<WeekDate> getWeekInfo() {
		
		List<WeekDate> weekDateList = new ArrayList<WeekDate>();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		// 일주일 간의 년, 월, 일, 요일
		for(int i = 0; i < 7; i++) {
			
			WeekDate weekDate = new WeekDate();
			
			weekDate.setYear(calcYear(year, month, date));
			
			weekDate.setMonth(calcMonth(year, month, date));
			
			weekDate.setDate(calcDate(year, month, date));
			
			weekDate.setDay(calcDay(day));			
			
			weekDateList.add(weekDate);
			
			date++;
			day++;
		}
		
		return weekDateList;
	}
	
	
	// 특정 스쿠터의 고유 번호를 변수로 받아 해당 스쿠터에 일주일 간 오전예약이 있는지 체크
	// 각 날짜에 오전 예약이 있으면 checkAM의 boolean checkAM == false(예약 불가)
	// 일주일 간의 checkAM을 List로 저장하여 반환
	public List<CheckAM> getAMReservation(int scooter){
		
		System.out.println("::::::" + scooter + "번 스쿠터에 대한 오전 예약 여부 계산 시작::::::");
		
		dao = template.getMapper(ReservationSessionDao.class);
		
		// 특정 스쿠터에 대한 현재일자부터 일주일간의 오전 예약 정보를 담을 List
		List<CheckAM> checkReservationAMList = new ArrayList<CheckAM>();
		
		List<WeekDate> weekDateList = this.getWeekInfo();
		
		String startWeekDate = "";
		String endWeekDate = "";
		
		// 시작 날짜: weekDateList의 첫번째
		startWeekDate = weekDateList.get(0).fullDate();
		// 끝 날짜: weekDateList의 마지막
		endWeekDate = weekDateList.get(6).fullDate();
		
		// startWeekDate ~ endWeekDate 기간 동안 특정 스쿠터의 예약현황 select
		List<ReservationInfo> reservationInfoList = dao.selectAMReservation(scooter, startWeekDate, endWeekDate);
		
		// 오전예약이 있는지 체크하여 checkAM 객체에 담아  일주일 간의 정보를 list로 반환
		for(int i = 0; i < 7; i++) {
			
			// checkAM 객체 생성
			CheckAM checkAM = new CheckAM();
			
			String weekDate = weekDateList.get(i).fullDate();
			
			System.out.println("weekDate 확인:::::: " + weekDate);
			
			// 예약 정보가 없없을 경우 checkAM의 boolean checkAM == true(예약 가능)
			if(reservationInfoList.isEmpty()) {
				checkAM.setCheckAM(true);
				checkReservationAMList.add(checkAM);
					
			} else {	// 예약 정보가 있을 경우
				
				checkAM.setCheckAM(true);
				
				for(int j = 0; j < reservationInfoList.size(); j++) {
					
					String date = reservationInfoList.get(j).getDate();
					System.out.println("date 확인:::::: " + date);				

					if(weekDate.equals(date)) {
						checkAM.setCheckAM(false);	// 예약불가
					}
				}
				checkReservationAMList.add(checkAM);
			}
		}	
		return checkReservationAMList;
	}
	
	
	// 특정 스쿠터의 고유 번호를 변수로 받아 해당 스쿠터에 일주일 간 오후 예약이 있는지 체크
	public List<CheckPM> getPMReservation(int scooter){
		
		System.out.println("::::::" + scooter + "번 스쿠터에 대한 오후 예약 여부 계산 시작::::::");

		dao = template.getMapper(ReservationSessionDao.class);
		
		List<CheckPM> checkReservationPMList = new ArrayList<CheckPM>();
		
		List<WeekDate> weekDateList = this.getWeekInfo();
		
		String startWeekDate = "";
		String endWeekDate = "";
		
		// 시작 날짜: weekDateList의 첫번째
		startWeekDate = weekDateList.get(0).fullDate();
		// 끝 날짜: weekDateList의 마지막
		endWeekDate = weekDateList.get(6).fullDate();
		
		List<ReservationInfo> reservationInfoList = dao.selectPMReservation(scooter, startWeekDate, endWeekDate);
			
		for(int i = 0; i < 7; i++) {
				
			CheckPM checkPM = new CheckPM();
				
			String weekDate = weekDateList.get(i).fullDate();

			System.out.println("weekDate 확인:::::: " + weekDate);
				
			if(reservationInfoList.isEmpty()) {
				checkPM.setCheckPM(true);
				checkReservationPMList.add(checkPM);
			} else {
				checkPM.setCheckPM(true);
					
				for(int j = 0; j < reservationInfoList.size(); j++) {
							
					String date = reservationInfoList.get(j).getDate();
					System.out.println("date 확인::::::" + date);

					if(weekDate.equals(date)) {
						checkPM.setCheckPM(false);
					} 		
				}
				checkReservationPMList.add(checkPM);;
			}
		}	
		return checkReservationPMList;		
	}
}
