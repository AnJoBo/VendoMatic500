package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

public class VendingMachine {
// instantiation
	private BigDecimal balance = new BigDecimal("0.00");
	private Map<String, Queue<Item>> inventory;
	private List<Item> itemBin = new LinkedList<>();
	private InventoryReader inventoryGen = new InventoryReader();
	private VendingLog log = new VendingLog();
	
// constructor
	public VendingMachine() {
		this.inventory = inventoryGen.generateInventory();
	}
	
	
// getters & setters
	public BigDecimal getBalance() {
		return balance;
	}
	
	public boolean getInventoryKey(String input) {
		return inventory.containsKey(input);
	}
	
// methods
	public void deposit(BigDecimal feed) throws IOException {
		
			if(feed.compareTo(new BigDecimal("0")) > 0 &&
			feed.compareTo(new BigDecimal("1")) == 0 ||
			feed.compareTo(new BigDecimal("2")) == 0 ||
			feed.compareTo(new BigDecimal("5")) == 0 ||
			feed.compareTo(new BigDecimal("10")) == 0) {
				this.balance = balance.add(feed);
				log.logData(true, feed, balance);
			} else {
				System.out.println();
				System.out.println("Invalid amount.");
			}
		
			
	}
	
	public void dispense(String slotID) throws IOException {
		
		if(!inventory.get(slotID).isEmpty()) {
			BigDecimal itemPrice = inventory.get(slotID).element().getPrice();

			if(balance.compareTo(itemPrice) > 0) {
				Item item = inventory.get(slotID).poll();
				log.logData(item.getName(), slotID, balance, balance.subtract(itemPrice));
				balance = balance.subtract(itemPrice);
				itemBin.add(item);
			} else {
				System.out.println();
				System.out.println("Not enough funds.");
			}
		} else {
			System.out.println();
			System.out.println("That item is sold out.");
		}
	}
	
	public void emptyItemBin() {
		itemBin.removeAll(itemBin);
	}
	public List<Item> getItemBin() {
		return itemBin;
	}
	
	public void displayInventory() {
		inventoryHeader();
		for(String key : inventory.keySet()) {
			if(!key.isEmpty()) {
				try {
					System.out.printf("%-8s | %-20s | %-5.2f | %d %n",
					key, inventory.get(key).element().getName(),
					inventory.get(key).element().getPrice(),
					inventory.get(key).size());
				} catch(NoSuchElementException ex) {
					inventorySlotEmpty(key);
				}
			}
		}
	}
	
	public void inventoryHeader() {
		System.out.printf("----------------------------------------------- %n" +
									"%8s | %-20s | %s | Stock %n"
						+ "----------------------------------------------- %n",
									"Slot ID", "Item", "Price");
	}
	
	public void inventorySlotEmpty(String key) {
		System.out.printf("%-8s | %-20s | -.--  | - %n", key, " -----SOLD OUT-----");
	}
	
	public void finish() throws IOException {
		BigDecimal reset = new BigDecimal("0.00");
		log.logData(false, balance, reset);
		emptyItemBin();
		this.balance = reset;
	}
}
