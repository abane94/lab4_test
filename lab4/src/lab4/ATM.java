package lab4;

import java.util.Scanner;

public class ATM{
	Private Bank bank;
	Private String accountEntry;
	Private String pinEntry;
	Private String entry;
	Private Account tmpAccount;
  
  public ATM(Bank b){
	  accountEntry = null;
	  pinEntry = null;
	  entry = null;
	  bank = b;
	  tmpAccount = null;
  }
  
  public void start(){
    do {
	    System.out.println("Please type " + '"' + "EXIT" + '"' + "to close.\n");
	    System.out.print("Please type " + '"' + "START" + '"' + "to begin: ");
	    entry = input.nextLine();
	    if (entry.equalsIgnoreCase("START")) {
		    System.out.print("Please enter an account number: ");
		    accountEntry = input.nextLine();
		    System.out.print("Please enter account Pin Number: ");
		    pinEntry = input.nextLine();
		    
		    tmpAccount = new Account(Integer.parseInt(accountEntry), Integer.parseInt(pinEntry));
		    
		    tmpAccount = bank.validate(tmpAccount);
		    
		    if(tmpAccount != null){
		    	System.out.println("Your account balance is: " + tmpAccount.getBalance());
		    
		    	System.out.print("Please select Withdraw (W) or Deposit (D): ");
		    	entry = input.nextLine();
		    
		    
				
		    	System.out.print("Please enter value of transaction: $");
		    	value = input.nextLine();
		    } else {
			System.out.println("Your Account number or PIN number was invalid."    
		    }
	    }
	} while (!entry.equals("EXIT"));
  }
}
