package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class Bank {
	TreeMap<Integer, Account> map = new TreeMap<Integer, Account>();
	String path;
	String header;

	/*
	 * this constructor reads in the data file containing the individual
	 * accounts and stores them in a map with the key being the account number
	 * and the value being the account object
	 */
	public Bank(String dataPath) {
		File data = new File(dataPath);
		FileReader r = null;
		try {
			r = new FileReader(data);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader;
		String line;
		try {
			reader = new BufferedReader(r);
			header = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String[] accountData = line.split(",");
				int num = Integer.parseInt(accountData[0]);
				int pin = Integer.parseInt(accountData[1]);
				double balance = Integer.parseInt(accountData[2]);
				Account curr = new Account(num, pin, balance);
				map.put(num, curr);

				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * validaes the account, given an account object this will return the full
	 * object (with balance) if the credentials match. if not retrun null
	 */
	public Account validate(Account temp) {
		int queryNum = temp.getAccountNumber();
		Account result;
		if (map.containsKey(queryNum))
			result = map.get(queryNum);
		else
			return null;

		if (temp.getPin() != result.getPin())
			return null;
		if (result.validate(temp.getPin()))
			return result;
		else
			return null;
	}

	// puts an already existing account in the map with an updated balance
	public boolean update(Account temp) {
		if (map.containsKey(temp.getAccountNumber())) {
			map.put(temp.getAccountNumber(), temp);
			return true;
		}
		return false;
	}

	// saves the accounts back to the file
	public void close() {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);

			bw.write(header);
			Set<Integer> keysSet = map.keySet();
			Object[] keys = keysSet.toArray();
			Account curr;
			for (int i = 0; i < keys.length; i++) {
				curr = map.get(keys[i]);
				bw.write(curr.toString());
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
