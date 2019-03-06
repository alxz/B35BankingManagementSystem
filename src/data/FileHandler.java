// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.5
// ***********************************

package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bus.Customer;
//import bus.DataCollection;

public class FileHandler {

	//write to file:
	public static void writeToFile(ArrayList<Customer> arrayList) throws IOException
	{
		FileOutputStream outputFile = new FileOutputStream("src/data/bankCustomers.ser");
		ObjectOutputStream outStream = new ObjectOutputStream(outputFile);
		outStream.writeObject(arrayList);
		outStream.close();
	}
	
	//read from file DataCollection myCustomerFromFile
	@SuppressWarnings("unchecked")
	public static ArrayList<Customer> readFromFile() throws IOException, ClassNotFoundException {
		//read from SerializedFile
		ArrayList<Customer> myCustomerFromFile = new ArrayList<Customer> ();
		FileInputStream inputFile = new FileInputStream("src/data/bankCustomers.ser");
		ObjectInputStream inStream = new ObjectInputStream(inputFile);
		
		myCustomerFromFile = (ArrayList<Customer>) (inStream.readObject());
		inStream.close();
		return myCustomerFromFile;
	}
}
