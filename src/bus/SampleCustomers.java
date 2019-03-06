package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SampleCustomers {
	private int howMany;
	private static String firstNamesList [] = {"Mary", "Lili", "John", "Peter", "Sara", "Thomas", "Nataly", "Max"};
	private static String lastNamesList [] = { "Brown", "Bel", "Doe", "Pen", "Green", "Edisson", "Macfly", "Zero" };
	private static String streetList [] = {"St Catherine", "Monkland", "Sherbrooke", "St Laurent", "St Jacques", "Notre-Dame"} ;
	private static String cityList [] = {"Montreal", "Quebec City", "Toronto", "Ottawa", "Vancouver", "Calgary"} ;
	private static String provinceList [] = {"QC", "QC", "ON", "ON", "BC", "AB"};
	private String tempFirstName;
	private String tempLastName;
	

	public int getHowMany() {
		return howMany;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}
	
	public String getTempFirstName() {
		return tempFirstName;
	}

	public void setTempFirstName(String tempFirstName) {
		this.tempFirstName = tempFirstName;
	}

	public String getTempLastName() {
		return tempLastName;
	}

	public void setTempLastName(String tempLastName) {
		this.tempLastName = tempLastName;
	}

	public SampleCustomers() {
		this.howMany = 0;
	}	

	public SampleCustomers(int howMany) {
		this.howMany = howMany;
		this.tempFirstName = "";
		this.tempLastName = "";
	}

	public static DataCollection createSampleCust(DataCollection clients) {
		//DataCollection clients = new DataCollection();
		// 1. Add sample clients to the system (sample accounts).
		// Client C1 --- Account List creation:
//		Customer c1 = new Customer(getNextCustId(clients), getPseudoRnd(1000, 8999), "Mary", "Brown" + getPseudoRnd(10, 99),
//				"mary.brown" + getPseudoRnd(1, 9) + "@gmail.com",
//				new Address("2901", "Rue Sherbrook", "123", "QC", "Montreal", "Canada", "A3B3C1"));
		Customer c1 = sampleCustomer(clients);
		clients.add(c1);
		ArrayList<Transaction> transLstAcct1C1 = new ArrayList<Transaction>();

		Account acct1 = new CheckingAcct(c1.getId(), 100001, EnumAccType.Checking,
				new Date(getPseudoRnd(1, 28), 10, 2018), 0.00, transLstAcct1C1, 4, 2.00);

		Transaction tr0acc1c1 = new Transaction(10000, "Open Deposit", EnumTranType.Deposit,
				new Date(29, 10, 2018), 1000.00, acct1.getBalance());
		transLstAcct1C1.add(tr0acc1c1);
		acct1.deposit(tr0acc1c1.getTrAmount());

		Transaction tr1acc1c1 = new Transaction(10001, "Withdraw money", EnumTranType.Withdraw,
				new Date(29, 10, 2018), 100, acct1.getBalance());
		transLstAcct1C1.add(tr1acc1c1);
		acct1.withdraw(tr1acc1c1.getTrAmount());

		Transaction tr2acc1c1 = new Transaction(10002, "Deposit amount", EnumTranType.Deposit,
				new Date(29, 10, 2018), 100, acct1.getBalance());
		transLstAcct1C1.add(tr2acc1c1);
		acct1.deposit(tr2acc1c1.getTrAmount());

		Transaction tr3acc1c1 = new Transaction(10003, "Withdraw money", EnumTranType.Withdraw,
				new Date(29, 10, 2018), 200, acct1.getBalance());
		transLstAcct1C1.add(tr3acc1c1);
		acct1.withdraw(tr3acc1c1.getTrAmount());

		Transaction tr4acc1c1 = new Transaction(10004, "Deposit amount", EnumTranType.Deposit,
				new Date(29, 10, 2018), 350, acct1.getBalance());
		transLstAcct1C1.add(tr4acc1c1);
		acct1.deposit(tr4acc1c1.getTrAmount());

		acct1.setTransactList(transLstAcct1C1); // re-write the list of transactions for Acct1

		ArrayList<Account> accListC1 = c1.getAcctList();
		accListC1.add(acct1);
		

		ArrayList<Transaction> transLstAcct2C1 = new ArrayList<Transaction>();
		Account acct2 = new CreditAcct(c1.getId(), 100002, EnumAccType.Credit, new Date(01, 10, 2018), 0.00,
				transLstAcct2C1, 3000, 2.5f);
		Transaction tr0acc2c1 = new Transaction(20000, "Open Deposit", EnumTranType.Deposit, new Date(28, 10, 2018),
				1000, acct2.getBalance());
		transLstAcct2C1.add(tr0acc2c1);
		acct2.deposit(tr0acc2c1.getTrAmount());

		Transaction tr1acc2c1 = new Transaction(20001, "Deposit amount", EnumTranType.Deposit,
				new Date(28, 10, 2018), 200, acct2.getBalance());
		transLstAcct2C1.add(tr1acc2c1);
		acct2.deposit(tr1acc2c1.getTrAmount());

		Transaction tr2acc2c1 = new Transaction(20002, "Withdraw cash", EnumTranType.Withdraw,
				new Date(28, 10, 2018), 250, acct2.getBalance());
		transLstAcct2C1.add(tr2acc2c1);
		acct2.withdraw(tr2acc2c1.getTrAmount());

		Transaction tr3acc2c1 = new Transaction(20003, "Deposit amount", EnumTranType.Deposit,
				new Date(28, 10, 2018), 210, acct2.getBalance());
		transLstAcct2C1.add(tr3acc2c1);
		acct2.deposit(tr3acc2c1.getTrAmount());

		acct2.setTransactList(transLstAcct2C1);
		accListC1.add(acct2);

		// next client C2
		// Customer account C2
		//Customer c2 = new Customer(getNextCustId(clients), getPseudoRnd(1000, 8999), "John", "Doe" + getPseudoRnd(10, 99),
		//		"john.doe" + getPseudoRnd(1, 9) + "@gmail.com",
		//		new Address("123", "Rue Monkland", "55", "QC", "Montreal", "Canada", "A1C3D1"));
		Customer c2 = sampleCustomer(clients);
		clients.add(c2);
		ArrayList<Transaction> transLstAcct3C2 = new ArrayList<Transaction>();
		Account acct3 = new CheckingAcct(c2.getId(), 100003, EnumAccType.Checking,
				new Date(getPseudoRnd(1, 29), 10, 2018), 0.00, transLstAcct3C2, 4, 2.00);

		Transaction tr0acc3c2 = new Transaction(30001, "Open Deposit", EnumTranType.Deposit,
				new Date(29, 10, 2018), 1000, acct3.getBalance());
		transLstAcct3C2.add(tr0acc3c2);
		acct3.deposit(tr0acc3c2.getTrAmount());

		Transaction tr1acc3c2 = new Transaction(30001, "Withdraw money", EnumTranType.Withdraw,
				new Date(29, 10, 2018), 100, acct3.getBalance());
		transLstAcct3C2.add(tr1acc3c2);
		acct3.deposit(tr1acc3c2.getTrAmount());

		Transaction tr2acc3c2 = new Transaction(30002, "Withdraw money", EnumTranType.Withdraw,
				new Date(29, 10, 2018), 130, acct3.getBalance());
		transLstAcct3C2.add(tr2acc3c2);
		acct3.deposit(tr2acc3c2.getTrAmount());

		Transaction tr3acc3c2 = new Transaction(30003, "Withdraw money", EnumTranType.Withdraw,
				new Date(29, 10, 2018), 550, acct3.getBalance());
		transLstAcct3C2.add(tr3acc3c2);
		acct3.withdraw(tr3acc3c2.getTrAmount());

		Transaction tr4acc3c2 = new Transaction(30004, "Deposit amount", EnumTranType.Deposit,
				new Date(29, 10, 2018), 260, acct3.getBalance());
		transLstAcct3C2.add(tr4acc3c2);
		acct3.deposit(tr4acc3c2.getTrAmount());

		Transaction tr5acc3c2 = new Transaction(30005, "Withdraw money", EnumTranType.Withdraw,
				new Date(30, 10, 2018), 50, acct3.getBalance());
		transLstAcct3C2.add(tr5acc3c2);
		acct3.withdraw(tr5acc3c2.getTrAmount());

		Transaction tr6acc3c2 = new Transaction(30006, "Withdraw money", EnumTranType.Withdraw,
				new Date(31, 10, 2018), 150, acct3.getBalance());
		transLstAcct3C2.add(tr6acc3c2);
		acct3.withdraw(tr6acc3c2.getTrAmount());

		Transaction tr7acc3c2 = new Transaction(30006, "Withdraw money", EnumTranType.Withdraw,
				new Date(31, 10, 2018), 120, acct3.getBalance());
		transLstAcct3C2.add(tr7acc3c2);
		acct3.withdraw(tr7acc3c2.getTrAmount());

		acct3.setTransactList(transLstAcct3C2);
		
		ArrayList<Account> accListC2 = c2.getAcctList();
		accListC2.add(acct3);

		// next client C3
		//Customer account C3
//		Customer c3 = new Customer(getNextCustId(clients), getPseudoRnd(1000, 8999), "Lili", "Marlein" + getPseudoRnd(10, 99),
//				"lili.marlein" + getPseudoRnd(1, 9) + "@yahoo.de",
//				new Address("557", "Rue Bridge", "4", "QC", "Montreal", "Canada", "X1C3F2"));
		Customer c3 = sampleCustomer(clients);
		clients.add(c3);

		ArrayList<Transaction> transLstAcct1C3 = new ArrayList<Transaction>();
		Account acct1C3 = new CheckingAcct(c3.getId(), 100001, EnumAccType.Checking,
				new Date(getPseudoRnd(1, 29), 10, 2018), 0.00, transLstAcct1C3, 4, 2.00);

		Transaction tr0acc1c3 = new Transaction(10001, "Open Deposit", EnumTranType.Deposit,
				new Date(getPseudoRnd(1, 28), 11, 2018), 1000, acct1C3.getBalance());
		transLstAcct1C3.add(tr0acc1c3);
		acct1C3.deposit(tr0acc1c3.getTrAmount());
		acct1C3.setTransactList(transLstAcct1C3);
		//accListC3.add(acct1C3);
		ArrayList<Account> accListC3 = c3.getAcctList();
		accListC3.add(acct1C3);
		
		// next client C4
		//Customer account C4
		Customer c4 = sampleCustomer(clients);
		clients.add(c4);

		ArrayList<Transaction> transLstAcct1C4 = new ArrayList<Transaction>();
		Account acct1C4 = new CheckingAcct(c4.getId(), 100001, EnumAccType.Checking,
				new Date(getPseudoRnd(1, 29), 11, 2018), 0.00, transLstAcct1C4, 4, 2.00);

		Transaction tr0acc1c4 = new Transaction(10001, "Open Deposit", EnumTranType.Deposit,
				new Date(getPseudoRnd(1, 28), 11, 2018), 1000, acct1C4.getBalance());
		transLstAcct1C4.add(tr0acc1c4);
		acct1C4.deposit(tr0acc1c4.getTrAmount());
		acct1C4.setTransactList(transLstAcct1C4);
		ArrayList<Account> accListC4 = c4.getAcctList();
		accListC4.add(acct1C4);
		
		// next client C5
		//Customer account C5
		Customer c5 = sampleCustomer(clients);
		clients.add(c5);

		ArrayList<Transaction> transLstAcct1C5 = new ArrayList<Transaction>();
		Account acct1C5 = new CheckingAcct(c5.getId(), 100001, EnumAccType.Checking,
				new Date(getPseudoRnd(1, 29), 11, 2018), 0.00, transLstAcct1C5, 4, 2.00);

		Transaction tr0acc1c5 = new Transaction(10001, "Open Deposit", EnumTranType.Deposit,
				new Date(getPseudoRnd(1, 28), 11, 2018), 1000, acct1C5.getBalance());
		transLstAcct1C5.add(tr0acc1c5);
		acct1C5.deposit(tr0acc1c5.getTrAmount());
		acct1C5.setTransactList(transLstAcct1C5);
		ArrayList<Account> accListC5 = c5.getAcctList();
		accListC5.add(acct1C5);
		
		return clients;
		
	}
	
	public static Customer sampleCustomer(DataCollection clients) {
		int provIdx = 0;
		int count = 10;
		Customer nextCustomer = new Customer();
		nextCustomer.setId(getNextCustId(clients));
		nextCustomer.setPin(getPseudoRnd(1000, 8999));
		
		String fName = firstNamesList[getPseudoRnd(0,8)];
		String lName = lastNamesList[getPseudoRnd(0,8)];
		
		boolean uniqueCustName = true;
		do {
			uniqueCustName = true;
			
			for (Customer aCustomer : clients.getMyList()) {
				if ((fName == aCustomer.getFirstName()) 
						&& (lName == aCustomer.getLastName())) {
					uniqueCustName = false;						
				}
			}			
			if (count == 0) {
				 lName = lName + String.valueOf(nextCustomer.getId());
				 uniqueCustName = true;
			}
			if (!uniqueCustName) {
				 fName = firstNamesList[getPseudoRnd(0,8)];
				 lName = lastNamesList[getPseudoRnd(0,8)];
			}			
			count --;
			if (count == 0) {
				break;
			}
		} while (!uniqueCustName);
	
		nextCustomer.setFirstName(fName);
		nextCustomer.setLastName(lName);
		nextCustomer.setEmail(fName+"."+lName+"@gmail.com");
		provIdx = getPseudoRnd(0,5);
		String province = provinceList[provIdx];
		String city = cityList[provIdx];
		String street = streetList[getPseudoRnd(0,5)];
		nextCustomer.setCustomerAddress(new Address (String.valueOf(getPseudoRnd(0,500)), street, 
				String.valueOf(getPseudoRnd(10,500)), province, city, "Canada", "A3B3C" + String.valueOf(getPseudoRnd(0,9))));
		
		return nextCustomer;
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
	
	
	@Override
	public String toString() {
		return "SampleCustomers [howMany=" + howMany + "]";
	}
	

}
