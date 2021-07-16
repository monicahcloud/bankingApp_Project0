import java.util.Scanner;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Employee;
import com.example.models.User;

import com.example.services.UserServices;


public class BankApplicationDriver {
	
	
	public static void main(String[] args) {
		
		UserDao uDao = new UserDaoDB();
		UserServices uServ = new UserServices(uDao);
		
		uServ.signUp("Moe", "Clark", "monicahcloud@revature.net", "password1");
//		System.out.println(uDao.getAllUsers());
		
//		Employee emp = new Employee();
//	 
//		System.out.println("Thank you for trusting First Bank with all of your banking needs.\n");
//		Scanner in = new Scanner(System.in);
//		
//		while(true) {
//	
//		System.out.println("Press 1 to Signup in the your account or Press 2 to Login for a new account or Please 3 to logout!");
//		
//		int choice = Integer.parseInt(in.nextLine());
//		
//			if(choice == 1) {
//		}else if(choice == 2) {
//						
//		uServ.login(null, null);
//		
//		}
//			}

	
}}
		