package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options, String message) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options, message);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	public Object getChoiceFromOptions(Object[] options) {
		return getChoiceFromOptions(options, "");
	}
	
	public String getChoiceFromOptions(String message) {
		return getChoiceFromOptions(message);
	}

	public BigDecimal getAmountFromUserInput() {
		for(;;){
			out.println();
			out.print("Please enter an amount >>>");
			out.flush();

			String userInput = in.nextLine();
			try {
				return new BigDecimal(userInput).setScale(2); // takes money from user and deposits into vending machine
			} catch(NumberFormatException ex) {					// converts their input into BD so you don't have to 
				out.println("Please enter a valid number.");		// worry about it
				out.println();
				out.flush();
			}
		}
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}
//a String array
	private void displayMenuOptions(Object[] options, String message) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.println(message);
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}
