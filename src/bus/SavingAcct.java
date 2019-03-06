// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// ***********************************

package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class SavingAcct extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6335064034748215950L;
	private double balance;
	private float anInterestRate;
	private float anGain;
	private float anExtraFee;
	
	public SavingAcct() {
		super();
		this.balance = 0;
		this.anInterestRate = 0.0f;
		this.anGain = 0.0f;
		this.anExtraFee = 0.0f;
	}
	
	public SavingAcct(int customerId, int accNum, EnumAccType accType,
			Date openDate, double balance, float anInterR, float anGain, ArrayList<Transaction> transList, float anExtraF) {
		super(customerId, accNum, accType, openDate, balance, transList);
		this.balance = balance;
		this.anInterestRate = anInterR;
		this.anGain = anGain;
		this.anExtraFee = anExtraF;
	}	
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public float getAnInterestRate() {
		return anInterestRate;
	}

	public void setAnInterestRate(float anInterestRate) {
		this.anInterestRate = anInterestRate;
	}

	public float getAnGain() {
		return anGain;
	}

	public void setAnGain(float anGain) {
		this.anGain = anGain;
	}

	public float getAnExtraFee() {
		return anExtraFee;
	}

	public void setAnExtraFee(float anExtraFee) {
		this.anExtraFee = anExtraFee;
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
		state = state + ";\tAnnual Interest: " + this.anInterestRate;
		state = state + ";\tAnnual Gaine: " + this.anGain;
		state = state + ";\tAnnual Extra Fee: " + this.anExtraFee;
		state = state + "\n\t********************************************************************************";
		return state;
	}


}
