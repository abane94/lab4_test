package lab4;

import java.util.Scanner;

public class ATM {
	private Bank bank;
	private String accountEntry;
	private String pinEntry;
	private String entry;
	private Account tmpAccount;

	public ATM(Bank b) {
		accountEntry = null;
		pinEntry = null;
		entry = null;
		bank = b;
		tmpAccount = null;
	}

	public void start() {
		Scanner input = new Scanner(System.in);
		String value;
		System.out.println("Welcome to A Generic Bank(TM)'s ATM");
		System.out.println("-----------------------------------\n");
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

				if (tmpAccount != null) {
					System.out.println("Your account balance is: " + tmpAccount.getBalance());

					System.out.print("Please select Withdraw (W) or Deposit (D): ");
					entry = input.nextLine();
					if (entry.equalsIgnoreCase("W")) {
						System.out.print("Please enter value of withdrawl: $");
						value = input.nextLine();
						tmpAccount.withdrawl(Double.parseDouble(value));
						bank.update(tmpAccount);
					} else if (entry.equalsIgnoreCase("D")) {
						System.out.print("Please enter value of Deposit: $");
						value = input.nextLine();
						tmpAccount.deposit(Double.parseDouble(value));
						bank.update(tmpAccount);
					} else {
						System.out.println("That is not a valid transaction entry.");
					}

					System.out.println("Your new account balance is: $" + tmpAccount.getBalance());

					System.out.println("Thank you for your buisness, and have a nice day!");

				} else {
					System.out.println("Your Account number or PIN number was invalid. Please Start Again.");

				}
			}
		} while (!entry.equalsIgnoreCase("EXIT"));
		System.out.println("ATM shutting down...");
		System.out.println("ATM is off. (Rerun driver to start again.)");
		input.close();
	}
}
