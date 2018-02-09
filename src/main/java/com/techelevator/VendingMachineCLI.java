package com.techelevator;

import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static VendingMachine vendingMachine = new VendingMachine();
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY= "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PURCHASE = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
														PURCHASE_MENU_OPTION_PURCHASE,
														PURCHASE_MENU_OPTION_FINISH_TRANSACTION,
														};
	
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	
	
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendingMachine.displayInventory();				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(!choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS,
					"Current Money Provided: " + vendingMachine.getBalance());

					if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						vendingMachine.deposit(menu.getAmountFromUserInput());
					} else if(choice.equals(PURCHASE_MENU_OPTION_PURCHASE)) {
						vendingMachine.displayInventory();
						System.out.println();
						System.out.print("Please enter an item ID >>>");
						Scanner scan = new Scanner(System.in);
						choice = scan.nextLine();
						choice = choice.toUpperCase();
						//choice = (String)menu.getChoiceFromOptions(vendingMachine);
						if(vendingMachine.getInventoryKey(choice)) {
							vendingMachine.dispense(choice);
							System.out.println(vendingMachine.itemBinCount());
							System.out.println("Thank you!");
						} //else, fail
							//vendingMachine.dispense(menu.getChoiceFromOptions());
						
					}
					
				}
				//Finishing logic
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);			// this is a class. this instantiates a new object of this class
		VendingMachineCLI cli = new VendingMachineCLI(menu); 	// and lets objects handle everything else
		cli.run();
		
	}
}
