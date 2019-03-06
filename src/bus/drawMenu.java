package bus;

public class drawMenu {
	private int minItem;
	private int maxItem;
	private String menuList;
	
	public drawMenu () {
		this.minItem = 0;
		this.maxItem = 0;
		this.menuList = "";
		
	};
	public drawMenu ( int min, int max, String menuList) {
		//min = minimum menu item
		//max = maximum menu item
		this.minItem = min;
		this.maxItem = max;
		this.menuList = menuList;		
	}

	public int getMinItem() {
		return minItem;
	}
	public void setMinItem(int minItem) {
		this.minItem = minItem;
	}
	public int getMaxItem() {
		return maxItem;
	}
	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}
	public String getMenuList() {
		return menuList;
	}
	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}
	
	public static String showMainMenu () {
		String showString = "";
		showString = showString + ("\n\tWelcome to the banking system application!\n");
		showString = showString + ("\n\tPlease choose one of the following activities:\n");
		showString = showString + ("\n\t1. Add sample customers to the system (generate 5 samples).");
		showString = showString + ("\n\t2. Add/Remove customer from the system.");
		showString = showString + ("\n\t3. View all information of existing customers.");
		showString = showString + ("\n\t4. Search and Display customer information.");
		showString = showString + ("\n\t5. Choose Customer operations.");
//		showString = showString + ("\n\t6. Manage customers transactions.");
		showString = showString + ("\n\t7. Save customers information to the file.");
		showString = showString + ("\n\t8. Read customers information from the file.");
		showString = showString + ("\n\n\t9. Exit system.");
		
		//showString = showString + ("\n\n\tPlease enter the item number: ");
		return showString;
	}
	////////////////========================================================
	public static String showAddRemCustMenu () {
		String showString = "";
		showString = showString + "\n\tAdd/Remove Customer Operations: \n";
		showString = showString + "\n\t1. Add new customer";
		showString = showString + "\n\t2. Remove existing customer";
		showString = showString + "\n\t3. List all customers accounts (brief card style)";
		showString = showString + "\n\t4. Delete ALL customers from the system!";
		showString = showString + "\n\t5. Quit to main menu";
		return showString;
	}
	////////////////========================================================
	public static String searchCustMenu () {
		String showString = "";
		showString = showString + "\n\tCustomer Search & Display operations: \n";
		showString = showString + "\n\t1. Search customer by ID";
		showString = showString + "\n\t2. Search customer by First Name";
		showString = showString + "\n\t3. Search customer by Last Name";
		showString = showString + "\n\t4. Quit to main menu\n";
		return showString;
	}
	
	public static String chooseCustOperMenu () {
		String showString = "";
		showString = showString + "\n\tChoose Customer operations: \n";
		showString = showString + "\n\t1. Customer Personal Inforamtion modification";
		showString = showString + "\n\t2. Customer Accounts operations (Add/Remove)";
		showString = showString + "\n\t3. Customer Transactions operations";
		showString = showString + "\n\t4. Quit to main menu\n";
		return showString;
	}
	
	public static String showCustomerAcctOperMenu () {
		String showString = "";
		showString = showString + "\n\tCustomer Accounts operations: \n";
		showString = showString + "\n\t1. Show Accounts\n";
		showString = showString + "\n\t2. Open Credit Account";
		showString = showString + "\n\t3. Open Saving Account";
		showString = showString + "\n\t4. Open Currency Account\n";
		showString = showString + "\n\t5. Close Account (Credit/Saving/Curency)";
//		showString = showString + "\n\t6. Close Saving Account";
//		showString = showString + "\n\t7. Close Currency Account";
		showString = showString + "\n\t8. Quit to main menu\n";
		return showString;
	}
	
	public static String showModCustMenu () {
		String showString = "";
		showString = showString + "\n\tCustomer Personal Information modification: \n";
		showString = showString + "\n\t1. View customer information";
		showString = showString + "\n\t2. Modify customer First and/or Last Name";
		showString = showString + "\n\t3. Modify customer email and/or address";
		showString = showString + "\n\t4. Modify customer address";
		showString = showString + "\n\t5. Quit to main menu\n";
		return showString;
	}

	public static String showTransactCustMenu () {
		String showString = "";
		showString = showString + "\n\tCustomer Transactions operations: \n";
		showString = showString + "\n\t1. View customer transactions and balance";
		showString = showString + "\n\t2. Operations: Withdrawal";
		showString = showString + "\n\t3. Operations: Deposit";
		showString = showString + "\n\t4. Operations: Transfer Money between accounts";
		showString = showString + "\n\t5. Quit to main menu\n";
		return showString;
	}
	
	@Override
	public String toString() {
		return "drawMenu [menuList=" + menuList + "]";
	}
	
	

}
