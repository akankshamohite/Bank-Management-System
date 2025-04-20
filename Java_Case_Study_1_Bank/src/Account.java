import java.time.LocalDate;

public abstract class Account {
	
	long accountNumber;
	String accountHolderName;
	double accountBalance;
	boolean isClosed;
	
	public Account() {
		super();
		
	}
	
	
	public Account(long accountNumber, String accountHolderName, double accountBalance, boolean isClosed) {
	super();
	this.accountNumber = accountNumber;
	this.accountHolderName = accountHolderName;
	this.accountBalance = accountBalance;
	this.isClosed = false;
}
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
	
	
	public void deposite(double amount) {
		if (amount > 0) {
			System.out.println();
            accountBalance = accountBalance + amount;
            System.out.println("DEPOSITED : Rs." + amount);
    		System.out.println("******** AMOUNT DEPOSITED SUCCESSFULLY!!! ********");
			System.out.println("BALANCE REMAIN IN ACCOUNT IS : "+accountBalance);
			System.out.println("TRANSACTION DATE : "+LocalDate.now());
    		AccountManagementSystem.logTransaction(accountNumber, "DEPOSITED", accountBalance);
    		System.out.println();
        } 
		else {
            System.out.println("INVALID DEPOSITE AMOUNT . . .");
        }

		System.out.println();
	}
	
	
	public abstract void withdraw(double amount);
	
	public abstract void calculateInterest();
	
	
	public void display() {
        System.out.println("\n=============================");
        System.out.printf("  ACCOUNT NUMBER: %d\n", accountNumber);
        System.out.printf("  HOLDER'S NAME: %s\n", accountHolderName);
        System.out.printf("  BALANCE: Rs. %.3f\n", accountBalance);
        System.out.printf("  STATUS: %s\n", isClosed ? "Closed" : "Active");
        System.out.println("=============================");
    }

}

