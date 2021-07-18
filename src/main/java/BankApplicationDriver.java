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
		
		System.out.println();
		UserDao uDao = new UserDaoDB();
		AccountDao aDao = new AccountDaoDB();
		TransactionDao tDao = new TransactionDaoDB();
		UserServices uServ = new UserServices(uDao);
		AccountServices aServ = new AccountServices(aDao);
//		TransactionServices tServ = new TransactionServices(tDao);
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Thank you for trusting First Bank with all of your banking needs.\n");
		
		User u = null;
		
//		System.out.println(uDao.getUserByUsername("JadaPickett-Smith4961"));
		
		
		while(true) {
		System.out.println("Press 1 to Signup in the your account or Press 2 to Login for a new account or Please 3 to logout!");
		
		int choice = Integer.parseInt(in.nextLine());
		
		if(choice == 1) {
			System.out.println("To register for an account you will need to make an initial deposit of $50\n"
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
			
			System.out.println("Please deposit an initial balance of at least $50 to open this account. ");
			double initialBalance = in.nextDouble();
			in.nextLine();
			
			if(initialBalance >= 50) {
				
				u = uServ.signUp(first, last, email, password);//create customer
				a = aServ.createAccount(u.getId(), initialBalance, acctType);//create account
				//bank.addCustomer(customer);//add to customers array
				
				System.out.println("You have successfully registered for an account.");
					
				System.out.println("Your username is " + u.getUsername() + " and your password is " + u.getPassword());
				//System.out.println("Your starting balance is " + u.getAccount().getBalance());
				System.out.println();
				
			}else {
				System.out.println("You did not meet the requirements to open an account.");
				
			}
			
		}else if (choice == 2) {//login
			
			System.out.println("Please enter your username:   ");
			String username = in.nextLine();
			
			System.out.println("Please enter your password:   ");
			String password = in.nextLine();
			
			u= uServ.login(username, password);
			System.out.println("Welcome " + u.getFirstName() + " " + u.getLastName());
			
			for(User user: uDao.getAllUsers()) {
			if(u.getUsername().equals(username) && password.equals(u.getPassword())) {
					System.out.println(u.getFirstName() +" " + u.getLastName() + ": You have successfully logged into your account.\nPlease select one of the following options.");
					
					System.out.println( );
					System.out.println("1. View balance.");
					System.out.println("2. Make a deposit .");
					System.out.println("3. Make a withdrawal.");
					System.out.println("4. View last transactions.");
					System.out.println("5. Make a transfer");
					System.out.println("6. Logout");
					
					int option = Integer.parseInt(in.nextLine());
					
					switch (option) {
					
					case 1://view balance
						t.inquiry();
						
						break;
					case 2: //make a deposit
						double amount;
						System.out.println("How much are you depositing into this account?");
						amount= Double.parseDouble(in.nextLine());
						t.makeDeposit(amount);
						break;
					case 3: //make a withdrawal
						double amount2;
						System.out.println("How much are you withdrawing from this account?");
						amount2= Double.parseDouble(in.nextLine());
						t.makeWithdrawal(amount2);
						break;
					case 4://view last transactions
						System.out.println("Your previous transaction is: ");
						t.viewPreviousTransaction();
						break;
					case 5://make transfer
						break;
					case 6://log out
						System.out.println("Thank you for trusting us with all of your banking needs.");
						break;					
					}
				}
			
			}			
		}else if (choice == 3) {
			System.out.println("Thanks for trusting us with all of your banking needs.\n");
			break;
		} else {
			System.out.println("Invalid input.");
		}
		
}}}
		