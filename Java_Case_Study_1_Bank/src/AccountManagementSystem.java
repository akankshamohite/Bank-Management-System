import java.time.LocalDate;
import java.util.Scanner;

public class AccountManagementSystem {

		static Account[] accounts=new Account[100];
		static int count=0;
		
		static String[] transactionLog = new String[100]; // Array for transaction logs
	    static int transactionCount = 0; // Tracks number of transaction logs
	    
	    private static long accountNumberCounter = 1000;
	    
	    
		Scanner sc = new Scanner(System.in);
		int ch;
		
		
		public Account[] createAccount() {
	        System.out.println("\n=================================");
	        System.out.println("  ACCOUNT CREATION MENU");
	        System.out.println("=================================");
	        System.out.print("  1. SAVING ACCOUNT\n  2. SALARY ACCOUNT\n  3. CURRENT ACCOUNT\n  4. LOAN ACCOUNT\n");
	        System.out.print("  ENTER YOUR ACCOUNT CHOICE: ");
	        ch=sc.nextInt();
	        
			switch(ch)
			{
			case 1:
				createSavingAccount();
				return accounts;
				
			case 2:
				createSalaryAccount();
				System.out.println("SALARY ACCOUNT\n");
				return accounts;
//				break;
				
			case 3:
				createCurrentAccount();
				System.out.println("CURRENT ACCOUNT\n");
				return accounts;
//				break;
				
			case 4:
				createLoanAccount();
				System.out.println("LOAN ACCOUNT\n");
				return accounts;
//				break;
			
			}
			
			return accounts;
		}





		private void createSavingAccount() {

			System.out.println();
			System.out.println("SAVING ACCOUNT\n");
			long accountNumber = generateAccountNumber();
	        System.out.println("GENERATED ACCOUNT NUMBER: " + accountNumber);
			System.out.print("ENTER ACCOUNT HOLDER's NAME :");
			String accountHolderName = sc.next();
			System.out.print("ENTER BALANCE :");
			double accountBalance = sc.nextDouble();
			
			
			if(accountBalance < 10000) {
				System.out.println("INSUFFICIENT BALANCE... YOUR MINIMUM BALANCE SHOULD BE 10000!!!");
				return;
			}
			accounts[count++]=new SavingAccount(accountNumber,accountHolderName,accountBalance, false);
			System.out.println();
			System.out.println("YOUR SAVING ACCOUNT FOR ACCOUNT NUMBER "+accountNumber+" IS CREATED SUCCESSFULLY!!!");
			System.out.println();
		}

		
		
		private void createSalaryAccount() {
			System.out.println();
			System.out.println("SALARY ACCOUNT\n");
			long accountNumber = generateAccountNumber();
	        System.out.println("GENERATED ACCOUNT NUMBER: " + accountNumber);
			System.out.print("ENTER ACCOUNT HOLDER's NAME :");
			String accountHolderName = sc.next();
			System.out.print("ENTER SALARY AMOUNT :");
			double accountBalance = sc.nextDouble();
			
			accounts[count++]=new SalaryAccount(accountNumber,accountHolderName,accountBalance, false, false, ch, null);
			System.out.println();
			System.out.println("YOUR SALARY ACCOUNT FOR ACCOUNT NUMBER "+accountNumber+" IS CREATED SUCCESSFULLY!!!");
			System.out.println();
			
		}
		
		
		
		private void createCurrentAccount() {
			
			System.out.println();
			System.out.println("CURRENT ACCOUNT\n");
			long accountNumber = generateAccountNumber();
	        System.out.println("GENERATED ACCOUNT NUMBER: " + accountNumber);
			System.out.print("ENTER ACCOUNT HOLDER's NAME :");
			String accountHolderName = sc.next();
			System.out.print("ENTER BALANCE :");
			double accountBalance = sc.nextDouble();
			
			accounts[count++]=new CurrentAccount(accountNumber,accountHolderName,accountBalance, false);
			System.out.println();
			System.out.println("YOUR CURRENT ACCOUNT FOR ACCOUNT NUMBER "+accountNumber+" IS CREATED SUCCESSFULLY!!!");
			System.out.println();
			
		}

		

		private void createLoanAccount() {
			System.out.println();
			System.out.println("LOAN ACCOUNT\n");
			long accountNumber = generateAccountNumber();
	        System.out.println("GENERATED ACCOUNT NUMBER: " + accountNumber);
			System.out.print("ENTER ACCOUNT HOLDER's NAME :");
			String accountHolderName = sc.next();
			System.out.print("ENTER LOAN AMOUNT :");
			double accountBalance = sc.nextDouble();
			
			accounts[count++]=new LoanAccount(accountNumber,accountHolderName,accountBalance, false, accountBalance);
			System.out.println();
			System.out.println("YOUR LOAN ACCOUNT FOR ACCOUNT NUMBER "+accountNumber+" IS CREATED SUCCESSFULLY!!!");
			System.out.println();
			
		}

		
		
		public static Account searchAccount(long accountNumber) {
			
			for(int i=0;i<count;i++)
			{
				if(accounts[i].getAccountNumber()==accountNumber)
					return accounts[i];
			}
			
			return null;
		}
		
		public static void logTransaction(long accountNumber, String status, double balance) {
	        if (transactionCount < transactionLog.length) {
	            transactionLog[transactionCount++] = accountNumber + "," + status + "," + LocalDate.now() + "," + balance;
	        } else {
	            System.out.println("TRANSACTION DATABASE IS FULL!");
	        }
	    }

	    public void closeAccount() {
	        System.out.print("ENTER ACCOUNT NUMBER TO CLOSE: ");
	        long accountNumber = sc.nextLong();
	        Account account = searchAccount(accountNumber);

	        if (account != null) {
	            account.setClosed(true);
	            logTransaction(accountNumber, "Account Closed", account.getAccountBalance());
	            System.out.println("\nACCOUNT " + accountNumber + " HAS BEEN CLOSED.");
	            System.out.println("***********************************************");
	        } else {
	            System.out.println("\nACCOUNT NOT FOUND.");
	        }
	    }

	    public void displayAllAccounts() {
	        System.out.println("ALL ACCOUNTS:");
	        for (int i = 0; i < count; i++) {
	            Account account = accounts[i];
	            System.out.println("\n Account Number: " + account.getAccountNumber() +
	                    "\n Holder Name: " + account.getAccountHolderName() +
	                    "\n Balance: " + account.getAccountBalance() +
	                    "\n Status: " + (account.isClosed() ? "Closed" : "Open"));
	        }
	    }


	    public void displayDailyReport() {
			System.out.println("******** Daily Report ********");
	        System.out.println("Acc No\t\t Status\t\t\tDate\t\t\tBalance");

	        for (int i = 0; i < transactionCount; i++) {
	        	String[] details = transactionLog[i].split(",");
	            System.out.println(details[0] + "\t\t" +
	            		details[1] + "\t\t" +
	            		details[2] + "\t\t" +
	            		details[3] + "\t\t");
	        }
	        System.out.println();	
		}
	    
	    
	    private static long generateAccountNumber() {
	        return accountNumberCounter++;
	    }
}
	

