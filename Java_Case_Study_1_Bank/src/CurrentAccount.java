import java.time.LocalDate;

public class CurrentAccount extends Account{
	
	static double overDraftLimit=100000;

	public CurrentAccount() {
		super();
		
		
	}

	public CurrentAccount(long accountNumber, String accountHolderName, double accountBalance, boolean isClosed) {
		super(accountNumber, accountHolderName, accountBalance, isClosed);
	}

	public static double getOverDreftLimit() {
		return overDraftLimit;
	}

	public static void setOverDreftLimit(double overDraftLimit) {
		CurrentAccount.overDraftLimit = overDraftLimit;
	}
	


	@Override
	public void withdraw(double amount) {
		if (accountBalance - amount >= -overDraftLimit) {
			accountBalance = accountBalance - amount;
            System.out.println("WITHDRAWN: Rs." + amount);
            System.out.println("******** AMOUNT WITHDRAW SUCCESSFULLY!!! ********");
			System.out.println("BALANCE REMAIN IN ACCOUNT IS : "+accountBalance);
			System.out.println("TRANSACTION DATE : "+LocalDate.now());
            AccountManagementSystem.logTransaction(accountNumber, "WITHDRAWN", accountBalance);
            System.out.println();
        } else {
            System.out.println("******** OVERDRAFT LIMIT EXCEEDED!!! ********");
            System.out.println();
        }
		System.out.println();
    }
		

	@Override
	public void calculateInterest() {
		System.out.println("******** NOT APPLICABLE ! ! ! ********");
	}
	
}
