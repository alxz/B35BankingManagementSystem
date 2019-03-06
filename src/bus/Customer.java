// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************
package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	private static final long serialVersionUID = -444925413738985290L;
	private int id;
	private int pin; //PIN to access this account
	private String firstName;
	private String lastName;
	private String email;
	private Address customerAddress;
	private ArrayList<Account> acctList;  //private attribute as ArrayList of Account type

	public Customer() {
		super();
		this.id = 0;
		this.pin = 0;
		this.firstName = "UnknownName";
		this.lastName = "UnknownLastName";
		this.email = "none";
		this.customerAddress = new Address();
		this.setAcctList(new ArrayList<Account>());//empty list of accounts
	}
	
	public Customer(int id, int pin, String firstName, String lastName, String email, Address customerAddress) {
		super();
		this.id = id;
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.customerAddress = customerAddress;
		this.setAcctList(new ArrayList<Account>());
		//In case if I want to create a Checking account as default account:
		// Account acct1clientObj = new CheckingAcct();
		// this.acctList.add(acct1clientObj);
	}
	
	public Customer(int id, int pin, String firstName, String lastName, 
			String email, Address customerAddress, ArrayList<Account>  accList ) {
			super();
			this.id = id;
			this.pin = pin;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.customerAddress = customerAddress;
			this.setAcctList(accList);
			//this.setAcctList(new ArrayList<Account>());
			}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public ArrayList<Account> getAcctList() {
		return acctList;
	}

	public void setAcctList(ArrayList<Account> acctList) {
		this.acctList = acctList;
	}

	public void remove(Account current) 
	{
		acctList.remove(current);
	}
	
	public void add(Account current) 
	{
		acctList.add(current);
	}
	
	public Account search(int acctNum) //searching for an Account by AccNumber
	{
		for (Account anAcct : acctList)
		{
			if (anAcct.getAccNum() == acctNum) return anAcct;			
		}
		return null;
	}
	
	public String toString()
	{
		String state;
		state = "\n\t===========================================================================\n";
		state = state + "\tID: # " + this.id + "; " +
				"\tPIN: [ " + this.pin + " ]" +
				"\n\tName: \t\t" + this.firstName + ", " + this.lastName +
				",\n\tAddress: \t" + this.customerAddress +
				",\n\tEmail: \t(" + this.email + ")";
		state = state + "\n\t===========================================================================\n";
		state = state + "\n\t\tThis customer has the following bank accounts: ";
		for (Account anAcct : acctList)
		{
			state = state + "\n" + anAcct.toString();		
		}
		state = state + "\n";
		return state;
	}

	public String showOnlyAccounts() {
		// only Accounts information no transactions
		String state;
		state = "\t ID: # " + this.id + "; " +
				"\tPIN: [ " + this.pin + " ]" +
				"\n\t Name: " + this.firstName +
				", " + this.lastName +
				",\n\t Address: \t" + this.customerAddress +
				",\n\t Email: \t(" + this.email + ")";
		state = state + "\n\n\tThis customer has the following accounts: ";
		for (Account anAcct : acctList)
		{
			state = state + "\n\t" + anAcct.showOnlyAccounts();		
		}
		return state;
	}
	
	public String showCustomerAccountsList() {
		// only Accounts information
		String state = ""; 
		for (Account anAcct : acctList)
		{
			state = state + "\n\t" + anAcct.getAccNum()
			 				+ " : " + anAcct.getAccType().toString() 
							+ " with balance = " + anAcct.getBalance();	
		}
		return state;
	}
	
	public String showOnlyUserInfo() {
		// only Accounts information no transactions
		String state;
		state = "\t ID# " + this.id + "; " +
				"\tPIN: [ " + this.pin + " ]" +
				"\t Name: " + this.firstName +
				", " + this.lastName + " \n\tAcc:" ;
//				",\n\t Address: \t" + this.customerAddress +
//				",\n\t Email: \t(" + this.email + ")";
		for (Account anAcct : acctList)
		{
			state = state + "\n\t" + anAcct.showOnlyAccInfo();		
		}
		return state;
	}
	
	public boolean OpenNewAccount(String accType, int custId) {
		//Unknown, Checking, Saving, Credit, Currency;
		ArrayList<Account> myAccList = getAcctList();
		int accNum = 100001;
		for (Account anAcct : myAccList) {
			if (anAcct.getAccType().toString() == accType) {
				//if that account same type as requested
				System.out.println("\n\tAn accout type of " + anAcct.getAccType().toString()
						+ " is already exist! Operation cancelled!");
				return false;
			}
			if (accNum <= anAcct.getAccNum())
				accNum ++;
				
		}
		Account myAcct;
		switch (accType) {
		case "Checking":
			myAcct = new Account (this.id, accNum, EnumAccType.Checking,
					new Date(), 0.00, new ArrayList<Transaction> ());
			this.acctList.add(myAcct);
			break;
		case "Saving":
			myAcct = new Account (this.id, accNum, EnumAccType.Saving,
					new Date(), 0.00, new ArrayList<Transaction> ());
			this.acctList.add(myAcct);
			break;
		case "Credit":
			myAcct = new Account (this.id, accNum, EnumAccType.Credit,
					new Date(), 0.00, new ArrayList<Transaction> ());
			this.acctList.add(myAcct);
			break;
		case "Currency":
			myAcct = new Account (this.id, accNum, EnumAccType.Currency,
					new Date(), 0.00, new ArrayList<Transaction> ());
			this.acctList.add(myAcct);
			break;
		default:
				break;
		}
		System.out.println("\n\tAdded account: #" + accNum + " type: " + accType);
		System.out.println("\n\tCurrent Customer " +
				this.getFirstName() + ", " +
				this.getLastName() + " =" +
				" accounts list changed to: \n");
		for (Account anAcct : myAccList) {
			System.out.println("\tAccount #" + anAcct.getAccNum() 
							+ " type: " + anAcct.getAccType().toString());		
		}
		return true;
	}
	
	public boolean CloseAccount(int accNum) {
//		ArrayList<Account> myAccList = getAcctList();
		try {
			Account removeAcct = search(accNum);			
			if (removeAcct.getAccType() == EnumAccType.Checking) {
				System.out.println("\n\tCan not remove CHECKING account!");
				return false;
			}
			if (removeAcct != null) {
				System.out.println("\n\tFound account: " + removeAcct.getAccNum()
				+ " type: " + removeAcct.getAccType() + "\n\t Removing this Account");
				acctList.remove(search(accNum));
				System.out.println("\n\tCurrent Customer " +
						this.getFirstName() + ", " +
						this.getLastName() + " =" +
						" accounts list changed to: \n");
				for (Account anAcct : getAcctList()) {
					System.out.println("\tAccount #" + anAcct.getAccNum() 
									+ " type: " + anAcct.getAccType().toString());		
				}
				return true;
			}
		}
		catch (Exception e)
		{
			System.out.println("\n\tError during removal process! \n\t" + e.toString());
		}
		
		return false; 
	
	}
	
	public void ShowAccountInfo (int acctNum) {
		//Unknown, Checking, Saving, Credit, Currency;
		ArrayList<Account> myAccList = getAcctList();
		for (Account anAcct : myAccList) {
			if (anAcct.getAccNum() == acctNum) {
				System.out.println("\tAccount #" + anAcct.getAccNum() 
							+ " type: " + anAcct.getAccType().toString()
							+ " balance: " + anAcct.getBalance() 
							+ "\n\tTransactions:\n");
				for (Transaction myTransact : anAcct.getTransactList()) {
					System.out.println("\t" + myTransact.toString());
				}
				System.out.println("\t--------------------------------------------\n");
			}
		}
	}
	
	/**
	 * 
	 * @param acctNum
	 * @param transactions - count of last transactions to show
	 */
	public void ShowLastTransactions (int acctNum, int transactions) {
		//Unknown, Checking, Saving, Credit, Currency;
		ArrayList<Account> myAccList = getAcctList();
		for (Account anAcct : myAccList) {
			if (anAcct.getAccNum() == acctNum) {
				System.out.println("\tAccount #" + anAcct.getAccNum() 
							+ " type: " + anAcct.getAccType().toString()
							+ " balance: " + anAcct.getBalance() 
							+ "\n\tTransactions:");
				
				int count = anAcct.getTransactList().size();
				
				// start from 0 if less transactions then asked
				int startFrom = count > transactions? (count - transactions) : 0; 
				
				for (int i = startFrom; i < anAcct.getTransactList().size(); i++ ) {
					Transaction myTransact = anAcct.getTransactList().get(i);
					//assign an element from the list using index (i)
					System.out.println("\n\t" + myTransact.toString());
				}
				
				System.out.println("\n\t--------------------------------------------\n");
			}
		}
	}
	
	public double getAccountBalance (int acctNum) {
		//Unknown, Checking, Saving, Credit, Currency;
		ArrayList<Account> myAccList = getAcctList();
		for (Account anAcct : myAccList) {
			if (anAcct.getAccNum() == acctNum) {
				return anAcct.getBalance();
			}
		}
		return 0;
	}
	
	public long nextTransactId (int acctNum) {
		//Unknown, Checking, Saving, Credit, Currency;
		ArrayList<Account> myAccList = getAcctList();
		long transactId = 100000;
		for (Account anAcct : myAccList) {
			if (anAcct.getAccNum() == acctNum) {
				for (Transaction myTransact : anAcct.getTransactList()) {
					transactId = myTransact.getTrNumber();
				}
				
			}
		}
		return transactId;
	}
	
}
