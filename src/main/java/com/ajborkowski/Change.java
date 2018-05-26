package com.ajborkowski;

import java.math.BigDecimal;

public class Change {

	private BigDecimal balance;
	
	private int tenDollarBill = 0;
	private int fiver = 0;		
	private int dollar = 0;
	private int quarter = 0;
	private int dime = 0;
	private int nickel = 0;
	
	private String yourChange = "You receive ";
	
	private int pieces = 0;
	
	public Change(BigDecimal balance) {
		this.balance = balance;
	}

	public void makeChange() {
		BigDecimal zero = new BigDecimal("0");
		BigDecimal ten = new BigDecimal("10");
		BigDecimal five = new BigDecimal("5");
		BigDecimal one = new BigDecimal("1");
		BigDecimal aQuarter = new BigDecimal("0.25");
		BigDecimal aDime = new BigDecimal("0.10");
		BigDecimal aNickel = new BigDecimal("0.05");
		
		while(balance.compareTo(zero) > 0) {
			if(balance.compareTo(ten) >= 0) {
				balance = balance.subtract(ten);
				tenDollarBill++;
				pieces++;
			} else if(balance.compareTo(five) >= 0) {
				balance = balance.subtract(five);
				fiver++;
				pieces++;
			} else if(balance.compareTo(one) >= 0) {
				balance = balance.subtract(one);
				dollar++;
				pieces++;
			} else if(balance.compareTo(aQuarter) >= 0) {
				balance = balance.subtract(aQuarter);
				quarter++;
				pieces++;
			} else if(balance.compareTo(aDime) >= 0) {
				balance = balance.subtract(aDime);
				dime++;
				pieces++;
			} else if(balance.compareTo(aNickel) >= 0) {
				balance = balance.subtract(aNickel);
				nickel++;
				pieces++;
			}
		}
	}
	
	public void printChange() {
		if(pieces > 0) {
			if(tenDollarBill == 1) {
				yourChange += "a ten dollar bill";
				punctuation(tenDollarBill);
			}
			if (tenDollarBill > 1) {
				yourChange += tenDollarBill + " ten dollar bills";
				punctuation(tenDollarBill);
			}
			if (fiver == 1) {
				yourChange += "a five dollar bill";
				punctuation(fiver);
			}
			if (fiver > 1) {
				yourChange += fiver + " five dollar bills";
				punctuation(fiver);
			}
			if (dollar == 1) {
				yourChange += "a one dollar bill";
				punctuation(dollar);
			}
			if (dollar > 1) {
				yourChange += dollar + " one dollar bills";
				punctuation(dollar);
			}
			if (quarter == 1) {
				yourChange += "a quarter";
				punctuation(quarter);
			}
			if (quarter > 1) {
				yourChange += quarter + " quarters";
				punctuation(quarter);
			}
			if (dime == 1) {
				yourChange += "a dime";
				punctuation(dime);
			}
			if (dime > 1) {
				yourChange += dime + " dimes";
				punctuation(dime);
			}
			if (nickel == 1) {
				yourChange += "a nickel";
				punctuation(nickel);
			}
			if (nickel > 1) {
				yourChange += nickel + " nickels";
				punctuation(nickel);
			}
			System.out.println(yourChange);
		} else {
			System.out.println("Goodbye!");
		}
	}
	
	public void punctuation(int valueCount) {
		pieces = pieces - valueCount;
		if(pieces == 0) {
			yourChange += ".";
		} else if(pieces > 0 && pieces < 3) {
			yourChange += ", and ";
		} else {
			yourChange += ", ";
		}
	}
	
}
