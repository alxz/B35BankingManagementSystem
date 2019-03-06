// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// ***********************************
package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class CheckingAcct extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7792185399559627124L;
	private double balance;
	private int freeTransCount;
	private double extraFees;
	
	public CheckingAcct() {
		super();
		this.balance = super.getBalance();
		this.freeTransCount = 4;
		this.extraFees = 2.00;
	}
	
	public CheckingAcct(int customerId, int accNum, EnumAccType accType,
			Date openDate, double balance, ArrayList<Transaction> transList, int freeTrCount, double extraFees) 
	{
		super(customerId, accNum, accType, openDate, balance, transList);
		this.balance = balance;
		super.setBalanceAcct(this.balance);
		this.freeTransCount = freeTrCount;
		this.extraFees = extraFees;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
		super.setBalanceAcct(balance);
	}

	public int getFreeTransCount() {
		return freeTransCount;
	}

	public void setFreeTransCount(int freeTransCount) {
		this.freeTransCount = freeTransCount;
	}


	public double getExtraFees() {
		return extraFees;
	}

	public void setExtraFees(double extraFees) {
		this.extraFees = extraFees;
	}

	@Override
	public void withdraw(double amount) {
		// managing balance  - withdrawal
		this.balance = this.balance - amount;
		super.setBalanceAcct(this.balance);
		
		if (this.freeTransCount == 0) {
			// add transactions fee to balance change
			this.balance = this.balance - this.extraFees;
		}
		if (this.freeTransCount > 0) {
			this.freeTransCount = this.freeTransCount -1;
		}
		
	}

	@Override
	public void deposit(double amount) {
		// managing balance  + deposits
		this.balance = this.balance + amount;
		super.setBalanceAcct(this.balance);
		if (this.freeTransCount > 0) {
			this.freeTransCount = this.freeTransCount -1;
		}
	}
	
	public String toString() {
		String state;
		//state = "\n";
		state = super.toString() + "\n\t*\t"+ this.getAccType() + " Account";
		state = state + "\t Balance: " + this.balance; 
		state = state + ";\t Free Transactions: " + this.freeTransCount + "\tExtraFees: " + this.extraFees; //freeTransCount
		state = state + "\n\t********************************************************************************";
		return state;
	}
	
}
