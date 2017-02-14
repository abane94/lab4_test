package lab4;

import java.util.Scanner;

public class ATM{
  Private String accountEntry;
  Private String pinEntry;
  Private String entry;
  
  public ATM(){
    System.out.println("Welcome to FakeBank (TM) ATM");
		System.out.println("----------------------------\n");
    accountEntry = null;
    pinEntry = null;
    entry = null;
  }
  
  public void start(){
    do {
      System.out.println("Please type " + '"' + "EXIT" + '"' + "to close.\n");
			System.out.print("Please type " + '"' + "START" + '"' + "to begin: ");
			entry = input.nextLine();
			if (entry.equalsIgnoreCase("START")) {
				System.out.print("Please enter an account number: ");
				account = input.nextLine();
        
				System.out.print("Please enter account Pin Number: ");
				pin = input.nextLine();
				
				System.out.print("Please select Withdraw (W) or Deposit (D): ");
				action = input.nextLine();
				
				System.out.print("Please enter value of transaction: $");
				value = input.nextLine();
			}

		} while (!entry.equals("EXIT"));
  }
}
