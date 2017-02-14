package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Bank {
	TreeMap<Integer, Account> map = new TreeMap<Integer, Account>();
	public Bank(String dataPath){
		File data = new File(dataPath);
		FileReader r = new FileReader(data);
		BufferedReader reader;
		String header;
		String line;
		try{
			reader = new BufferedReader(r);
			header = reader.readLine();
			line = reader.readLine()
			while(line != null){
				String[] accountData = line.split(" ");
        int num = Interger.parseInt(accountData[0]);
        int pin = Interger.parseInt(accountData[1]);
        double balance = Interger.parseInt(accountData[2]);
				Account curr = new Account(num, pin, balance);
				map.put(num, curr);
        
        line = reader.readLine();
			}
		}
		catch(Exception e){
			
		}
	}
}
