import java.util.Scanner;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.TransactionDao;
import com.example.dao.TransactionDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Account;
import com.example.models.Employee;
import com.example.models.Transactions;
import com.example.models.User;
import com.example.services.AccountServices;
import com.example.services.TransactionServices;
import com.example.services.UserServices;


public class BankApplicationDriver {
	
	
	public static void main(String[] args) {
		Account a;
		Transactions t= new Transactions();	
		
		UserDao uDao = new UserDaoDB();
		AccountDao aDao = new AccountDaoDB();
		//TransactionDao tDao = new TransactionDaoDB();
		UserServices uServ = new UserServices(uDao);
		AccountServices aServ = new AccountServices(aDao);
		//TransactionServices tServ = new TransactionServices(tDao);
		User u1 = uDao.getUserByUsername("MonicahCloud5943");
		System.out.println(u1);
		//uDao.deleteUser(u);
		System.out.println(uDao.getAllUsers());
		System.out.println(aDao.getAccountByUser(u1));
		System.out.println(aDao.getAllAccounts());
		
		
		//aDao.makeDeposit("MonicahCloud5943", 5100);
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("*******************************************************************************");
		System.out.println();
		System.out.println("Thank you for trusting First Bank with all of your banking needs.\n");
		System.out.println();
		System.out.println("*******************************************************************************");
//		
//		System.out.println(uDao.getUserByUsername("JadaPickett-Smith4357"));
//		
//		System.out.println( uDao.getAllUsers());
	
//	System.out.println( aDao.getUserAccount("JadaPickett-Smith4357"));
		User u = null;
		
		while(true) {
		System.out.println("Press 1 to Signup for a new account or Press 2 to Login for a new account or Please 3 to logout!");
		
		int choice = Integer.parseInt(in.nextLine());
		
		if(choice == 1) { //Signup
			
			System.out.println();
			System.out.println("To create an account you will need to make an initial deposit of $50\n"
					+ " for the account to be approved.\n");
			System.out.println("What kind of account would you like to open? CHECKING or SAVINGS!");
			String acctType= in.nextLine().toUpperCase();
			
				if(!"CHECKING".equals(acctType) && !"SAVINGS".equals(acctType)){
					System.out.println("Please enter Checking or Savings");		
					continue;
				}
				
			System.out.println("Please enter your First Name:   ");
			String first = in.nextLine();
			
			System.out.println("Please enter your Last Name:   ");
			String last = in.nextLine();
			
			System.out.print("Please enter your email: ");
			String email = in.nextLine();
			
			System.out.println("Please enter a password:   ");
			String password = in.nextLine();
			
			System.out.println("How much will you be depositing as your opening balanace?");
			int initialBalance = in.nextInt();
			in.nextLine();
			
			if(initialBalance >= 50) {
				
				u = uServ.signUp(first, last, email, password);//create customer
				a = aServ.createAccount(u.getId(), initialBalance, acctType);//create account
				
				System.out.println("You have successfully registered for a new account.");
				System.out.println();	
				System.out.println("Your username is " + u.getUsername() + " and your password is " + u.getPassword());
				//System.out.println("Your starting balance is " + u.getAccount().getBalance());
				System.out.println();
				
			}else {
				System.out.println("You did not meet the requirements to open an account.");
				
			}//End of signup
			
		}else if (choice == 2) {//login
			
			System.out.println("Please enter your username:   ");
			String username = in.nextLine();
			
			System.out.println("Please enter your password:   ");
			String password = in.nextLine();
			
			u= uServ.login(username, password);
			System.out.println("\nWelcome " + u.getFirstName() + " " + u.getLastName());
			System.out.println();
			
			while(true) {
				boolean flag = false;

					System.out.println("\n" +u.getFirstName() +" " + u.getLastName() + ": You have successfully logged into your account.\n\nPlease select from the following options.");
					System.out.println( );
					System.out.println("1. View balance.");
					System.out.println("2. Make a deposit .");
					System.out.println("3. Make a withdrawal.");
					System.out.println("4. Make a transfer.");
					System.out.println("5. Logout");
				
					
					int option = Integer.parseInt(in.nextLine());
					
					switch (option) {
					
					case 1://view balance
						
						System.out.println("*********************************************");
						System.out.println("Your current balance is:  $" + aDao.getAccountByUser(u).getCurrentBalance());
						System.out.println("**********************************************");
										
						break;
					case 2: //make a deposit
						int amount;
						System.out.println("How much are you depositing into this account?");
						amount= Integer.parseInt(in.nextLine());
						System.out.println("************************************");
						aDao.makeDeposit(u, amount);
						System.out.println("Deposited:  $" + amount);
						System.out.println("Your new balance is:  $" + aDao.getAccountByUser(u).getCurrentBalance() );
						System.out.println("************************************");
						break;
					case 3: //make a withdrawal
						int amount2;
						System.out.println("How much are you withdrawing from this account?");
						amount2= Integer.parseInt(in.nextLine());
											
						System.out.println("************************************");
						aDao.withDrawal(u, amount2);
						System.out.println("Requested Withdrawal Amount:  $" + amount2);
						System.out.println("Your new balance is:  $" + aDao.getAccountByUser(u).getCurrentBalance() );
						//						System.out.println("We're unable to complete this transaction. Please try again later.");
						System.out.println("************************************");
						break;
					case 4://make transfer
//						double amount3;
//						System.out.println("How much are you withdrawing from this account?");
//						amount3= Double.parseDouble(in.nextLine());
//						
//						System.out.println("************************************************************************************");
//						System.out.println("Transfer is successful. " + " The new balance in " + acctType  + "'s account is "+ acctBalance);
//						System.out.println("Transfer received. $" + acct.acctBalance + " was deposited into " + acct.acctType  + " 's account.");
//						System.out.println("*************************************************************************************");
						break;
					case 5://log out
						flag = true;
						System.out.println("Thank you for trusting us with all of your banking needs.");
						break;					
					}
					if(flag) {break;}
			}
					
		}else if (choice == 3) {
			System.out.println("Thanks for trusting us with all of your banking needs.\n");
			break;
		} else {
			System.out.println("Invalid input.");
		}
		
		
}}}
		