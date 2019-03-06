// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************

package bus;

public interface IAccountOperations {
	

	void withdraw(double amount);

	void deposit(double amount);
	
	boolean transfer(Account accFrom, Account accTo, double amount);
	
	double getBalance();
	
}
