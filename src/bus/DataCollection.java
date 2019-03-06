// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************
package bus;

import java.io.Serializable;
import java.util.ArrayList;;
public class DataCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690687173164202955L;
	private ArrayList<Customer> myList;  //private attribute as ArrayList of Employees type
	
	public DataCollection() 
	{
		myList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getMyList()
	{
		return myList;
	}
	
//	public void setMyList(ArrayList<Customer> myList) 
//	{
//		this.myList = myList;
//	}
	
	public void remove(Customer current) 
	{
		myList.remove(current);
	}
	
	public void add(Customer current) 
	{
		myList.add(current);
	}
	
	public Customer search(int id) 
	{
		for (Customer currentCustomer : myList)
		{
			if (currentCustomer.getId() == id) return currentCustomer;			
		}
		return null;
	}
}
