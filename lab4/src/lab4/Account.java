import java.math.BigDecimal;

public class Account {
	
	private int accountNumber;
	private int pin;
	private double balance;
	
	public Account(int a; int p;){
		accountNumber = a;
		pin = p;
		balance = 0;
	}
	
	public Account(int a; int p; int b){
		accountNumber = a;
		pin = p;
		balance = b;
	}
	
	public boolean validate(int p){
		if(p == pin) return true;
		return false;
	}
	
	public double withdrawl(double amount){
		if(balance >= amount){
			balance = balance - amount;
			return balance;
		}
		else{
			return balance;
		}
	}
	
	public double deposit(double amount){
		balance = balance + amount;
		return balance;
	}
}
