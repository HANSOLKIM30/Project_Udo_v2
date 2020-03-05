package com.wad.udo.reservation.domain;

public class WeekDate {
	
	private String year;
	private String month;
	private String date;
	private String day;

	public String getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = Integer.toString(year);
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = "";
		// month가 1에서 9일 때, 앞에 0 붙여주기
		if(month > 0 && month < 10) {
			this.month += "0";
		}
			this.month += Integer.toString(month);
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = "";
		// date가 1에서 9일 때, 앞에 0 붙여주기(js의 Date 형식에 맞춰주기)
		if(date > 0 && date < 10) {
			this.date += "0";			
		}
		this.date += Integer.toString(date);
	}

	public String getDay() {
		return day;
	}

	public void setDay(int day) {	
		switch (day) {
			case 1:
				this.day = "Sun";
				break;

			case 2:
				this.day = "Mon";
				break;

			case 3:
				this.day = "Tue";
				break;

			case 4:
				this.day = "Wed";
				break;

			case 5:
				this.day = "Thu";
				break;

			case 6:
				this.day = "Fri";
				break;

			case 7:
				this.day = "Sat";
				break;
			}
	}

	public WeekDate(String year, String month, String date, String day) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.day = day;
	}
	
	public WeekDate() {

	}
	
	public String fullDate() {
		return this.year + this.month + this.date;
	}

	@Override
	public String toString() {
		return "WeekDate [year=" + year + ", month=" + month + ", date=" + date + ", day=" + day + "]";
	}
}