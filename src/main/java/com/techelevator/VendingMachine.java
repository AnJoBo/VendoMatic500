package com.techelevator;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VendingMachine {
// instantiation
	private BigDecimal balance = new BigDecimal("0.00");
	private Map<String, Queue<Item>> inventory;
	private List<Item> itemBin = new LinkedList<>();
	private InventoryReader inventoryGen = new InventoryReader();
	
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
	public void deposit(BigDecimal feed) {
		if(feed.compareTo(new BigDecimal("0")) > 0) {
			this.balance = balance.add(feed);
		} //else {
		//	System.out.println("Invalid input.");
		//}
	}
	
	public void dispense(String slotID) {
		if(balance.compareTo(inventory.get(slotID).element().getPrice()) >= 0) {
			Item item = inventory.get(slotID).poll();
			balance = balance.subtract(inventory.get(slotID).element().getPrice());
			itemBin.add(item);
		} else {
			System.out.println("No moneys");
		}
	}
	
	public int itemBinCount() {
		return itemBin.size();
	}
	public List<Item> getItemBin() {
		return itemBin;
	}
	
	public void displayInventory() {
		//System.out.println(inventory.entrySet().); //
		for(String key : inventory.keySet()) {
			if(!key.isEmpty()) {
				System.out.printf("%s | %s - %.2f | %d %n",
					key, inventory.get(key).element().getName(),
					inventory.get(key).element().getPrice(),
					inventory.get(key).size());
			} else {
				System.out.printf("%s | Out of Stock %n", key);
			}
		}
	}
	
	public void finish() {
		//add to logWriter
		
		this.balance = new BigDecimal("0.00");
	}
}
