package lab4;

public class Account {
	
	private int accountNumber;
	private int pin;
	private double balance;
	
	public Account(int a, int p){
		accountNumber = a;
		pin = p;
		balance = 0;
	}
	
	public Account(int a, int p, double b){
		accountNumber = a;
		pin = p;
		balance = b;
	}
	
	public boolean validate(int p){
		if(p == pin) return true;
		return false;
	}
	
	public boolean withdrawl(double amount){
		if(balance >= amount){
			balance = balance - amount;
			return true;
		}
		System.out.println("This transcraction could not be completed");
		return false;
	}
	
	public void deposit(double amount){
		balance = balance + amount;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getPin(){
		return pin;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public String toString(){
		return "" + accountNumber + " " + pin + " " + balance;
	}
}
