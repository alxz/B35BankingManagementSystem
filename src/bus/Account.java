// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// ***********************************

package bus;
import java.io.Serializable;
import java.util.ArrayList; //This is to create an ArrayList of Transactions

public class Account implements IAccountOperations , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1865854058600282805L;
	private int customerId;
	private int accNum;
	private EnumAccType accType;
	private Date openDate;
	private static double balanceAcct;
	private ArrayList<Transaction> transactList;  //private attribute as ArrayList of Transactions type
	
	public Account() {
		this.customerId = 0;
		this.accNum = 0;
		this.accType = EnumAccType.Unknown;
		this.openDate = new Date();
		this.setBalanceAcct(0);
		this.transactList = new ArrayList<Transaction>();		
	}
	
	public Account (int customerId, int accNum, EnumAccType accType,
					Date openDate, double balance, ArrayList<Transaction> transList) {
		this.customerId = customerId;
		this.accNum = accNum;
		this.accType = accType;
		this.openDate = openDate;
		this.setBalanceAcct(balance);
		this.transactList = new ArrayList<Transaction>(transList);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public EnumAccType getAccType() {
		return accType;
	}

	public void setAccType(EnumAccType accType) {
		this.accType = accType;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

//	public double getBalanceAcct() {
//		return balanceAcct;
//	}
//
//	public void setBalanceAcct(double balance) {
//		this.balanceAcct = balance;
//	}
	
	//transactList = new ArrayList<Transaction>()
	public ArrayList<Transaction> getTransactList()
	{    return transactList;	}
	
	public void setTransactList(ArrayList<Transaction> transactList) 
	{	this.transactList = transactList;	}
	
	public void remove(Transaction current) 
	{
		transactList.remove(current);
	}
	
	public void add(Transaction current) 
	{
		transactList.add(current);
	}
	
	public Transaction search(int transactId) //searching for a transaction
	{
		for (Transaction aTransact : transactList)
		{
			if (aTransact.getTrNumber() == transactId) return aTransact;			
		}
		return null;
	}
	
	public  void withdraw(double amount) {
	}
	
	public  void deposit(double amount) {
	}
	
	public String toString() {
		String state;
		state = "\n\t******* Account: " + this.getAccType() +  " ******************************************************\n";
		state = state + "\t*\tNumber: " + this.accNum; 		//Account Number
		state = state + "\tCust ID: " + this.customerId; 	//Customer associated		
		//state = state + "\tAcctType: " + this.accType;		//Type: Checking/Credit/Savings/Currency
		state = state + "\tOpenDate: " + this.openDate;		//Open date for an account
		state = state + "\tBalance: " + this.getBalance();		//Current balance
		state = state + "\n\t********************************************************************************";

		if (transactList.size() > 0)
		{
			state = state + "\n\t------------------------------------------- Transactions List --------------------------------------------";
			state = state + "\n\tTr.#\t Description\t \t Type\t \t\t Date\t\t\t Amount \t Balance";
			state = state + "\n\t----------------------------------------------------------------------------------------------------------";
			for (Transaction aTransList : transactList)
			{
				state = state + "\n" + aTransList.toString();			
			}
			state = state + "\n\t----------------------------------------------------------------------------------------------------------";
		}
		return state;
	}
	
	public String showOnlyAccounts() {
		String state;
		state = "\n\t******* Account: " + this.getAccType() +  " ******************************************************\n";
		state = state + "\t*\tNumber: " + this.accNum; 		//Account Number
		state = state + "\tCust ID: " + this.customerId; 	//Customer associated		
		//state = state + "\tAcctType: " + this.accType;		//Type: Checking/Credit/Savings/Currency
		state = state + "\tOpenDate: " + this.openDate;		//Open date for an account
		state = state + "\tBalance: " + this.getBalance();		//Current balance
		state = state + "\n\t********************************************************************************";
		return state;
	}
	
	public String showOnlyAccInfo() {
		String state;
		state = " " + this.getAccType();
//		state = state + "\t*\tNumber: " + this.accNum; 		//Account Number
//		state = state + "\tCust ID: " + this.customerId; 	//Customer associated		
//		//state = state + "\tAcctType: " + this.accType;		//Type: Checking/Credit/Savings/Currency
//		state = state + "\tOpenDate: " + this.openDate;		//Open date for an account
		state = state + " (" + this.getBalance() + "); ";		//Current balance
//		state = state + "\n\t********************************************************************************";

		return state;
	}
	

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balanceAcct;
	}

	public static double getBalanceAcct() {
		return balanceAcct;
	}

	public void setBalanceAcct(double balanceAcct) {
		Account.balanceAcct = balanceAcct;
	}

	@Override
	public boolean transfer(Account accFrom, Account accTo, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
