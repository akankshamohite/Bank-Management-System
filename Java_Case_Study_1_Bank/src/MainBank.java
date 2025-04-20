import java.util.Scanner;

public class MainBank {
	
	//In Java, local variables inside methods cannot have access modifiers like private or protected. 
		//If you're getting the error illegal modifier, it means you are declaring the variables (ADMIN_USERNAME and ADMIN_PASSWORD) as local variables inside a method. 
		//Local variables cannot have these modifiers.(comment is for my reference and understanding)
	private static  String adminUsername = "admin";
    private static  String adminPassword = "satara123";

	public static void main(String[] args) {
		
	
		AccountManagementSystem am = new AccountManagementSystem();
		Scanner sc = new Scanner(System.in);
		
		
	    
		int ch;
		
		do {
			System.out.println("****************************************");
            System.out.println("        WELCOME TO THE BANK");
            System.out.println("****************************************");
            System.out.println("1: CREATE ACCOUNT");
            System.out.println("2: LOGIN");
            System.out.println("3: ADMIN");
            System.out.println("4: EXIT");
            System.out.print("ENTER YOUR CHOICE : ");
            ch = sc.nextInt();
			
			System.out.println();
			
			switch(ch) {
			case 1:
				Account[] accounts = am.createAccount();
				break;
				
			case 2:
				System.out.println();
				System.out.println("\n********  WELCOME TO LOG IN  ********");
				System.out.println();
				System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
				long accountNumber = sc.nextLong();
				
				System.out.println();
				
				Account a1=AccountManagementSystem.searchAccount(accountNumber);
				
				
				if(a1==null)
						System.out.println("\n******** ACCOUNT NOT FOUND ********");
				else
				{
					
					int choice;
					do {
				     
					System.out.println("\n********  MENU  *******\n");
					System.out.println("1. DEPOSITE");
					System.out.println("2. WITHDRAW");
					System.out.println("3. CALCULATE INTEREST");
					System.out.println("4. DISPLAY BALALNCE");
					System.out.println("5. EXITING...");
					System.out.println();
					System.out.print("ENTER YOUR CHOICE : ");
					choice=sc.nextInt();	
				
					System.out.println();
					
						 switch(choice)
						 {
						 	case 1: 
						 		System.out.print("HOW MUCH AMOUNT YOU WANT TO DEPOSITE :");
						 		double amt=sc.nextDouble();
						 		a1.deposite(amt);
						 		System.out.println();
						 		break;
						 			
						 	case 2:
						 	    if (a1 instanceof LoanAccount) {
						 	        System.out.println("\n******** WITHDRAW IS NOT ALLOWED FOR LOAN ACCOUNT! ! ! ******");
						 	    } else {
						 	        System.out.print("HOW MUCH AMOUNT YOU WANT TO WITHDRAW: ");
						 	        double amt1 = sc.nextDouble();
						 	        a1.withdraw(amt1);
						 	    }
						 	    System.out.println();
						 	    break;
						 	    
							        
						 	case 3:
						 		a1.calculateInterest();
						 		System.out.println();
						 		break;
							 
						 	case 4:
						 		System.out.println("YOUR BALANCE IS : "+a1.getAccountBalance());
						 		System.out.println();
						 		break;
							 
						 	case 5:
						 		System.out.println("\n******** SUCESSFULLY EXIT!!! ********");
						 		System.out.println();
						 		break;
							 
						 }
					}while(choice!=5);
				}
				
				break;
				
			case 3:
                System.out.println("\n********  WELCOME TO ADMIN  ********");

                System.out.print("ENTER ADMIN USERNAME: ");
                String username = sc.next();
                System.out.print("ENTER ADMIN PASSWORD: ");
                String password = sc.next();
				
                if(username.equals(adminUsername) && password.equals(adminPassword)) {
				int adminChoice;
			    do {
			    	
			        System.out.println("\nADMIN MENU:");
			        System.out.println("1. DAILY REPORT");
			        System.out.println("2. CLOSE ACCOUNT");
			        System.out.println("3. DISPLAY ALL ACCOUNTS");
			        System.out.println("4. EXIT ADMIN MENU");
			        System.out.print("ENTER YOUR CHOICE: ");
			        adminChoice = sc.nextInt();

			        switch (adminChoice) {
			            case 1:
			                am.displayDailyReport();
			                break;
			            case 2:
			                am.closeAccount();
			                break;
			            case 3:
			                am.displayAllAccounts();
			                break;
			            case 4:
			                System.out.println("\n******** EXITING ADMIN MENU! ! ! ********");
			                break;
			            default:
			                System.out.println("INVALID CHOICE. TRY AGAIN.");
			        }
			    } while (adminChoice != 4);
			    
               }
                break;
			}
	}while(ch!=4);
  }
}




	
