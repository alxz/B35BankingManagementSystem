// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************

package bus;

import java.io.Serializable;

public class Transaction implements IAccountOperations , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6971169110137502763L;
	private long trNumber;
	private String  trDescription;
	private EnumTranType tranType;
	private Date trDate;
	private double trAmount;
	private double balanceIn;
	
	
	public Transaction () {
		this.trNumber = 0;
		this.trDescription = "Unknown";
		this.tranType = EnumTranType.Unknown;
		this.trDate = new Date();
		this.trAmount = 0;
		this.balanceIn = 0;
	}

	public Transaction(long trNumber, String trDescription, 
					EnumTranType tranType, Date trDate, double trAmount, double balanceIn) {
		super();
		this.trNumber = trNumber;
		this.trDescription = trDescription;
		this.tranType = tranType;
		this.trDate = trDate;
		this.trAmount = trAmount;
		this.balanceIn = balanceIn;
		
		if (this.tranType == EnumTranType.Deposit)
		{
			//this.trAmount = this.trAmount + trAmount;
			this.balanceIn = balanceIn + trAmount;
			
		}
		if (this.tranType == EnumTranType.Withdraw)
		{
			//this.trAmount = this.trAmount - trAmount;
			this.balanceIn = balanceIn - trAmount;
		}
	}


	public long getTrNumber() {
		return trNumber;
	}


	public void setTrNumber(long trNumber) {
		this.trNumber = trNumber;
	}


	public String getTrDescription() {
		return trDescription;
	}


	public void setTrDescription(String trDescription) {
		this.trDescription = trDescription;
	}


	public EnumTranType getTranType() {
		return tranType;
	}


	public void setTranType(EnumTranType tranType) {
		this.tranType = tranType;
	}


	public Date getTrDate() {
		return trDate;
	}


	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}


	public double getTrAmount() {
		return trAmount;
	}


	public void setTrAmount(double trAmount) {
		this.trAmount = trAmount;
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	public String toString() // this is OVERRIDEN operation(method)!!!
	{
		String state;
		state = "\t" + this.trNumber + 
				" \t" +	this.trDescription + 
				" \t\t" + this.tranType + 
				" \t\t " + this.trDate + 
				" \t\t " + this.trAmount +
				" \t\t " + this.balanceIn;
		return state;
	}

	@Override
	public boolean transfer(Account accFrom, Account accTo, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
