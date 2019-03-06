package bus;

import java.util.ArrayList;
import java.util.List;

public class SearchCustomer {
	private int custId;
	private String firstName;
	private String lastName;
	private String emailAddr;
	private String strNum;
	private String strName;
	private String aptNum;
	private String postIdx;
	private String provCode;
	private String cityName;
	private String countryCode;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getStrNum() {
		return strNum;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getAptNum() {
		return aptNum;
	}
	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}
	public String getPostIdx() {
		return postIdx;
	}
	public void setPostIdx(String postIdx) {
		this.postIdx = postIdx;
	}
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
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
	public SearchCustomer() {
		this.custId = 0;
		this.firstName = null;
		this.lastName = null;
		this.emailAddr = null;
		this.strNum = null;
		this.strName = null;
		this.aptNum = null;
		this.postIdx = null;
		this.provCode = null;
		this.cityName = null;
		this.countryCode = null;
	}

	public SearchCustomer(int custId, String firstName, String lastName, String emailAddr, String strNum,
			String strName, String aptNum, String postIdx, String provCode, String cityName, String countryCode) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddr = emailAddr;
		this.strNum = strNum;
		this.strName = strName;
		this.aptNum = aptNum;
		this.postIdx = postIdx;
		this.provCode = provCode;
		this.cityName = cityName;
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "SearchCustomer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddr=" + emailAddr + ", strNum=" + strNum + ", strName=" + strName + ", aptNum=" + aptNum
				+ ", postIdx=" + postIdx + ", provCode=" + provCode + ", cityName=" + cityName + ", countryCode="
				+ countryCode + "]";
	}
	
	public static Customer searchById(DataCollection clients, int id) {
		
		for (Customer aCustomer : clients.getMyList()) {
			if (aCustomer.getId() == id) {
				return aCustomer;
			}
		}
		return null;		
	}
	
	public static List<Customer> searchByFirstName(DataCollection clients, String name) {
		List<Customer> listFound = new ArrayList<Customer>();
		boolean isFound = false;		
		for (Customer aCustomer : clients.getMyList()) {
			String input = aCustomer.getFirstName();
			isFound = input.toLowerCase().contains(name.toLowerCase());
			
			if (isFound) {
				//System.out.println("\n\tFound: " + aCustomer.getFirstName() + ", " + aCustomer.getLastName());
				listFound.add(aCustomer);
			}
		}
		return listFound;		
	}
	
	public static List<Customer> searchByLastName(DataCollection clients, String name) {
		boolean isFound = false;	
		List<Customer> listFound = new ArrayList<Customer>();
		for (Customer aCustomer : clients.getMyList()) {
			String input = aCustomer.getLastName();
			isFound = input.toLowerCase().contains(name.toLowerCase());	
			
			if (isFound) {
				//System.out.println("\n\tFound: " + aCustomer.getFirstName() + ", " + aCustomer.getLastName());
				listFound.add(aCustomer);
			}
		}		
		return listFound;		
	}

}
