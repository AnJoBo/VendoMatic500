package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendingLog {

	private String path = "log-file.txt";
	private File vendingLog = new File(path);
	
	public void createLog() throws IOException {
		vendingLog.createNewFile();
	}
	
	public void logData(boolean feed, BigDecimal exchange, BigDecimal currentFunds) throws IOException {
		
		try(Writer output = new BufferedWriter(new FileWriter(path, true))
				/*PrintWriter writer = new PrintWriter(path)*/) {
			String line = "";
			
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
			String action = "";
			String money = "";
			String currentBalance = "";
			
			if(feed) {
				action = "FEED MONEY:";
				money = "$" + exchange.toString();
				currentBalance = "$" + currentFunds.toString();
			} else {
				action = "GIVE CHANGE:";
				money = "$" + exchange.toString();
				currentBalance = "$" + currentFunds.toString();
			}
			
			output.append(line);
					/*printf("%s %10s %s %10s %n", timeStamp, action, money, currentBalance));*/
		}
	}
	
	public void logData(String item, String slotID, BigDecimal currentFunds, BigDecimal balance) throws FileNotFoundException {
		try(PrintWriter writer = new PrintWriter(path)) {
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
			String action = "";
			String money = "";
			String currentBalance = "";
			
			action = item + " " + slotID;
			money = "$" + balance;
			currentBalance = "$" + currentFunds;
			
			writer.printf("%s %10s %s %10s %n", timeStamp, action, currentBalance, money);
		}
	}
	
	public String lineGenerator(boolean feed) {
		String line = "";
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
		String action = "";
		String money = "";
		String currentBalance = "";
		
//		if(feed) {
//			action = "FEED MONEY:";
//			money = "$" + exchange.toString();
//			currentBalance = "$" + currentFunds.toString();
//		} else {
//			action = "GIVE CHANGE:";
//			money = "$" + exchange.toString();
//			currentBalance = "$" + currentFunds.toString();
//		}
		
		
		
		return line;
	}
	
}
