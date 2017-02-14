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
		    	if(entry.equalsIgnoreCase("W"){	
		    		System.out.print("Please enter value of withdrawl: $");
		    		value = input.nextLine();
				tmpAccount.withdrawl(Double.parseDouble(value));
			}
			if(entry.equalsIgnoreCase("D"){	
		    		System.out.print("Please enter value of Deposit: $");
		    		value = input.nextLine();
				tmpAccount.deposit(Double.parseDouble(value));
			}
			   
			System.out.println("Your new account balance is: $" + tmpAccount.getBalance());
			   
		    } else {
			System.out.println("Your Account number or PIN number was invalid."    
		    }
	    }
	} while (!entry.equalsIgnoreCase("EXIT"));
  }
}
