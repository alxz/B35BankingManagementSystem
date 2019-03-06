// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************

package bus;

import java.io.Serializable;
import java.time.LocalDate;

public class Date implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -573614400749978537L;
	//attributes
	private int month;
	private int day;	
	private int year;
	
	//public services
	//constructors
	public Date() {
		//java.util.Date date=new java.util.Date(); - this is deprecated Date()
		LocalDate today = LocalDate.now();
		this.day = today.getDayOfMonth();
		this.month = today.getMonthValue();
		this.year = today.getYear();
	}
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int getMonth() {
		return this.month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	@SuppressWarnings("deprecation")
	public void setTodayDate() {
		java.util.Date date=new java.util.Date();
		this.day = date.getDate();
		this.month = date.getMonth();
		this.year = date.getYear();
		
		
	}
	//now we use String type as reference type:
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
}
