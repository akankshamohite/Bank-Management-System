import java.time.LocalDate;

public class SavingAccount extends Account {
	
	static double  interestRate=20;
	static double  minBalance=10000;

	

	public SavingAccount() {
		super();
		
	}
	



	public SavingAccount(long accountNumber, String accountHolderName, double accountBalance, boolean isClosed) {
		super(accountNumber, accountHolderName, accountBalance, isClosed);
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(double interestRate) {
		SavingAccount.interestRate = interestRate;
	}

	public static double getMinBalance() {
		return minBalance;
	}

	public static void setMinBalance(double minBalance) {
		SavingAccount.minBalance = minBalance;
	}
	
	
	
	public void withdraw(double amount) {

			if (amount > 0) {
				if(accountBalance > getMinBalance()) {
	            accountBalance = accountBalance - amount;
	            System.out.println("WITHDRAW : Rs." + amount);
	            System.out.println("******** AMOUNT WITHDRAW SUCCESSFULLY!!! ********");
				System.out.println("BALANCE REMAIN IN ACCOUNT IS : "+accountBalance);
				System.out.println("TRANSACTION DATE : "+LocalDate.now());
				AccountManagementSystem.logTransaction(accountNumber, "WITHDRAWN", accountBalance);
				System.out.println();
				}
	        } else {
	            System.out.println("INVALID WITHDRAW AMOUNT.");
	            System.out.println();
	        }
			System.out.println();
		}

	
	
	@Override
	public void calculateInterest() {
		
		double interestAmount= (getAccountBalance() * interestRate)/100;
		double newBalance = getAccountBalance() + interestAmount;
		
		System.out.println("ACCOUNT BALANCE : "+getAccountBalance());
		System.out.println("INTEREST EARNED : "+interestAmount);
		System.out.println("NEW BALANCE AFTER INTEREST : "+newBalance);
		
		
	}
}

