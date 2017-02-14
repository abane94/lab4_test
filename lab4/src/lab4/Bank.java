package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Bank {
	TreeMap<Integer, Account> map = new TreeMap<Integer, Account>();
	String path;
	String header;
	public Bank(String dataPath){
		File data = new File(dataPath);
		FileReader r = new FileReader(data);
		BufferedReader reader;
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
	
	public Account validate(Account temp){
		int queryNum = temp.getAccountNumber();
		Account result;
		if (map.contains(queryNum)
		    result = map.get(queryNum);
		else
		    return null;
		
		if(temp.getPin() != result.getPin()){
			return null;
		if (result.validate())
		    return result;
		else
		    return null;
	}
		    
	
	public boolean update(Account temp){
		if (map.contains(temp.getAccountNumber())){
			map.push(temp.getAccountNumber(), temp);
			return true;
		}
		return false;
	}
		    
	public void close(){
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			
			bw.erite(header);
			int[] keys = map.keys();
			Account curr;
			for( int i = 0; i < keys.length; i++){
				curr = map.get(keys[i]);
				bw.write(
			}

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
		    
}
