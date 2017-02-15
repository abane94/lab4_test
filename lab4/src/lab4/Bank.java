package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
			line = reader.readLine();
			while(line != null){
				String[] accountData = line.split(" ");
        			int num = Integer.parseInt(accountData[0]);
        			int pin = Integer.parseInt(accountData[1]);
        			double balance = Integer.parseInt(accountData[2]);
				Account curr = new Account(num, pin, balance);
				map.put(num, curr);
        
        			line = reader.readLine();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Account validate(Account temp){
		int queryNum = temp.getAccountNumber();
		Account result;
		if (map.containsKey(queryNum)
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
			
			bw.write(header);
			Set<Integer> keysSet = map.keySet();
			Object[] keys = keysSet.toArray();
			Account curr;
			for( int i = 0; i < keys.length; i++){
				curr = map.get(keys[i]);
				bw.write(curr.toString());
			}

			fw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		    
}
