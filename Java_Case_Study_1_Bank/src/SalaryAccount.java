
import java.time.LocalDate;
import java.time.Period;

public class SalaryAccount extends SavingAccount {
    
    boolean accountFreeze = true;
    private static final int TRANSACTION_LIMIT = 1;
    private int transactions = 0;
    LocalDate lastTransactionDate;
    
    public SalaryAccount() {
        super();
        this.lastTransactionDate = LocalDate.now();
    }
    
    public SalaryAccount(long accountNumber, String accountHolderName, double accountBalance, boolean isClosed,
			boolean accountFreeze, int transactions, LocalDate lastTransactionDate) {
		super(accountNumber, accountHolderName, accountBalance, isClosed);
		this.accountFreeze = accountFreeze;
		this.transactions = transactions;
		this.lastTransactionDate = LocalDate.now();
	}
    

	public boolean isAccountFreeze() {
        return accountFreeze;
    }
    
    public void setAccountFreeze(boolean accountFreeze) {
        this.accountFreeze = accountFreeze;
    }
    
    public int getTransactions() {
        return transactions;
    }
    
    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }
    
    public static int getTransactionLimit() {
        return TRANSACTION_LIMIT;
    }
    
    @Override
    public void withdraw(double amount) {
        LocalDate withdrawDate = LocalDate.now();
        checkValidity(withdrawDate);
        if (accountFreeze) {
            if (amount > 0 && accountBalance >= amount) {
                accountBalance -= amount;
                lastTransactionDate = withdrawDate;
                System.out.println("WITHDRAWN: Rs." + amount);
                System.out.println("******** AMOUNT WITHDRAWN SUCCESSFULLY!!! ********");
                System.out.println("BALANCE REMAIN IN ACCOUNT IS : "+accountBalance);
                System.out.println("TRANSACTION DATE : "+LocalDate.now());
                AccountManagementSystem.logTransaction(accountNumber, "WITHDRAWN", accountBalance);
                System.out.println();
            } else {
                System.out.println("INSUFFICIENT BALANCE OR INVALID AMOUNT.");
                System.out.println();
            }
        } else {
            System.out.println("ACCOUNT IS FROZEN. CANNOT WITHDRAW.");
            System.out.println();
        }
    }
    
    @Override
    public void calculateInterest() {
        System.out.println("******** NOT APPLICABLE ! ! ! ********");
        System.out.println();
    }
    
    public void checkValidity(LocalDate withdrawDate) {
        if (lastTransactionDate != null) {
            Period p = Period.between(lastTransactionDate, withdrawDate);
            accountFreeze = p.getDays() < 60;
        } else {
            accountFreeze = true; 
        }
    }
}

