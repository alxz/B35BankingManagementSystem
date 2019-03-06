// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// ***********************************

package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class CurrencyAcct extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4056140031526657707L;
	private double balance;
	private double acctLimit;
	private float interestRate;
	
	public CurrencyAcct() {
		super();
		this.balance = 0;
		this.acctLimit = 0;
		this.interestRate = 0.0f;
	}
	
	public CurrencyAcct(int customerId, int accNum, EnumAccType accType,
			Date openDate, double balance, double acctLimit, ArrayList<Transaction> transList, float intRate) {
		super(customerId, accNum, accType, openDate, balance, transList);
		this.balance = balance;
		this.acctLimit = acctLimit;
		this.interestRate = intRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getCreditLimit() {
		return acctLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.acctLimit = creditLimit;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		this.balance = this.balance - amount;
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance = this.balance + amount;
	}
	
	public String toString() {
		String state;
		state = "";
		state = super.toString() + "\n\t*\t" + this.getAccType() + " Account";
		state = state + "\tCurrent Balance: " + this.balance;
		state = state + ";\tCredit Limit: " + this.acctLimit;
		state = state + ";\tInterest Rate: " + this.interestRate;
		state = state + "\n\t********************************************************************************";
		return state;
	}


}
