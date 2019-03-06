package bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AddRemoveCustomer {

	private double minAmount;
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

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
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

	public AddRemoveCustomer(double minAmount, String firstName, String lastName, String emailAddr, String strNum,
			String strName, String aptNum, String postIdx, String provCode, String cityName, String countryCode) {
		this.minAmount = minAmount;
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

	public static Customer createNewCustomer(DataCollection clients) {

		// 1. Add new client
		// Client C1 --- Account List creation:
		String inputVal;
		double minDeposit = 0;
		String firstName = null;
		String lastName = null;
		String emailAddr = null;
		String strNum = null;
		String strName = null;
		String aptNum = null;
		String postIdx = null;
		String provCode = null;
		String cityName = null;
		String countryCode = null;
		Scanner scan = new Scanner(System.in);

		// ArrayList<Account> accListNewC = new ArrayList<Account>(); // Acct List for
		// Customer account C

		System.out.print("\n\tFirst Name: \t");
		firstName = scan.nextLine();
		System.out.print("\n\tLast Name: \t");
		lastName = scan.nextLine();
		System.out.print("\n\tEmail address (fname.lname@gmail.com): \t");
		emailAddr = scan.nextLine();
		if (emailAddr.length() == 0) {
			emailAddr = firstName + "." + lastName + "@gmail.com";
			System.out.println("\t\tEmail address set to: " + emailAddr);
		}

		System.out.print("\n\n\tPlease enter customer\'s address using: ");
		System.out.print("\n\tStreen Number: \t");
		strNum = scan.nextLine();
		System.out.print("\n\tStreet Name: \t");
		strName = scan.nextLine();
		System.out.print("\n\tApartment Number: \t");
		aptNum = scan.nextLine();
		System.out.print("\n\tProvince Code (QC): \t");
		provCode = scan.nextLine();
		if (provCode.length() == 0) {
			provCode = "QC";
			System.out.println("\t\tProvince code set to: " + provCode);
		}

		System.out.print("\n\tCity Name (Montreal): \t");
		cityName = scan.nextLine();
		if (cityName.length() == 0) {
			cityName = "Montreal";
			System.out.println("\t\tCity Name set to: " + cityName);
		}

		System.out.print("\n\tCountry Name (Canada): \t");
		countryCode = scan.nextLine();
		if (countryCode.length() == 0) {
			countryCode = "Canada";
			System.out.println("\t\tCountry Name set to: " + countryCode);
		}
		System.out.print("\n\tPostal Index (A1B2C3): \t");
		postIdx = scan.nextLine();
		if (postIdx.length() == 0) {
			postIdx = "A1B2C3";
			System.out.println("\t\tPostal Index set to: " + postIdx);
		}
		do {
			System.out.print("\n\tPlease place first deposit of (min allowed 100): \t");
			inputVal = scan.nextLine();
			if (isDoubleNumber(inputVal)) {
				minDeposit = Double.parseDouble(inputVal);
				if (minDeposit < 100) {
					System.out.println("\n\tPlease enter a positive number greater than 100.00 \t");
					minDeposit = 0;
				}
			} else {
				System.out.println("\n\tPlease enter a positive number greater than 100.00 \t");
				minDeposit = 0;
			}
		} while (minDeposit == 0);

		Customer clientObj = new Customer(getNextCustId(clients), getPseudoRnd(1000, 8999), firstName, lastName,
				emailAddr, new Address(strNum, strName, aptNum, provCode, cityName, countryCode, postIdx));

		ArrayList<Transaction> tranLstChecking = new ArrayList<Transaction>();

		Account acct1clientObj = new CheckingAcct(clientObj.getId(), 100001, EnumAccType.Checking, new Date(),
				minDeposit, tranLstChecking, 4, 2.00);
		System.out.println("\n\t============== Account is created! ============== \t");

		// First transactions
		String question;
		System.out.print("\n\tWould you like to deposit any amount to the account? (Y/N)\t");
		question = scan.nextLine();
		char ans = question.charAt(0);

		if ((question.charAt(0) == 'y') || (question.charAt(0) == 'Y')) {
			// ok to deposit
			double amountDeposit = 0;
			System.out.print("\n\tPlease enter the amount you want to deposit: ");
			inputVal = scan.nextLine();
			if (isDoubleNumber(inputVal)) {
				amountDeposit = Double.parseDouble(inputVal);
				if (amountDeposit > 0) {
					// if amount is positive - we deposit this amount
					Transaction tr0acc1clientObj = new Transaction(10000, "Open Deposit", EnumTranType.Deposit,
							new Date(), amountDeposit, acct1clientObj.getBalance());
					tranLstChecking.add(tr0acc1clientObj);
					acct1clientObj.deposit(tr0acc1clientObj.getTrAmount());
				} else {
					System.out.println("\n\tOperation cancelled! \n\t Not enougth amount!\n\t");
				}
			} else {
				// otherwise let user know of the issue
				System.out.println("\n\tOperation cancelled! "
						+ "\n\t We can only deposit using positive double or integer numbers!");
			}

		} else {
			System.out.println("\n\tYou choose not to create first transaction! ");
		}

		acct1clientObj.setTransactList(tranLstChecking); // re-write the list of transactions for Acct1

		ArrayList<Account> accListNewC = clientObj.getAcctList();
		accListNewC.add(acct1clientObj);

		for (Account anAccount : clientObj.getAcctList()) {
			// check an account if has checking account
			if (anAccount.getAccType() == EnumAccType.Checking) {
				System.out.print("\n\n\tWe found checking account: " + anAccount.getAccNum() + "\tbalance = "
						+ anAccount.getBalance() + "\n\t");
			}
		}
		return clientObj;
	}

	public static int getNextCustId(DataCollection clients) {
		int nextCustID = 1;

		for (Customer aCustomer : clients.getMyList()) {
			if (nextCustID == aCustomer.getId()) {
				++nextCustID;
			}
		}
		return nextCustID;

	}

	public static int getPseudoRnd(int min, int max) {
		Random randomNum = new Random();
		int randInt = min + randomNum.nextInt(max);
		return randInt;
	}
	
	public static Customer removeCustomerById(DataCollection clients) {
		
		Scanner scan = new Scanner(System.in);
		int id = -1;
		do {
			System.out.print("\n\n\tTo remove all customer records: ");
			System.out.print("\n\tPlease enter customer ID (enter 0 to exit): ");
			Object inputVal = scan.nextLine();
			try {
				// statements that may cause an exception
				id = Integer.parseInt((String) inputVal);
			} catch (Exception e) {
				// error handling code
				System.out.println("\n\n\t\tException occurred - string is not a valid number!");
				id = -1;
			}
			Customer foundCustomer = SearchCustomer.searchById(clients, id);
			if (id == 0) {
				break;
			}
			if (foundCustomer != null) {
				System.out.println("\n\t To be removed: \n\t" + foundCustomer.toString());
				//clients.remove(foundCustomer);
				return  foundCustomer;
			}
			else {
				System.out.println("\n\t *** Sorry, nothing found! *** \n");
				id = -1;
			}
			
		} while (id == -1);
		
		return null;
	}
	
	public static boolean isDoubleNumber(String inputVal) {
		try {
			// statements that may cause an exception
			Double number = Double.parseDouble(inputVal);
			return true;
		} catch (Exception e) {
			// error handling code
			return false;
		}
	}	
	public static boolean isIntNumber(String inputVal) {
		try {
			// statements that may cause an exception
			int number = Integer.parseInt(inputVal);
			return true;
		} catch (Exception e) {
			// error handling code
			return false;
		}
	}
	
	public static Customer updateCustomer(DataCollection clients, int custId) {
		String inputVal;
		double minDeposit = 0;
		String firstName = null;
		String lastName = null;
		String emailAddr = null;
		String strNum = null;
		String strName = null;
		String aptNum = null;
		String postIdx = null;
		String provCode = null;
		String cityName = null;
		String countryCode = null;
		Scanner scan = new Scanner(System.in);
		
				
		Customer myCustomer = SearchCustomer.searchById(clients, custId);

		System.out.print("\n\tFirst Name (" + myCustomer.getFirstName() + "): \t");
		firstName = scan.nextLine();
		if (firstName.length() == 0) 
			firstName = myCustomer.getFirstName();			
		myCustomer.setFirstName(firstName);
		System.out.println("\n\tFirst name set to:" + firstName);
		
		System.out.print("\n\tLast Name (" + myCustomer.getLastName() + "): \t");
		lastName = scan.nextLine();
		if (lastName.length() == 0) 
			lastName = myCustomer.getLastName();			
		myCustomer.setLastName(lastName);
		System.out.println("\n\tLast name set to:" + lastName);
		
		System.out.print("\n\tEmail address ( " + myCustomer.getEmail() + " ): \t");
		emailAddr = scan.nextLine();
		if (emailAddr.length() == 0) {
			emailAddr = myCustomer.getEmail();			
		}
		myCustomer.setEmail(emailAddr);
		System.out.println("\t\tEmail address set to: " + emailAddr);

		System.out.print("\n\n\tPlease modify customer\'s address [ " + myCustomer.getCustomerAddress() + " ] using: ");
		System.out.print("\n\tStreen Number: \t");		
		strNum = scan.nextLine();
		if (strNum.length() == 0) 
			strNum = myCustomer.getCustomerAddress().getStreetNumber();
		System.out.println("\n\tStreet number set to:" + strNum);
		
		System.out.print("\n\tStreet Name: \t");
		strName = scan.nextLine();
		if (strName.length() == 0) 
			strName = myCustomer.getCustomerAddress().getStreetName();			
		System.out.println("\n\tStreet number set to:" + strName);
		
		System.out.print("\n\tApartment Number: \t");
		aptNum = scan.nextLine();
		
		if (aptNum.length() == 0) 
			aptNum = myCustomer.getCustomerAddress().getApptNumber();			
		System.out.println("\n\tAppartment number set to:" + aptNum);
		
		System.out.print("\n\tProvince Code (QC): \t");
		provCode = scan.nextLine();
		if (provCode.length() == 0) {
			provCode = "QC";
			System.out.println("\t\tProvince code set to: " + provCode);
		}

		System.out.print("\n\tCity Name (Montreal): \t");
		cityName = scan.nextLine();
		if (cityName.length() == 0) 
			cityName = myCustomer.getCustomerAddress().getCityName();			
		System.out.println("\n\tAppartment number set to:" + cityName);

		System.out.print("\n\tCountry Name (Canada): \t");
		countryCode = scan.nextLine();
		if (countryCode.length() == 0) {
			countryCode = "Canada";
			System.out.println("\t\tCountry Name set to: " + countryCode);
		}
		
		System.out.print("\n\tPostal Index (A1B2C3): \t");
		postIdx = scan.nextLine();
		if (postIdx.length() == 0) 
			postIdx = myCustomer.getCustomerAddress().getPostalIndex();			
		System.out.println("\n\tAppartment number set to:" + postIdx);

		myCustomer.setCustomerAddress(new Address(strNum, strName, aptNum, provCode, cityName, countryCode, postIdx));
		
//		for (Customer element : clients.getMyList()) {
//			if (element.getId() == myCustomer.getId()) {
//				newList.add(myCustomer);
//			}
//			else {
//				newList.add(element);
//			}
//			System.out.println("\n" + element.showOnlyAccounts());
//			System.out.println("\n");
//		}
		System.out.println("\n\tCustomer updated: " + myCustomer.toString());
		return myCustomer;
	}
	
}
