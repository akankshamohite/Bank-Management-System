
public class LoanAccount extends Account{
	
	static double  interestRate = 15;
	static double loanAmount = 80000;
	double repayAmount;
	
	public LoanAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoanAccount(long accountNumber, String accountHolderName, double accountBalance, boolean isClosed,
			double repayAmount) {
		super(accountNumber, accountHolderName, accountBalance, isClosed);
		this.repayAmount = repayAmount;
	}

	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double interestRate) {
		LoanAccount.interestRate = interestRate;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(double repayAmount) {
		this.repayAmount = repayAmount;
	}
	
	
	
	@Override
	public void withdraw(double amount) {
		System.out.println("******** NOT APPLICABLE ! ! ! ********");
		
	}
	@Override
	public void calculateInterest() {
        double timePeriod = 1; // Default time period (1 year)
        double interest = (loanAmount * interestRate * timePeriod) / 100;
        
        System.out.println("INTEREST ON LOAN : " + interest);
        double totalRepayAmount = loanAmount + interest;
        System.out.println("TOTAL REPAYBALE AMOUNT : " + totalRepayAmount);
	}
	
	

}
