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
	
	//? μ§κ΅¬?κΈ?
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

	//? μ§κ΅¬?κΈ?
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
	
	
	//?€?  ??½?¬λΆ? μ²΄ν¬?κΈ?
	public List<ChkRvAm> getChkRvAm(int rv_bike){
		System.out.println(":::::::::::::::::::::::?€? !::::::::::::::::::::::::::::::");
		//dao ?€? ?κΈ?
		dao = template.getMapper(RvSessionDao.class);
		
		//λ°μ?¬ κ°μ²΄ ?€? ?κΈ?
		List<ChkRvAm> chkRvAmList = new ArrayList<ChkRvAm>();

		//1. rv_date1, rv_date2 ? μ§? ?€? 
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
		
		//2. ?€μΏ ν° λ²νΈ?? ??¬ ? μ§λ?? ?΅? κ°μ²΄ λ°μ?€κΈ? 

			List<RvInfo> rvInfoList = dao.selectListByBikeAm(rv_bike, rv_date1, rv_date2);
			
		//3. ??½?¬λΆ???°?Ό κ°μ²΄? true / false λ°ν
			for(int i = 0; i < weekList.size(); i++) {
				ChkRvAm chkRvAm = new ChkRvAm();
				//?€? ? μ§? λ°μ?€κΈ?
				String weekDate = weekList.get(i).toStringDate();
				//λ°μ?¨ ? μ§? ??±
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
							
						//?΄?Ή ? μ§κ? ??½? μ§μ? ?ΌμΉνλ©? true λ°ν
						if(weekDate.equals(rv_date)) {
							chkRvAm.setChkRvAm(false);
						} 		
					}
					System.out.println(":::::::::::::::::::::::::::???₯? κ°?: "+ chkRvAm.getChkRvAm());
					chkRvAmList.add(chkRvAm); 					
				}
				
			}	
			return chkRvAmList;
	}
	
	
	//?€? ??½?¬λΆ? μ²΄ν¬?κΈ?
	public List<ChkRvPm> getChkRvPm(int rv_bike){
		System.out.println(":::::::::::::::::::::::?€?!::::::::::::::::::::::::::::::");
		//dao ?€? ?κΈ?
		dao = template.getMapper(RvSessionDao.class);
		
		//λ°μ?¬ κ°μ²΄ ?€? ?κΈ?
		List<ChkRvPm> chkRvPmList = new ArrayList<ChkRvPm>();
		
		//1. rv_date1, rv_date2 ? μ§? ?€? ? ??΄ ?Όμ£ΌμΌ κ°μ²΄ λ°μ?€κΈ?
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
		
		//2. ?€μΏ ν° λ²νΈ?? ??¬ ? μ§λ?? ?΅? κ°μ²΄ λ°μ?€κΈ?

			//κ°μ²΄κ°? ????λ‘? μ°©μ°©μ°? ?€?΄?€κ² μ??
			List<RvInfo> rvInfoList = dao.selectListByBikePm(rv_bike, rv_date1, rv_date2);
			
		//3. ??½?¬λΆ???°?Ό κ°μ²΄? true / false λ°ν
			for(int i = 0; i < weekList.size(); i++) {
				
				ChkRvPm chkRvPm = new ChkRvPm();
				
				//?€? ? μ§? λ°μ?€κΈ?
				String weekDate = weekList.get(i).toStringDate();
				//λ°μ?¨ ? μ§? ??±
				weekDate = weekDate.replace(" ", "");
				weekDate = weekDate.replace("-", "");
				System.out.println(":::::::::::::::::::::::::::::::::?€? ? μ§?: " + weekDate);
				
				if(rvInfoList.isEmpty()) {
					chkRvPm.setChkRvPm(true);
					chkRvPmList.add(chkRvPm);
					
				} else {
					chkRvPm.setChkRvPm(true);
					
					for(int j = 0; j < rvInfoList.size(); j++) {
							
						String rv_date = rvInfoList.get(j).getRv_date();
						rv_date = rv_date.replace(" ", "");
						rv_date = rv_date.replace("-", "");					

						System.out.println(":::::::::::??½ ? μ§?: " + rv_date);
							
						//?΄?Ή ? μ§κ? ??½? μ§μ? ?ΌμΉνλ©? true λ°ν
						if(weekDate.equals(rv_date)) {
							chkRvPm.setChkRvPm(false);
						} 		
					}
					System.out.println(chkRvPm.getChkRvPm());
					chkRvPmList.add(chkRvPm);
					System.out.println(":::::::::::::::::::::::::::???₯? κ°?: "+ chkRvPm.getChkRvPm());
				}
				
			}	
			return chkRvPmList;
		}

}
