package com.techelevator;

import java.math.BigDecimal;

public class Change {

	BigDecimal balance = new BigDecimal("0.00");
	
	public Change(BigDecimal change) {
		this.balance = change;
	}
	
	//methods
	public String makeChange() {
		
		int tenDollarBill = 0;
		int fiver = 0;		
		int dollar = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		
		while(balance.compareTo(new BigDecimal("0.00")) > 0) {
			
			if(balance.compareTo(new BigDecimal("10.00")) >= 0) {
				balance = balance.subtract(new BigDecimal("10.00"));
				tenDollarBill++;
			} else if(balance.compareTo(new BigDecimal("5.00")) >= 0) {
				balance = balance.subtract(new BigDecimal("5.00"));
				fiver++;
			} else if(balance.compareTo(new BigDecimal("1.00")) >= 0) {
				balance = balance.subtract(new BigDecimal("1.00"));
				dollar++;
			} else if(balance.compareTo(new BigDecimal(".25")) >= 0) {
				balance = balance.subtract(new BigDecimal("0.25"));
				quarter++;
			} else if(balance.compareTo(new BigDecimal("0.10")) >= 0) {
				balance = balance.subtract(new BigDecimal("0.10"));
				dime++;
			} else if(balance.compareTo(new BigDecimal("0.05")) >= 0) {
				balance = balance.subtract(new BigDecimal("0.05"));
				nickel++;
			}
		}
		
		String yourChange = "You get ";
		
		if(tenDollarBill == 1) {
			yourChange += "one ten dollar bill ";
		}
		if (tenDollarBill > 1) {
			yourChange += tenDollarBill + " ten dollar bills ";
		}
		if (fiver == 1) {
			yourChange += "one five dollar bill ";
		}
		if (fiver > 1) {
			yourChange += fiver + " five dollar bills ";
		}
		if (dollar == 1) {
			yourChange += "one dollar bill ";
		}
		if (dollar > 1) {
			yourChange += dollar + " dollar bills ";
		}
		if (quarter == 1) {
			yourChange += "one quarter ";
		}
		if (quarter > 1) {
			yourChange += quarter + " quarters ";
		}
		if (dime == 1) {
			yourChange += "one dime ";
		}
		if (dime > 1) {
			yourChange += dime + " dimes ";
		}
		if (nickel == 1) {
			yourChange += "and one nickel ";
		}
		if (nickel > 1) {
			yourChange += " and " + nickel + " nickels ";
		}
		
		
		
		return yourChange;

//		} else {
//			System.out.println("Thank you for your purchase! You have no change.");
	}
	
	
}
