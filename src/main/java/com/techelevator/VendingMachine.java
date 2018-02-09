package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VendingMachine {
// instantiation
	private BigDecimal balance;
	private Map<String, Queue<Item>> inventory;
	private List<Item> itemBin;
	private InventoryReader inventoryGen = new InventoryReader(); //wat
	
// constructor
	public VendingMachine() {
		this.inventory = inventoryGen.generateInventory(); //teh
	}
	
	
// methods
	public void deposit() {
	}
	
	public void dispense(String slotID) {
	}
	
	public void displayInventory() {
		System.out.println(inventory.entrySet()); // fook
	}
	
	public void finish() {
	}
}
