package com.wad.udo.reservation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.reservation.dao.RvSessionDao;
import com.wad.udo.reservation.domain.ChkRvAm;
import com.wad.udo.reservation.domain.ChkRvPm;
import com.wad.udo.reservation.domain.RvInfo;
import com.wad.udo.reservation.domain.WeekInfo;

@Service("dateService")
public class RvWeekChkService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private RvSessionDao dao;
	
	//?��짜구?���?
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

	//?��짜구?���?
	public int calcDay(int day) {
		
		if (day > 7) {
			day = day-7;
		} 
		
		return day;
	}
	
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

	public int calcYear(int year, int month, int date) {
		if(month==12 && date==31) {
			year ++;
		}
		return year;
	}
	
	public List<WeekInfo> getWeekInfo() {
		
		List<WeekInfo> listWeekInfo = new ArrayList<WeekInfo>();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i = 0; i<7; i++) {
			WeekInfo weekInfo = new WeekInfo();
			
			weekInfo.setYear(calcYear(year, month, date));
			
			weekInfo.setMonth(calcMonth(year, month, date));
			
			weekInfo.setDate(calcDate(year, month, date));
			
			weekInfo.setDay(calcDay(day));			
			
			listWeekInfo.add(weekInfo);
			
			date++;
			day++;
		}
		
		return listWeekInfo;
	}
	
	
	//?��?�� ?��?��?���? 체크?���?
	public List<ChkRvAm> getChkRvAm(int rv_bike){
		System.out.println(":::::::::::::::::::::::?��?��!::::::::::::::::::::::::::::::");
		//dao ?��?��?���?
		dao = template.getMapper(RvSessionDao.class);
		
		//받아?�� 객체 ?��?��?���?
		List<ChkRvAm> chkRvAmList = new ArrayList<ChkRvAm>();

		//1. rv_date1, rv_date2 ?���? ?��?��
		List<WeekInfo> weekList = this.getWeekInfo();
		
		String rv_date1 = "";
		String rv_date2 = "";
		
		for(int i = 0; i < weekList.size(); i++) {
			if(i==0) {
				rv_date1 = weekList.get(0).toStringDate();
			} 
			else if(i==weekList.size()-1) {
				rv_date2 = weekList.get(weekList.size()-1).toStringDate();
			}
		}
		
		//2. ?��쿠터 번호?? ?��?�� ?��짜�?? ?��?�� 객체 받아?���? 

			List<RvInfo> rvInfoList = dao.selectListByBikeAm(rv_bike, rv_date1, rv_date2);
			
		//3. ?��?��?���??��?��?�� 객체?�� true / false 반환
			for(int i = 0; i < weekList.size(); i++) {
				ChkRvAm chkRvAm = new ChkRvAm();
				//?��?�� ?���? 받아?���?
				String weekDate = weekList.get(i).toStringDate();
				//받아?�� ?���? ?��?��
				weekDate = weekDate.replace(" ", "");
				weekDate = weekDate.replace("-", "");
				
				if(rvInfoList.isEmpty()) {
					chkRvAm.setChkRvAm(true);
					chkRvAmList.add(chkRvAm);
					
				} else {
					chkRvAm.setChkRvAm(true);
					
					for(int j = 0; j < rvInfoList.size(); j++) {
							
						String rv_date = rvInfoList.get(j).getRv_date();
						rv_date = rv_date.replace(" ", "");
						rv_date = rv_date.replace("-", "");					
							
						//?��?�� ?��짜�? ?��?��?��짜�? ?��치하�? true 반환
						if(weekDate.equals(rv_date)) {
							chkRvAm.setChkRvAm(false);
						} 		
					}
					System.out.println(":::::::::::::::::::::::::::???��?�� �?: "+ chkRvAm.getChkRvAm());
					chkRvAmList.add(chkRvAm); 					
				}
				
			}	
			return chkRvAmList;
	}
	
	
	//?��?�� ?��?��?���? 체크?���?
	public List<ChkRvPm> getChkRvPm(int rv_bike){
		System.out.println(":::::::::::::::::::::::?��?��!::::::::::::::::::::::::::::::");
		//dao ?��?��?���?
		dao = template.getMapper(RvSessionDao.class);
		
		//받아?�� 객체 ?��?��?���?
		List<ChkRvPm> chkRvPmList = new ArrayList<ChkRvPm>();
		
		//1. rv_date1, rv_date2 ?���? ?��?��?�� ?��?�� ?��주일 객체 받아?���?
		List<WeekInfo> weekList = this.getWeekInfo();
		
		String rv_date1 = "";
		String rv_date2 = "";
		
		for(int i = 0; i < weekList.size(); i++) {
			if(i==0) {
				rv_date1 = weekList.get(0).toStringDate();
			} 
			else if(i==weekList.size()-1) {
				rv_date2 = weekList.get(weekList.size()-1).toStringDate();
			}
		}
		
		//2. ?��쿠터 번호?? ?��?�� ?��짜�?? ?��?�� 객체 받아?���?

			//객체�? ?��?��??�? 착착�? ?��?��?��겠�??
			List<RvInfo> rvInfoList = dao.selectListByBikePm(rv_bike, rv_date1, rv_date2);
			
		//3. ?��?��?���??��?��?�� 객체?�� true / false 반환
			for(int i = 0; i < weekList.size(); i++) {
				
				ChkRvPm chkRvPm = new ChkRvPm();
				
				//?��?�� ?���? 받아?���?
				String weekDate = weekList.get(i).toStringDate();
				//받아?�� ?���? ?��?��
				weekDate = weekDate.replace(" ", "");
				weekDate = weekDate.replace("-", "");
				System.out.println(":::::::::::::::::::::::::::::::::?��?�� ?���?: " + weekDate);
				
				if(rvInfoList.isEmpty()) {
					chkRvPm.setChkRvPm(true);
					chkRvPmList.add(chkRvPm);
					
				} else {
					chkRvPm.setChkRvPm(true);
					
					for(int j = 0; j < rvInfoList.size(); j++) {
							
						String rv_date = rvInfoList.get(j).getRv_date();
						rv_date = rv_date.replace(" ", "");
						rv_date = rv_date.replace("-", "");					

						System.out.println(":::::::::::?��?�� ?���?: " + rv_date);
							
						//?��?�� ?��짜�? ?��?��?��짜�? ?��치하�? true 반환
						if(weekDate.equals(rv_date)) {
							chkRvPm.setChkRvPm(false);
						} 		
					}
					System.out.println(chkRvPm.getChkRvPm());
					chkRvPmList.add(chkRvPm);
					System.out.println(":::::::::::::::::::::::::::???��?�� �?: "+ chkRvPm.getChkRvPm());
				}
				
			}	
			return chkRvPmList;
		}

}
