package com.ajborkowski;

//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendingLog {

	private String path = "log-file.txt";
//	private File vendingLog = new File(path);
	
	// I may want to setup a way to create a new file (if not present) with a "heading" and descriptive titles
	
//	public void createLog() throws IOException {
//		vendingLog.createNewFile();
//	}
	
	// Logging for when money is being fed or returned
	public void logData(boolean feed, BigDecimal exchange, BigDecimal currentFunds) throws IOException {
		try(PrintWriter output = new PrintWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
			String action = "";
			String money = "";
			String currentBalance = "";
			
			if(feed) {
				action = "FEED MONEY";
				money = "$" + exchange.toString();
				currentBalance = "$" + currentFunds.toString();
			} else {
				action = "GIVE CHANGE";
				money = "$" + exchange.toString();
				currentBalance = "$" + currentFunds.toString();
			}
			
			output.printf("%-25s %-25s %-8s %-10s %n", timeStamp, action, money, currentBalance);
		}
		
	}
	
	// Logging for vending items
	public void logData(String item, String slotID, BigDecimal currentFunds, BigDecimal balance) throws IOException {
		try(PrintWriter output = new PrintWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
			String action = "";
			String money = "";
			String currentBalance = "";
			
			action = item + " " + slotID;
			money = "$" + balance;
			currentBalance = "$" + currentFunds;
			
			output.printf("%-25s %-25s %-8s %-10s %n", timeStamp, action, currentBalance, money);
		}
	}
	
}
