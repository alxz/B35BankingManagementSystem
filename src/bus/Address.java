// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************

package bus;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9077524896901870907L;
	//attributes
	private String streetNumber;
	private String streetName;
	private String apptNumber;
	private String provinceCode;
	private String cityName;
	private String countryCode;
	private String postalIndex;
	
	//public services
	//constructors
	public Address() {
		this.streetNumber = "Unknown";
		this.streetName = "Unknown";
		this.apptNumber = "";
		this.provinceCode = "Unknown";		
		this.cityName = "Unknown";
		this.countryCode = "Unknown";
		this.postalIndex = "Unknown";
		
	}
	
	public Address(String apptN, String strNum, String strName, 
					String provCode, String cityN, String countryC, String postIdx) 
	{
		this.streetNumber = strNum;
		this.streetName = strName;
		this.apptNumber = apptN;
		this.provinceCode = provCode;		
		this.cityName = cityN;
		this.countryCode = countryC;
		this.postalIndex = postIdx;
		
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApptNumber() {
		return apptNumber;
	}

	public void setApptNumber(String apptNumber) {
		this.apptNumber = apptNumber;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalIndex() {
		return postalIndex;
	}

	public void setPostalIndex(String postalIndex) {
		this.postalIndex = postalIndex;
	}
	
	//now we use String type as reference type:
	public String toString() {
		if (this.apptNumber.isEmpty() || this.apptNumber == "") {
			return this.streetNumber + ", " + this.streetName + ", " + this.cityName + ", "
					+ this.provinceCode + ", " + this.postalIndex + ", " + this.countryCode;
		}
		else {
			return this.apptNumber + "-" + this.streetNumber + ", " + this.streetName + ", " + this.cityName
					 + ", " + this.provinceCode + ", " + this.postalIndex + ", " + this.countryCode;			
		}
	}
	
}
