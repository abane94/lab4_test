package lab4;

public class ATM_driver {
	public static void main(String[] args) {
		Bank bank = new Bank("../data.txt");
		ATM atm = new ATM(bank);
		atm.start();
	}
}
