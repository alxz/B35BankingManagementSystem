// by Alexey Zapromyotov,
// Submitted to: Houria Houmel
// Created Date: since 4-OCT-2018 - 7-DEC-2018
// Semester: FALL-2018
// Project: Banking Management System Application
// Version 2.6
// ***********************************

package prod;

import bus.SampleCustomers;
import bus.SearchCustomer;
import bus.Transaction;
import bus.Customer;
import bus.DataCollection;
import bus.Date;
import bus.EnumTranType;
import bus.Account;
import bus.AddRemoveCustomer;
import bus.drawMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.IOException;
import java.util.Scanner; //to input data from keyboard

public class BankingAppTester_v4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		int idNum = 0;
		int itemSelMenueLevTwo = 0;
		String inputVal;
		boolean exitApp = false;

		Scanner scan = new Scanner(System.in);
		DataCollection clients = new DataCollection();
		DataCollection myCustomerFromFile = new DataCollection();

		do {
			exitApp = false;
			System.out.println(drawMenu.showMainMenu());
			System.out.print("\n\n\tPlease enter the item number: ");
			inputVal = scan.nextLine();

			try { // statements that may cause an exception
				idNum = Integer.parseInt(inputVal);
			} catch (Exception e) { // error handling code
				System.out.println("Exception occurred");
				idNum = 0;
			}

			switch (idNum) {
			case 0: { 
				break;
			}
			case 1: {
//				// 1. Add sample clients to the system (sample accounts).
				clients = SampleCustomers.createSampleCust(clients); //using sample class to add to a collection
				System.out.println("\n\t========== Sample Clients accounts and transactions created =============\n");
				System.out.println("\n\t===================== < **************************** > ====================");
				System.out.println("\n\t\tClients inforamtion including transactions ...");
				System.out.println("\n\t===================== < **************************** > ====================\n");
				for (Customer element : clients.getMyList()) {
					System.out.println(element.toString());
//					System.out.println(
//							"\t===================== <  ****************************  > ====================\n");
				}
				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 2: {
				// 2 Add new client to the system.
				// showAddRemCustMenu
				do {
					exitApp = false;
					System.out.println(drawMenu.showAddRemCustMenu());
					System.out.print("\n\n\tPlease enter the item number: ");
					inputVal = scan.nextLine();
					try { // statements that may cause an exception
						itemSelMenueLevTwo = Integer.parseInt(inputVal);
					} catch (Exception e) { // error handling code
						System.out.println("Exception occurred");
						itemSelMenueLevTwo = 0;
					}

					switch (itemSelMenueLevTwo) {
					case 1: //create new customer account
						Customer custNew;
						custNew = AddRemoveCustomer.createNewCustomer(clients);
						clients.add(custNew);
						System.out.println("\n\tPlease press Enter to go back to main menu...\n");
						System.in.read();
						break;
					case 2: // 2. Remove existing client
						Customer custRemove;
						custRemove = AddRemoveCustomer.removeCustomerById(clients);
						clients.remove(custRemove);
						System.out.println("\n\tOperation completed.\n");
						System.out.println("\n\tPlease press Enter to go back to main menu...\n");
						System.in.read();
						break;
					case 3: // 3. List all client accounts
						System.out.println("\n");
						System.out.println(
								"\n\t===================== < **************************** > ====================");
						System.out.println("\n\t\tClients inforamtion including transactions ...");
						System.out.println(
								"\n\t===================== < **************************** > ====================\n");
						for (Customer element : clients.getMyList()) {
							System.out.println("\n" + element.showOnlyAccounts());
							System.out.println("\n");
						}
						System.out.println("\n\tPlease press Enter to go back to main menu...\n");
						System.in.read();
						break;
					case 4: //remove all customer from the system
						clients.getMyList().clear(); // empty customers list
						System.out.println("\n\tAll records were removed!\n");
						System.out.println("\n\tPlease press Enter to go back to main menu...\n");
						System.in.read();
						break;
					case 5: // 5. Quit to main menu
						exitApp = true;
						break;
					}

				} while (!exitApp);
				exitApp = false;
				break;
			}

			case 3: {
				// 3 Displaying data from console & memory
				System.out.println("\n");
				System.out.println("\n\t=============================================================");
				System.out.println("\n\t\tClients inforamtion including transactions ...");
				System.out.println("\n\t=============================================================\n");
				for (Customer element : clients.getMyList()) {
					System.out.println(element.showOnlyUserInfo());
					System.out.println(
							"\t-----------------------------------------------------------------------------------\n");
				}
				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 4: {
				// 4. Search/view client information and transaction.

				System.out.println("\n\tSearch and View Customer information!\n");
				itemSelMenueLevTwo = 0;
				exitApp = false;
				do {
					
					System.out.println(drawMenu.searchCustMenu());
					System.out.print("\n\n\tPlease enter the menu item number: ");
					inputVal = scan.nextLine();

					try { // statements that may cause an exception
						itemSelMenueLevTwo = Integer.parseInt(inputVal);
					} catch (Exception e) { // error handling code
						System.out.println("Exception occurred");
						itemSelMenueLevTwo = 0;
					}					
					int id;
					switch (itemSelMenueLevTwo) {
					case 0:
						break;
					case 1:						
						do {
							
							System.out.print("\n\t1. Please enter customer ID to search for: ");
							inputVal = scan.nextLine();
							try {
								// statements that may cause an exception
								id = Integer.parseInt(inputVal);
							} catch (Exception e) {
								// error handling code
								System.out.println("\n\n\t\tException occurred - string is not a valid number!");
								id = 0;
							}
							Customer foundCustomer = SearchCustomer.searchById(clients, id);
							if (foundCustomer != null) {
								System.out.println("\n\t" + foundCustomer.toString());
							}
							else {
								System.out.println("\n\t *** Sorry, nothing found! *** \n");
							}
						} while (id == 0);
						break;
					case 2:
					{
						System.out.println("\n\t2. Please enter customer First Name: ");
						System.out.print("\n\tPlease enter First Name: ");
						inputVal = scan.nextLine();
						List<Customer> listFound = new ArrayList<Customer>();
						listFound = SearchCustomer.searchByFirstName(clients, inputVal);
						if (listFound.size() != 0) {
							System.out.println("\n\tFound " + listFound.size() + " customer(s)");
							System.out.println("\n\t" + listFound.toString());
						}
						else {
							System.out.println("\n\t *** Sorry, nothing found! *** \n");
						}
						
						break;
					}
					case 3:
					{
						System.out.println("\n\t3. Please enter customer Last Name: ");
						System.out.print("\n\tPlease enter customer Last Name: ");
						inputVal = scan.nextLine();
						List<Customer> listFound = new ArrayList<Customer>();
						listFound  = SearchCustomer.searchByLastName(clients, inputVal);
						if (listFound.size() != 0) {
							System.out.println("\n\tFound " + listFound.size() + " customer(s)");
							System.out.println("\n\t" + listFound.toString());
						}
						else {
							System.out.println("\n\t *** Sorry, nothing found! *** \n");
						}
						break;
					}
					case 4: //exit
						System.out.println("\n\t4. Exit!");
						exitApp = true;
						break;
					}
					
				} while (!exitApp);
				exitApp = false;
				break;
	
			}
			case 5: {
				// 5. Choose Customer operations
				/*  Choose Customer operations:
					1. Customer Personal Information modification
					2. Customer Accounts operations
					3. Customer Transactions operations
					4. Quit to main menu				*/				
				int custId;
				System.out.println("\t-------------------------------------------------------------");
				do {
					System.out.print("\n\t*** Please enter customer ID to work with: ");
					inputVal = scan.nextLine();
					try { // statements that may cause an exception
						custId = Integer.parseInt(inputVal);
					} catch (Exception e) { // error handling code
						System.out.println("\n\n\t\tException: string is not a valid number!");
						custId = 0;
					}
					Customer foundCustomer = SearchCustomer.searchById(clients, custId);
					if (foundCustomer != null) {
						System.out.println("\n\t" + foundCustomer.showOnlyUserInfo());
					}
					else {
						System.out.println("\n\t *** Sorry, nothing found! *** \n");
					}
				} while (custId == 0);
				
				exitApp = false;
				
				System.out.println("\n\tWe will work with customer record with id: " +custId);
				do {
					System.out.print(drawMenu.chooseCustOperMenu() + "\n\t\t Enter menu item: ");
					inputVal = scan.nextLine();
					try { // statements that may cause an exception
						itemSelMenueLevTwo = Integer.parseInt(inputVal);
					} catch (Exception e) { // error handling code
						System.out.println("\n\tException occurred");
						itemSelMenueLevTwo = 0;
					}

					switch (itemSelMenueLevTwo) {
					case 1: // 1. Customer Personal Information modification
						Customer UpdCustomer = AddRemoveCustomer.updateCustomer(clients, custId);
						//Customer foundCustomer = SearchCustomer.searchById(clients, custId);
						//clients.remove(foundCustomer);
						//clients.add(UpdCustomer);
						System.out.println("\n\tCustomer (ID# " +  UpdCustomer.getId() 
						+ ") " + UpdCustomer.getFirstName() + ", " + UpdCustomer.getLastName()
						+ " - inforamtion updated!");
						break;
					case 2:
						/* 2. Customer Accounts operations
								1. Show Accounts
								2. Open Saving Account
								3. Open Credit Account
								4. Open Currency Account
								5. Close Account (Saving/Credit/Currency)
								8. Quit to main menu
						*/
						boolean exitCustAcct = false;
						int itemSelMenueLevThree = 0;
						do {
							System.out.print(drawMenu.showCustomerAcctOperMenu() + "\n\t\t Enter menu item: ");
							inputVal = scan.nextLine();
							
							try { // statements that may cause an exception
								itemSelMenueLevThree = Integer.parseInt(inputVal);
							} catch (Exception e) { // error handling code
								System.out.println("\n\tException occurred");
								itemSelMenueLevThree = 0;
							}
							Customer foundCustomer = SearchCustomer.searchById(clients, custId);
							switch (itemSelMenueLevThree) {
							case 1: //Show Accounts
								System.out.println("\n\t *** Customer Accounts Information: *** \n");								
								if (foundCustomer != null) {
									System.out.println("\t" + foundCustomer.showOnlyAccounts());
								}
								else {
									System.out.println("\n\t *** Sorry, nothing found! *** \n");
								}
								break;
							case 2: //Open Credit Account
								foundCustomer.OpenNewAccount("Credit", custId);
								System.out.println("\n\t---------------------------------------");
								break;
							case 3: //Open Saving Account
								foundCustomer.OpenNewAccount("Saving", custId);
								System.out.println("\n\t---------------------------------------");
								break;
							case 4: //Open Currency Account
								foundCustomer.OpenNewAccount("Currency", custId);
								System.out.println("\n\t---------------------------------------");
								break;
							case 5: //Close Any Account
								System.out.println("\n\t *** Current List of accounts: *** \n");								
								if (foundCustomer != null) {
									System.out.println("\n\t" + foundCustomer.showCustomerAccountsList());
								}
								else {
									System.out.println("\n\t *** Sorry, nothing found! *** \n");
								}
								System.out.print("\n\tPlease choose Account number to close: ");
								int accNum = 0;
								inputVal = scan.nextLine();
								try { // statements that may cause an exception
									accNum = Integer.parseInt(inputVal);
								} catch (Exception e) { // error handling code
									System.out.println("\n\tException occurred");
									accNum = 0;
								}
								boolean result = foundCustomer.CloseAccount(accNum);
								if (!result) 
									System.out.println("\n\tOperation failed!!!\n");
								break;
							case 8: //exit
								exitCustAcct = true;
								break;
							default:
								exitCustAcct = false;
								break;								
							}							
						} while(!exitCustAcct);
						
						break;
					case 3:
						// 3. Customer Transaction operations
						int myAccountId = 0;
						System.out.println("\n\t *** 3. Customer Transactions operations *** ");
						Customer myCustomer = SearchCustomer.searchById(clients, custId);
						ArrayList<Account> myAccList = myCustomer.getAcctList();
						do {
							System.out.println("\n\tPelase choose Account number to work with: ");
							
							for (Account anAcct : myAccList) {
								System.out.println("\tAccount #" + anAcct.getAccNum() 
												+ " type: " + anAcct.getAccType().toString());		
							}
							System.out.print("\n\t Enter account number:  ");
							inputVal = scan.nextLine();
							try { // statements that may cause an exception
								myAccountId = Integer.parseInt(inputVal);
							} catch (Exception e) { // error handling code
								System.out.println("\n\tException occurred");
								myAccountId = 0;
							}
						} while (myAccountId == 0);
						Account myAcct = myCustomer.search(myAccountId);
						exitCustAcct = false;
						do {
							System.out.print(drawMenu.showTransactCustMenu() + "\n\t\t Enter menu item: ");
							inputVal = scan.nextLine();
							
							try { // statements that may cause an exception
								itemSelMenueLevThree = Integer.parseInt(inputVal);
							} catch (Exception e) { // error handling code
								System.out.println("\n\tException occurred");
								itemSelMenueLevThree = 0;
							}
							double currBalance = myCustomer.getAccountBalance(myAccountId);
							double myAmount = 0.00;
							Transaction myCurTransact;
							switch (itemSelMenueLevThree) {
							case 1: //View customer transactions and balance
								System.out.println("\n\tCurrent customer Account details:");
								myCustomer.ShowAccountInfo(myAccountId);
								break;
							case 2: //Operations: Withdrawal
								System.out.println("\n\tOperations: Withdrawal");
								System.out.println("\n\tCurrent account balance: " + currBalance);
								do {
									System.out.print("\n\tPlease enter the amount to withdraw (0 - to exit): ");
									inputVal = scan.nextLine();
									try { // statements that may cause an exception
										myAmount = Integer.parseInt(inputVal);
									} catch (Exception e) { // error handling code
										System.out.println("\n\tException occurred");
										myAmount = 0;
									}
								} while (myAmount == 0);
								
								if ((currBalance - myAmount) < 0) {
									System.out.println("\t--------------------------------------------\n");
									System.out.println("\n\tNot enough money on the balance to proceed!"
											+ "\n\tOperation aborted!");
									System.out.println("\t--------------------------------------------\n");
									break;
								}
								myCurTransact = new Transaction(myCustomer.nextTransactId(myAccountId) +1, 
										"Withdraw money", EnumTranType.Withdraw,
										new Date(), myAmount, currBalance);
								myAcct.add(myCurTransact);
								myAcct.withdraw(myCurTransact.getTrAmount());
								System.out.println("\n\tNew balance for the account: " + myAcct.getBalance());
								//myCustomer.ShowAccountInfo(myAccountId);
								myCustomer.ShowLastTransactions(myAccountId, 2);
								break;
							case 3: //deposit								
								System.out.println("\n\tOperations: Deposit");
								System.out.println("\n\tCurrent account balance: " + currBalance);									
								do {
									System.out.print("\n\tPlease enter the amount to deposit (0 - to exit): ");
									inputVal = scan.nextLine();
									try { // statements that may cause an exception
										myAmount = Integer.parseInt(inputVal);
									} catch (Exception e) { // error handling code
										System.out.println("\n\tException occurred");
										myAmount = 0;
									}
								} while (myAmount == 0);								
								myCurTransact = new Transaction(myCustomer.nextTransactId(myAccountId) +1, 
										"Deposit money", EnumTranType.Deposit,
										new Date(), myAmount, currBalance);
								myAcct.add(myCurTransact);
								myAcct.deposit(myCurTransact.getTrAmount());
								System.out.println("\n\tNew balance for the account: " + myAcct.getBalance());
								myCustomer.ShowLastTransactions(myAccountId, 2);
								break;
							case 4: //Operations: Transfer Money between accounts
								int myAccountIdTo = 0;
								double fromBalance = 0;
								double toBalance = 0;
								Transaction myCurTransactFrom;
								Transaction myCurTransactTo;
								do {
									System.out.println("\n\tAccount number to transfer money from: " 
														+ myAccountId);
									System.out.print("\n\tPelase choose Account number to transfer money to: \n");
									
									for (Account anAcct : myAccList) {
										if (anAcct.getAccNum() != myAccountId) {
											System.out.println("\tAccount #" + anAcct.getAccNum() 
											+ " type: " + anAcct.getAccType().toString());
										}												
									}
									System.out.print("\n\t Enter account number:  ");
									inputVal = scan.nextLine();
									try { // statements that may cause an exception
										myAccountIdTo = Integer.parseInt(inputVal);
									} catch (Exception e) { // error handling code
										System.out.println("\n\tException occurred");
										myAccountIdTo = 0;
									}
								} while (myAccountIdTo == 0);
								Account myAcctTo = myCustomer.search(myAccountIdTo);
								toBalance = myAcctTo.getBalance();
								fromBalance = myAcct.getBalance();
								System.out.println("\tAccount balance: " + toBalance);
								do {
									System.out.print("\n\tPlease enter the amount to transfer (0 - to exit): ");
									inputVal = scan.nextLine();
									try { // statements that may cause an exception
										myAmount = Integer.parseInt(inputVal);
									} catch (Exception e) { // error handling code
										System.out.println("\n\tException occurred");
										myAmount = 0;
									}
								} while (myAmount == 0);
								
								myCurTransactFrom = new Transaction(myCustomer.nextTransactId(myAccountId) +1, 
										"Withdraw money", EnumTranType.Withdraw,
										new Date(), myAmount, fromBalance);
								myAcct.add(myCurTransactFrom);
								myAcct.withdraw(myCurTransactFrom.getTrAmount());
								
								myCurTransactTo = new Transaction(myCustomer.nextTransactId(myAccountIdTo) +1, 
										"Deposit money", EnumTranType.Deposit,
										new Date(), myAmount, toBalance);
								myAcctTo.add(myCurTransactTo);
								myAcctTo.deposit(myCurTransactTo.getTrAmount());
								
								//System.out.println("\n\tNew balance for the account-From: " + myAcct.getBalance());
								myCustomer.ShowLastTransactions(myAccountId, 2);
								
								//System.out.println("\n\tNew balance for the account-To: " + myAcctTo.getBalance());
								myCustomer.ShowLastTransactions(myAccountIdTo, 2);
								break;
							case 5:
								exitCustAcct = true;
								break;							
							}
							
						} while (!exitCustAcct);										
						break;
						
					case 4:
						// 4. Quit to main menu
						exitApp = true;
						break;
					}
				} while (!exitApp);
				exitApp = false;

				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 6: {
				// 6. Modify Client Transactions - Customer Transactions operations";
				System.out.println("\n\t *** 3. Customer Transactions operations *** ");

				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 7: {
				// 7. Save clients information to the file.
				// writing data to the file
				System.out.println("\n\t===================== < **************************** > ====================");
				System.out.println("\n\t\tWritting client infomration to the binary file ...");
				System.out.println("\n\t===================== < **************************** > ====================\n");
				data.FileHandler.writeToFile(clients.getMyList());

				System.out.println("\n\t\tWritting completed ...");

				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 8: {
				// 5 Read from File
				System.out.println("\n\t////////////////////////////////////////////////////////////////////");
				System.out.println("\t\t Reading a list of customers from FileHandler.Customers: ");
				System.out.println("\t////////////////////////////////////////////////////////////////////\n");
				for (Customer aCustomer : data.FileHandler.readFromFile()) {
					myCustomerFromFile.add(aCustomer);
					//System.out.println("\n" + aCustomer.toString());
				}
				
				clients.getMyList().clear(); // empty customers list
				
				for (Customer aCustomer : myCustomerFromFile.getMyList()) {
					clients.add(aCustomer); //populate customers list
					System.out.println("\n" + aCustomer.toString());
				}
				System.out.println("\t////////////////////////////////////////////////////////////////////\n");
				System.out.println("\n\tPlease press Enter to go back to main menu...\n");
				System.in.read();
				break;
			}
			case 9: {
				// 9 - EXIT from the system
				System.out.println("\n\tPlease press Enter to Exit Application...");
				System.in.read();
				exitApp = true;
				break;
			}
			default: {
				// nothing;
			}

			}

		} while (!exitApp);

	}
	
	public static int getNextCustId(DataCollection clients) {
		int nextCustID = 1;
		
		for (Customer aCustomer : clients.getMyList()) {
			if (nextCustID == aCustomer.getId()) {
				++ nextCustID ;
			}
		}		
		return nextCustID;
		
	}
	
	public static int getPseudoRnd(int min, int max) {
		Random randomNum = new Random();
		int randInt = min + randomNum.nextInt(max);
		return randInt;
	}
	

}
