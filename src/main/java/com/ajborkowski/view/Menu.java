package com.ajborkowski.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.script.Bindings;

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
			out.print("Enter an amount [0 to cancel]>>>");
			out.flush();
			
			String userInput = in.nextLine();
			try {
				BigDecimal input = new BigDecimal(userInput).stripTrailingZeros();
				if(input.precision() == 1 && input.precision() <= 4) {
					return input;
				} else {
					out.println("\n*** Please enter a valid number ***");
					out.flush();
				}
				
			} catch(NumberFormatException ex) {
				out.println("\n*** Please enter a valid number ***");
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
			//out.println(e.getMessage());
		}
		if(choice == null && choice != "") {
			out.println("\n*** What you entered is not not a valid option ***");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options, String message) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println(message);
		out.print("\nChoose an option >>> ");
		out.flush();
	}
	
	public void displayBanner() {
		System.out.println(" _    __               __      __  ___      __  _      __________  ____  ______\r\n" + 
						   "| |  / /__  ____  ____/ /___  /  |/  /___ _/ /_(_)____/ ____/ __ \\/ __ \\/ / / /\r\n" + 
						   "| | / / _ \\/ __ \\/ __  / __ \\/ /|_/ / __ `/ __/ / ___/___ \\/ / / / / / / / / / \r\n" + 
						   "| |/ /  __/ / / / /_/ / /_/ / /  / / /_/ / /_/ / /______/ / /_/ / /_/ /_/_/_/  \r\n" + 
						   "|___/\\___/_/ /_/\\__,_/\\____/_/  /_/\\__,_/\\__/_/\\___/_____/\\____/\\____(_|_|_)");
	}
}
