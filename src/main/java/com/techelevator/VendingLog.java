package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		
		try(PrintWriter output = new PrintWriter(new FileWriter(path, true))) {
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
			
			output.printf("%s %-15s %-5s %-10s %n", timeStamp, action, money, currentBalance);
		}
		
	}
	
	public void logData(String item, String slotID, BigDecimal currentFunds, BigDecimal balance) throws IOException {
		try(PrintWriter output = new PrintWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
			String action = "";
			String money = "";
			String currentBalance = "";
			
			action = item + " " + slotID;
			money = "$" + balance;
			currentBalance = "$" + currentFunds;
			
			output.printf("%s %-15s %-5s %-10s %n", timeStamp, action, currentBalance, money);
		}
	}
	
}
